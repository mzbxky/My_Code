package com.fc.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LazyTest {
    @Test
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Student student = applicationContext.getBean(Student.class);
//        student.setName("糖醋里脊");
//        student.setAge((byte) 15);
//        student.getId(1);
     //   System.out.println(student);

    }
}
