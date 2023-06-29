package com.selab.demo.dao;

import com.selab.demo.model.ApplicationModel;
import com.selab.demo.model.ProcessModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import java.util.List;
@Mapper
public interface ProcessDao {
    @Insert("INSERT INTO selabspringe.process (client_id, curr_state, notes, price, open_to_curr, file_path1, file_path2, file_path3, record_path) VALUES(#{client_id}, #{curr_state}, #{notes}, #{price}, #{open_to_curr}, #{file_path1}, #{file_path2}, #{file_path3}, #{record_path}) ")
    void insert(ProcessModel processModel);

    @Select("SELECT * FROM selabspringe.process WHERE client_id=#{client_id} ")
    List<ProcessModel> findbyclient_id(int client_id);

    @Select("SELECT * FROM selabspringe.process WHERE PID=#{PID} ")
    List<ProcessModel> findbyPID(int PID);

    @Select("SELECT record_path FROM selabspringe.process WHERE PID=#{PID} ")
    String findbyPID2(int PID);

    @Update("UPDATE selabspringe.process SET client_id=#{client_id}, curr_state=#{curr_state}, notes=#{notes}, price=#{price}, open_to_curr=#{open_to_curr},file_path1=#{file_path1},file_path2=#{file_path2},file_path3=#{file_path3},record_path=#{record_path} WHERE PID=#{PID}")
    void update(ProcessModel processModel);

    @Delete("DELETE FROM selabspringe.process WHERE PID = #{PID}")
    void delete(int PID);



}
