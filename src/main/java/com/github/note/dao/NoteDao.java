package com.github.note.dao;

import com.github.note.domain.Note;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单信息
 * Created  by Mr.kk
 * DateTime on 2018-11-24 22:28:40
 */
public interface NoteDao {

    /**
     * 新增
     */
    public int insert(@Param("note") Note note);

    /**
     * 删除
     */
    public int delete(@Param("id") String id);

    /**
     * 更新
     */
    public int update(@Param("note") Note note);

    /**
     * Load查询
     */
    public Note load(@Param("id") String id);

    /**
     * Load查询
     */
    public List<Note> getAll(@Param("note")Note note);


    /**
     * 分页查询Data
     */
    public List<Note> pageList(@Param("offset") int offset,
                               @Param("pagesize") int pagesize,
                               @Param("note") Note note);

    /**
     * 分页查询Count
     */
    public int pageListCount(@Param("offset") int offset,
                             @Param("pagesize") int pagesize,
                             @Param("note") Note note);

}

