package com.fc;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fc.entity.User;
import com.fc.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class ServiceImplTests {
    @Autowired
    private UserService userService;

    // 能够获取到BaseMapper的
    @Test
    void testGetBaseMapper() {
        BaseMapper<User> baseMapper = userService.getBaseMapper();

        System.err.println(baseMapper);
        List<User> users = baseMapper.selectList(null);
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    void testList(){
        List<User> list = userService.list();
        for (User user : list) {
            System.out.println(user);
        }
    }
    //删除的操作是对BaseMapper的封装，原本获取的是受影响的行数，现在获取到的是是否删除成功
    @Test
    void testRemoveId(){
        boolean removeById = userService.removeById(1);
        System.err.println("是否i删除成功"+removeById);
    }
    //删除多个id，只执行了一次sql语句，一次删除
    //删除成功一个也是true
    @Test
    void testRemoveByIds(){
        boolean b = userService.removeByIds(Arrays.asList(11, 2, 3));
        System.out.println("是否删除成功"+b);
    }
    //执行了三次sql语句
    @Test
    void testRemoveBatchByIds(){
        boolean b = userService.removeBatchByIds(Arrays.asList(11, 2, 3));
        System.out.println("是否删除成功"+b);
    }
//测试插入
    @Test
    void testSave(){
        User user = new User();
        user.setName("马儿扎哈");
        user.setAge("10");
        user.setUsername("蚂蚱哈");
        user.setPassword("666");
        boolean save = userService.save(user);
        System.out.println("是否插入成功：" + save);
        System.out.println("获取主键自增长id：" + user.getId());
    }
    // 插入或者修改操作
    // 如果我们传递了id那么就是修改操作
    // SELECT id,name,age,gender,birthday,info FROM student WHERE id=?
    // UPDATE student SET name=?, age=?, gender=?, birthday=?, info=? WHERE id=?
    // 如果没有传递id就是插入操作
    @Test
    void testSaveOrUpdate(){
        User user = new User();
        user.setId(-1384083455);
        user.setGender("女");
        boolean b = userService.saveOrUpdate(user);
        System.out.println("修改是否成功"+b);
    }
    // 测试批量插入，执行了两次SQL
    // INSERT INTO student ( id, name, age, birthday, info ) VALUES ( ?, ?, ?, ?, ? )
//    @Test
//    void testSaveBatch() {
//        Set<Student> students = new HashSet<>();
//
//        Student student1 = new Student();
//        student1.setName("王心凌");
//        student1.setAge(40);
//        student1.setBirthday(new Date());
//        student1.setInfo("甜心教主");
//
//        students.add(student1);
//
//        Student student2 = new Student();
//        student2.setName("刘耕宏");
//        student2.setAge(50);
//        student2.setBirthday(new Date());
//        student2.setInfo("《本草纲目》");
//
//        students.add(student2);
//
//        boolean saved = studentService.saveBatch(students);
//
//        System.out.println("是否插入成功：" + saved);
//    }
}