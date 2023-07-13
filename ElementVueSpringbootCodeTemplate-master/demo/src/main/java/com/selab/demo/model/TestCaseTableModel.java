package com.selab.demo.model;
import javax.persistence.Table;
@Table
public class TestCaseTableModel {
    private Integer tableid;
    private String testclassificaion;
    private String num;
    private String testcasedesign;
    private String stockdescription;
    private String expectedresult;
    private String designer;
    private String testtime;

    public TestCaseTableModel(Integer tableid, String testclassificaion, String num, String testcasedesign, String stockdescription, String expectedresult, String designer, String testtime) {
        this.tableid = tableid;
        this.testclassificaion = testclassificaion;
        this.num = num;
        this.testcasedesign = testcasedesign;
        this.stockdescription = stockdescription;
        this.expectedresult = expectedresult;
        this.designer = designer;
        this.testtime = testtime;
    }

    public Integer getTableid() {
        return tableid;
    }

    public void setTableid(Integer tableid) {
        this.tableid = tableid;
    }

    public String getTestclassificaion() {
        return testclassificaion;
    }

    public void setTestclassificaion(String testclassificaion) {
        this.testclassificaion = testclassificaion;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getTestcasedesign() {
        return testcasedesign;
    }

    public void setTestcasedesign(String testcasedesign) {
        this.testcasedesign = testcasedesign;
    }

    public String getStockdescription() {
        return stockdescription;
    }

    public void setStockdescription(String stockdescription) {
        this.stockdescription = stockdescription;
    }

    public String getExpectedresult() {
        return expectedresult;
    }

    public void setExpectedresult(String expectedresult) {
        this.expectedresult = expectedresult;
    }

    public String getDesigner() {
        return designer;
    }

    public void setDesigner(String designer) {
        this.designer = designer;
    }

    public String getTesttime() {
        return testtime;
    }

    public void setTesttime(String testtime) {
        this.testtime = testtime;
    }
}
