package com.fc.controller;

import com.fc.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("collect")
public class CollectionController {
    @Autowired
    private CollectionService collectionService;
    //获取收藏
    @RequestMapping("list")
   public Map<String,Object> findAll(Integer pageNum,Integer pageSize){
        Map<String,Object> map = new HashMap<>();
        if (collectionService.findAll(pageNum,pageSize) == null){
            map.put("message","用户获取失败");
            map.put("code",404);
            map.put("success",false);
            map.put("data", "{错误描述}");
            return map;
        }
        map.put("message","用户获取成功");
        map.put("code",200);
        map.put("success",true);
        map.put("data:",collectionService.findAll(pageNum,pageSize));
        return map;
   }
   @RequestMapping("del")
   public Map<String,Object> delete(Long id){
       Map<String , Object> map = new HashMap<>();
       if (collectionService.delete(id) != 1){
           map.put("message","用户删除失败");
           map.put("code",404);
           map.put("success",false);
           map.put("data", "{错误描述}");
       }
       map.put("message","用户删除成功");
       map.put("code",200);
       map.put("success",true);
       map.put("data","{}");
       return map;
   }
}
