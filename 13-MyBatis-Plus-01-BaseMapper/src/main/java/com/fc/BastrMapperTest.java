package com.fc;

import com.fc.dao.UserDao;
import com.fc.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//通用mapper测试
@SpringBootTest
public class BastrMapperTest {
    @Autowired
    private UserDao userDao;
    //查询全部
    @Test
    public void findAll(){
        List<User> users = userDao.selectList(null);
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    //测试根据id查询
    public void findById(){
        User user = userDao.selectById(4);
        System.out.println(user);
    }
    //测试根据id批量查询
    @Test
    public void findByIdOnBatch(){
        List<User> users = userDao.selectBatchIds(Arrays.asList(4, 5, 6));
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    //测试查询总数
    public void  count(){
        Long count = userDao.selectCount(null);
        System.out.println(count);
    }
    //简单条件查询
    @Test
    public void findMap(){
        //添加条件
        Map<String,Object> conditional = new HashMap<>();
        conditional.put("gender","男");
        conditional.put("age",11);
        List<User> users = userDao.selectByMap(conditional);
        for (User user : users) {
            System.out.println(user);
        }
    }
    //测试插入
    @Test
    public void insert(){
        User user = new User();
        user.setUsername("唔西迪西");
        user.setPassword("can i login");
        user.setAge("6");
        user.setName("面试必过");
        int affectedRows = userDao.insert(user);
        System.out.println(affectedRows>0?"添加成功":"添加失败");
    }
    @Test
    //测试根据id进行删除
    public void delete(){
        int affectedRows = userDao.deleteById(9);
        System.out.println(affectedRows>0?"删除成功":"删除失败");
    }
    //多条件删除
    @Test
    public void testDeleteByConditional(){
        //必须满足所有条件才能删除
        Map<String,Object> map = new HashMap<>();
        map.put("id",5);
        map.put("gender","男");
        int affectedRows = userDao.deleteByMap(map);
        System.out.println(affectedRows>0?"删除成功":"删除失败");
    }
    //批量删除
    @Test
    public void testBatchDelete(){
        int affectedRows = userDao.deleteBatchIds(Arrays.asList(1,2,3));
        System.out.println(affectedRows);
    }
        //根据id进行修改
    @Test
    public void update(){
        User user = new User();
        user.setId(-1384083455);
        user.setName("必过666");
        int affectedRows = userDao.updateById(user);

        System.out.println(affectedRows>0?"修改成功":"修改失败");
    }
    @Test
    //测试自定义sql语句
    public void CustomSql(){
        List<User> users = userDao.selectByDesc();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
