package com.selab.demo.controller;

import com.fasterxml.jackson.core.json.UTF8JsonGenerator;
import com.selab.demo.model.FileModel;
import com.selab.demo.service.FileService;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;


@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired
    FileService fileService;
    @CrossOrigin
    @RequestMapping(value="/upload", method = RequestMethod.POST)
    public Integer upload(@RequestParam("file") MultipartFile file,
                         @RequestParam("PID") Integer PID){
        return fileService.upload(file, PID);
    }
    @CrossOrigin
    @RequestMapping(value="/select/all", method = RequestMethod.POST)
    public FileModel[] selectAllFiles(){
        return fileService.selectAllFiles();
    }
    @CrossOrigin
    @RequestMapping(value="/select/byPID", method = RequestMethod.POST)
    public FileModel[] selectByPID(@RequestParam("PID") Integer PID){
        return fileService.selectByPID(PID);
    }
    @CrossOrigin
    @RequestMapping(value="/select/byFID", method = RequestMethod.POST)
    public FileModel selectByFID(@RequestParam("FID") Integer FID){
        return fileService.selectByFID(FID);
    }

    @CrossOrigin
    @RequestMapping(value = "/download", method = RequestMethod.POST)
    public String download(@RequestParam("FID") Integer FID, HttpServletResponse response){
        //  新建文件流，从磁盘读取文件流
        FileModel fileModel = selectByFID(FID);
        if(fileModel == null) return "不存在FID为 "+FID.toString() + " 的文件";
        try (FileInputStream fis = new FileInputStream(fileModel.getFilePath());
             BufferedInputStream bis = new BufferedInputStream(fis);
             OutputStream os = response.getOutputStream()) {    //  OutputStream 是文件写出流，将文件下载到浏览器客户端
            // 新建字节数组，长度是文件的大小，比如文件 6kb, bis.available() = 1024 * 6
            byte[] bytes = new byte[bis.available()];
            // 从文件流读取字节到字节数组中
            bis.read(bytes);
            // 重置 response
            response.reset();
            // 设置 response 的下载响应头
            response.setHeader("Access-Control-Allow-Origin","*");
            response.setHeader("Access-Control-Expose-Headers", "Content-disposition");
            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition", "attachment;filename="
                    + URLEncoder.encode(fileModel.getFileName(), StandardCharsets.UTF_8));
            // 写出字节数组到输出流
            os.write(bytes);
            // 刷新输出流
            os.flush();
        } catch (Exception e) {

            return e.getMessage();
        }
        return "下载任务创建成功";
    }

}
