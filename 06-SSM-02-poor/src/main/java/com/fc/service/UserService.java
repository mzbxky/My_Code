package com.fc.service;

import com.fc.entity.User;
import com.fc.vo.ResultVo;

public interface UserService {
    ResultVo delete(Long id);

    ResultVo updateUser(User user);

    ResultVo addUser(User user);

    ResultVo getList(Integer pageNo, Integer pageSize,Long id);
}
