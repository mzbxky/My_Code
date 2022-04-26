package com.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("file")
public class FileController {
    @RequestMapping("upload")
    public ModelAndView upload(MultipartFile upload, ModelAndView mv) {
        //准备路径
        String path = "D:/server/apache-tomcat-8.5.37/webapps/upload";
        File file = new File(path);
        if (!file.exists()){
            file.mkdirs();
        }
        //获取文件名
        String filename = upload.getOriginalFilename();
        if (filename!=null){
            try {
                upload.transferTo(new File(path,filename));
                mv.addObject("img","http://localhost:8081/upload/"+file.getName());
                mv.setViewName("/success.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        //准备路径
//        String path = "D:/server/apache-tomcat-8.5.37/webapps/upload";
//        File file = new File(path);
//        //判断路径是否存在，如果不存在就创建
//        if (!file.exists()){
//            file.mkdirs();
//        }
//        //获取文件名
//        String filename = upload.getOriginalFilename();
//        //如果文件名不为空
//        if (filename!=null){
//            try {
//                upload.transferTo(new File(path,filename));
//                //将对象添加到模型中
//                mv.addObject("img","http://localhost:8081/upload/"+file.getName());
//                mv.setViewName("/success.jsp");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        //准备路径
//        String path = "D:/server/apache-tomcat-8.5.37/webapps/upload";
//        File file = new File(path);
//        //如果路径不存在
//        //file.exists测试此路径或文件名是否存在
//        if (!file.exists()){
//            //创建由抽象路径名表示 的 新目录以及该抽象路径名 的 所有不存在 的 父目录
//            //如果路径不存在就创建
//            file.mkdirs();
//        }
//        //获取文件名
//        String filename = upload.getOriginalFilename();
//        //上传
//        //如果文件名不为空就上传
//        if (filename!=null){
//            try {
//                upload.transferTo(new File(path,filename));
//                //将对象添加到模型中
//                mv.addObject("img","http://localhost:8081/upload/"+file.getName());
//                //设置跳转路径
//                mv.setViewName("/success.jsp");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

//        //准备路径
//        String path = "D:/server/apache-tomcat-8.5.37/webapps/upload";
//        File file = new File(path);
//        //如果路径不存在
//        if(!file.exists()){
//            file.mkdirs();
//        }
//        //获取文件名
//        String filename = upload.getOriginalFilename();
//
//            //上传
//        try {
//            if(filename!=null) {
//                upload.transferTo(new File(path, filename));
//                mv.addObject("img","http://localhost:8081/upload/"+file.getName());
//                mv.setViewName("/success.jsp");
//
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }



//        // 准备路径
//        String path = "D:/server/apache-tomcat-8.5.37/webapps/upload";
//
//        File file = new File(path);
//
//        // 路径不存在
//        if (!file.exists()) {
//            file.mkdirs();
//        }
//
//        // 获取文件名
//        String filename = upload.getOriginalFilename();
//
//        try {
//            if (filename != null) {
//                // 上传
//                upload.transferTo(new File(path, filename));
//
//                mv.addObject("img", "http://localhost:8081/upload/" + filename);
//
//                mv.setViewName("/success.jsp");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        return mv;
    }
}

