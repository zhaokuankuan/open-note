package com.github.note;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author :Mr.kk
 * @date: 2019/8/26 16:05
 */
@SpringBootApplication
@MapperScan("com.github.note.dao")
public class OpenNoteApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenNoteApplication.class,args);
    }
}
