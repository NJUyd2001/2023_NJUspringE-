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
    List<ProcessModel> findByUID(Integer UID);


    @Select("SELECT * FROM selabspringe.process WHERE PID=#{PID} ")
    ProcessModel findByPID(Integer PID);
    @Select("SELECT * FROM selabspringe.process WHERE AID=#{AID} ")
    List<ProcessModel> findByAID(Integer AID);
    @Select("SELECT * FROM selabspringe.process")
    List<ProcessModel> findAll();
    @Select("SELECT AID FROM selabspringe.process WHERE state=#{state}")
    List<Integer> selectAIDsByState(String state);
    @Select("SELECT PID FROM selabspringe.process WHERE state=#{state}")
    List<Integer> selectPIDsByState(String state);
    @Select("SELECT PID FROM selabspringe.process WHERE PID=#{PID} ")
    Integer findByPID2(Integer PID);
    // 更新notes和state
    @Update("UPDATE selabspringe.process SET notes=#{notes}, state=#{state} WHERE PID=#{PID}")
    void update(ProcessModel processModel);
    // 只更新state
    @Update("UPDATE selabspringe.process SET state=#{state} WHERE PID=#{PID}")
    void updateState(Integer PID, String state);
    @Update("UPDATE selabspringe.process SET AgID=#{AgID} WHERE PID=#{PID}")
    void setAgID(Integer PID, Integer AgID);
    @Update("UPDATE selabspringe.process SET AID=#{AID} WHERE PID=#{PID}")
    void setAID(Integer PID, Integer AID);
    @Update("UPDATE selabspringe.process SET SID=#{SID} WHERE PID=#{PID}")
    void setSID(Integer PID, Integer SID);
    @Update("UPDATE selabspringe.process SET RID=#{RID} WHERE PID=#{PID}")
    void setRID(Integer PID, Integer RID);
    @Update("UPDATE selabspringe.process SET RTID=#{RTID} WHERE PID=#{PID}")
    void setRTID(Integer PID, Integer RTID);
    @Update("UPDATE selabspringe.process SET RCID=#{RCID} WHERE PID=#{PID}")
    void setRCID(Integer PID, Integer RCID);
    @Update("UPDATE selabspringe.process SET QID=#{QID} WHERE PID=#{PID}")
    void setQID(Integer PID, Integer QID);
    @Update("UPDATE selabspringe.process SET CID=#{CID} WHERE PID=#{PID}")
    void setCID(Integer PID, Integer CID);
    @Update("UPDATE selabspringe.process SET STID=#{STID} WHERE PID=#{PID}")
    void setSTID(Integer PID, Integer STID);
    @Update("UPDATE selabspringe.process SET TID=#{TID} WHERE PID=#{PID}")
    void setTID(Integer PID, Integer TID);
    @Update("UPDATE selabspringe.process SET TEID=#{TEID} WHERE PID=#{PID}")
    void setTEID(Integer PID, Integer TEID);
    @Update("UPDATE selabspringe.process SET TCID=#{TCID} WHERE PID=#{PID}")
    void setTCID(Integer PID, Integer TCID);
    @Update("UPDATE selabspringe.process SET TRID=#{TRID} WHERE PID=#{PID}")
    void setTRID(Integer PID, Integer TRID);
    @Update("UPDATE selabspringe.process SET SDRID=#{SDRID} WHERE PID=#{PID}")
    void setSDRID(Integer PID, Integer SDRID);
    @Update("UPDATE selabspringe.process SET SCID=#{SCID} WHERE PID=#{PID}")
    void setSCID(Integer PID, Integer SCID);
    @Update("UPDATE selabspringe.process SET CHID=#{CHID} WHERE PID=#{PID}")
    void setCHID(Integer PID, Integer CHID);
    @Delete("DELETE FROM selabspringe.process WHERE PID = #{PID}")
    void delete(Integer PID);
    @Delete("DELETE FROM selabspringe.file WHERE PID = #{PID}")
    void clearFiles(Integer PID);
}
