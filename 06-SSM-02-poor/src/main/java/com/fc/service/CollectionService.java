package com.fc.service;

import com.fc.entity.Collection;

import java.util.List;

public interface CollectionService {

    List<Collection> findAll(Integer pageNum, Integer pageSize);

    int delete(Long id);
}
