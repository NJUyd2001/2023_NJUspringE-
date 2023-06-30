package com.selab.demo.model;
import com.selab.demo.model.enums.curr_state;
import com.selab.demo.model.enums.open_to_curr;


import javax.persistence.Table;

/**
 * @author 李晨博
 * @time 2023/6/2
 * Process 表单结构
 * */
@Table
public class ProcessModel extends BaseEntity {
    private int PID;
    private int client_id;
    private curr_state curr_state;
    private String notes;
    private double price;
    private open_to_curr open_to_curr;
    private String file_path1;
    private String file_path2;
    private String file_path3;
    private String record_path;
    /**
     * {
     *    "client_id":"1",
     *    "curr_state":"A",
     *    "notes":"1",
     *    "price":"1",
     *    "open_to_curr":"A",
     *    "file_path1":"1",
     *    "file_path2":"1",
     *    "file_path3":"1",
     *    "record_path":"1"
     * }
     **/

    public ProcessModel(int PID, int client_id,curr_state curr_state,String notes,double price,open_to_curr open_to_curr,String file_path1,String file_path2,String file_path3,String record_path) {
        this.PID =PID;
        this.client_id =client_id;
        this.curr_state = curr_state;
        this.notes = notes;
        this.price = price;
        this.open_to_curr = open_to_curr;
        this.file_path1 = file_path1;
        this.file_path2 = file_path2;
        this.file_path3 = file_path3;
        this.record_path = record_path;
    }

    public int getPID() {
        return PID;
    }

    public void setPID(int PID) {
        this.PID = PID;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public com.selab.demo.model.enums.curr_state getCurr_state() {
        return curr_state;
    }

    public void setCurr_state(com.selab.demo.model.enums.curr_state curr_state) {
        this.curr_state = curr_state;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public com.selab.demo.model.enums.open_to_curr getOpen_to_curr() {
        return open_to_curr;
    }

    public void setOpen_to_curr(com.selab.demo.model.enums.open_to_curr open_to_curr) {
        this.open_to_curr = open_to_curr;
    }

    public String getFiles_path1() {
        return file_path1;
    }

    public void setFiles_path1(String file_path1) {
        this.file_path1 = file_path1;
    }

    public String getFile_path2() {
        return file_path2;
    }

    public void setFile_path2(String file_path2) {
        this.file_path2 = file_path2;
    }

    public String getFile_path3() {
        return file_path3;
    }

    public void setFile_path3(String file_path3) {
        this.file_path3 = file_path3;
    }

    public String getRecord_path() {
        return record_path;
    }

    public void setRecord_path(String record_path) {
        this.record_path = record_path;
    }

    public static class MessagesModel {
    }
}
