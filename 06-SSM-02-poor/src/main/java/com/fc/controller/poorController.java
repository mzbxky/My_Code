package com.fc.controller;

import com.fc.entity.PoorWithBLOBs;
import com.fc.service.PoorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;
//
@RestController
@RequestMapping("poor")
public class poorController {
    @Autowired
private PoorService poorService;
    @RequestMapping("list")
    public Map<String ,Object> findAll(Integer pageNo, Integer pageSize){
        return poorService.findAll(pageNo,pageSize);
    }
    @RequestMapping("add")
    public Map<String,Object> add(PoorWithBLOBs poor){
        return poorService.add(poor);
    }
    @RequestMapping("update")
    public Map<String,Object> update(PoorWithBLOBs poor){
        return poorService.update(poor);
    }
    @RequestMapping("del")
    public Map<String ,Object> delete(Long id){
        return poorService.delete(id);
    }
    @RequestMapping("click")
    public Map<String,Object> click(Long id, Date lastClickTime){
        return poorService.click(id,lastClickTime);
    }
}
