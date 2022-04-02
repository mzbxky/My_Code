package com.fc.service;

import com.fc.entity.Carousel;

import java.util.Map;

public interface CarouselService {
    Map<String,Object> findAll(Integer pageNo, Integer pageSize);

    Map<String,Object> delete(Integer id);

    Map<String,Object> add(Carousel carousel);

    Map<String,Object> update(Carousel carousel);

        Map<String,Object> state(Integer id);
}
