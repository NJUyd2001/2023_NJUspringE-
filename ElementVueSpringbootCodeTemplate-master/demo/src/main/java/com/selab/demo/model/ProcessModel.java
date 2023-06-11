package com.selab.demo.model;
import java.util.Date;
import com.selab.demo.model.enums.ProcessNext;
import com.selab.demo.model.enums.ProcessPrev;
import com.selab.demo.model.enums.ProcessCurr;
import com.selab.demo.model.enums.ProcessCurr_state;


import javax.persistence.Table;

/**
 * @author 李晨博
 * @time 2023/6/2
 * Process 表单结构
 * */
@Table
public class ProcessModel extends BaseEntity{
    private ProcessPrev prev;
    private ProcessCurr curr;
    private ProcessNext next;
    private ProcessCurr_state curr_state;
    private String notes;
    private double price;
    private String files_path;
    private String record_path;

    public ProcessModel(ProcessPrev prev,ProcessCurr curr,ProcessNext next, ProcessCurr_state curr_state,String notes,double price,String files_path,String record_path){
        this.prev = prev;
        this.curr = curr;
        this.curr_state = curr_state;
        this.next = next;
        this.notes = notes;
        this.price = price;
        this.files_path = files_path;
        this.record_path = record_path;
    }

    public ProcessPrev getPrev(){return prev;}
    public void setPrev(ProcessPrev prev){this.prev = prev;}
    public ProcessCurr getCurr(){return curr;}
    public void setCurr(ProcessCurr curr){this.curr = curr;}
    public ProcessNext getNext(){return next;}
    public void setNext(ProcessNext next){this.next = next;}
    public ProcessCurr_state getCurr_state(){return curr_state;}
    public void setCurr_state(ProcessCurr_state curr_state){this.curr_state = curr_state;}
    public String getNotes(){return notes;}
    public void setNotes(String notes){this.notes = notes;}
    public double getPrice(){return price;}
    public void setPrice(double price){this.price = price;}
    public String getFiles_path(){return files_path;}
    public void setFiles_path(String files_path) {this.files_path = files_path;}
    public String getRecord_path(){return record_path;}

    public void setRecord_path(String record_path) {
        this.record_path = record_path;
    }
}
