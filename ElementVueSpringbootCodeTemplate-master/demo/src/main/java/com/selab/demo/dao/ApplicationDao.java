package com.selab.demo.dao;

import com.selab.demo.model.ApplicationModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestMapping;

@Mapper
public interface ApplicationDao {
    @Insert("INSERT INTO selabspringe.applicaiton(applicantID, auditorID, curr_state, doc_path, phone, time, title) VALUES (#{applicantID}, #{audtiorID}, #{curr_state}, #{doc_path}, #{phone}, #{time}, #{title})")
    void insertApp(ApplicationModel applicationModel);

}
