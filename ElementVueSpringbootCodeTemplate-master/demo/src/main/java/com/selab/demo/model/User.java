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

    private String zipcode; // zip code 邮编
    private String address; // 地址
    private String ip;

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

    private String contact; //联系人
    private String contactTel; //联系人电话
    private String emailAddr;
    private String password;
   // @Enumerated(EnumType.STRING)


    private String phone;
    // @Enumerated(EnumType.STRING)
    private String usertype;
    private String USERFAX;
    // functions

    public String getUSERFAX() {
        return USERFAX;
    }

    public void setUSERFAX(String USERFAX) {
        this.USERFAX = USERFAX;
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
        this.usertype = userType;
        this.USERFAX = "";
    }


    public String getPhone() {
        return phone;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
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
