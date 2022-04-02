package com.fc.controller;

import com.fc.entity.Carousel;
import com.fc.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("carousel")
public class CarouselController {
@Autowired
    private CarouselService carouselService;
@RequestMapping("list")
public Map<String,Object> findAll(Integer pageNo,Integer pageSize){
   return carouselService.findAll(pageNo,pageSize);

}
@RequestMapping("del")
public Map<String, Object> delete(Integer id){
    return carouselService.delete(id);

}
@RequestMapping("add")
public Map<String, Object> add(@RequestBody Carousel carousel){
    return carouselService.add(carousel);
}
@RequestMapping("update")
public Map<String, Object> update(@RequestBody Carousel carousel){
    return carouselService.update(carousel);
}
@RequestMapping("state")
public Map<String, Object> state(Integer id){

    return carouselService.state(id);
}
}
