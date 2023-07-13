package com.selab.demo.dao;

import com.selab.demo.model.TestReviewModel;
import org.apache.ibatis.annotations.*;

@Mapper
public interface TestReviewDao {
    @Insert("INSERT INTO selabspringe.testreview(PID, SoftwareName, VersionNumber, ProjectNum, TestCategory, WritingNormality, TestEnvironment, Completeness, SelectMethod, TestcaseCover, InputOutputData, Timing, HumanResourcesArrangement, TE_Opinion, TRM_Opinion, QM_Opinion, TD_Opinion, SI_Opinion)"+
            "VALUES (#{PID}, #{SoftwareName}, #{VersionNumber}, #{ProjectNum}, #{TestCategory}, #{WritingNormality}, #{TestEnvironment}, #{Completeness}, #{SelectMethod}, #{TestcaseCover}, #{InputOutputData}, #{Timing}, #{HumanResourcesArrangement}, #{TE_Opinion}, #{TRM_Opinion}, #{QM_Opinion}, #{TD_Opinion}, #{SI_Opinion})")
    @SelectKey(keyColumn = "TRID", before = false, resultType = Integer.class, statement = {"select last_insert_id()"}, keyProperty = "TRID")
    public void insert(TestReviewModel testReviewModel);
    @Select("SELECT * FROM testreview WHERE TRID=#{TRID}")
    public TestReviewModel selectByTRID(Integer TRID);
    @Select("SELECT * FROM testreview WHERE PID=#{PID}")
    public TestReviewModel selectByPID(Integer PID);
    @Update("UPDATE testreview SET PID=#{PID}, SoftwareName=#{SoftwareName}, VersionNumber=#{VersionNumber}, ProjectNum=#{ProjectNum}, " +
            "TestCategory=#{TestCategory}, WritingNormality=#{WritingNormality}, TestEnvironment=#{TestEnvironment}, " +
            "Completeness=#{Completeness}, SelectMethod=#{SelectMethod}, TestcaseCover=#{TestcaseCover}, " +
            "InputOutputData=#{InputOutputData}, Timing=#{Timing}, HumanResourcesArrangement=#{HumanResourcesArrangement}, " +
            "TE_Opinion=#{TE_Opinion}, TRM_Opinion=#{TRM_Opinion}, QM_Opinion=#{QM_Opinion}, TD_Opinion=#{TD_Opinion}, SI_Opinion=#{SI_Opinion}" +
            " WHERE TRID =#{TRID}")
    public void update(TestReviewModel testReviewModel);

    @Delete("DELETE FROM testreview WHERE TRID=#{TRID}")
    public void delete(Integer TRID);
}
