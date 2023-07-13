package com.selab.demo.dao;
import com.selab.demo.model.TestRecordModel;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface TestRecordDao {
    @Insert("INSERT INTO selabspringe.testrecord(tableid,softwarename,client,examiner,date) VALUES (#{tableid} ,#{softwarename},#{client},#{examiner},#{date})")
    @Options(useGeneratedKeys=true, keyProperty="TRID", keyColumn="TRID")
    void insert(TestRecordModel testRecordModel);

    @Select("SELECT * FROM selabspringe.testrecord WHERE TRID = #{TRID}")
    List<TestRecordModel> select(int TRID);

    @Select("SELECT TRID FROM selabspringe.testrecord WHERE TRID = #{TRID}")
    Integer select2(int TRID);

    @Update("UPDATE selabspringe.testrecord SET tableid = #{tableid}, softwarename = #{softwarename},client=#{client},examiner=#{examiner},date=#{date} WHERE TRID = #{TRID}")
    void update(TestRecordModel testRecordModel);

    @Delete("DELETE FROM selabspringe.testrecord WHERE TRID = #{TRID}")
    void delete(int TRID);

}
