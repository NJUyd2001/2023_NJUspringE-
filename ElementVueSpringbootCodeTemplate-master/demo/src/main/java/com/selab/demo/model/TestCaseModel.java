package com.selab.demo.model;
import javax.persistence.Table;
@Table

public class TestCaseModel {
    private  Integer TCID;
    private String tableid;

    public TestCaseModel(Integer TCID, String tableid) {
        this.TCID = TCID;
        this.tableid = tableid;
    }

    public Integer getTCID() {
        return TCID;
    }

    public void setTCID(Integer TCID) {
        this.TCID = TCID;
    }

    public String getTableid() {
        return tableid;
    }

    public void setTableid(String tableid) {
        this.tableid = tableid;
    }
}
