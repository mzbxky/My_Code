package com.fc.controller;

import com.fc.dao.TbUserMapper;
import com.fc.entity.TbUser;
import com.fc.service.UserService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.*;
import java.io.IOException;

@RestController
@RequestMapping("user")
public class UserController extends HttpServlet {
    @Autowired
    private UserService userService;

    @Autowired
    private TbUserMapper tbUserMapper;
    @GetMapping("delete")
    public ResultVo delete(Integer id){
        return userService.delete(id);
    }
    @GetMapping("checkNick")
    public Integer checkNick(Integer id){
        return userService.checkNick(id);
    }


//@Override
    @PostMapping("login")
public ResultVo login(String username, String password,  int remember, HttpServletRequest req, HttpServletResponse resp){
        return userService.login(username,password,remember,req, resp);
}

    @RequestMapping("update")
    public ResultVo update(@RequestBody TbUser user, @RequestBody MultipartFile img){
        return userService.update(user,img);
    }
    @GetMapping("logout")
    public ModelAndView loginOut(ModelAndView mv,HttpServletRequest req,HttpServletResponse resp){
        //获取session
        HttpSession session = req.getSession(false);
        if (session!=null){
            //移除
            session.removeAttribute("user");

            Cookie cookie = new Cookie("JSESSIONID","");
            cookie.setMaxAge(0);
            resp.addCookie(cookie);
            mv.setViewName("/login.jsp");
        }else {
            try {
                resp.getWriter().print("未登录不可执行此操作");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    return mv;
}
@RequestMapping("automatic")
public ModelAndView automatic(ModelAndView mv,HttpServletRequest req,HttpServletResponse resp) {
    //获取session
    HttpSession session = req.getSession(false);
    // 如果说session为空，说明没有登录
    if (session == null||null==session.getAttribute("user")) {
        System.out.println(session.getAttribute("user")+"session的东西");
        mv.setViewName("/login.jsp");
    }else {
        mv.setViewName("/index.jsp");
    }
    return mv;
}
}
