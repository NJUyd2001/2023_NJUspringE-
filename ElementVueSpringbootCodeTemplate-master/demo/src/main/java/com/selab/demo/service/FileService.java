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

@Service
public class FileService {
    @Autowired
    FileDao fileDao;
    @Autowired
    FileUtil fileUtil;
    public Integer upload(MultipartFile file, Integer PID){
        try {
            String fileName = file.getOriginalFilename();
            String filePath = fileUtil.getUpload(file, PID);
            FileModel fileModel = new FileModel(filePath, PID, fileName);
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
}
