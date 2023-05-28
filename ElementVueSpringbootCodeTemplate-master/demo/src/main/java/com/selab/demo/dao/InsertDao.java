package com.selab.demo.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Bean;

// test insert
@Mapper
public interface InsertDao {
    @Insert("INSERT INTO selabspringe.test(data) VALUE (#{data})")
    void insert(String data); // insert a sqlLine
}
