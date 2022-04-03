package com.fc.controller;

import com.fc.entity.VolunteerRecruitment;
import com.fc.service.VolunteerRecruitmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
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
    @RequestMapping("del")
    public Map<String,Object> delete(Long id){
        return volunteerRecruitmentService.delete(id);
    }
    @RequestMapping("update")
    public Map<String,Object> update(VolunteerRecruitment volunteerRecruitment){
        return volunteerRecruitmentService.update(volunteerRecruitment);
    }
    @RequestMapping("click")
    public Map<String,Object> click(Long id, Date lastClickTime){
        return volunteerRecruitmentService.click(id,lastClickTime);
    }
}
