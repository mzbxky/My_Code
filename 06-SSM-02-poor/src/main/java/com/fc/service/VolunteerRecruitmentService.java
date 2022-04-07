package com.fc.service;

import com.fc.entity.VolunteerRecruitment;
import com.fc.vo.ResultVo;

import java.util.Date;

public interface VolunteerRecruitmentService {

    ResultVo findAll(Integer pageNo, Integer pageSize,Long id);

    ResultVo add(VolunteerRecruitment volunteerRecruitment);

    ResultVo delete(Long id);

    ResultVo update(VolunteerRecruitment volunteerRecruitment);

    ResultVo click(Long id, Date lastClickTime);
}
