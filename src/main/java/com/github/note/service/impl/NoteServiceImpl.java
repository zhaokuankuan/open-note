package com.github.note.service.impl;

import com.github.note.common.ReturnModel;
import com.github.note.dao.NoteDao;
import com.github.note.domain.Note;
import com.github.note.service.NoteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 订单信息
 * Created  by Mr.kk
 * DateTime on 2018-11-24 22:28:40
 */
@Service
public class NoteServiceImpl implements NoteService {

    @Resource
    private NoteDao noteDao;

    /**
     * 新增或修改
     */
    @Override
    public ReturnModel insertOrUpdate(Note note) {
        ReturnModel result = new ReturnModel();
        if (note == null) {
            return result;
        }
        if(0 != note.getId() && !"".equals(note.getId())){
            //修改
            result =  update(note);
        }else{ //新增
            result = insert(note);
        }
        return result;
    }

    /**
     * 新增
     */
    @Override
    public ReturnModel insert(Note note) {
        ReturnModel result = new ReturnModel();
        if (note == null) {
            return result;
        }
        noteDao.insert(note);
        return result;
    }

    /**
     * 删除
     */
    @Override
    public ReturnModel delete(String id) {
        ReturnModel result = new ReturnModel();
        if(null == id || "".equals(id)){
            result.setMsg("id不能为空！");
            return result;
        }
        int ret = noteDao.delete(id);
        if(ret > 0){
            return  result;
        }else{
            return  result;
        }
    }

    /**
     * 修改
     */
    @Override
    public ReturnModel update(Note note) {
        ReturnModel result = new ReturnModel();
        int ret = noteDao.update(note);
        if(ret > 0){
            return  result;
        }else{
            return  result;
        }
    }

    /**
     * 根据Id查询
     */
    @Override
    public ReturnModel load(String id) {
        ReturnModel result = new ReturnModel();
        if(null == id || "".equals(id)){
            result.setMsg("id不能为空！");
            return result;
        }
        Note note = noteDao.load(id);
        return result;
    }

    /**
     * 全部查询
     */
    public List<Note> getAll(Note note){
        List<Note> list = noteDao.getAll(note);
        return list;
    };

    /**
     * 分页查询
     */
    @Override
    public Map<String,Object> pageList(int offset, int pagesize,Note note) {
        Map<String, Object> result = new HashMap<String, Object>();
        List<Note> pageList = noteDao.pageList(offset, pagesize,note);
        int totalCount = noteDao.pageListCount(offset, pagesize,note);
        // 分页查询的数据的返回
        result.put("pageList", pageList);
        result.put("totalCount", totalCount);
        return result;
    }

}

