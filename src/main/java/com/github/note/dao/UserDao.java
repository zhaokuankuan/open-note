package com.github.note.dao;

import com.github.note.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户
 * Created  by Mr.kk
 * DateTime on 2019-08-26 16:36:13
 */
public interface UserDao {

    /**
     * 新增
     */
    public int insert(@Param("user") User user);

    /**
     * 删除
     */
    public int delete(@Param("id") String id);

    /**
     * 修改
     */
    public int update(@Param("user") User user);

    /**
     * 根据id查询
     */
    public User load(@Param("id") String id);

    /**
     * 全部查询
     */
    public List<User> getAll(@Param("user")User user);


    /**
     * 分页查询数据
     */
    public List<User> pageList(@Param("offset") int offset,
                               @Param("pagesize") int pagesize,
                               @Param("user")User user);

    /**
     * 分页查询总条数
     */
    public int pageListCount(@Param("offset") int offset,
                             @Param("pagesize") int pagesize,
                             @Param("user")User user);

}

