package com.fc.service;

import com.fc.vo.ResultVo;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

public interface FileService {
    ResultVo file(MultipartFile file, ModelAndView mv);
}
