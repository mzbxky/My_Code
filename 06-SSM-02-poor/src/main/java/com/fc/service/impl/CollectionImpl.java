package com.fc.service.impl;

import com.fc.dao.CollectionMapper;
import com.fc.entity.Collection;
import com.fc.service.CollectionService;
import com.fc.vo.DataVo;
import com.fc.vo.ResultVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CollectionImpl implements CollectionService {
    @Autowired
private CollectionMapper collectionMapper;
    @Override
    public ResultVo findAll(Integer pageNo, Integer pageSize,Long id) {
        List<Collection> collections;
        ResultVo resultVo = new ResultVo();
        try {
            if (id == null){
                PageHelper.startPage(pageNo,pageSize);
                collections = collectionMapper.selectByExample(null);
            }else {
                Collection collection = collectionMapper.selectByPrimaryKey(id);
                collections = new ArrayList<>();
                collections.add(collection);
            }
            PageInfo<Collection> pageInfo = new PageInfo<>(collections);

            DataVo<Collection> dataVo = new DataVo<>(pageInfo.getTotal(),collections,pageNo,pageSize);

            resultVo = new ResultVo(200,"查询成功",true,dataVo);
        }catch (Exception e){
            resultVo = new ResultVo(-1,"查询失败",false,null);
        }


        return resultVo;
    }

    @Override
    public ResultVo delete(Long id) {
        ResultVo resultVo = new ResultVo();
       int affectedRows = collectionMapper.deleteByPrimaryKey(id);
       if(affectedRows>0){
           resultVo = new ResultVo(200,"删除成功",true,null);
       }else {
           resultVo = new ResultVo(-1,"删除失败",false,null);
       }
        return resultVo;
    }

    @Override
    public ResultVo add(Collection collection) {
        if(collection.getCreateTime()==null){
            collection.setCreateTime(new Date());
        }
        ResultVo resultVo;
        int affectedRows = collectionMapper.insertSelective(collection);
        if(affectedRows>0){
            resultVo = new ResultVo(200,"添加成功",true,collection);
        }else {
            resultVo = new ResultVo(-1,"添加失败",false,null);
        }
        return resultVo;
    }
}
