package com.fc.controller;

import com.fc.entity.TbNoteType;
import com.fc.entity.TbUser;
import com.fc.service.TypeService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("type")
public class TypeController {
    @Autowired
    private TypeService typeService;
    @GetMapping("list")
    public ModelAndView list(ModelAndView mv, HttpSession session){
        TbUser user = (TbUser) session.getAttribute("user");
        Integer userId = user.getId();
        List<TbNoteType> types = typeService.list(userId);
        session.setAttribute("list",types);
        session.setAttribute("changePage","/type/list.jsp");
        mv.setViewName("forward:/index.jsp");
        return mv;
    }
    @RequestMapping("addOrUpdate")
    @ResponseBody
    public ResultVo addOrUpdate( TbNoteType tbNoteType){
        ResultVo result = null;
        if (tbNoteType.getId()!=null){
            result = typeService.update(tbNoteType);
        }else {
            result = typeService.add(tbNoteType);
        }
        return result;
    }
    @GetMapping("delete")
    @ResponseBody
    public ResultVo delete(Integer id){
        return typeService.delete(id);
    }
}
