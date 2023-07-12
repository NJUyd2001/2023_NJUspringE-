package com.selab.demo.model;
import javax.persistence.Table;
import java.util.Date;

@Table

public class SoftwareTestModel {
    private Integer STID;
    private String mark;
    private String systemoverview;
    private String documentationoverview;
    private String baseline;
    private String hardware;
    private String software;
    private String other;
    private String participatingorganization;
    private String personnel;
    private String testlevel;
    private String testcatagory;
    private String generaltestcondition;
    private String plannedexecutiontest;
    private String testcase;
    private String traceabilityodrequirement;
    private String softtableid;

    public SoftwareTestModel(Integer STID, String mark, String systemoverview, String documentationoverview, String baseline, String hardware, String software, String other, String participatingorganization, String personnel, String testlevel, String testcatagory, String generaltestcondition, String plannedexecutiontest, String testcase, String traceabilityodrequirement, String softtableid) {
        this.STID = STID;
        this.mark = mark;
        this.systemoverview = systemoverview;
        this.documentationoverview = documentationoverview;
        this.baseline = baseline;
        this.hardware = hardware;
        this.software = software;
        this.other = other;
        this.participatingorganization = participatingorganization;
        this.personnel = personnel;
        this.testlevel = testlevel;
        this.testcatagory = testcatagory;
        this.generaltestcondition = generaltestcondition;
        this.plannedexecutiontest = plannedexecutiontest;
        this.testcase = testcase;
        this.traceabilityodrequirement = traceabilityodrequirement;
        this.softtableid = softtableid;
    }

    public Integer getSTID() {
        return STID;
    }

    public void setSTID(Integer STID) {
        this.STID = STID;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getSystemoverview() {
        return systemoverview;
    }

    public void setSystemoverview(String systemoverview) {
        this.systemoverview = systemoverview;
    }

    public String getDocumentationoverview() {
        return documentationoverview;
    }

    public void setDocumentationoverview(String documentationoverview) {
        this.documentationoverview = documentationoverview;
    }

    public String getBaseline() {
        return baseline;
    }

    public void setBaseline(String baseline) {
        this.baseline = baseline;
    }

    public String getHardware() {
        return hardware;
    }

    public void setHardware(String hardware) {
        this.hardware = hardware;
    }

    public String getSoftware() {
        return software;
    }

    public void setSoftware(String software) {
        this.software = software;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getParticipatingorganization() {
        return participatingorganization;
    }

    public void setParticipatingorganization(String participatingorganization) {
        this.participatingorganization = participatingorganization;
    }

    public String getPersonnel() {
        return personnel;
    }

    public void setPersonnel(String personnel) {
        this.personnel = personnel;
    }

    public String getTestlevel() {
        return testlevel;
    }

    public void setTestlevel(String testlevel) {
        this.testlevel = testlevel;
    }

    public String getTestcatagory() {
        return testcatagory;
    }

    public void setTestcatagory(String testcatagory) {
        this.testcatagory = testcatagory;
    }

    public String getGeneraltestcondition() {
        return generaltestcondition;
    }

    public void setGeneraltestcondition(String generaltestcondition) {
        this.generaltestcondition = generaltestcondition;
    }

    public String getPlannedexecutiontest() {
        return plannedexecutiontest;
    }

    public void setPlannedexecutiontest(String plannedexecutiontest) {
        this.plannedexecutiontest = plannedexecutiontest;
    }

    public String getTestcase() {
        return testcase;
    }

    public void setTestcase(String testcase) {
        this.testcase = testcase;
    }

    public String getTraceabilityodrequirement() {
        return traceabilityodrequirement;
    }

    public void setTraceabilityodrequirement(String traceabilityodrequirement) {
        this.traceabilityodrequirement = traceabilityodrequirement;
    }

    public String getSofttableid() {
        return softtableid;
    }

    public void setSofttableid(String softtableid) {
        this.softtableid = softtableid;
    }
}
