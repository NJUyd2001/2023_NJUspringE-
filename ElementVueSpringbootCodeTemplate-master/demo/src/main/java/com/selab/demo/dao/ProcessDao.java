package com.selab.demo.dao;

import com.selab.demo.model.ApplicationModel;
import com.selab.demo.model.ProcessModel;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface ProcessDao {
    @Insert("INSERT INTO selabspringe.process (notes, UID, AID, state, QID, CID) VALUES(#{notes}, #{UID}, #{AID}, #{state}, #{QID}, #{CID}) ")
    @SelectKey(keyColumn = "PID", before = false, resultType = Integer.class, statement = {"select last_insert_id()"}, keyProperty = "PID")
    void insert(ProcessModel processModel);

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
    // 更新notes和state
    @Update("UPDATE selabspringe.process SET notes=#{notes}, state=#{state} WHERE PID=#{PID}")
    void update(ProcessModel processModel);
    // 只更新state
    @Update("UPDATE selabspringe.process SET state=#{state} WHERE PID=#{PID}")
    void updateState(int PID, String state);
    @Update("UPDATE selabspringe.process SET AgID=#{AgID} WHERE PID=#{PID}")
    void setAgID(int PID, int AgID);
    @Update("UPDATE selabspringe.process SET AID=#{AID} WHERE PID=#{PID}")
    void setAID(int PID, int AID);
    @Update("UPDATE selabspringe.process SET QID=#{QID} WHERE PID=#{PID}")
    void setQID(int PID, int QID);
    @Update("UPDATE selabspringe.process SET CID=#{CID} WHERE PID=#{PID}")
    void setCID(int PID, int CID);

    @Delete("DELETE FROM selabspringe.process WHERE PID = #{PID}")
    void delete(int PID);
    @Delete("DELETE FROM selabspringe.file WHERE PID = #{PID}")
    void clearFiles(Integer PID);
}
