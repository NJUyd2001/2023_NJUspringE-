package com.selab.demo.model;

import javax.persistence.Entity;
/**
 * @author 刘轩昂
 * @time 2023/6/28
 * */
@Entity
public class File {
    private long FID;           // 文件ID
    private String path;        // 文件在服务器中的存储路径
    private long uploaderID;    // 上传用户ID

    public File(long FID, String path, long uploaderID) {
        this.FID = FID;
        this.path = path;
        this.uploaderID = uploaderID;
    }

    public long getFID() {
        return FID;
    }

    public void setFID(long FID) {
        this.FID = FID;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public long getUploaderID() {
        return uploaderID;
    }

    public void setUploaderID(long uploaderID) {
        this.uploaderID = uploaderID;
    }
}
