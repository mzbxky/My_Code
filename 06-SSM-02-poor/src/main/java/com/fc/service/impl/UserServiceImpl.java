package com.fc.service.impl;

import com.fc.dao.UserMapper;
import com.fc.entity.User;
import com.fc.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
private UserMapper userMapper;

    @Override
    public Map<String,Object> delete(Long id) {
        Map<String , Object> map = new HashMap<>();
        if (userMapper.deleteByPrimaryKey(id) != 1){
            map.put("message","用户删除失败");
            map.put("code",404);
            map.put("success",false);
            map.put("data", "{错误描述}");
        }
        map.put("message","用户删除成功");
        map.put("code",200);
        map.put("success",true);
        map.put("data","{}");
        return map;
    }

    @Override
    public Map<String,Object> updateUser(User user) {
        Map<String,Object> map = new HashMap<>();
        if(userMapper.updateByPrimaryKey(user) != 1){
            map.put("message","用户修改失败");
            map.put("code",404);
            map.put("success",false);
            map.put("data", "{错误描述}");
            return map;
        }
        map.put("message","用户修改成功");
        map.put("code",200);
        map.put("success",true);
        map.put("data","{}");
        return map;
    }

    @Override
    public Map<String, Object> addUser(User user) {
        Map<String , Object> map = new HashMap<>();
        if (userMapper.insert(user) != 1){
            map.put("message","用户删除失败");
            map.put("code",404);
            map.put("success",false);
            map.put("data", "{错误描述}");
        }
        map.put("message","用户删除成功");
        map.put("code",200);
        map.put("success",true);
        map.put("data","{}");
        return map;

    }

    @Override
    public Map<String,Object> findAll(Integer pageNo,Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<User> list = userMapper.selectByExample(null);
        PageInfo<User> pageInfo = new PageInfo<>(list);
        Map<String,Object> map = new HashMap<>();
        if (pageInfo.getList() == null){
            map.put("message","用户获取失败");
            map.put("code",404);
            map.put("success",false);
            map.put("data", "{错误描述}");
            return map;
        }
        map.put("message","用户获取成功");
        map.put("code",200);
        map.put("success",true);
        map.put("data:",pageInfo);
        return map;
    }
}
