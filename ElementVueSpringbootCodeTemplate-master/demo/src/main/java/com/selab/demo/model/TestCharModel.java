package com.selab.demo.model;
import javax.persistence.Table;
@Table
public class TestCharModel {
    private Integer testid;
    private String testcharacteristic;
    private String testspecification;
    private String testresult;

    public TestCharModel(Integer testid, String testcharacteristic, String testspecification, String testresult) {
        this.testid = testid;
        this.testcharacteristic = testcharacteristic;
        this.testspecification = testspecification;
        this.testresult = testresult;
    }

    public Integer getTestid() {
        return testid;
    }

    public void setTestid(Integer testid) {
        this.testid = testid;
    }

    public String getTestcharacteristic() {
        return testcharacteristic;
    }

    public void setTestcharacteristic(String testcharacteristic) {
        this.testcharacteristic = testcharacteristic;
    }

    public String getTestspecification() {
        return testspecification;
    }

    public void setTestspecification(String testspecification) {
        this.testspecification = testspecification;
    }

    public String getTestresult() {
        return testresult;
    }

    public void setTestresult(String testresult) {
        this.testresult = testresult;
    }
}
