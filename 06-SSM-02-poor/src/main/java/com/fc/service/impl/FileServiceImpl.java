package com.fc.service.impl;

import com.fc.service.FileService;
import com.fc.vo.ResultVo;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class
FileServiceImpl implements FileService {
    ResultVo resultVo;
    @Override
    public ResultVo file(MultipartFile file, ModelAndView mv) {
        // 准备路径
        String path = "http://localhost:8081/upload/";

        // 获取文件名
        String filename = file.getOriginalFilename();

        // 获取后缀名
        String suffix = filename.substring(filename.lastIndexOf('.'));

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");

        String format = formatter.format(new Date());

        // 拼接成一个新的文件名
        filename = format + suffix;

//        Client client = Client.create();
        Client client = Client.create();

        // 连接服务器
        WebResource resource = client.resource(path + filename);

        try {
            // 推送文件到服务器上
            resource.put(file.getBytes());
            resultVo = new ResultVo(200,"查询成功",true,path+filename);
        } catch (IOException e) {
            resultVo = new ResultVo(200,"查询成功",true,null);
            e.printStackTrace();
        }

//        mv.addObject("img", "http://localhost:8081/upload/" + filename);
//
//        mv.setViewName("/success.jsp");
        System.out.println(resultVo);
        return resultVo;

    }
}
