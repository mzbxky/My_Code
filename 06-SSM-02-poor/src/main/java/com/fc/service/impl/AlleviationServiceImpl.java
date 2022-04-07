package com.fc.service.impl;


import com.fc.entity.Alleviation;
import com.fc.service.AlleviationService;
import com.fc.vo.DataVo;
import com.fc.vo.ResultVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fc.dao.AlleviationMapper;
import java.util.*;

@Service
public class AlleviationServiceImpl implements AlleviationService {
    @Autowired
    private AlleviationMapper alleviationMapper;
    @Override
    public ResultVo findAll(Integer pageNo, Integer pageSize,Long id) {
        ResultVo resultVo;
        List<Alleviation> alleviations;
        try {
            if(id == null){
                PageHelper.startPage(pageNo,pageSize);
                alleviations = alleviationMapper.selectByExample(null);
            }else {
                Alleviation alleviation = alleviationMapper.selectByPrimaryKey(id);
                alleviations = new ArrayList<>();
                alleviations.add(alleviation);
            }
            PageInfo<Alleviation> pageInfo = new PageInfo<>(alleviations);
            DataVo<Alleviation> dataVo = new DataVo<>(pageInfo.getTotal(),alleviations,pageNo,pageSize);
            resultVo = new ResultVo(200,"查询成功",true,dataVo);
        }catch (Exception e){
            resultVo = new ResultVo(-1,"查询失败",false,null);
        }
        return resultVo;
    }

    @Override
    public ResultVo add(Alleviation alleviation) {
        ResultVo resultVo;
        if(alleviation.getCreateTime() == null){
            alleviation.setCreateTime(new Date());
        }
        int affectedRows = alleviationMapper.insertSelective(alleviation);
        if(affectedRows>0){
            resultVo = new ResultVo(200,"添加陈公公",true,alleviation);
        }else {
            resultVo = new ResultVo(-1,"添加失败",false,null);
        }
        return resultVo;
    }

    @Override
    public ResultVo update(Alleviation alleviation) {
        ResultVo resultVo;
        int affectedRows = alleviationMapper.updateByPrimaryKeySelective(alleviation);
        if(affectedRows>0){
            Alleviation result = alleviationMapper.selectByPrimaryKey(alleviation.getId());
            resultVo = new ResultVo(200,"修改成功",true,result);
        }else {
            resultVo = new ResultVo(-1,"修改失败",false,null);
        }
        return resultVo;
    }

    @Override
    public ResultVo delete(Long id) {
        ResultVo resultVo;
        int affectedRows = alleviationMapper.deleteByPrimaryKey(id);
        if(affectedRows>0){
            resultVo = new ResultVo(200,"删除成功",true,null);
        }else {
            resultVo = new ResultVo(-1,"删除失败",false,null);
        }
        return resultVo;
    }

    @Override
    public ResultVo click(Date lastClickTime, Long id) {
        ResultVo resultVo;
        if(lastClickTime == null){
            lastClickTime = new Date();
        }
        int affectedRows = alleviationMapper.click(lastClickTime,id);
        if(affectedRows>0){
            resultVo = new ResultVo(200,"点击成功",true,null);
        }else {
            resultVo = new ResultVo(-1,"点击失败",false,null);
        }
        return resultVo;


    }
}
