package com.fc.service;

import com.fc.entity.MessageBoardWithBLOBs;

import java.util.Map;

public interface MessageBoardService {
    Map<String,Object> findAll(Integer pageNo, Integer pageSize);

    Map<String, Object> add(MessageBoardWithBLOBs messageBoard);

    Map<String, Object> delete(Long id);
}
