package com.selab.demo.model;
import javax.persistence.Table;


@Table
public class ReportMainModel {
    private Integer RID;
    private String client;
    private String projectnum;
    private String samplename;
    private String version;
    private String sampledate;
    private String typetest;
    private String testtime;
    private String developmentcompany;
    private String samplestatus;
    private String neededstandard;
    private String samplelist;
    private String testconclusion;
    private String organizer;
    private String sampledate1;
    private String auditor;
    private String sampledate2;
    private String approver;
    private String sampledate3;

    public ReportMainModel(Integer RID, String client, String projectnum, String samplename, String version, String sampledate, String typetest, String testtime, String developmentcompany, String samplestatus, String neededstandard, String samplelist, String testconclusion, String organizer, String sampledate1, String auditor, String sampledate2, String approver, String sampledate3) {
        this.RID = RID;
        this.client = client;
        this.projectnum = projectnum;
        this.samplename = samplename;
        this.version = version;
        this.sampledate = sampledate;
        this.typetest = typetest;
        this.testtime = testtime;
        this.developmentcompany = developmentcompany;
        this.samplestatus = samplestatus;
        this.neededstandard = neededstandard;
        this.samplelist = samplelist;
        this.testconclusion = testconclusion;
        this.organizer = organizer;
        this.sampledate1 = sampledate1;
        this.auditor = auditor;
        this.sampledate2 = sampledate2;
        this.approver = approver;
        this.sampledate3 = sampledate3;
    }

    public Integer getRID() {
        return RID;
    }

    public void setRID(Integer RID) {
        this.RID = RID;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getProjectnum() {
        return projectnum;
    }

    public void setProjectnum(String projectnum) {
        this.projectnum = projectnum;
    }

    public String getSamplename() {
        return samplename;
    }

    public void setSamplename(String samplename) {
        this.samplename = samplename;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSampledate() {
        return sampledate;
    }

    public void setSampledate(String sampledate) {
        this.sampledate = sampledate;
    }

    public String getTypetest() {
        return typetest;
    }

    public void setTypetest(String typetest) {
        this.typetest = typetest;
    }

    public String getTesttime() {
        return testtime;
    }

    public void setTesttime(String testtime) {
        this.testtime = testtime;
    }

    public String getDevelopmentcompany() {
        return developmentcompany;
    }

    public void setDevelopmentcompany(String developmentcompany) {
        this.developmentcompany = developmentcompany;
    }

    public String getSamplestatus() {
        return samplestatus;
    }

    public void setSamplestatus(String samplestatus) {
        this.samplestatus = samplestatus;
    }

    public String getNeededstandard() {
        return neededstandard;
    }

    public void setNeededstandard(String neededstandard) {
        this.neededstandard = neededstandard;
    }

    public String getSamplelist() {
        return samplelist;
    }

    public void setSamplelist(String samplelist) {
        this.samplelist = samplelist;
    }

    public String getTestconclusion() {
        return testconclusion;
    }

    public void setTestconclusion(String testconclusion) {
        this.testconclusion = testconclusion;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public String getSampledate1() {
        return sampledate1;
    }

    public void setSampledate1(String sampledate1) {
        this.sampledate1 = sampledate1;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public String getSampledate2() {
        return sampledate2;
    }

    public void setSampledate2(String sampledate2) {
        this.sampledate2 = sampledate2;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public String getSampledate3() {
        return sampledate3;
    }

    public void setSampledate3(String sampledate3) {
        this.sampledate3 = sampledate3;
    }
}
