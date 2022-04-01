package com.fc.service.impl;

import com.fc.dao.CarouselMapper;
import com.fc.entity.Carousel;
import com.fc.service.CarouselService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarouselServiceImpl implements CarouselService {
@Autowired
private CarouselMapper carouselMapper;
    @Override
    public List<Carousel> findAll(Integer pageNo,Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<Carousel> list = carouselMapper.selectByExample(null);
        PageInfo<Carousel> pageInfo = new PageInfo<>(list);
        return pageInfo.getList();

    }

    @Override
    public Integer delete(Integer id) {
        return carouselMapper.deleteByPrimaryKey(id);
    }
}
