package com.fc.controller;

import com.fc.entity.VolunteerRecruitment;
import com.fc.service.VolunteerRecruitmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("recruitment")
public class VolunteerRecruitmentController {
    @Autowired
    private VolunteerRecruitmentService volunteerRecruitmentService;
    @RequestMapping("list")
    public Map<String, Object> findAll(Integer pageNo, Integer pageSize){
        return volunteerRecruitmentService.findAll(pageNo,pageSize);
    }
    @RequestMapping("add")
    public Map<String,Object> add(VolunteerRecruitment volunteerRecruitment){
        return volunteerRecruitmentService.add(volunteerRecruitment);
    }
}
