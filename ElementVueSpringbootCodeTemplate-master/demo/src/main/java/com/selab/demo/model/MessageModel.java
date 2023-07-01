package com.selab.demo.model;
import java.util.Date;
import javax.persistence.Table;

@Table
public class MessageModel {
    private int MID;
    private int sender_id;
    private int receiver_id;
    private Date regTime;
    private String message;
    private String doc_ex_path;

    /**
     {
     "sender_id":"1",
     "receiver_id":"1",
     "regTime":"2017-09-02 10:29:14",
     "message":"1",
     "doc_ex_path":"1"
     }
     **/

    public MessageModel(int MID,int sender_id,int receiver_id,Date regTime,String message, String doc_ex_path){
        this.MID =  MID;
        this.sender_id = sender_id;
        this.receiver_id = receiver_id;
        this.regTime = regTime;
        this.message = message;
        this.doc_ex_path = doc_ex_path;
    }
    public int getMID() {
        return MID;
    }

    public void setMID(int MID) {
        this.MID = MID;
    }

    public int getSender_id() {
        return sender_id;
    }

    public void setSender_id(int sender_id) {
        this.sender_id = sender_id;
    }

    public int getReceiver_id() {
        return receiver_id;
    }

    public void setReceiver_id(int receiver_id) {
        this.receiver_id = receiver_id;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDoc_ex_path() {
        return doc_ex_path;
    }

    public void setDoc_ex_path(String doc_ex_path) {
        this.doc_ex_path = doc_ex_path;
    }
}
