package com.fc.controller;

import com.fc.entity.TbNote;
import com.fc.entity.TbUser;
import com.fc.service.IndexService;
import com.fc.vo.NoteVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

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

        // 获取域对象中的user
        TbUser user = (TbUser) session.getAttribute("user");

        // 获取用户id
        Integer userId = user.getId();

        // 所有的日记
        PageInfo<TbNote> pageInfo = indexService.page(pageNum, pageSize, userId, id, title, date);
        mv.addObject("page", pageInfo);

        // 获取所有日记的日期分类
        List<NoteVO> dateInfo = indexService.findDateInfo(userId);

        session.setAttribute("dateInfo", dateInfo);

        // 获取所有日记的类别
        List<NoteVO> typeInfo = indexService.findTypeInfo(userId);
        session.setAttribute("typeInfo", typeInfo);


        if (id != null) {
            mv.addObject("typeId", id);
        }

        if (title != null && !title.equals("")) {
            mv.addObject("title", title);
        }

        if (date != null && !date.equals("")) {
            mv.addObject("date", date);
        }
        mv.addObject("changePage", "/note/list.jsp");
        mv.addObject("menu_page", "index");

        mv.setViewName("forward:/index.jsp");
        return mv;
    }
    @GetMapping("searchType")
    public ModelAndView searchType(Integer id, ModelAndView mv) {
        mv.addObject("id", id);

        mv.setViewName("forward:/index/page");

        return mv;
    }

    @GetMapping("searchTitle")
    public ModelAndView searchTitle(String title, ModelAndView mv) {
        mv.addObject("title", title);

        mv.setViewName("forward:/index/page");

        return mv;
    }

    @GetMapping("searchDate")
    public ModelAndView searchDate(String date, ModelAndView mv) {
        mv.addObject("date", date);

        mv.setViewName("forward:/index/page");

        return mv;
    }

}
