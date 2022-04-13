package com.fc.controller;

import com.fc.service.FileService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@RestController
@CrossOrigin("/*")

public class FileController {
    @Autowired
    private FileService fileService;
    @RequestMapping("uploadImg")
    public ResultVo upload(@RequestBody MultipartFile file, ModelAndView mv) {
        return fileService.file(file,mv);
    }
}
