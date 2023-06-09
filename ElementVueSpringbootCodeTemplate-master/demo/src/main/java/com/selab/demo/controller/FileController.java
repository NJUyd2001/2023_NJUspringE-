package com.selab.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.json.UTF8JsonGenerator;
import com.selab.demo.dao.FileDao;
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
    @Autowired
    FileDao fileDao;
    @CrossOrigin
    @RequestMapping(value="/upload", method = RequestMethod.POST)
    public Integer upload(@RequestParam("file") MultipartFile file,
                         @RequestParam("PID") Integer PID,
                          @RequestParam("state") String state,
                          @RequestParam("fileType") String fileType){
        try {
            return fileService.upload(file, PID, state, fileType);
        }   catch (Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
    }
    @CrossOrigin
    @RequestMapping(value="/select/all", method = RequestMethod.POST)
    public FileModel[] selectAllFiles(){
        return fileService.selectAllFiles();
    }
//    @CrossOrigin
//    @RequestMapping(value="/select/byPID", method = RequestMethod.POST)
//    public FileModel[] selectByPID(@RequestParam("PID") Integer PID){
//        return fileService.selectByPID(PID);
//    }
//    @CrossOrigin
//    @RequestMapping(value="/select/byFID", method = RequestMethod.POST)
//    public FileModel selectByFID(@RequestParam("FID") Integer FID){
//        return fileService.selectByFID(FID);
//    }
    @CrossOrigin
    @RequestMapping(value="/select/byPID", method = RequestMethod.POST)
    public FileModel[] selectByPID(@RequestBody String postJson) {
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        try{
            Integer PID = jsonObject.getInteger("PID");
            return fileService.selectByPID(PID);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    @CrossOrigin
    @RequestMapping(value = "/select/fileName", method = RequestMethod.POST)
    public String selectFileName(@RequestBody String postJson){
        return fileService.selectFileName(postJson);
    }
    @CrossOrigin
    @RequestMapping(value="/select/byFID", method = RequestMethod.POST)
    public FileModel selectByFID(@RequestBody String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        try{
            Integer FID = jsonObject.getInteger("FID");
            return fileService.selectByFID(FID);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    @CrossOrigin
    @RequestMapping(value="/select/byState", method = RequestMethod.POST)
    public Integer selectByState(@RequestBody String postJson){
        return fileService.selectByState(postJson);
    }
    @CrossOrigin
    @RequestMapping(value = "/download", method = RequestMethod.POST)
    public String download(@RequestBody String postJson, HttpServletResponse response){
        //  新建文件流，从磁盘读取文件流
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer FID = jsonObject.getInteger("FID");
        FileModel fileModel = fileDao.selectByFID(FID);
        System.out.println(fileModel);
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


//    @CrossOrigin
//    @RequestMapping(value = "/downloadWithState", method = RequestMethod.POST)
//    public String downloadWithState(@RequestParam("PID") Integer PID, @RequestParam("state") String state,
//                           @RequestParam("fileType") String fileType, HttpServletResponse response) {
//        //  新建文件流，从磁盘读取文件流
//        FileModel fileModel = new FileModel();
//        fileModel.setFileType(fileType);
//
//        fileModel.setState(state);
//        fileModel.setPID(PID);
//        Integer FID = fileDao.selectByState(fileModel);
//        System.out.println(fileModel);
//        if (FID == -1) return "不存在符合条件的文件";
//        try (FileInputStream fis = new FileInputStream(fileModel.getFilePath());
//             BufferedInputStream bis = new BufferedInputStream(fis);
//             OutputStream os = response.getOutputStream()) {    //  OutputStream 是文件写出流，将文件下载到浏览器客户端
//            // 新建字节数组，长度是文件的大小，比如文件 6kb, bis.available() = 1024 * 6
//            byte[] bytes = new byte[bis.available()];
//            // 从文件流读取字节到字节数组中
//            bis.read(bytes);
//            // 重置 response
//            response.reset();
//            // 设置 response 的下载响应头
//            response.setHeader("Access-Control-Allow-Origin", "*");
//            response.setHeader("Access-Control-Expose-Headers", "Content-disposition");
//            response.setContentType("application/octet-stream");
//            response.setHeader("Content-disposition", "attachment;filename="
//                    + URLEncoder.encode(fileModel.getFileName(), StandardCharsets.UTF_8));
//            // 写出字节数组到输出流
//            os.write(bytes);
//            // 刷新输出流
//            os.flush();
//        } catch (Exception e) {
//
//            return e.getMessage();
//        }
//        return "下载任务创建成功";
//    }
}
