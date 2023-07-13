package com.selab.demo.dao;
import com.selab.demo.model.QuoteModel;
import com.selab.demo.model.ReportMainModel;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface ReportMainDao {

    @Insert("INSERT INTO selabspringe.reportmain (client,projectnum,samplename,version,sampledate,typetest,testtime,developmentcompany,samplestatus,neededstandard,samplelist,testconclusion,organizer,sampledate1,auditor,sampledate2,approver,sampledate3) VALUES (#{client},#{projectnum},#{samplename},#{version},#{sampledate},#{typetest},#{testtime},#{developmentcompany},#{samplestatus},#{neededstandard},#{samplelist},#{testconclusion},#{organizer},#{sampledate1},#{auditor},#{sampledate2},#{approver},#{sampledate3})")
    @Options(useGeneratedKeys=true, keyProperty="RID", keyColumn="RID")
    public void insert(ReportMainModel reportMainModel);

    @Select("SELECT * FROM selabspringe.reportmain WHERE RID = #{RID}")
    List<ReportMainModel> select(Integer RID);

    @Select("SELECT RID FROM selabspringe.reportmain WHERE RID = #{RID}")
    Integer select2(Integer RID);

    @Update("UPDATE selabspringe.reportmain SET client=#{client},projectnum=#{projectnum},samplename=#{samplename},version=#{version},sampledate=#{sampledate},typetest=#{typetest},testtime=#{testtime},developmentcompany=#{developmentcompany},samplestatus=#{samplestatus},neededstandard=#{neededstandard},samplelist=#{samplelist},testconclusion=#{testconclusion},organizer=#{organizer},sampledate1=#{sampledate1},auditor=#{auditor},sampledate2=#{sampledate2},approver=#{approver},sampledate3=#{sampledate3} WHERE RID = #{RID}")
    public void update(ReportMainModel reportMainModel);

    @Delete("DELETE FROM selabspringe.reportmain WHERE RID = #{RID}")
    public void delete(Integer RID);
}
