package com.fc.test;

import com.fc.entity.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanTest {
    @Test
    public void test() {
//        // 获取容器
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//
//        Student student = (Student) applicationContext.getBean("student5");
//
//        System.out.println(student);
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Student student = (Student) applicationContext.getBean("student5");
//        System.out.println(student);
        //获取容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = (Student) applicationContext.getBean("student2");
        student.setAge((byte) 6);
        System.out.println(student);
    }
}
