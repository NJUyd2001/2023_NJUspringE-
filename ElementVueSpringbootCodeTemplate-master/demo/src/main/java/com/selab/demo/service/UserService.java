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
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 刘轩昂
 * @time 2023/5/28
 * */
@Service
public class UserService {
    @Autowired
    UserDao userDao;
    // 插入用户数据
    public String insert(String postJson){
        System.out.println("内容：" + postJson);
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
            System.out.println(e.getMessage());
            return simplifyErrMsg(e.getCause().getMessage());
        }
        return "注册成功";
    }
    // 用户登录
    public User customerLogin(String postJson) {
        System.out.println("内容：" + postJson);
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        String nickname = jsonObject.getString("uname");
        String password = jsonObject.getString("password");

        return userDao.customerLogin(nickname, password);
    }
    public User staffLogin(String postJson) {
        System.out.println("内容：" + postJson);
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        String nickname = jsonObject.getString("uname");
        String password = jsonObject.getString("password");

        return userDao.staffLogin(nickname, password);
    }
    public List<User> selectAll(){
        System.out.println("正在返回信息");
        return userDao.selectAll();
    }
    public User selectByUID(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer UID = jsonObject.getInteger("UID");
        return userDao.selectByUID(UID);
    }
    public List<User> selectAllCustomer(){
        return userDao.selectAllCustomer();
    }
    public List<User> selectAllStaff(){
        return userDao.selectAllStaff();
    }
    public String simplifyErrMsg(String err){
        Pattern pattern= Pattern.compile("\'(.*?)\'");
        Matcher matcher=pattern.matcher(err);
        List<String> errList = new ArrayList<String> ();
        while (matcher.find()){
            errList.add(matcher.group());
        }
        if (errList.isEmpty()) return err;
        return errList.get(errList.size()-1).replace("'", "");
    }
    public String update(String postJson){

        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer UID = jsonObject.getInteger("UID");
        String new_fax = jsonObject.getString("new_fax");
        String new_emailAddr = jsonObject.getString("new_emailAddr");
        String new_nickname = jsonObject.getString("new_uname");
        String new_password = jsonObject.getString("new_password");
        String new_phone = jsonObject.getString("new_phone");

        //TODO: ip
        String new_ip = jsonObject.getString("new_ip");
        String new_address = jsonObject.getString("new_address");
        String new_contact = jsonObject.getString("new_contact");
        String new_contactTel = jsonObject.getString("new_contactTel");
        String new_zipcode = jsonObject.getString("new_zipcode");

        if(userDao.findByUID(UID) == null) return "不存在 UID = "+ UID + " 的用户";
        try{
            userDao.update(UID, new_nickname, new_password, new_emailAddr
                    , new_phone, new_fax, new_ip, new_address, new_contact, new_contactTel, new_zipcode);
        }catch (DataAccessException e){
            // return e.getMessage();
            return simplifyErrMsg(e.getCause().getMessage());
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
