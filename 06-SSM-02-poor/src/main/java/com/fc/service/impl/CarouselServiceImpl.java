package com.fc.service.impl;

import com.fc.dao.CarouselMapper;
import com.fc.entity.Carousel;
import com.fc.service.CarouselService;
import com.fc.vo.DataVo;
import com.fc.vo.ResultVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarouselServiceImpl implements CarouselService {
@Autowired
private CarouselMapper carouselMapper;
    @Override
    public ResultVo getList(Integer pageNo, Integer pageSize,Integer id) {
        List<Carousel> carousels;
        ResultVo resultVo;
        try {
            if(id == null){
                PageHelper.startPage(pageNo,pageSize);
                carousels = carouselMapper.selectByExample(null);

            }else {
                Carousel carousel = carouselMapper.selectByPrimaryKey(id);
                carousels = new ArrayList<>();
                carousels.add(carousel);
            }
            PageInfo<Carousel> pageInfo = new PageInfo<>(carousels);
            DataVo<Carousel> dataVo = new DataVo<>(pageInfo.getTotal(),carousels,pageNo,pageSize);
            resultVo = new ResultVo(200,"查询成功",true,dataVo);
        }catch (Exception e){
            resultVo = new ResultVo(-1,"查询失败",false,null);
        }
       return resultVo;


    }

    @Override
    public ResultVo delete(Integer id) {
        ResultVo resultVo;
        int affectedRows = carouselMapper.deleteByPrimaryKey(id);
        if(affectedRows >0){
            resultVo = new ResultVo(200,"删除成功",true,null);
        }else {
            resultVo = new ResultVo(-1,"删除失败",false,null);
        }
        return resultVo;
    }

    @Override
    public ResultVo add(Carousel carousel) {
        int affectedRows = carouselMapper.insertSelective(carousel);
        ResultVo resultVo;
        if(affectedRows>0){
            resultVo = new ResultVo(200,"添加成功",true,carousel);
        }else {
            resultVo = new ResultVo(-1,"添加失败",false,null);
        }
        return resultVo;
    }

    @Override
    public ResultVo update(Carousel carousel) {
        ResultVo resultVo;
        int affectedRows = carouselMapper.updateByPrimaryKeySelective(carousel);
        if(affectedRows>0){
            Carousel result = carouselMapper.selectByPrimaryKey(carousel.getId());
            resultVo = new ResultVo(200,"轮播图修改成功",true,carousel);
        }else {
            resultVo = new ResultVo(-1,"修改失败",false,null);
        }
        return resultVo;
    }

    @Override
    public ResultVo state(Long id) {
       ResultVo resultVo;
       if(carouselMapper.setState(id)){
           resultVo = new ResultVo(200,"轮播图设置成功",true,null);
       }else {
           resultVo = new ResultVo(-1,"轮播图设置失败",false,null);
       }
       return resultVo;
    }
}
