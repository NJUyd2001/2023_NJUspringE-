package com.selab.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.selab.demo.dao.FileDao;
import com.selab.demo.dao.UserDao;
import com.selab.demo.model.FileModel;
import com.selab.demo.utils.FileUtil;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;

@Service
public class FileService {
    @Autowired
    FileDao fileDao;
    @Autowired
    FileUtil fileUtil;
    public Integer upload(MultipartFile file, Integer PID, String state, String fileType) throws Exception{
        try {
            String fileName = file.getOriginalFilename();
            String filePath = fileUtil.uploadWithFileInfo(file, PID, state, fileType);
            FileModel fileModel = new FileModel(filePath, PID, fileName);
            fileModel.setState(state);
            fileModel.setFileType(fileType);
            if(filePath.isEmpty()) return null;
            fileDao.upload(fileModel);
            return fileModel.getFID();
        }catch (IOException e){
            System.out.println(e.getCause().getMessage());
            return null;
        }
    }
    public FileModel[] selectAllFiles(){
        return fileDao.selectAllFiles();
    }
    public FileModel[] selectByPID(Integer PID){
        return fileDao.selectByPID(PID);
    }
    public FileModel selectByFID(Integer FID){
        return fileDao.selectByFID(FID);
    }
    public Integer selectByState(String postJson){
        System.out.println("内容：" + postJson);
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer PID = jsonObject.getInteger("PID");
        String state = jsonObject.getString("state");
        String fileType = jsonObject.getString("fileType");
        FileModel fileModel = new FileModel();
        fileModel.setState(state);
        fileModel.setFileType(fileType);
        fileModel.setPID(PID);
        //System.out.println("转化为：" + fileModel);
        try{
            return fileDao.selectByState(fileModel);
        }catch (Exception e){
            return -1;
        }
    }
}
