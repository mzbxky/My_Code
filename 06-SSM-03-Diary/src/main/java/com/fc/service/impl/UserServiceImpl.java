package com.fc.service.impl;

import com.fc.controller.FileController;
import com.fc.dao.TbUserMapper;
import com.fc.entity.TbUser;
import com.fc.service.UserService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    TbUserMapper tbUserMapper;


    @Override
    public ResultVo login(String username, String password, int remember, HttpServletRequest req, HttpServletResponse resp) {
            TbUser user = tbUserMapper.selectUser(username);
            ResultVo resultVo = null;
            //说名该用户存在
            if (user!=null){
                //用户名与密码一致
                if (password.equals(user.getPassword())){
                    //获取session
                    HttpSession session = req.getSession(true);
                    //将登录信息存储到session中

                    session.setAttribute("user",user);

                    //准备jsessionid对应的cookie
                    Cookie cookie = new Cookie("JSESSIONID",session.getId());

                    if (remember == 1){

                        //设置cookie过期时间

                        cookie.setMaxAge(60*30);

                        resp.addCookie(cookie);

                    }else {
                        System.out.println(remember+"在这里");
                        //设置cookie过期时间
                        cookie.setMaxAge(-1);
                    }

                    resultVo = new ResultVo(200,"登录成功",true,null);
                    try {
                        req.getRequestDispatcher("/index.jsp").forward(req, resp);

                    } catch (IOException | ServletException e) {
                        e.printStackTrace();
                    }
                }else {
                    resultVo = new ResultVo(-1,"登录失败，用户名或密码错误",false,null);
                }
            }else {
                resultVo = new ResultVo(-1,"登录失败，用户名或密码错误",false,null);
            }
        return resultVo;
    }

    @Override
    public ResultVo delete(Integer id) {
        ResultVo resultVo;
        int affectedRows = tbUserMapper.deleteByPrimaryKey(id);

        if(affectedRows>0){
            resultVo = new ResultVo(200,"删除成功",true,null);
        }else {
            resultVo = new ResultVo(-1,"删除失败",false,null);
        }
        return resultVo;
    }

    @Override
    public Integer checkNick(Integer id) {
        TbUser user = tbUserMapper.selectByPrimaryKey(id);
        if(user == null){
            return 1;
        }
        return -1;
    }

    @Override
    public ResultVo update(TbUser user, MultipartFile img) {
        ResultVo resultVo = null;
        Map<String,Object> map = new HashMap<>();
        if (img!=null){
            FileController fileController = null;
            ResultVo resultVo1 = fileController.upload(img);
            if (resultVo1.getCode()>0){
                map.put("img","头像上传成功");
            }
        }else {
           int affectedRows =  tbUserMapper.updateByPrimaryKeySelective(user);
           if (affectedRows>0){
               map.put("data","修改成功");
               resultVo = new ResultVo(1,"修改成功",true,map);
           }else {
               resultVo = new ResultVo(-1,"修改失败",false,null);
           }
        }
        return resultVo;
    }




}
