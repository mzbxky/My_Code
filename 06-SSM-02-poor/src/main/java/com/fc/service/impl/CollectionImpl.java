package com.fc.service.impl;

import com.fc.dao.CollectionMapper;
import com.fc.entity.Collection;
import com.fc.service.CollectionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionImpl implements CollectionService {
    @Autowired
private CollectionMapper collectionMapper;
    @Override
    public List<Collection> findAll(Integer pageNum, Integer pageSize) {

         PageHelper.startPage(pageNum,pageSize);
        List<Collection> list = collectionMapper.selectByExample(null);
        PageInfo<Collection> pageInfo = new PageInfo<>(list);
        return pageInfo.getList();
    }

    @Override
    public int delete(Long id) {
        return collectionMapper.deleteByPrimaryKey(id);
    }
}
