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
    @Insert("INSERT INTO selabspringe.process (notes, UID, AID, state, price, fileIDs) VALUES(#{notes}, #{UID}, #{AID}, #{state}, #{price}, #{fileIDs}) ")
    void insert(ProcessModel processModel);

    @Select("SELECT * FROM selabspringe.process WHERE UID=#{UID} ")
    List<ProcessModel> findByUID(int UID);

    @Select("SELECT * FROM selabspringe.process WHERE PID=#{PID} ")
    ProcessModel findByPID(int PID);
    @Select("SELECT * FROM selabspringe.process WHERE AID=#{AID} ")
    List<ProcessModel> findByAID(int AID);
    @Select("SELECT * FROM selabspringe.process")
    List<ProcessModel> findAll();
    @Select("SELECT PID FROM selabspringe.process WHERE PID=#{PID} ")
    Integer findByPID2(int PID);
// TODO:
    //@Update("UPDATE selabspringe.process SET PID=#{PID}, notes=#{notes}, UID=#{UID}, AID=#{AID}, state=#{state},fileIDs=#{fileIDs} WHERE PID=#{PID}")
    void update();

    @Delete("DELETE FROM selabspringe.process WHERE PID = #{PID}")
    void delete(int PID);



}
