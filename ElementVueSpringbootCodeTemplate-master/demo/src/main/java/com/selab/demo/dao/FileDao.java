package com.selab.demo.dao;

import com.selab.demo.model.FileModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FileDao {
    @Insert("INSERT INTO selabspringe.file(filePath, PID, fileName) VALUES (#{filePath}, #{PID}, #{fileName})")
    void upload(FileModel fileModel);
    @Select("SELECT * FROM file")
    public FileModel[] selectAllFiles();
    @Select("SELECT * FROM file WHERE PID=#{PID}")
    public FileModel[] selectByPID(Integer PID);
    @Select("SELECT * FROM file WHERE FID=#{FID}")
    public FileModel selectByFID(Integer FID);
}
