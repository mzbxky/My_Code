package com.fc.dao;

import com.fc.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserDao {
    List<User> findAll();

    int add(User user);

    int update(User user);

    int delete(Integer id);

}
