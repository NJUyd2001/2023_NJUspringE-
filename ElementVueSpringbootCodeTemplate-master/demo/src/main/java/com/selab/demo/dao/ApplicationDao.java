package com.selab.demo.dao;

import com.selab.demo.model.ApplicationModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

@Mapper
public interface ApplicationDao {
    @Insert("INSERT INTO selabspringe.application(applicantID, auditorID, curr_state, doc_path, phone, time, title) VALUES (#{applicantID}, #{audtiorID}, #{curr_state}, #{doc_path}, #{phone}, #{time}, #{title})")
    void insertApp(ApplicationModel applicationModel);
    @Select("SELECT * FROM selabspringe.application WHERE applicantID=#{username} ")
    ApplicationModel findbyuserA(int username);
    @Select("SELECT * FROM selabspringe.application WHERE auditorID=#{username} ")
    ApplicationModel findbyuserB(int username);
    @Select("SELECT * FROM selabspringe.application WHERE AID=#{AID} ")
    ApplicationModel findbyAID(int AID);
    @Select("SELECT title FROM selabspringe.application WHERE AID=#{AID} ")
    String findbyAID2(int AID);
    @Update("UPDATE selabspringe.application SET applicantID = {applicantID}, auditorID = #{audtiorID}, curr_state = #{curr_state},doc_path = #{doc_path},phone = #{phone},time = #{time},title = #{title} WHERE AID=#{AID}")
    void updateapplication(ApplicationModel applicationModel);
    @Delete("DELETE FROM selabspringe.application WHERE AID = #{AID}")
    void deleteapplication(int AID);

}
