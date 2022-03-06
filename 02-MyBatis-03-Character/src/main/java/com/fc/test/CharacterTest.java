package com.fc.test;

import com.fc.dao.StudentDao;
import com.fc.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class CharacterTest {
    //查询小于
    @Test
    public void testFindLessThanAge(){
        //读取配置文件
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            //获取工厂
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            //获取连接
            SqlSession session = factory.openSession();
            //实体类对象
            StudentDao studentDao = session.getMapper(StudentDao.class);
            //调用方法
            List<Student> students = studentDao.findLessThanAge(15);
            for(Student student:students){
                System.out.println(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    @Test
//    public void testFindLessThanAge(){
//        //读取配置文件
//        try {
//            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//            //获取工厂
//            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
//            //获取连接
//            SqlSession session = factory.openSession();
//            //获取实体类对象
//            StudentDao studentDao = session.getMapper(StudentDao.class);
//            //调用接口中的方法
//            List<Student> students = studentDao.findLessThanAge(16);
//            for(Student student:students){
//                System.out.println(student);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//@Test
//    public void testFindLessThanAge(){
//    //读取配置文件
//    try {
//        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//        //获取工厂
//        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
//        //获取连接
//        SqlSession session = factory.openSession();
//        StudentDao studentDao = session.getMapper(StudentDao.class);
//        List<Student> students = studentDao.findLessThanAge(16);
//        for(Student student:students){
//            System.out.println(student);
//        }
//        session.close();
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//}
//查询大于
    @Test
    public void testGreaterThanAge(){
        //读取配置文件
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            //获取工厂
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            //获取连接
            SqlSession session = factory.openSession();
            StudentDao studentDao = session.getMapper(StudentDao.class);
            List<Student> students = studentDao.findGreaterThanAge(50);
            for (Student student : students) {
                System.out.println(student);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    @Test
//    public void testGreaterThanAge(){
//        //读取配置文件按
//        try {
//            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//            //获取工厂
//            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
//            //获取连接
//            SqlSession session = factory.openSession();
//            StudentDao studentDao = session.getMapper(StudentDao.class);
//            List<Student> students = studentDao.findGreaterThanAge(50);
//            for (Student student : students) {
//                System.out.println(student);
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    @Test
//    public void testGreaterThanAge(){
//    //读取配置
//        try {
//            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//            //获取工厂
//            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
//            //获取连接
//            SqlSession session = factory.openSession();
//            StudentDao studentDao = session.getMapper(StudentDao.class);
//            List<Student> students = studentDao.findGreaterThanAge(16);
//            for(Student student:students){
//                System.out.println(student);
//            }
//            session.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//
//        }
//    }
}
