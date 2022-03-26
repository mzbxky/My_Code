package com.fc.test;

import com.fc.dao.impl.UserDaoImpl;
import org.junit.Test;

import java.util.Observable;

public class UserTest extends Observable{
    @Test
    public void test(){
        UserDaoImpl userDao = new UserDaoImpl();
        userDao.findAll();
    }
}
