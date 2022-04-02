package com.fc.service;

import com.fc.entity.VolunteerRecruitment;

import java.util.Map;

public interface VolunteerRecruitmentService {

    Map<String,Object> findAll(Integer pageNo, Integer pageSize);

    Map<String, Object> add(VolunteerRecruitment volunteerRecruitment);
}
