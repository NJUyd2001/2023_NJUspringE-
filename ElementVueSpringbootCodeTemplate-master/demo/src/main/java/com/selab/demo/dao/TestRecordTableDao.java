package com.selab.demo.dao;

import com.selab.demo.model.TestRecordTableModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper

public interface TestRecordTableDao {
    @Insert("INSERT INTO selabspringe.testrecordtable(testclassification,serialnum,designspecification,regulation,precondition,executionprocess,expectedresult,designer,actualresult,bugnum,usecaseexecutor,testingtime,confirmperson) VALUES (#{testclassification} ,#{serialnum},#{designspecification},#{regulation},#{precondition},#{executionprocess},#{expectedresult},#{designer},#{actualresult},#{bugnum},#{usecaseexecutor},#{testingtime},#{confirmperson})")
    @Options(useGeneratedKeys=true, keyProperty="tableid", keyColumn="tableid")
    void insert(TestRecordTableModel testRecordTableModel);

    @Select("SELECT * FROM selabspringe.testrecordtable WHERE tableid = #{tableid}")
    List<TestRecordTableModel> select(Integer tableid);

    @Select("SELECT tableid FROM selabspringe.testrecordtable WHERE tableid = #{tableid}")
    Integer select2(Integer tableid);

    @Update("UPDATE selabspringe.testrecordtable SET testclassification = #{testclassification}, serialnum = #{serialnum},designspecification=#{designspecification},regulation=#{regulation},precondition=#{precondition},executionprocess=#{executionprocess},expectedresult=#{expectedresult},designer=#{designer},actualresult=#{actualresult},bugnum=#{bugnum},usecaseexecutor#{usecaseexecutor},testingtime=#{testingtime},confirmperson=#{confirmperson} WHERE tableid = #{tableid}")
    void update(TestRecordTableModel testSoftModel);

    @Delete("DELETE FROM selabspringe.testrecordtable WHERE tableid = #{tableid}")
    void delete(Integer tableid);
}
