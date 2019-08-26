package com.github.note.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用户
 * Created  by Mr.kk
 * DateTime on 2019-08-26 16:36:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private int id;

    /**
     * 登陆名称
     */
    private String loginName;

    /**
     * 名称
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 头像
     */
    private String avtor;


}