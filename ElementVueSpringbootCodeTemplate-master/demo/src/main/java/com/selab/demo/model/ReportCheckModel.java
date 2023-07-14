package com.selab.demo.model;
import javax.persistence.Table;
@Table
public class ReportCheckModel {
    private Integer CHID;
    private String softwarename;
    private String client;
    private String examiner;
    private String date;
    private String tableid;

    public ReportCheckModel(Integer CHID, String softwarename, String client, String examiner, String date, String tableid) {
        this.CHID = CHID;
        this.softwarename = softwarename;
        this.client = client;
        this.examiner = examiner;
        this.date = date;
        this.tableid = tableid;
    }

    public Integer getCHID() {
        return CHID;
    }

    public void setCHID(Integer CHID) {
        this.CHID = CHID;
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
