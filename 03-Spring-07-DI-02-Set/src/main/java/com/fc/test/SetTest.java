package com.fc.test;

import com.fc.entity.Car;
import com.fc.entity.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetTest {
@Test
    public void test() {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    Car car = applicationContext.getBean("car1",Car.class);
    Person person = applicationContext.getBean(Person.class);
    //因为配置文件中引用的是同一个car，所以两个是同一个对象，如果引用了不同的bean，结果就为false
    System.out.println(car == person.getCar());
    System.out.println(car.hashCode());
    System.out.println(person.getCar().hashCode());
}
}
