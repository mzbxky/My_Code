package com.fc.service;

import com.fc.entity.Student;
import com.fc.vo.PageInfo;

public interface StudentService {
    //获取PageInfo对象
    PageInfo<Student> getPageInfo(int pageNo,int pageSize);
}
