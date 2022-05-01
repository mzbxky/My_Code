package com.fc.controller;

import com.fc.entity.TbNote;
import com.fc.entity.TbUser;
import com.fc.service.IndexService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("index")
public class IndexController {
    @Autowired
    private IndexService indexService;
    @RequestMapping(value = "page", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView page(ModelAndView mv,
                             HttpSession session,
                             Integer id,
                             String title,
                             String date,
                             @RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
                             @RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize){

        TbUser user = (TbUser) session.getAttribute("user");

        //获取用户id
        Integer userId = user.getId();

        PageInfo<TbNote> pageInfo = indexService.page(pageNum, pageSize, userId, id, title, date);
        mv.addObject("page",pageInfo);
        mv.addObject("changePage","/note/list.jsp");
        mv.setViewName("forward:/index.jsp");
        return mv;
    }
    @GetMapping("searchType")
    public ModelAndView searchType(ModelAndView mv,Integer id,HttpSession session){
        session.setAttribute("id",id);
        mv.setViewName("forward:/index/page");
        return mv;
    }
    @GetMapping("searchTitle")
        public ModelAndView searchTitle(ModelAndView mv,String title,HttpSession session){
        session.setAttribute("title",title);
        mv.setViewName("forward:/index/page");
            return mv;
        }
    @GetMapping("searchDate")
    public ModelAndView searchDate(ModelAndView mv, Date date, HttpSession session){
        session.setAttribute("pubTime",date);
        mv.setViewName("forward:/index/page");
        return mv;
    }

}
