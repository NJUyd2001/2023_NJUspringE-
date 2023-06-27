package com.selab.demo.model;



import javax.persistence.Table;


/**
 * @author 刘轩昂
 * @time 2023/5/28
 * User 表单结构
 * */

@Table
public class User extends BaseEntity{


    private Integer UID;
    private String nickname;
    private String regTime;



    private String emailAddr;
    private String password;
   // @Enumerated(EnumType.STRING)


    private String phone;
    // @Enumerated(EnumType.STRING)
    private String type;
    private String fax;
    // functions

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }


    // getters and setters

    public Integer getUID() {
        return UID;
    }

    public void setUID(Integer UID) {
        this.UID = UID;
    }

    public String getRegTime() {
        return regTime;
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }

    public User(){}
    public User(String nickname, String emailAddr, String password, String phone, String userType) {
        this.nickname = nickname;
        this.emailAddr = emailAddr;
        this.password = password;

       // this.regTime = regTime;
        this.phone = phone;
        this.type = userType;
        this.fax = "";
    }


    public String getPhone() {
        return phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
