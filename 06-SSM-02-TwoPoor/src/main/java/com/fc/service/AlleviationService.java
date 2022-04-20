package com.fc.service;

import com.fc.entity.Alleviation;
import com.fc.vo.ResultVo;

import java.util.Date;

public interface AlleviationService {
    ResultVo getList(Integer pageNo, Integer pageSize,Long id);

    ResultVo add(Alleviation alleviation);

    ResultVo update(Alleviation alleviation);

    ResultVo delete(Long id);

    ResultVo click(Date lastClickTime, Long id);
}
