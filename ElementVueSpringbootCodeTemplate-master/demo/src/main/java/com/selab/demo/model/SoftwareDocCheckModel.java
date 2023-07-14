package com.selab.demo.model;
import javax.persistence.Table;
import java.util.Date;

@Table
public class SoftwareDocCheckModel {
    private Integer SCID;
    private String tableid;

    public SoftwareDocCheckModel(Integer SCID, String tableid) {
        this.SCID = SCID;
        this.tableid = tableid;
    }

    public Integer getSCID() {
        return SCID;
    }

    public void setSCID(Integer SCID) {
        this.SCID = SCID;
    }

    public String getTableid() {
        return tableid;
    }

    public void setTableid(String tableid) {
        this.tableid = tableid;
    }
}
