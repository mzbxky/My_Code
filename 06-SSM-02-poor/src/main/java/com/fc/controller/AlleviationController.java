package com.fc.controller;

import com.fc.entity.Alleviation;
import com.fc.service.AlleviationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("policy")
public class AlleviationController {
    @Autowired
    private AlleviationService alleviationService;
    @RequestMapping("list")
    public Map<String,Object> findAll(Integer pageNo,Integer pageSize){
        return alleviationService.findAll(pageNo,pageSize);
    }
    @RequestMapping("add")
    public Map<String,Object> add(@RequestBody Alleviation alleviation){
        return alleviationService.add(alleviation);
    }
    @RequestMapping("update")
    public Map<String,Object> update(@RequestBody Alleviation alleviation){
        return alleviationService.update(alleviation);
    }
    @RequestMapping("del")
    public Map<String,Object> delete(Long id){
        return alleviationService.delete(id);
    }
    @RequestMapping("click")
    public Map<String,Object> click(Date lastClickTime, Long id ){
        return alleviationService.click(lastClickTime,id);
    }
}
