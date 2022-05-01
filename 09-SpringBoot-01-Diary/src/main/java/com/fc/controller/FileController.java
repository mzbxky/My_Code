package com.fc.controller;

import com.fc.util.FileUploadUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Controller

public class FileController {
    public Map<String, Object> jsonFileUpload(@RequestPart("img") MultipartFile img) {
        Map<String, Object> map = new HashMap<>();

        Set<String> paths = new HashSet<>();
        // 单文件上传
        if (img!=null&&!img.getOriginalFilename().isEmpty()) {

            String path = FileUploadUtil.fileUpload(img);
            paths.add(path);
        }
        map.put("code", 200);
        map.put("message", "上传成功");
        map.put("success", true);
        map.put("data", paths);

        return map;
    }


}
