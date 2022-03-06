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

public class MyBatisTest {
    //添加数据
    @Test
    public void testAdd(){
        SqlSession session = null;
        //读取配置文件
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            //获取工厂
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            //获取连接
            session = factory.openSession();
            //执行sql语句
            StudentDao mapper = session.getMapper(StudentDao.class);
            int affectedRows = mapper.add();
            ;
            //提交
            session.commit();
            System.out.println("受影响的行数"+affectedRows);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (session!=null){
                session.close();
            }
        }
    }

    @Test
    public void testSelect() {
        try {
            // 读取配置文件
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            // 获取sqlSession工厂对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            // 获取sqlSession，这个东西就类似queryRunner。包含了所有对数据库的操作
            SqlSession session = sqlSessionFactory.openSession();

            // 执行指定明明空间下的指定sql语句tr
            StudentDao mapper = session.getMapper(StudentDao.class);
            Student student = mapper.selectOne();

            System.out.println(student);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //根据指定id查询
    @Test
    public void testFindById(){
        //读取配置
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            //获取工厂
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            //获取连接
            SqlSession session = factory.openSession();
            //获取接口的实现类
            StudentDao studentDao = session.getMapper(StudentDao.class);
            Student student = studentDao.findById(4);
            System.out.println(student);
            //提交
            session.commit();
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
