package com.github.note.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 订单信息
 * Created  by Mr.kk
 * DateTime on 2018-11-24 22:28:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Note implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private int id;

    /**
     * 标题
     */
    private String title;

    /**
     * 创建时间
     */
    private String date;

    /**
     * 内容
     */
    private String content;

    /**
     * 标记
     */
    private int star;

    /**
     * 用户id
     */
    private int userId;


}
