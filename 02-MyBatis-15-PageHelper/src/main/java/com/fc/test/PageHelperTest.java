package com.fc.test;

import com.fc.dao.StudentDao;
import com.fc.entity.Student;
import com.fc.util.MyBatisUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;

import java.util.List;

public class PageHelperTest {
//    @Test
//    public void test(){
//        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
//        PageHelper.startPage(2,2);
//        List<Student> students = studentDao.findAll();
//        for (Student student : students) {
//            System.out.println(student);
//        }
//        MyBatisUtil.commit();
//    }
//    @Test
//    public void test(){
//        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
//        //第三页，一页显示三条
//        PageHelper.startPage(3,3);
//        List<Student> students = studentDao.findAll();
//        for (Student student : students) {
//            System.out.println(student);
//        }
//        MyBatisUtil.commit();
//    }
//    @Test
//    public void test(){
//        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
//        PageHelper.startPage(1,3);
//        List<Student> students = studentDao.findAll();
//        for (Student student : students) {
//            System.out.println(student);
//        }
//        MyBatisUtil.commit();
//
//    }
//    @Test
//    public void test(){
//        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
//        PageHelper.startPage(1,3);
//        List<Student> students = studentDao.findAll();
//        for (Student student : students) {
//            System.out.println(student);
//        }
//        MyBatisUtil.commit();
//    }
//@Test
//public void test(){
//    StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
//    PageHelper.startPage(1,3);
//    List<Student> students = studentDao.findAll();
//    for (Student student : students) {
//        System.out.println(student);
//    }
//    MyBatisUtil.commit();
//
//}
//@Test
//public void test(){
//    StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
//    PageHelper.startPage(1,3);
//    List<Student> students = studentDao.findAll();
//    for (Student student : students) {
//        System.out.println(student);
//    }
//    MyBatisUtil.commit();
//
//}

    @Test
    public void test(){
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
        PageHelper.startPage(1,3);
        List<Student> students = studentDao.findAll();
        for (Student student : students) {
            System.out.println(student);
        }
        MyBatisUtil.commit();

    }

//    @Test
//    public void testPageInfo() {
//        StudentDao dao = MyBatisUtil.getMapper(StudentDao.class);
//
//        // 开启分页
//        PageHelper.startPage(1, 2);
//
//        List<Student> students = dao.findAll();
//
//        // 封装PageInfo
//        PageInfo<Student> pageInfo = new PageInfo<>(students);
//
//        System.out.println(pageInfo);
//    }
//    @Test
//    public void testPageInfo(){
//        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
//        //开启分页
//        PageHelper.startPage(1,3);
//        List<Student> students = studentDao.findAll();
//        //封装PageInfo
//        PageInfo<Student> pageInfo = new PageInfo<>(students);
//        System.out.println(pageInfo);
//    }
//    public void testPageInfo(){
//        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
//        //开启分页
//        PageHelper.startPage(1,2);
//        List<Student> students = studentDao.findAll();
//        //封装PageInfo
//        PageInfo<Student> pageInfo = new PageInfo<>(students);
//        System.out.println(pageInfo);
//    }
//    public void testPageInfo(){
//        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
//        //开启分页
//        PageHelper.startPage(1,3);
//        List<Student> students = studentDao.findAll();
//        //封装PageInfo
//        PageInfo<Student> pageInfo = new PageInfo<>(students);
//        System.out.println(pageInfo);
//    }
//    public void testPageInfo(){
//    StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
//    PageHelper.startPage(1,3);
//    List<Student> students = studentDao.findAll();
//        PageInfo<Student> pageInfo = new PageInfo<>(students);
//        System.out.println(pageInfo);
//    }
//    public void testPageInfo(){
//    StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
//    PageHelper.startPage(1,3);
//    List<Student> students = studentDao.findAll();
//        PageInfo<Student> pageInfo = new PageInfo<>(students);
//        System.out.println(pageInfo);
//    }
    public void testPageInfo(){
    StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
    //第几页，一页几条
    PageHelper.startPage(1,3);
    List<Student> students = studentDao.findAll();
        PageInfo<Student> pageInfo = new PageInfo<>(students);
        System.out.println(pageInfo);
    }
}
