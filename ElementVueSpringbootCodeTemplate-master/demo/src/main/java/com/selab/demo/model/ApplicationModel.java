package com.selab.demo.model;
import java.util.Date;
import com.selab.demo.model.enums.ApplicationState;

import javax.persistence.Table;

/**
 * @author 李晨博
 * @time 2023/5/30
 * Application 表单结构
 * */
@Table
public class ApplicationModel extends BaseEntity{
    //private String AID;
    private int applicantID;//申请单ID
    private int audtiorID;//审核员ID
    private ApplicationState curr_state;//审核状态
    private String doc_path;//文件路径
    private String phone;//手机号码
    private Date time;//时间
    private String title;//标题

    //public String getAID(){return AID;}

    //public void setAID(String AID){this.AID = AID;}

    public ApplicationModel(int applicantID, int audtiorID, ApplicationState curr_state,String doc_path, String phone, Date time, String title){
        this.applicantID = applicantID;
        this.audtiorID = audtiorID;
        this.curr_state = curr_state;
        this.doc_path = doc_path;
        this.phone = phone;
        this.time = time;
        this.title = title;
    }

    public int getApplicantID(){return applicantID;}

    public void setApplicantID(int applicantID){this.applicantID = applicantID;}

    public int getAudtiorID(){return audtiorID;}

    public void setAudtiorID(int auditorID){this.audtiorID = audtiorID;}

    public ApplicationState getCurr_state(){return curr_state;}

    public void setCurr_state(ApplicationState curr_state){this.curr_state = curr_state;}

    public String getDoc_path(){return doc_path;}

    public void setDoc_path(String doc_path){this.doc_path = doc_path;}

    public String getPhone(){return phone;}

    public void setPhone(String phone){this.phone = phone;}

    public Date getTime(){return time;}

    public void setTime(Date time){this.time = time;}

    public String getTitle(){return title;}

    public void setTitle(String title){this.title = title;}
}
