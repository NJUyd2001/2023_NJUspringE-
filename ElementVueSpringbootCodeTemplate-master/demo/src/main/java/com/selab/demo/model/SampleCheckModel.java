package com.selab.demo.model;
import javax.persistence.Table;
import java.util.Date;

@Table
public class SampleCheckModel {

    private Integer SID;
    private String views;
    private String pass;

    public SampleCheckModel(Integer SID, String views, String pass) {
        this.SID = SID;
        this.views = views;
        this.pass = pass;
    }

    public Integer getSID() {
        return SID;
    }

    public void setSID(Integer SID) {
        this.SID = SID;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
