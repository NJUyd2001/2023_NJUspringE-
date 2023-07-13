package com.selab.demo.dao;
import com.selab.demo.model.ReportCheckModel;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface ReportCheckDao {
    @Insert("INSERT INTO selabspringe.reportcheck(tableid,softwarename,client,examiner,date) VALUES (#{tableid} ,#{softwarename},#{client},#{examiner},#{date})")
    @Options(useGeneratedKeys=true, keyProperty="CHID", keyColumn="CHID")
    void insert(ReportCheckModel reportCheckModel);

    @Select("SELECT * FROM selabspringe.reportcheck WHERE CHID = #{CHID}")
    List<ReportCheckModel> select(int CHID);

    @Select("SELECT CHID FROM selabspringe.reportcheck WHERE CHID = #{CHID}")
    Integer select2(int CHID);

    @Update("UPDATE selabspringe.reportcheck SET tableid = #{tableid}, softwarename = #{softwarename},client=#{client},examiner=#{examiner},date=#{date} WHERE CHID = #{CHID}")
    void update(ReportCheckModel reportCheckModel);

    @Delete("DELETE FROM selabspringe.reportcheck WHERE CHID = #{CHID}")
    void delete(int CHID);

}
