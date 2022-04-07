package com.fc.controller;

import com.fc.entity.Carousel;
import com.fc.service.CarouselService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("carousel")
public class CarouselController {
@Autowired
    private CarouselService carouselService;
@GetMapping("list")
public ResultVo findAll(Integer pageNo, Integer pageSize,Integer id){
   return carouselService.findAll(pageNo,pageSize,id);

}
@GetMapping("del")
public ResultVo delete(Integer id){
    return carouselService.delete(id);

}
@PostMapping("add")
public ResultVo add(@RequestBody Carousel carousel){
    return carouselService.add(carousel);
}
@PostMapping("update")
public ResultVo update(@RequestBody Carousel carousel){
    return carouselService.update(carousel);
}
@PostMapping("state")
public ResultVo state(Long id){

    return carouselService.state(id);
}
}
