package com.selab.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.selab.demo.dao.UserDao;
import com.selab.demo.model.User;
import com.selab.demo.model.enums.Gender;
import com.selab.demo.model.enums.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDao userDao;
    // 插入用户数据
    public String insert(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Gender gender = jsonObject.getObject("gender", Gender.class);
        UserType userType = jsonObject.getObject("type", UserType.class);
        String nickname = jsonObject.getString("nickname");
        String njuNumber = jsonObject.getString("njuNumber");
        String emailAddr = jsonObject.getString("emailAddr");
        String password = jsonObject.getString("password");
        String phone = jsonObject.getString("phone");
        User user = new User(nickname, njuNumber, emailAddr, password, gender, phone, userType);

        userDao.insert(user);
        return "inserted successfully";
    }
    // 用户登录
    public String login(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        String nickname = jsonObject.getString("nickname");
        String password = jsonObject.getString("password");

        String result =  userDao.login(nickname, password);
        if(result == null) return "登录失败";
        else return "用户" + result + "，您已成功登录";
    }
}
