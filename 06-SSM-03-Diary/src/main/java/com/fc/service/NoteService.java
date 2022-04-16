package com.fc.service;

import com.fc.vo.ResultVo;

public interface NoteService {
    ResultVo delete(Integer id);

    ResultVo addOrUpdate(Integer id);
}
