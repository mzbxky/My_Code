package com.fc.service;

import com.fc.entity.TbNoteType;
import com.fc.vo.ResultVo;

import java.util.List;

public interface TypeService {
    List<TbNoteType> list(Integer userId);

    ResultVo update(TbNoteType tbNoteType);


    ResultVo add(TbNoteType tbNoteType);

    ResultVo delete(Integer id);
}
