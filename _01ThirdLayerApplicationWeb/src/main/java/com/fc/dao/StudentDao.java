package com.fc.dao;

import com.fc.entity.Student;

import java.util.List;

public interface StudentDao {
    int getTotalCount();
    List<Student> gitList(int pageNo,int pageSize);
}
