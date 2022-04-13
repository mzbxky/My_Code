package com.fc.service.impl;

import com.fc.controller.FileController;
import com.fc.dao.UserMapper;
import com.fc.entity.User;
import com.fc.service.UserService;
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
public class UserServiceImpl implements UserService {
    @Autowired
private UserMapper userMapper;
    @Override
    public ResultVo getList(Integer pageNo, Integer pageSize,Long id,String username,String name) {
        List<User> users = null;
        ResultVo resultVo = new ResultVo();
        try {
            if(id == null){
                PageHelper.startPage(pageNo,pageSize);
                users = userMapper.selectByExample(null);
            }else if (id != null){
                User user = userMapper.selectByPrimaryKey(id);
                users = new ArrayList<>();
                users.add(user);
            }else if(username != null){

            }else if(name != null){

            }
            PageInfo<User> pageInfo = new PageInfo<>(users);

            DataVo<User> dataVo = new DataVo<>(pageInfo.getTotal(),users,pageNo,pageSize);

            resultVo = new ResultVo(200,"查询成功",true,dataVo);

        }catch (Exception e){
            resultVo = new ResultVo(-400,"查询失败",false,null);

        }

        return resultVo;
    }

    @Override
    public ResultVo delete(Long id) {
       int affectedRows = userMapper.deleteByPrimaryKey(id);
       ResultVo resultVo;
       if(affectedRows>0){
           resultVo = new ResultVo(200,"删除成功",true,null);
       }else {
           resultVo = new ResultVo(-1,"删除失败",false,null);
       }
        return resultVo;
    }

    @Override
    public ResultVo updateUser(User user) {
        int affectedRows = userMapper.updateByPrimaryKeySelective(user);
        ResultVo resultVo;
        if(affectedRows >0){
            User result = userMapper.selectByPrimaryKey(user.getId());
            resultVo = new ResultVo(200,"修改成功",true,result);
        }else {
            resultVo = new ResultVo(-1,"修改失败",false,null);
        }
        return resultVo;
    }

    @Override
    public ResultVo addUser(User user) {
        FileController fileController = null;
        ResultVo resultVo;
        if(user.getCreateTime() == null){
            user.setCreateTime(new Date());
        }
        int affectedRows = userMapper.insertSelective(user);

        if(affectedRows>0){
            resultVo = new ResultVo(200,"添加成功",true,user);
        }else {
            resultVo = new ResultVo(-1,"添加失败",false,null);
        }
            return resultVo;
    }


}
