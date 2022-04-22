package com.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Controller
@RequestMapping("file")
public class FileController {
    @RequestMapping("toDownload")
    public String toDownload(Model model){
        model.addAttribute("img","001.jpg");
        return "/index.jsp";
    }
    @RequestMapping("download")
    public void download(String filename, HttpServletResponse resp){
        //下载的路径
        String path = "D:/server/apache-tomcat-8.5.37/webapps/upload";
        File file = new File(path,filename);
        //声明要下载了
        resp.setHeader("Content-Dis*position","attachment;filename="+file.getName());
        ServletOutputStream outputStream = null;
        BufferedInputStream inputStream = null;
        try {
            outputStream = resp.getOutputStream();
            inputStream = new BufferedInputStream(new FileInputStream(file));
            //缓冲区
            byte[] buffer = new byte[1024*80];
            //没有读取到文件末尾
            while (inputStream.read(buffer) != -1){
                //写入数据
                outputStream.write(buffer);
                //刷新
                outputStream.flush();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        //下载的路径
//        String path = "D:/server/apache-tomcat-8.5.37/webapps/upload";
//        File file = new File(path,filename);
//        //声明要进行下载了
//        resp.setHeader("Content-Disposition","attachment;filename="+file.getName());
//
//        ServletOutputStream outputStream = null;
//        BufferedInputStream inputStream = null;
//        try {
//            outputStream = resp.getOutputStream();
//            inputStream = new BufferedInputStream(new FileInputStream(file));
//            //缓冲区
//            byte[] buffer = new byte[1024*80];
//            //没有读到文件末尾
//            while (inputStream.read(buffer) != -1){
//                //写入数据
//                outputStream.write(buffer);
//                //刷新
//                outputStream.flush();
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            try {
//                if (inputStream != null) {
//                    inputStream.close();
//                }
//                if (outputStream != null) {
//                    outputStream.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        //下载的路径
//        String path = "D:/server/apache-tomcat-8.5.37/webapps/upload";
//        File file = new File(path,filename);
//        //声明要进行下载了
//        resp.setHeader("Content-Disposition","attachment;filename="+file.getName());
//        ServletOutputStream outputStream = null;
//        BufferedInputStream inputStream = null;
//        try {
//            outputStream = resp.getOutputStream();
//            inputStream = new BufferedInputStream(new FileInputStream(file));
//            // 缓冲区
//            byte[] buffer = new byte[1024 * 80];
//
//            // 没有读到文件的末尾
//            while (inputStream.read(buffer) != -1) {
//                // 写入数据
//                outputStream.write(buffer);
//
//                // 刷新
//                outputStream.flush();
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                if (inputStream != null) {
//                    inputStream.close();
//                }
//                if (outputStream != null) {
//                    outputStream.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }


    }
}
