package com.selab.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.selab.demo.dao.UserDao;
import com.selab.demo.model.User;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDao userDao;
    // 插入用户数据
    public String insert(String postJson){
        //System.out.println("内容：" + postJson);
        postJson = URLDecoder.decode(postJson, StandardCharsets.UTF_8); // ascii 码转义

        JSONObject jsonObject = JSONObject.parseObject(postJson);

        String userType = jsonObject.getString("type");
        String nickname = jsonObject.getString("uname");

        String emailAddr = jsonObject.getString("emailAddr");
        String password = jsonObject.getString("password");
        String phone = jsonObject.getString("phone");
        User user = new User(nickname, emailAddr, password, phone, userType);
        try {
            userDao.insert(user);
        }catch (DataAccessException e){
            return e.getMessage();
        }
        return "注册成功";
    }
    // 用户登录
    public User login(String postJson) {
        //System.out.println("内容：" + postJson);
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        String nickname = jsonObject.getString("uname");
        String password = jsonObject.getString("password");

        return userDao.login(nickname, password);
    }

    public List<User> selectAll(){
        return userDao.selectAll();
    }
    public List<User> selectAllCustomer(){
        return userDao.selectAllCustomer();
    }
    public List<User> selectAllStaff(){
        return userDao.selectAllStaff();
    }

    public String update(String postJson){

        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer UID = jsonObject.getInteger("UID");
        String new_fax = jsonObject.getString("new_fax");
        String new_emailAddr = jsonObject.getString("new_emailAddr");
        String new_nickname = jsonObject.getString("new_uname");
        String new_password = jsonObject.getString("new_password");
        String new_phone = jsonObject.getString("new_phone");
        try{
            userDao.update(UID, new_nickname, new_password, new_emailAddr
                    , new_phone, new_fax);
        }catch (DataAccessException e){
            return e.getMessage();
        }
        return "信息已更新";
    }
    public String delete(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer UID = jsonObject.getInteger("UID");


        if(userDao.findByUID(UID) == null) return "不存在 UID = "+ UID + " 的用户";
        try{
            userDao.delete(UID);
        }catch (DataAccessException e){
            return e.getMessage();
        }


        return "删除成功";
    }
}
