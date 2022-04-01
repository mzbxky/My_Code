package com.fc.controller;

import com.fc.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("carousel")
public class CarouselController {
@Autowired
    private CarouselService carouselService;
@RequestMapping("list")
public Map<String,Object> findAll(Integer pageNo,Integer pageSize){
    Map<String,Object> map = new HashMap<>();
    if (carouselService.findAll(pageNo,pageSize) == null){
        map.put("message","用户获取失败");
        map.put("code",404);
        map.put("success",false);
        map.put("data", "{错误描述}");
        return map;
    }
    map.put("message","用户获取成功");
    map.put("code",200);
    map.put("success",true);
    map.put("data:",carouselService.findAll(pageNo,pageSize));
    return map;

}
@RequestMapping("del")
public Map<String, Object> delete(Integer id){
    Map<String , Object> map = new HashMap<>();
    if (carouselService.delete(id) != 1){
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
