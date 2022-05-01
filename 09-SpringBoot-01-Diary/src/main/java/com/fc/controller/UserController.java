package com.fc.controller;

import com.fc.entity.TbUser;
import com.fc.service.UserService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
private UserService userService;
    @Autowired
    private FileController file;
    @PostMapping("login")
    public ModelAndView login(TbUser user,
                              Integer remember,
                              HttpSession session,
                              HttpServletResponse response,
                              ModelAndView mv) {

        // 调用业务层的登录方法
        ResultVo result = userService.login(user.getUsername(), user.getPassword());

        // 登录成功的情况
        if (result.getCode() == 200) {

            session.setAttribute("user", result.getData());

            Cookie cookie;

            // 勾选了记住我
            if (remember != null && remember == 1 ) {
                cookie = new Cookie("JSESSIONID", session.getId());
                System.out.println("勾选了");
                // 半个钟头
                cookie.setMaxAge(30 * 60);
            } else {
                cookie = new Cookie("JSESSIONID", null);

                // 浏览器关闭时自动销毁
                cookie.setMaxAge(-1);
            }

            // 发送到浏览器
            response.addCookie(cookie);

            mv.setViewName("/index.jsp");
        } else {
            // 登录失败的情况
            mv.addObject("resultInfo", result);
            mv.setViewName("redirect:/login.jsp");
        }

        return mv;
    }
    @GetMapping("logout")
    public ModelAndView logout(HttpSession session, HttpServletRequest req,HttpServletResponse resp,ModelAndView mv){
        //获取session
        session = req.getSession(false);
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
    @GetMapping("userCenter")
    public ModelAndView userCenter(HttpSession session,ModelAndView mv){
        TbUser user = (TbUser) session.getAttribute("user");
        session.setAttribute("menu_page",user);
        session.setAttribute("changePage","/user/info.jsp");
        mv.setViewName("forward:/index.jsp");
        return mv;
    }
    @PostMapping("update")
    public ModelAndView update(ModelAndView mv, MultipartFile img,@RequestBody TbUser user){
        if (img!=null){
            Map<String,Object> map = file.jsonFileUpload(img);
            int code = (int) map.get("code");
           // String path = (String) map.get("data");
            if (code == 200){
                mv.setViewName("forward:/user/userCenter");
            }else {
                mv.setViewName("forward:/index.jsp");
            }
        }else {
            int affectedRows = userService.update(user);
            if (affectedRows>0){
                mv.setViewName("forward:/user/userCenter");
            }else {
                mv.setViewName("forward:/index.jsp");
            }
        }
        return mv;
    }
    @GetMapping("checkNick")
    public int checkNick(String nick){
        return userService.checkNick(nick);
    }
}
