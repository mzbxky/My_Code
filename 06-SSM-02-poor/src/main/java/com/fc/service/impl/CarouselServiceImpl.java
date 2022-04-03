package com.fc.service.impl;

import com.fc.dao.CarouselMapper;
import com.fc.entity.Carousel;
import com.fc.service.CarouselService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CarouselServiceImpl implements CarouselService {
@Autowired
private CarouselMapper carouselMapper;
    @Override
    public Map<String,Object> findAll(Integer pageNo,Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<Carousel> list = carouselMapper.selectByExample(null);
        PageInfo<Carousel> pageInfo = new PageInfo<>(list);
        Map<String,Object> map = new HashMap<>();
        if (pageInfo.getList() == null){
            map.put("message","用户获取失败");
            map.put("code",404);
            map.put("success",false);
            map.put("data", "{错误描述}");
            return map;
        }
        map.put("message","用户获取成功");
        map.put("code",200);
        map.put("success",true);
        map.put("data:",pageInfo);
        return map;


    }

    @Override
    public Map<String,Object> delete(Integer id) {
        Map<String , Object> map = new HashMap<>();
        if (carouselMapper.deleteByPrimaryKey(id) != 1){
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

    @Override
    public Map<String, Object> add(Carousel carousel) {
        Map<String , Object> map = new HashMap<>();
        if (carouselMapper.insert(carousel) != 1){
            map.put("message","用户添加失败");
            map.put("code",404);
            map.put("success",false);
            map.put("data", "{错误描述}");
        }
        map.put("message","用户添加成功");
        map.put("code",200);
        map.put("success",true);
        map.put("data","{}");
        return map;

    }

    @Override
    public Map<String, Object> update(Carousel carousel) {
        Map<String , Object> map = new HashMap<>();
        if (carouselMapper.updateByPrimaryKey(carousel) != 1){
            map.put("message","用户添加失败");
            map.put("code",404);
            map.put("success",false);
            map.put("data", "{错误描述}");
        }
        map.put("message","用户添加成功");
        map.put("code",200);
        map.put("success",true);
        map.put("data","{}");
        return map;

    }

    @Override
    public Map<String, Object> state(Integer id) {
        Map<String , Object> map = new HashMap<>();
        if(!carouselMapper.setState(id)){
            map.put("message","设置失败");
            map.put("code",404);
            map.put("success",false);
            map.put("data", "{错误描述}");
        }
        map.put("message","设置成功");
        map.put("code",200);
        map.put("success",true);
        map.put("data","{}");
        return map;
    }
}
