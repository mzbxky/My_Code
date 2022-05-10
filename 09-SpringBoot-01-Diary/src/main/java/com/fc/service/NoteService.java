package com.fc.service;

import com.fc.entity.TbNote;
import com.fc.entity.TbNoteAndType;
import com.fc.entity.TbNoteType;
import com.fc.vo.ResultVo;

import java.util.List;

public interface NoteService {
    ResultVo delete(Integer id);

    TbNote list(Integer noteId);

    List<TbNoteType> selectType(Integer userId);

    TbNoteAndType detail(Integer id);

    int add(TbNote tbNote);

    int update(TbNote note);

    ResultVo findByUserId(Integer userId);
}
