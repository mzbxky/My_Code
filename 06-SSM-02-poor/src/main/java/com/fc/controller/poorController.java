package com.fc.controller;

import com.fc.entity.Poor;
import com.fc.entity.PoorWithBLOBs;
import com.fc.service.PoorService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//
@RestController
@RequestMapping("poor")
public class poorController {
    @Autowired
private PoorService poorService;
    @GetMapping("list")
    public ResultVo getList(@RequestParam(value = "pageNo",defaultValue = "1") Integer pageNo,
                            @RequestParam(value = "pageSize",defaultValue = "3") Integer pageSize,
                            Long id){
        return poorService.getList(pageNo,pageSize,id);
    }
    @PostMapping("add")
    public ResultVo add(@RequestBody PoorWithBLOBs poor){
        return poorService.add(poor);
    }
    @PostMapping("update")
    public ResultVo update(@RequestBody PoorWithBLOBs poor){
        return poorService.update(poor);
    }
    @GetMapping("del")
    public ResultVo delete(Long id){
        return poorService.delete(id);
    }
    @PostMapping("click")
    public ResultVo click(@RequestBody Poor poor){
        return poorService.click(poor.getId(),poor.getLastClickTime());
    }
}
