package com.fc.controller;

import com.fc.entity.MessageBoardWithBLOBs;
import com.fc.service.MessageBoardService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/comment")
@RestController
public class MessageBoardController {
    @Autowired
    private MessageBoardService messageBoardService;
    @GetMapping("/list")
    public ResultVo findAll(@RequestParam(value = "pageNo",defaultValue = "1") Integer pageNo,
                            @RequestParam(value = "pageSize",defaultValue = "1") Integer pageSize,
                            Long id){
        return messageBoardService.findAll(pageNo,pageSize,id);
    }
    @PostMapping("add")
    public ResultVo add(@RequestBody MessageBoardWithBLOBs messageBoard){
        return messageBoardService.add(messageBoard);
    }
    @GetMapping("del")
    public ResultVo delete(Long id){
        return messageBoardService.delete(id);
    }
    @PostMapping("reply")
    public ResultVo reply(@RequestBody MessageBoardWithBLOBs messageBoard){
        return messageBoardService.reply(messageBoard);
    }
}
