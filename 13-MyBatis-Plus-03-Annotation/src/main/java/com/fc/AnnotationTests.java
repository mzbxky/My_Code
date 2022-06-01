package com.fc;

import com.fc.dao.UserMapper;
import com.fc.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class AnnotationTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    void testList(){
        List<User> Users = userMapper.selectList(null);
        for (com.fc.entity.User User : Users) {
            System.out.println(User);
        }
    }
    @Test
    //测试逻辑删除
    void testLogicDelete(){
        int i = userMapper.deleteById(2);
        System.out.println(i>0 ? "删除成功":"删除失败");
    }
}
