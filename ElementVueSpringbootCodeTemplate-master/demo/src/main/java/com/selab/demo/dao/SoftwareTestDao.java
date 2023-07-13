package com.selab.demo.dao;
import com.selab.demo.model.SoftwareTestModel;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface SoftwareTestDao {

    @Insert("INSERT INTO selabspringe.softwaretest (mark,systemoverview,documentationoverview,baseline,hardware,software,participatingorganization,personnel,testlevel,testcatagory,generaltestcondition,plannedexecutiontest,testcase,traceabilityodrequirement,softtableid,applicationfile,versionnumber,softwarename,other,typetest) VALUES (#{mark},#{systemoverview},#{documentationoverview},#{baseline},#{hardware},#{software},#{participatingorganization},#{personnel},#{testlevel},#{testcatagory},#{generaltestcondition},#{plannedexecutiontest},#{testcase},#{traceabilityodrequirement},#{softtableid},#{applicationfile},#{versionnumber},#{softwarename},#{other},#{typetest})")
    @Options(useGeneratedKeys=true, keyProperty="STID", keyColumn="STID")
    public void insert(SoftwareTestModel softwareTestModel);

    @Select("SELECT * FROM selabspringe.softwaretest WHERE STID = #{STID}")
    List<SoftwareTestModel> select(Integer STID);

    @Select("SELECT STID FROM selabspringe.softwaretest WHERE STID = #{STID}")
    Integer select2(Integer STID);

    @Update("UPDATE selabspringe.softwaretest SET mark=#{mark},systemoverview=#{systemoverview},documentationoverview=#{documentationoverview},baseline=#{baseline},hardware=#{hardware},software=#{software},participatingorganization=#{participatingorganization},personnel=#{personnel},testlevel=#{testlevel},testcatagory=#{testcatagory},generaltestcondition=#{generaltestcondition},plannedexecutiontest=#{plannedexecutiontest},testcase=#{testcase},traceabilityodrequirement=#{traceabilityodrequirement},softtableid=#{softtableid},applicationfile=#{applicationfile},versionnumber=#{versionnumber},softwarename=#{softwarename},other=#{other},typetest=#{typetest} WHERE STID = #{STID}")
    public void update(SoftwareTestModel softwareTestModel);

    @Delete("DELETE FROM selabspringe.softwaretest WHERE STID = #{STID}")
    public void delete(Integer STID);
}
