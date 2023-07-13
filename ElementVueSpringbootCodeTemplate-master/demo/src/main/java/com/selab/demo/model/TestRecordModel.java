package com.selab.demo.model;
import javax.persistence.Table;
@Table

public class TestRecordModel {
    private Integer TRID;
    private String tableid;

    public TestRecordModel(Integer TRID, String tableid) {
        this.TRID = TRID;
        this.tableid = tableid;
    }

    public Integer getTRID() {
        return TRID;
    }

    public void setTRID(Integer TRID) {
        this.TRID = TRID;
    }

    public String getTableid() {
        return tableid;
    }

    public void setTableid(String tableid) {
        this.tableid = tableid;
    }
}
