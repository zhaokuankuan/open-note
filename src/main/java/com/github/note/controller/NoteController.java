package com.github.note.controller;

import com.github.note.common.ReturnModel;
import com.github.note.domain.Note;
import com.github.note.service.NoteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 订单信息
 * Created  by Mr.kk
 * DateTime on 2018-11-24 22:28:40
 */
@RestController
@Api(value = "搭建环境的测试代码",tags = {"note-controller"},description = "搭建环境的测试代码")
public class NoteController {

    @Resource
    private NoteService noteService;

    /**
     * 新增或修改
     */
    @ApiOperation(value = "insertOrUpdate",notes = "insertOrUpdate")
    @RequestMapping(value="/note/insertOrUpdate",method = {RequestMethod.GET, RequestMethod.POST})
    public ReturnModel insertOrUpdate(Note note){
        if(null == note){
            note = new Note();
        }
        return noteService.insertOrUpdate(note);
    }

    /**
     * 新增
     */
    @ApiOperation(value = "新增",notes = "新增")
    @RequestMapping(value="/note/insert",method = {RequestMethod.GET, RequestMethod.POST})
    public ReturnModel insert(Note note){
        return noteService.insert(note);
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除",notes = "删除")
    @ApiImplicitParam(value = "删除的id",name="id")
    @RequestMapping(value="/note/delete",method = {RequestMethod.GET, RequestMethod.POST})
    public ReturnModel delete(String id){
        return noteService.delete(id);
    }

    /**
     * 修改
     */
    @ApiOperation(value = "修改",notes = "修改")
    @RequestMapping(value="/note/update",method = {RequestMethod.GET, RequestMethod.POST})
    public ReturnModel update(Note note){
        return noteService.update(note);
    }

    /**
     * 根据Id查询
     */
    @ApiOperation(value = "根据Id查询",notes = "根据Id查询")
    @ApiImplicitParam(value = "查询的Id",name="id")
    @RequestMapping(value="/note/getById",method = {RequestMethod.GET, RequestMethod.POST})
    public ReturnModel load(String id){
        return noteService.load(id);
    }

    /**
     * 全部查询
     */
    @ApiOperation(value = "全部查询",notes = "全部查询")
    @RequestMapping(value="/note/getAll",method = {RequestMethod.GET, RequestMethod.POST})
    public List<Note> getAll(Note note){
        return noteService.getAll(note);
    }

    /**
     * 分页查询
     */
    @ApiOperation(value = "分页查询",notes = "分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "当前的页码",name="offset"),
            @ApiImplicitParam(value = "每页显示的条数",name="pagesize")
     })
    @RequestMapping(value="/note/getByPageList",method = {RequestMethod.GET, RequestMethod.POST})
    public Map<String, Object> pageList(@RequestParam(required = false, defaultValue = "0") int offset,
                                        @RequestParam(required = false, defaultValue = "10") int pagesize,
                                        Note note) {
        return noteService.pageList(offset, pagesize,note);
    }

}
