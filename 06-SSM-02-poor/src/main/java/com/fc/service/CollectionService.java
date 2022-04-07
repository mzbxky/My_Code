package com.fc.service;

import com.fc.entity.Collection;
import com.fc.vo.ResultVo;

public interface CollectionService {

    ResultVo findAll(Integer pageNo, Integer pageSize,Long id);

    ResultVo delete(Long id);

    ResultVo add(Collection collection);
}
