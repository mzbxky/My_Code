package com.fc.test;

import com.fc.dao.StudentDao;
import com.fc.dao.UserDao;
import com.fc.entity.Student;
import com.fc.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    @Test
    public void testAdd(){
        SqlSession session = null;
        //加载配置文件
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            //获取工厂对象
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            //获取连接
            session = factory.openSession();
            UserDao userDao = session.getMapper(UserDao.class);
            int affectedRows = userDao.add();
            System.out.println("受影响的行数"+affectedRows);
            session.commit();
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(session!=null){
                session.close();
            }
        }
    }
//    @Test
//    public void testAdd(){
//        SqlSession session = null;
//        //加载配置文件
//        try {
//            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//            //获取工厂对象
//            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
//            //获取连接
//            session = factory.openSession();
//            UserDao userDao = session.getMapper(UserDao.class);
//            int affectedRows = userDao.add();
//            session.commit();
//            session.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            if (session!=null){
//                session.close();
//            }
//        }
//    }
//    @Test
//    public void testAdd(){
//        //加载配置文件
//        try {
//            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//            //获取工厂对象
//            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
//            //获取连接
//            SqlSession session = factory.openSession();
//            UserDao userDao = session.getMapper(UserDao.class);
//            int affectedRows = userDao.add();
//            System.out.println("受影响的行数"+affectedRows);
//            session.commit();
//            session.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    //查询全部
    @Test
    public void testUser(){
        //加载配置文件
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            //获取工厂
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            //获取连接
            SqlSession session = factory.openSession();
            UserDao userDao = session.getMapper(UserDao.class);
            List<User> users = userDao.findAll();
            for(User user:users){
                System.out.println(user);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    @Test
//    public void testUser(){
//        //加载配置文件
//        try {
//            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//            //获取工厂对象
//            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
//            //获取连接
//            SqlSession session = factory.openSession();
//            UserDao userDao = session.getMapper(UserDao.class);
//            List<User> users = userDao.findAll();
//            for(User user:users){
//                System.out.println(user);
//            }
//            session.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    @Test
//    public void testUser(){
//        try {
//            //加载配置文件
//            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//            //获取工厂对象
//            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
//            //获取连接
//            SqlSession session = factory.openSession();
//            UserDao userDao = session.getMapper(UserDao.class);
//            List<User> users = userDao.findAll();
//            for(User user:users){
//                System.out.println(user);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    //根据ID查
    @Test
    public void testFindById(){
        //加载配置文件
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            //获取工厂
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            //获取连接
            SqlSession session = factory.openSession();
            StudentDao studentDao = session.getMapper(StudentDao.class);
            Student student = studentDao.findById(5);
            System.out.println(student);
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    @Test
//    public void testFindById(){
//        //加载配置文件
//        try {
//            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//            //获取工厂
//            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
//            //获取连接、
//            SqlSession session = factory.openSession();
//            StudentDao studentDao = session.getMapper(StudentDao.class);
//            Student student = studentDao.findById(1);
//            System.out.println(student);
//            session.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    @Test
//    public void testFindById(){
//        //加载配置文件
//        try {
//            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//            //获取工厂
//            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
//            //获取连接
//            SqlSession session = factory.openSession();
//            StudentDao studentDao = session.getMapper(StudentDao.class);
//            Student student = studentDao.findById(2);
//            System.out.println(student);
//            session.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    @Test
//    public void testFindById(){
//        //加载配置文件
//        try {
//            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//            //获取工厂
//            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
//            //获取连接
//            SqlSession session = factory.openSession();
//            StudentDao studentDao = session.getMapper(StudentDao.class);
//            Student student = studentDao.findById(3);
//            System.out.println(student);
//            session.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
