package com.selab.demo.model;
import javax.persistence.Table;
@Table
public class TestRecordModel {
    private Integer TRID;
    private String softwarename;
    private String client;
    private String examiner;
    private String date;
    private String tableid;

    public TestRecordModel(Integer TRID, String softwarename, String client, String examiner, String date, String tableid) {
        this.TRID = TRID;
        this.softwarename = softwarename;
        this.client = client;
        this.examiner = examiner;
        this.date = date;
        this.tableid = tableid;
    }

    public Integer getTRID() {
        return TRID;
    }

    public void setTRID(Integer TRID) {
        this.TRID = TRID;
    }

    public String getSoftwarename() {
        return softwarename;
    }

    public void setSoftwarename(String softwarename) {
        this.softwarename = softwarename;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getExaminer() {
        return examiner;
    }

    public void setExaminer(String examiner) {
        this.examiner = examiner;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTableid() {
        return tableid;
    }

    public void setTableid(String tableid) {
        this.tableid = tableid;
    }
}
