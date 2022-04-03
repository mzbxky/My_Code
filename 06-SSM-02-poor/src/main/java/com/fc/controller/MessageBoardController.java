package com.fc.controller;

import com.fc.entity.MessageBoardWithBLOBs;
import com.fc.service.MessageBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RequestMapping("comment")
public class MessageBoardController {
    @Autowired
    private MessageBoardService messageBoardService;
    @RequestMapping("list")
    public Map<String,Object> findAll(Integer pageNo,Integer pageSize){
        return messageBoardService.findAll(pageNo,pageSize);
    }
    @RequestMapping("add")
    public Map<String,Object> add(MessageBoardWithBLOBs messageBoard){
        return messageBoardService.add(messageBoard);
    }
    @RequestMapping("del")
    public Map<String,Object> delete(Long id){
        return messageBoardService.delete(id);
    }
}
