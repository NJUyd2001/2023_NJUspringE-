package com.selab.demo.model;
import javax.persistence.Table;
@Table
public class ReportCheckTableModel {
    private Integer tableid;
    private String num;
    private String checkcontent;
    private String description;
    private String radio;

    public ReportCheckTableModel(Integer tableid, String num, String checkcontent, String description, String radio) {
        this.tableid = tableid;
        this.num = num;
        this.checkcontent = checkcontent;
        this.description = description;
        this.radio = radio;
    }

    public Integer getTableid() {
        return tableid;
    }

    public void setTableid(Integer tableid) {
        this.tableid = tableid;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getCheckcontent() {
        return checkcontent;
    }

    public void setCheckcontent(String checkcontent) {
        this.checkcontent = checkcontent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRadio() {
        return radio;
    }

    public void setRadio(String radio) {
        this.radio = radio;
    }
}
