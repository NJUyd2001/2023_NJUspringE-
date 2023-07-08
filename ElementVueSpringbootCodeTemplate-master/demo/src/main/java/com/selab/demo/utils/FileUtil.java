package com.selab.demo.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.rmi.server.UID;

@Component
public class FileUtil {
    public static final String UPLOAD_FILEPATH = "D:\\selab\\file\\";
    @ResponseBody
    public String getUpload(@RequestPart(value = "file") MultipartFile mf,
    @RequestParam(value = "PID") Integer PID) throws IOException {

        System.out.println("文件上传信息:"+mf.getOriginalFilename());

        //将文件上传到指定文件夹
        if (!mf.isEmpty()){
            String fileName=mf.getOriginalFilename();
            //文件上传
            String finalPath = UPLOAD_FILEPATH + PID.toString() + "\\" + fileName;
            File finaFile = new File(finalPath);
            if (!finaFile.exists())
                finaFile.mkdirs();
            mf.transferTo(new File(finalPath));
            return finalPath;

        }

        return ""; // 文件不存在
    }
}