package com.selab.demo.dao;

import com.selab.demo.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestMapping;

@Mapper
public interface UserDao {
    @Insert("INSERT INTO selabspringe.user(nickname, njuNumber, emailAddr, password, gender, phone, type) VALUES (#{nickname}, #{njuNumber}, #{emailAddr}, #{password}, #{gender}, #{phone}, #{userType})")
    void insert(User user);
    @Select("SELECT nickname FROM selabspringe.user WHERE nickname=#{nickname} AND password=#{password}")
    public String login(String nickname, String password);
}
