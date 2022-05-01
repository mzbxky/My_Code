package com.fc.service;

import com.fc.entity.TbUser;
import com.fc.vo.ResultVo;

public interface UserService {
    ResultVo login(String username, String password);


    int update(TbUser user);

    int checkNick(String nick);
}
