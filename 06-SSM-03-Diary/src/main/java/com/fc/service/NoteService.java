package com.fc.service;

import com.fc.entity.TbNote;
import com.fc.vo.ResultVo;

public interface NoteService {
    ResultVo delete(Integer id);

    ResultVo addOrUpdate(TbNote note);
}
