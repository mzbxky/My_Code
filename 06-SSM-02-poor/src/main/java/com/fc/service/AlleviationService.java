package com.fc.service;

import com.fc.entity.Alleviation;

import java.util.Map;

public interface AlleviationService {
    Map<String,Object> findAll(Integer pageNo,Integer pageSize);

    Map<String, Object> add(Alleviation alleviation);

    Map<String, Object> update(Alleviation alleviation);

    Map<String, Object> delete(Long id);
}
