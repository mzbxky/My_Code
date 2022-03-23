package com.fc.dao.impl;

import com.fc.dao.UserDao;
import com.fc.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository("userDao")
//在持久层
public class UserDaoImpl implements UserDao {

    @Override
    public List<User> findAll() {
        ArrayList<User> list = new ArrayList<>();
        list.add(new User(1,"法斗","132456"));
        list.add(new User(2,"中华田园犬","5201314"));
        list.add(new User(3,"比熊","1235"));
        return list;
    }
}
