package com.fc.controller;

import com.fc.entity.TbNoteType;
import com.fc.service.TypeService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("type")
public class TypeController {
    @Autowired
    private TypeService typeService;
    @GetMapping("list")
    public ResultVo list( Integer pageNum, Integer pageSize, Integer id){
        return typeService.list(pageNum,pageSize,id);
    }
    @PostMapping("addOrUpdate")
    public ResultVo addOrUpdate(@RequestBody TbNoteType tbNoteType){
        return typeService.addOrUpdate(tbNoteType);
    }
    @GetMapping("delete")
    public ResultVo delete(Integer id){
        return typeService.delete(id);
    }
}
