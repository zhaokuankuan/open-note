package com.github.note.controller;

import com.github.note.common.ReturnModel;
import com.github.note.domain.User;
import com.github.note.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 用户
 * Created  by Mr.kk
 * DateTime on 2019-08-26 16:36:13
 */
@Api(description = "用户")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 新增或修改
     */
    @ApiOperation(value = "新增或修改",notes = "新增或修改")
    @PostMapping(value="/user/insertOrUpdate")
    public ReturnModel insertOrUpdate(HttpServletRequest request,User user){
        if(null == user){
            user = new User();
        }
        int result = userService.insertOrUpdate(user);
        return result>0?new ReturnModel(ReturnModel.Success,"success",user):new ReturnModel(ReturnModel.Error,"fail",user);
    }

    /**
     * 新增
     */
    @ApiOperation(value = "新增",notes = "新增")
    @PostMapping(value="/user/insert")
    public ReturnModel insert(HttpServletRequest request,User user){
        int result = userService.insert(user);
        return result>0?new ReturnModel(ReturnModel.Success,"success",user):new ReturnModel(ReturnModel.Error,"fail",user);
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除",notes = "删除")
    @PostMapping(value="/user/delete")
    public ReturnModel delete(HttpServletRequest request,String id){
        int result = userService.delete(id);
        return result>0?new ReturnModel(ReturnModel.Success,"success",id):new ReturnModel(ReturnModel.Error,"fail",id);
    }

    /**
     * 修改
     */
    @ApiOperation(value = "修改",notes = "修改")
    @PostMapping(value="/user/update")
    public ReturnModel update(HttpServletRequest request,User user){
        int result = userService.update(user);
        return result>0?new ReturnModel(ReturnModel.Success,"success",user):new ReturnModel(ReturnModel.Error,"fail",user);
    }

    /**
     * 根据Id查询
     */
    @ApiOperation(value = "根据Id查询",notes = "根据Id查询")
    @GetMapping(value="/user/getById")
    public ReturnModel load(HttpServletRequest request,String id){
        ReturnModel returnmodel = new ReturnModel();
        User user =  userService.load(id);
        returnmodel.setData(user);
        return returnmodel;
    }

    /**
     * 全部查询
     */
    @ApiOperation(value = "全部查询",notes = "全部查询")
    @GetMapping(value="/user/getAll")
    public ReturnModel getAll(HttpServletRequest request,User user){
        List<User> list =  userService.getAll(user);
        if(null!=list && list.size()>0){
            return new ReturnModel(ReturnModel.Success,"success",list);
        }else{
            return new ReturnModel(ReturnModel.Success,"数据为空",list);
        }
    }

    /**
     * 分页查询
     */
    @ApiOperation(value = "分页查询",notes = "分页查询")
    @GetMapping(value="/user/getByPageList")
    public ReturnModel pageList(HttpServletRequest request,
                                User user,
                                @RequestParam(required = false, defaultValue = "0") int offset,
                                @RequestParam(required = false, defaultValue = "10") int pagesize) {
        Object obj =  userService.pageList(offset, pagesize,user);
        if(null!=obj){
            return new ReturnModel(ReturnModel.Success,"success",obj);
        }else{
            return new ReturnModel(ReturnModel.Success,"数据为空",obj);
        }
    }


}

