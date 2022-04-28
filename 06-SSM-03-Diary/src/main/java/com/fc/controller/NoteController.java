package com.fc.controller;

import com.fc.entity.TbNote;
import com.fc.service.NoteService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("note")
public class NoteController {
    @Autowired
    private NoteService noteService;
    @GetMapping("delete")
    public ResultVo delete(Integer id){
        return noteService.delete(id);
    }
    @GetMapping("addOrUpdate")
    public ResultVo addOrUpdate(TbNote note){
        return noteService.addOrUpdate(note);
    }

}
