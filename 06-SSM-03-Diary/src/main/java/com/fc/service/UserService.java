package com.fc.service;

import com.fc.entity.TbUser;
import com.fc.vo.ResultVo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {
    ResultVo login(String username, String password, int number, HttpServletRequest req, HttpServletResponse resp);

    ResultVo delete(Integer id);

    Integer checkNick(Integer id);


    ResultVo update(TbUser user, MultipartFile img);


}
