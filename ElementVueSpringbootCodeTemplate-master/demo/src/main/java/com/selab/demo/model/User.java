package com.selab.demo.model;


import com.selab.demo.model.enums.Gender;
import com.selab.demo.model.enums.UserType;

import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

/**
 * @author 刘轩昂
 * @time 2023/5/28
 * User 表单结构
 * */

@Table
public class User extends BaseEntity{

    private String nickname;
    private String njuNumber;


    private String emailAddr;
    private String password;
    private Gender gender;
    //private Date regTime;
    private String phone;
    private UserType userType;

    // functions



    // getters and setters


    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public User(String nickname, String njuNumber, String emailAddr, String password, Gender gender, String phone, UserType userType) {
        this.nickname = nickname;
        this.njuNumber = njuNumber;
        this.emailAddr = emailAddr;
        this.password = password;
        this.gender = gender;
       // this.regTime = regTime;
        this.phone = phone;
        this.userType = userType;
    }

    public String getPhone() {
        return phone;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }



    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNjuNumber() {
        return njuNumber;
    }

    public void setNjuNumber(String njuNumber) {
        this.njuNumber = njuNumber;
    }

    public String getEmailAddr() {
        return emailAddr;
    }


    public void setEmailAddr(String emailAddr) {
        this.emailAddr = emailAddr;
    }



    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
