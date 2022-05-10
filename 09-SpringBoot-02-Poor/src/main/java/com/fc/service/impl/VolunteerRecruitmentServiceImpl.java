package com.fc.service.impl;

import com.fc.dao.VolunteerRecruitmentMapper;
import com.fc.entity.VolunteerRecruitment;
import com.fc.service.VolunteerRecruitmentService;
import com.fc.vo.DataVo;
import com.fc.vo.ResultVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class VolunteerRecruitmentServiceImpl implements VolunteerRecruitmentService {
    @Autowired
    private VolunteerRecruitmentMapper volunteerRecruitmentMapper;
    @Override
    public ResultVo getList(Integer pageNo, Integer pageSize,Long id) {
        List<VolunteerRecruitment> volunteerRecruitments;
        ResultVo resultVo;
        //try {
            if(id == null){
                PageHelper.startPage(pageNo,pageSize);
                volunteerRecruitments = volunteerRecruitmentMapper.selectByExample(null);
            }else {
                VolunteerRecruitment volunteerRecruitment = volunteerRecruitmentMapper.selectByPrimaryKey(id);
                volunteerRecruitments = new ArrayList<>();
                volunteerRecruitments.add(volunteerRecruitment);

                click(volunteerRecruitment.getId(), null);
            }
            PageInfo<VolunteerRecruitment> pageInfo = new PageInfo<>(volunteerRecruitments);

            DataVo<VolunteerRecruitment> dataVo = new DataVo<>(pageInfo.getTotal(),volunteerRecruitments,pageNo,pageSize);

            resultVo = new ResultVo(200,"查询成功",true,dataVo);

//        }catch (Exception e){
//            resultVo = new ResultVo(-400,"查询失败",false,null);
//
//        }

        return resultVo;

    }

    @Override
    public ResultVo add(VolunteerRecruitment volunteerRecruitment) {
        ResultVo resultVo;
        if(volunteerRecruitment.getCreateTime() == null){
            volunteerRecruitment.setCreateTime(new Date());
        }
        if(volunteerRecruitment.getClickNum() == null){
            volunteerRecruitment.setClickNum(0);
        }
        int affectedRows = volunteerRecruitmentMapper.insertSelective(volunteerRecruitment);
        if(affectedRows>0){
            resultVo = new ResultVo(200,"添加成功",true,volunteerRecruitment);
        }else {
            resultVo = new ResultVo(-1,"添加失败",false,null);
        }
        return resultVo;
    }

    @Override
    public ResultVo delete(Long id) {
        int affectedRows = volunteerRecruitmentMapper.deleteByPrimaryKey(id);
        ResultVo resultVo;
        if(affectedRows>0){
            resultVo = new ResultVo(200,"删除成功",true,null);
        }else {
            resultVo = new ResultVo(-1,"删除失败",false,null);
        }
        return resultVo;

    }

    @Override
    public ResultVo update(VolunteerRecruitment volunteerRecruitment) {
        int affectedRows = volunteerRecruitmentMapper.updateByPrimaryKeySelective(volunteerRecruitment);
        ResultVo resultVo;
        if(affectedRows >0){
            VolunteerRecruitment result = volunteerRecruitmentMapper.selectByPrimaryKey(volunteerRecruitment.getId());
            resultVo = new ResultVo(200,"OK",true,result);
        }else {
            resultVo = new ResultVo(-1,"fail",false,null);
        }
        return resultVo;
    }

    @Override
    public ResultVo click(Long id, Date lastClickTime) {
        ResultVo resultVo;
        if(lastClickTime == null){
            lastClickTime = new Date();
        }
        int affectedRows = volunteerRecruitmentMapper.click(id,lastClickTime);
        if(affectedRows>0){
            resultVo = new ResultVo(200,"OK",true,null);
        }else {
            resultVo = new ResultVo(-1,"fail",false,null);
        }
        return resultVo;

    }
}
