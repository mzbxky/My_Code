package com.fc.controller;

import com.fc.entity.Collection;
import com.fc.service.CollectionService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("collect")
public class CollectionController {
    @Autowired
    private CollectionService collectionService;
    //获取收藏
    @GetMapping("list")
   public ResultVo findAll(Integer pageNo, Integer pageSize,Long id){

        return collectionService.findAll(pageNo,pageSize,id);
   }
   @GetMapping("del")
   public ResultVo delete(Long id){
       return collectionService.delete(id);
   }
   @PostMapping("add")
   public ResultVo add(@RequestBody Collection collection){
        return collectionService.add(collection);
   }
}
