package com.github.note.common;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author :Mr.kk
 * @date: 2018/8/16-18:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnModel implements Serializable{

    //成功
    public static final int Success = 200;
    //失败
    public static final int Error = 500;

    public static final long serialVersionUID = 1L;

    private int code;
    private String msg;
    private Object data;


}


