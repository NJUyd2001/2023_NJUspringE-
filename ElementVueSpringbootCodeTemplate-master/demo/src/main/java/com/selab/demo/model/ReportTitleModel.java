package com.selab.demo.model;
import javax.persistence.Table;
import java.util.Date;

@Table
public class ReportTitleModel {

    private Integer RTID;
    private String softwarename;
    private String versionnumber;
    private String client;
    private String typetest;
    private String date;

    public ReportTitleModel(Integer RTID, String softwarename, String versionnumber, String client, String typetest, String date) {
        this.RTID = RTID;
        this.softwarename = softwarename;
        this.versionnumber = versionnumber;
        this.client = client;
        this.typetest = typetest;
        this.date = date;
    }

    public Integer getRTID() {
        return RTID;
    }

    public void setRTID(Integer RTID) {
        this.RTID = RTID;
    }

    public String getSoftwarename() {
        return softwarename;
    }

    public void setSoftwarename(String softwarename) {
        this.softwarename = softwarename;
    }

    public String getVersionnumber() {
        return versionnumber;
    }

    public void setVersionnumber(String versionnumber) {
        this.versionnumber = versionnumber;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getTypetest() {
        return typetest;
    }

    public void setTypetest(String typetest) {
        this.typetest = typetest;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
