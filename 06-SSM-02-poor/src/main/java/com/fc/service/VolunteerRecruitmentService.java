package com.fc.service;

import com.fc.entity.VolunteerRecruitment;

import java.util.Date;
import java.util.Map;

public interface VolunteerRecruitmentService {

    Map<String,Object> findAll(Integer pageNo, Integer pageSize);

    Map<String, Object> add(VolunteerRecruitment volunteerRecruitment);

    Map<String, Object> delete(Long id);

    Map<String, Object> update(VolunteerRecruitment volunteerRecruitment);

    Map<String, Object> click(Long id, Date lastClickTime);
}
