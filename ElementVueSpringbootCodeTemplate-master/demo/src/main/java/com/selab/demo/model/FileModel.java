package com.selab.demo.model;

import javax.persistence.Entity;
/**
 * @author 刘轩昂
 * @time 2023/6/28
 * */
@Entity
public class FileModel {
    private Integer FID;           // 文件ID
    private String filePath;        // 文件在服务器中的存储路径
    private Integer PID;    // 上传用户ID

    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    private String uploadTime;
    public FileModel( String filePath, Integer PID, String fileName) {
        this.filePath = filePath;
        this.PID = PID;
        this.fileName = fileName;
    }
    public FileModel( ) {

    }
    public FileModel( Integer FID,String filePath, Integer PID, String uploadTime, String fileName) {
        this.FID = FID;
        this.filePath = filePath;
        this.PID = PID;
        this.uploadTime = uploadTime;
        this.fileName  = fileName;
    }
    public Integer getFID() {
        return FID;
    }

    public void setFID(Integer FID) {
        this.FID = FID;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Integer getPID() {
        return PID;
    }

    public void setPID(Integer PID) {
        this.PID = PID;
    }
}
