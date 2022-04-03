package com.fc.service;

import com.fc.entity.PoorWithBLOBs;

import java.util.Date;
import java.util.Map;

public interface PoorService {
    Map<String,Object> findAll(Integer pageNo,Integer pageSize);

    Map<String, Object> add(PoorWithBLOBs poor);

    Map<String, Object> update(PoorWithBLOBs poor);

    Map<String, Object> delete(Long id);

    Map<String, Object> click(Long id, Date lastClickTime);
}
