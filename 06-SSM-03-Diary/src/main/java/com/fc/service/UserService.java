package com.fc.service;

import com.fc.entity.TbUser;
import com.fc.vo.ResultVo;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {


    ResultVo delete(Integer id);

    Integer checkNick(Integer id);


    ResultVo update(TbUser user, MultipartFile img);


}
