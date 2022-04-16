package com.fc.service.impl;

import com.fc.controller.FileController;
import com.fc.dao.TbUserMapper;
import com.fc.entity.TbUser;
import com.fc.service.UserService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    TbUserMapper tbUserMapper;


    @Override
    public ResultVo delete(Integer id) {
        ResultVo resultVo;
        int affectedRows = tbUserMapper.deleteByPrimaryKey(id);

        if(affectedRows>0){
            resultVo = new ResultVo(200,"删除成功",true,null);
        }else {
            resultVo = new ResultVo(-1,"删除失败",false,null);
        }
        return resultVo;
    }

    @Override
    public Integer checkNick(Integer id) {
        TbUser user = tbUserMapper.selectByPrimaryKey(id);
        if(user == null){
            return 1;
        }
        return -1;
    }

    @Override
    public ResultVo update(TbUser user, MultipartFile img) {
        ResultVo resultVo = null;
        Map<String,Object> map = new HashMap<>();
        if (img!=null){
            FileController fileController = null;
            ResultVo resultVo1 = fileController.upload(img);
            if (resultVo1.getCode()>0){
                map.put("img","头像上传成功");
            }
        }else {
           int affectedRows =  tbUserMapper.updateByPrimaryKeySelective(user);
           if (affectedRows>0){
               map.put("data","修改成功");
               resultVo = new ResultVo(1,"修改成功",true,map);
           }else {
               resultVo = new ResultVo(-1,"修改失败",false,null);
           }
        }
        return resultVo;
    }




}
