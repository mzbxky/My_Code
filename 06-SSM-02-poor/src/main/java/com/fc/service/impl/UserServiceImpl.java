package com.fc.service.impl;

import com.fc.dao.UserMapper;
import com.fc.entity.User;
import com.fc.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
private UserMapper userMapper;

    @Override
    public Integer delete(Long id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer updateUser(User user) {

        return userMapper.updateByPrimaryKey(user);
    }

    @Override
    public Integer addUser( User user) {
        user.setId(8L);
        user.setName("黑小虎");
        user.setGender("男");
        //user.setAge("12");
        user.setUsername("蓝兔yyds");
        user.setPassword("123456");
        user.setPhone("12346");
        user.setEmail("123");
        user.setPhoto("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fdingyue.ws.126.net%2F4loKcmtyIK3AHhHtA11UUzQZPxdlDaqjpticOFCUkzN3E1553467386587.jpeg&refer=http%3A%2F%2Fdingyue.ws.126.net&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1651288581&t=ff8e02932a548f3cb4156ae727e843e1");
        return userMapper.insert(user);
    }

    @Override
    public List<User> findAll(Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<User> list = userMapper.selectByExample(null);
        PageInfo<User> pageInfo = new PageInfo<>(list);

        return pageInfo.getList();
    }
}
