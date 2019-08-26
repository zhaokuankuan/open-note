package com.github.note.service;

import com.github.note.domain.User;

import java.util.List;
import java.util.Map;
/**
 * 用户
 * Created  by Mr.kk
 * DateTime on 2019-08-26 16:36:13
 */
public interface UserService {

    /**
     * 新增或修改
     */
    public int insertOrUpdate(User user);

    /**
     * 新增
     */
    public int insert(User user);

    /**
     * 删除
     */
    public int delete(String id);

    /**
     * 修改
     */
    public int update(User user);

    /**
     * 根据Id查询
     */
    public User load(String id);

    /**
     * 全部查询
     */
    public List<User> getAll(User user);

    /**
     * 分页查询
     */
    public Map<String,Object> pageList(int offset, int pagesize,User user);

}
