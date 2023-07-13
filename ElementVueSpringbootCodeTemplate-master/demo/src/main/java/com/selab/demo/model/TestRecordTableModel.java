package com.selab.demo.model;
import javax.persistence.Table;
@Table

public class TestRecordTableModel {
    private Integer tableid;
    private String testclassification;
    private String serialnum;
    private String designspecification;
    private String regulation;
    private String precondition;
    private String executionprocess;
    private String expectedresult;
    private String designer;
    private String actualresult;
    private String bugnum;
    private String usecaseexecutor;
    private String testingtime;
    private String confirmperson;

    public TestRecordTableModel(Integer tableid, String testclassification, String serialnum, String designspecification, String regulation, String precondition, String executionprocess, String expectedresult, String designer, String actualresult, String bugnum, String usecaseexecutor, String testingtime, String confirmperson) {
        this.tableid = tableid;
        this.testclassification = testclassification;
        this.serialnum = serialnum;
        this.designspecification = designspecification;
        this.regulation = regulation;
        this.precondition = precondition;
        this.executionprocess = executionprocess;
        this.expectedresult = expectedresult;
        this.designer = designer;
        this.actualresult = actualresult;
        this.bugnum = bugnum;
        this.usecaseexecutor = usecaseexecutor;
        this.testingtime = testingtime;
        this.confirmperson = confirmperson;
    }

    public Integer getTableid() {
        return tableid;
    }

    public void setTableid(Integer tableid) {
        this.tableid = tableid;
    }

    public String getTestclassification() {
        return testclassification;
    }

    public void setTestclassification(String testclassification) {
        this.testclassification = testclassification;
    }

    public String getSerialnum() {
        return serialnum;
    }

    public void setSerialnum(String serialnum) {
        this.serialnum = serialnum;
    }

    public String getDesignspecification() {
        return designspecification;
    }

    public void setDesignspecification(String designspecification) {
        this.designspecification = designspecification;
    }

    public String getRegulation() {
        return regulation;
    }

    public void setRegulation(String regulation) {
        this.regulation = regulation;
    }

    public String getPrecondition() {
        return precondition;
    }

    public void setPrecondition(String precondition) {
        this.precondition = precondition;
    }

    public String getExecutionprocess() {
        return executionprocess;
    }

    public void setExecutionprocess(String executionprocess) {
        this.executionprocess = executionprocess;
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

    public String getActualresult() {
        return actualresult;
    }

    public void setActualresult(String actualresult) {
        this.actualresult = actualresult;
    }

    public String getBugnum() {
        return bugnum;
    }

    public void setBugnum(String bugnum) {
        this.bugnum = bugnum;
    }

    public String getUsecaseexecutor() {
        return usecaseexecutor;
    }

    public void setUsecaseexecutor(String usecaseexecutor) {
        this.usecaseexecutor = usecaseexecutor;
    }

    public String getTestingtime() {
        return testingtime;
    }

    public void setTestingtime(String testingtime) {
        this.testingtime = testingtime;
    }

    public String getConfirmperson() {
        return confirmperson;
    }

    public void setConfirmperson(String confirmperson) {
        this.confirmperson = confirmperson;
    }
}
