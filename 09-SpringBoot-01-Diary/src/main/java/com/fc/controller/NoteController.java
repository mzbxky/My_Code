package com.fc.controller;

import com.fc.entity.*;
import com.fc.service.NoteService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("note")
public class NoteController {
    @Autowired
    private NoteService noteService;
    @GetMapping("delete")
    @ResponseBody
    public ResultVo delete(Integer id){
        return noteService.delete(id);
    }
    @GetMapping("view")
    public ModelAndView view(ModelAndView mv, HttpSession session,Integer id){
        if (id!=null){
            TbNote note = noteService.list(id);
            session.setAttribute("noteInfo",note);

        }
        TbUser user = (TbUser) session.getAttribute("user");
        Integer userId = user.getId();
        List<TbNoteType> types =noteService.selectType(userId);
        session.setAttribute("typeList",types);
        session.setAttribute("changePage","/note/view.jsp");
        mv.setViewName("forward:/index.jsp");
        return mv;
    }
    @GetMapping("detail")
    @ResponseBody
    public TbNote detail(@RequestParam("id") Integer id, HttpSession session, ModelAndView mv){
        TbNote note = noteService.detail(id);
        session.setAttribute("note",note);
        session.setAttribute("changePage","/note/detail.jsp");
        mv.setViewName("forward:/index.jsp");
        return note;
    }
    @PostMapping("addOrUpdate")
    public ModelAndView addOrUpdate(ModelAndView mv,TbNote note,HttpSession session){
        TbNote noteOne = noteService.detail(note.getId());
        //添加
        if (noteOne==null){
            int affectedRows = noteService.add(note);
            if (affectedRows>0){
                mv.setViewName("forward:/index.jsp");
            }else {
                session.setAttribute("resultInfo",noteOne);
                session.setAttribute("id",note.getId());
                mv.setViewName("forward:/note/view");
            }
        }else {
            int affectedRows = noteService.update(note);
            if (affectedRows>0){
                mv.setViewName("forward:/index.jsp");
            }else {
                session.setAttribute("resultInfo",noteOne);
                session.setAttribute("id",note.getId());
                mv.setViewName("forward:/note/view");
            }
        }

return mv;
    }
}
