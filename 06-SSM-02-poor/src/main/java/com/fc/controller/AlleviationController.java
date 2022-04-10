package com.fc.controller;

import com.fc.entity.Alleviation;
import com.fc.service.AlleviationService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("policy")
@CrossOrigin
public class AlleviationController {
    @Autowired
    private AlleviationService alleviationService;
    @GetMapping("list")
    public ResultVo getList(Integer pageNo, Integer pageSize,Long id){
        return alleviationService.getList(pageNo,pageSize,id);
    }
    @PostMapping("add")
    public ResultVo add(@RequestBody Alleviation alleviation){
        return alleviationService.add(alleviation);
    }
    @PostMapping("update")
    public ResultVo update(@RequestBody Alleviation alleviation){
        return alleviationService.update(alleviation);
    }
    @GetMapping("del")
    public ResultVo delete(Long id){
        return alleviationService.delete(id);
    }
    @PostMapping("click")
    public ResultVo click( @RequestBody Alleviation alleviation ){
        return alleviationService.click(alleviation.getLastClickTime(),alleviation.getId());
    }
}
