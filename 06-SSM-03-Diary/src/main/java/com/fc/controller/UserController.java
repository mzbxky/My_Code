package com.fc.controller;

import com.fc.dao.TbUserMapper;
import com.fc.entity.TbUser;
import com.fc.service.UserService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
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
@RequestMapping("login")
public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");

    String username = req.getParameter("username");
    String password = req.getParameter("password");
    TbUser user = tbUserMapper.selectUser(username);
    if(user==null){

    }else {
        HttpSession session = req.getSession(true);

        session.setAttribute("username", username);

        Cookie cookie = new Cookie("JSESSIONID", session.getId());

        cookie.setMaxAge(30);

        resp.addCookie(cookie);

        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }


}

@RequestMapping("update")
    public ResultVo update(@RequestBody TbUser user, @RequestBody MultipartFile img){
        return userService.update(user,img);
    }
    @GetMapping("logout")
    public ModelAndView logout(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        ModelAndView mv = null;
        //获取session
        HttpSession session = req.getSession(false);
        String path = null;
        if (session!=null){
            //移除
            session.removeAttribute("user");
            //
            Cookie cookie = new Cookie("JSESSIONID","");
            cookie.setMaxAge(0);
            resp.addCookie(cookie);
//            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            mv.setViewName("/login.jsp");

        }else {
            resp.getWriter().print("未登录不可执行此操作");
        }
 return mv;
    }

}
