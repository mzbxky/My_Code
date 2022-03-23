package com.fc.test;

import com.fc.entity.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConstructorTest {
@Test
    public void test(){
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    Person person = applicationContext.getBean( Person.class);
    System.out.println(person);
}

}
