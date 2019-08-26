package com.github.note.service;

import com.github.note.common.ReturnModel;
import com.github.note.domain.Note;

import java.util.List;
import java.util.Map;

/**
 * 订单信息
 * Created  by Mr.kk
 * DateTime on 2018-11-24 22:28:40
 */
public interface NoteService {

    /**
     * 新增或修改
     */
    public ReturnModel insertOrUpdate(Note note);

    /**
     * 新增
     */
    public ReturnModel insert(Note note);

    /**
     * 删除
     */
    public ReturnModel delete(String id);

    /**
     * 更新
     */
    public ReturnModel update(Note note);

    /**
     * 根据Id查询
     */
    public ReturnModel load(String id);

    /**
     * 全部查询
     */
    public List<Note> getAll(Note note);

    /**
     * 分页查询
     */
    public Map<String,Object> pageList(int offset, int pagesize,Note note);

}
