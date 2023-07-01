package com.selab.demo.model;

import javax.persistence.Entity;
/**
 * @author 刘轩昂
 * @time 2023/6/28
 * */
@Entity
public class FileModel {
    private long FID;           // 文件ID
    private String filePath;        // 文件在服务器中的存储路径
    private long PID;    // 上传用户ID

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
    public FileModel( String filePath, long PID, String fileName) {
        this.filePath = filePath;
        this.PID = PID;
        this.fileName = fileName;
    }
    public FileModel( Integer FID,String filePath, long PID, String uploadTime, String fileName) {
        this.FID = FID;
        this.filePath = filePath;
        this.PID = PID;
        this.uploadTime = uploadTime;
        this.fileName  = fileName;
    }
    public long getFID() {
        return FID;
    }

    public void setFID(long FID) {
        this.FID = FID;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public long getPID() {
        return PID;
    }

    public void setPID(long PID) {
        this.PID = PID;
    }
}
