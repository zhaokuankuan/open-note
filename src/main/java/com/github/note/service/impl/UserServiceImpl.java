package com.github.note.service.impl;

import com.github.note.common.DateUtils;
import com.github.note.common.MD5Util;
import com.github.note.dao.UserDao;
import com.github.note.domain.User;
import com.github.note.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户
 * Created  by Mr.kk
 * DateTime on 2019-08-26 16:36:13
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    /**
     * 新增或修改
     */
    @Override
    public int insertOrUpdate(User user) {
        int result = 0;
        if(user.getId() != 0){
            //修改
            result =  update(user);
        }else{ //新增
            result = insert(user);
        }
        return result;
    }

    /**
     * 新增
     */
    @Override
    public int insert(User user) {
        user.setCreateTime(DateUtils.getTs());
        user.setPassword(MD5Util.MD5(user.getPassword()));
        return userDao.insert(user);
    }

    /**
     * 删除
     */
    @Override
    public int delete(String id) {
        return userDao.delete(id);
    }

    /**
     * 修改
     */
    @Override
    public int update(User user) {
        user.setPassword(MD5Util.MD5(user.getPassword()));
        return userDao.update(user);
    }

    /**
     * 根据Id查询
     */
    @Override
    public User load(String id) {
        return userDao.load(id);
    }

    /**
     * 全部查询
     */
    public List<User> getAll(User user){
        List<User> list = userDao.getAll(user);
        return list;
    };

    /**
     * 分页查询
     */
    @Override
    public Map<String,Object> pageList(int offset, int pagesize,User user) {
        Map<String, Object> map = new HashMap<String, Object>();
        offset=offset==0?0:(offset)*pagesize;
        List<User> pageList = userDao.pageList(offset, pagesize,user);
        int totalCount = userDao.pageListCount(offset, pagesize,user);
        // 分页查询的数据的返回
        map.put("pageList", pageList);
        map.put("totalCount", totalCount);
        return map;
    }

}

