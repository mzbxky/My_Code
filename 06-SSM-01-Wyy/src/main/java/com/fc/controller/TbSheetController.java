package com.fc.controller;

import com.fc.entity.TbMusic;
import com.fc.entity.TbSheet;
import com.fc.service.TbSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("sheet")
public class TbSheetController {
    @Autowired
    private TbSheetService tbSheetService;
    @RequestMapping("findAll")
    public List<TbSheet> findAll(){
        return tbSheetService.findAll();
    }
    @RequestMapping("insertSheet")
    public Map<String, Object> insertSheet(TbSheet sheetName){
        Map<String,Object> map = new HashMap<>();
        if(tbSheetService.insertSheet(sheetName)==1){
            map.put("code",1);
            map.put("message","创建成功");
        }else {
            map.put("code",-1);
            map.put("message","创建失败");
        }
        return map;
    }
    @RequestMapping("findSongsBySheet")
    public List<TbMusic> findSongsBySheet(TbSheet sheetName){
        return tbSheetService.findSongsBySheet(sheetName);
    }
}
