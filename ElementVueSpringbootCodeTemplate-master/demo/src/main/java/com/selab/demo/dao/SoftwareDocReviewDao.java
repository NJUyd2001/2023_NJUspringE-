package com.selab.demo.dao;

import com.selab.demo.model.SoftwareDocReviewModel;
import com.selab.demo.model.TestReviewModel;
import org.apache.ibatis.annotations.*;

@Mapper
public interface SoftwareDocReviewDao {
    @Insert("INSERT INTO selabspringe.softwaredocreview(SoftWareName, Client, ReviewCompleteDate, Reviewer, Examiner) VALUES"+
            " (#{SoftWareName}, #{Client}, #{ReviewCompleteDate}, #{Reviewer}, #{Examiner})")
    @SelectKey(keyColumn = "SDRID", before = false, resultType = Integer.class, statement = {"select last_insert_id()"}, keyProperty = "SDRID")
    public void insert(SoftwareDocReviewModel softwareDocReviewModel);
    @Select("SELECT * FROM softwaredocreview WHERE SDRID=#{SDRID}")
    public SoftwareDocReviewModel selectBySDRID(Integer SDRID);
    @Select("SELECT * FROM softwaredocreview WHERE PID=#{PID}")
    public SoftwareDocReviewModel selectByPID(Integer PID);
    @Update("UPDATE softwaredocreview SET SoftWareName=#{SoftWareName}, Client=#{Client}, " +
            "ReviewCompleteDate=#{ReviewCompleteDate}, Reviewer=#{Reviewer}, Examiner=#{Examiner}")
    public void update(SoftwareDocReviewModel softwareDocReviewModel);

    @Delete("DELETE FROM softwaredocreview WHERE SDRID=#{SDRID}")
    public void delete(Integer SDRID);
}
