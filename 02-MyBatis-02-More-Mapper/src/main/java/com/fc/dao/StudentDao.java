package com.fc.dao;

import com.fc.entity.Student;

public interface StudentDao {
    Student findById(Integer id);
}
