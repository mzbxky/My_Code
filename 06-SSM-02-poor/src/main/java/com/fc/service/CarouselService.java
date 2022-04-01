package com.fc.service;

import com.fc.entity.Carousel;

import java.util.List;

public interface CarouselService {
List<Carousel> findAll(Integer pageNo,Integer pageSize);

    Integer delete(Integer id);
}
