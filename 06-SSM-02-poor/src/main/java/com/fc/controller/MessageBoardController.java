package com.fc.controller;

import com.fc.entity.MessageBoardWithBLOBs;
import com.fc.service.MessageBoardService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("msgboard")
@RestController
@CrossOrigin
public class MessageBoardController {
    @Autowired
    private MessageBoardService messageBoardService;
    @GetMapping("/getlist")
    public ResultVo getList(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "pageSize",defaultValue = "1") Integer pageSize,
                            Long id){
        return messageBoardService.getList(pageNum,pageSize,id);
    }
    @PostMapping("add")
    public ResultVo add(@RequestBody MessageBoardWithBLOBs messageBoard){
        return messageBoardService.add(messageBoard);
    }
    @GetMapping("delete")
    public ResultVo delete(Long id){
        return messageBoardService.delete(id);
    }
    @PostMapping("reply")
    public ResultVo reply(@RequestBody MessageBoardWithBLOBs messageBoard){
        return messageBoardService.reply(messageBoard);
    }
}
