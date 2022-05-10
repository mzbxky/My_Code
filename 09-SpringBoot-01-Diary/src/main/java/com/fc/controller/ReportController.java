package com.fc.controller;

import com.fc.entity.TbUser;
import com.fc.service.NoteService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RequestMapping("report")
@Controller
public class ReportController {
    @Autowired
    private NoteService noteService;
    @GetMapping("location")
    @ResponseBody
    public ResultVo location(HttpSession session){
        TbUser user = (TbUser) session.getAttribute("user");
        Integer userId = user.getId();
        ResultVo result = noteService.findByUserId(userId);
        return result;
    }
    @GetMapping("info")
    public ModelAndView info(ModelAndView mv,HttpSession session){
        session.setAttribute("menu_page","/report");
        session.setAttribute("changePage","/report/info.jsp");
        mv.setViewName("forward:/index.jsp");
        return mv;
    }
//    @GetMapping("month")
//    @ResponseBody
//    public ResultVo getMonth(HttpSession session) {
//        TbUser user = (TbUser) session.getAttribute("user");
//
//        Map<String, Object> data = reportService.getMonth(user.getId());
//
//        ResultVo vo = new ResultVo();
//
//        if (data != null) {
//            vo.setData(data);
//            vo.setCode(1);
//        }
//
//        return vo;
//    }

}
