package com.selab.demo.dao;

import com.selab.demo.model.ApplicationModel;
import com.selab.demo.model.ProcessModel;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface ProcessDao {
    @Insert("INSERT INTO selabspringe.process (notes, UID, AID, state, price, fileIDs) VALUES(#{notes}, #{UID}, #{AID}, #{state}, #{price}, #{fileIDs}) ")
    @SelectKey(keyColumn = "PID", before = false, resultType = Integer.class, statement = "select last_inserted_id()", keyProperty = "PID")
    Integer insert(ProcessModel processModel);

    @Select("SELECT * FROM selabspringe.process WHERE UID=#{UID} ")
    List<ProcessModel> findByUID(int UID);

    @Select("SELECT * FROM selabspringe.process WHERE PID=#{PID} ")
    ProcessModel findByPID(int PID);
    @Select("SELECT * FROM selabspringe.process WHERE AID=#{AID} ")
    List<ProcessModel> findByAID(int AID);
    @Select("SELECT * FROM selabspringe.process")
    List<ProcessModel> findAll();
    @Select("SELECT AID FROM selabspringe.process WHERE state=#{state}")
    List<Integer> selectAIDsByState(String state);
    @Select("SELECT PID FROM selabspringe.process WHERE state=#{state}")
    List<Integer> selectPIDsByState(String state);
    @Select("SELECT PID FROM selabspringe.process WHERE PID=#{PID} ")
    Integer findByPID2(int PID);
// TODO:
    //@Update("UPDATE selabspringe.process SET PID=#{PID}, notes=#{notes}, UID=#{UID}, AID=#{AID}, state=#{state},fileIDs=#{fileIDs} WHERE PID=#{PID}")
    void update();

    @Delete("DELETE FROM selabspringe.process WHERE PID = #{PID}")
    void delete(int PID);



}
