package com.fc.controller;

import com.fc.entity.VolunteerRecruitment;
import com.fc.service.VolunteerRecruitmentService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("recruitment")
public class VolunteerRecruitmentController {
    @Autowired
    private VolunteerRecruitmentService volunteerRecruitmentService;
    @GetMapping("list")
    public ResultVo getList(@RequestParam(value = "pageNo",defaultValue = "1") Integer pageNo,
                            @RequestParam(value = "pageSize",defaultValue = "1") Integer pageSize,
                            Long id){
        return volunteerRecruitmentService.getList(pageNo,pageSize,id);
    }
    @PostMapping("add")
    public ResultVo add(@RequestBody VolunteerRecruitment volunteerRecruitment){
        return volunteerRecruitmentService.add(volunteerRecruitment);
    }
    @GetMapping("del")
    public ResultVo delete(Long id){
        return volunteerRecruitmentService.delete(id);
    }
    @PostMapping("update")
    public ResultVo update(@RequestBody VolunteerRecruitment volunteerRecruitment){
        return volunteerRecruitmentService.update(volunteerRecruitment);
    }
    @PostMapping ("click")
    public ResultVo click(@RequestBody VolunteerRecruitment volunteerRecruitment){
        return volunteerRecruitmentService.click(volunteerRecruitment.getId(),volunteerRecruitment.getLastClickTime());
    }
}
