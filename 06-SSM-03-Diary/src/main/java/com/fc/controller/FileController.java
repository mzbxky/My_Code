package com.fc.controller;

import com.fc.service.FileService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin("/*")

public class FileController {
    @Autowired
    private FileService fileService;
    @RequestMapping("uploadImg")
    public ResultVo upload(@RequestBody MultipartFile file) {
        return fileService.file(file);
    }
}
