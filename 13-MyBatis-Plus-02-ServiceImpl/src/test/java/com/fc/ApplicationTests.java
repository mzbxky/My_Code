package com.fc;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fc.entity.User;
import com.fc.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ApplicationTests {
@Autowired
private UserService userService;
    @Test
    void contextLoads() {
        BaseMapper<User> baseMapper = userService.getBaseMapper();
        System.out.println(baseMapper);
        List<User> users = baseMapper.selectList(null);
        for (User user : users) {
            System.out.println(user);
        }
    }


}
