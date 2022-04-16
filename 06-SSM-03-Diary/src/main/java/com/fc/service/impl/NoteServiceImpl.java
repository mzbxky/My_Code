package com.fc.service.impl;

import com.fc.dao.TbNoteMapper;
import com.fc.entity.TbNote;
import com.fc.service.NoteService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteServiceImpl implements NoteService {
    ResultVo resultVo;
    @Autowired
    private TbNoteMapper tbNoteMapper;
    @Override
    public ResultVo delete(Integer id) {
        int affectedRows = tbNoteMapper.deleteByPrimaryKey(id);
        if(affectedRows>0){
            resultVo = new ResultVo(1,"删除成功",true,null);
        }
        resultVo = new ResultVo(-1,"删除失败",false,null);
        return resultVo;
    }

    @Override
    public ResultVo addOrUpdate(Integer id) {
        TbNote tbNote = tbNoteMapper.addOrUpdate(id);
        if(tbNote == null){
            resultVo = new ResultVo(-1,"该日记不存在",false,null);
        }
        resultVo = new ResultVo(1,"查询成功",true,tbNote);
        System.out.println(tbNote);
        return resultVo;
    }
}
