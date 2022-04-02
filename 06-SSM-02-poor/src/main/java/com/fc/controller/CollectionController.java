package com.fc.controller;

import com.fc.entity.Collection;
import com.fc.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("collect")
public class CollectionController {
    @Autowired
    private CollectionService collectionService;
    //获取收藏
    @RequestMapping("list")
   public Map<String,Object> findAll(Integer pageNo,Integer pageSize){

        return collectionService.findAll(pageNo,pageSize);
   }
   @RequestMapping("del")
   public Map<String,Object> delete(Long id){
       return collectionService.delete(id);
   }
   @RequestMapping("add")
   public Map<String ,Object> add(@RequestBody Collection collection){
        return collectionService.add(collection);
   }
}
