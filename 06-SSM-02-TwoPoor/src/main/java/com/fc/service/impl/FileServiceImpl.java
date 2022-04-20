package com.fc.service.impl;

import com.fc.service.FileService;
import com.fc.vo.ResultVo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class
FileServiceImpl implements FileService {
    ResultVo resultVo;
    @Override
    public ResultVo file(MultipartFile file, String type) {
//        // 准备路径
//        String path = "http://localhost:8081/upload/";
//
//        // 获取文件名
//        String filename = file.getOriginalFilename();
//
//        // 获取后缀名
//        String suffix = filename.substring(filename.lastIndexOf('.'));
//
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
//
//        String format = formatter.format(new Date());
//
//        // 拼接成一个新的文件名
//        filename = format + suffix;
//
////        Client client = Client.create();
//        Client client = Client.create();
//
//        // 连接服务器
//        WebResource resource = client.resource(path + filename);
//
//        try {
//            // 推送文件到服务器上
//            resource.put(file.getBytes());
//            resultVo = new ResultVo(200,"查询成功",true,path+filename);
//        } catch (IOException e) {
//            resultVo = new ResultVo(200,"查询成功",true,null);
//            e.printStackTrace();
//        }
//
////        mv.addObject("img", "http://localhost:8081/upload/" + filename);
////
////        mv.setViewName("/success.jsp");
//        System.out.println(resultVo);
//        return resultVo;
        // 上传的路径
        String path = "D:/server/apache-tomcat-8.5.37/webapps/upload/Poverty-Alleviation/" + type;

        System.out.println(type);
        File pathFile = new File(path);

        // 如果指定的路径不存在
        if (!pathFile.exists()) {
            // 创建多级路径
            pathFile.mkdirs();
        }

        // 获取文件名
        String filename = file.getOriginalFilename();

        // 获取格式化器
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");

        // 获取格式化之后的日期时间字符串
        String formatDate = formatter.format(new Date());

        // 获取文件后缀名
        String suffix = filename.substring(filename.lastIndexOf('.'));

        // 获取新的文件名
        filename = formatDate + suffix;

        ResultVo vo = new ResultVo();

        try {
            // 文件上传操作
            file.transferTo(new File(pathFile, filename));

            vo.setMessage("上传成功！！！");
            vo.setCode(200);
            vo.setSuccess(true);
//            String imgPath = "http://localhost:8081/upload/Poverty-Alleviation/"+type+ "/" + filename;
//
//            vo.setData(imgPath);
//            System.out.println(vo.getData());
            Map<String, Object> map = new HashMap<>();
            map.put("imgurl", "http://localhost:8081/upload/Poverty-Alleviation/" + type + "/" + filename);

            vo.setData(map);
            //System.out.println(map.get("imgurl"));
        } catch (IOException e) {
            e.printStackTrace();

            vo.setMessage("上传失败！！！");
            vo.setCode(-2000);
            vo.setSuccess(false);

        }

        return vo;
    }
}
