package com.fc.service.impl;

import com.fc.dao.TbNoteMapper;
import com.fc.dao.TbNoteTypeMapper;
import com.fc.entity.TbNote;
import com.fc.entity.TbNoteType;
import com.fc.entity.TbNoteTypeExample;
import com.fc.service.NoteService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private TbNoteMapper tbNoteMapper;
    @Autowired
    private TbNoteTypeMapper tbNoteTypeMapper;
    @Override
    public ResultVo delete(Integer id) {
        ResultVo result;
        int affectedRows = tbNoteMapper.deleteByPrimaryKey(id);
        if (affectedRows>0){
            result = new ResultVo(1, "删除成功", true, null);

        }else {
            result = new ResultVo(0, "删除失败", false, null);

        }
        return result;
    }

    @Override
    public TbNote list(Integer noteId) {
//        TbNoteExample example = new TbNoteExample();
//
//        TbNoteExample.Criteria criteria = example.createCriteria();
//        criteria.andIdEqualTo(noteId);
//        List<TbNote> notes = tbNoteMapper.selectByExample(example);
        TbNote note = tbNoteMapper.selectByPrimaryKey(noteId);
        return note;
    }

    @Override
    public List<TbNoteType> selectType(Integer userId) {
        TbNoteTypeExample example = new TbNoteTypeExample();
        TbNoteTypeExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<TbNoteType> types = tbNoteTypeMapper.selectByExample(example);
        return types;
    }

    @Override
    public TbNote detail(Integer id) {
        TbNote note = tbNoteMapper.detail(id);
        return note;
    }

    @Override
    public int add(TbNote note) {
        if (note.getLon() == null){
            note.setLon((float) 116.404);
        }
        if (note.getLat()== null){
            note.setLat((float) 39.915);
        }
        note.setPubTime(new Date());
        int affectedRows = tbNoteMapper.insertSelective(note);
        return affectedRows;
    }

    @Override
    public int update(TbNote note) {
        int affectedRows = tbNoteMapper.updateByPrimaryKeySelective(note);

        return affectedRows;
    }

    @Override
    public ResultVo findByUserId(Integer userId) {
        ResultVo result;
        List<TbNote> notes = tbNoteMapper.findByUserId(userId);
        if (notes!=null){
            result = new ResultVo(1, "查询成功", true, notes);
        }else {
            result = new ResultVo(0, "查询失败", true, null);

        }
        return result;
    }
}
