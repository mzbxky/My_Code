package com.fc.service;

import com.fc.entity.Collection;

import java.util.Map;

public interface CollectionService {

    Map<String,Object> findAll(Integer pageNo, Integer pageSize);

    Map<String,Object> delete(Long id);

    Map<String,Object> add(Collection collection);
}
