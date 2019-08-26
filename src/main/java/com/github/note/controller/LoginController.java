package com.github.note.controller;

import com.github.note.common.MD5Util;
import com.github.note.common.ReturnModel;
import com.github.note.domain.User;
import com.github.note.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author :Mr.kk
 * @date: 2019/8/26 16:45
 */
@RestController
@Api(description = "登录相关的接口")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/login")
    public Object login(@RequestBody(required = true) User user){
        User userQuery = new User();
        userQuery.setLoginName(user.getLoginName());
        List<User> userList = userService.getAll(userQuery);
        if(null == userList || userList.size() == 0){
            return new ReturnModel(ReturnModel.Error,"用户不存在",user);
        }
        if(MD5Util.MD5(user.getPassword()).equals(userList.get(0).getPassword())){
            return new ReturnModel(ReturnModel.Success,"登陆成功",userList.get(0));
        }
        return new ReturnModel(ReturnModel.Success,"登陆失败","");
    }
}
