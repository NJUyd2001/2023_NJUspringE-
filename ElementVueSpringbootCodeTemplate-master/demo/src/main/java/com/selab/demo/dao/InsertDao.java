package com.selab.demo.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Bean;

// test insert
@Mapper
public interface InsertDao {
    @Insert("INSERT INTO selabspringe.test(data) VALUE (#{data})")
    void insertTest(String data); // insert a sqlLine
    @Insert("INSERT INTO selabspringe.test(id) VALUES (#{data})")
    void insertID(Integer id);
}
