package com.fc.service;

import com.fc.entity.MessageBoardWithBLOBs;
import com.fc.vo.ResultVo;

public interface MessageBoardService {
    ResultVo getList(Integer pageNo, Integer pageSize,Long id);

    ResultVo add(MessageBoardWithBLOBs messageBoard);

    ResultVo delete(Long id);

    ResultVo reply(MessageBoardWithBLOBs messageBoard);
}
