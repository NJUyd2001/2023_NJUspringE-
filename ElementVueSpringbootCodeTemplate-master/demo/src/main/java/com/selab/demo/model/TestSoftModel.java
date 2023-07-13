package com.selab.demo.model;
import javax.persistence.Table;
@Table
public class TestSoftModel {
    private Integer softid;
    private String softwarecategory;
    private String softwarename;
    private String edition;

    public TestSoftModel(Integer softid, String softwarecategory, String softwarename, String edition) {
        this.softid = softid;
        this.softwarecategory = softwarecategory;
        this.softwarename = softwarename;
        this.edition = edition;
    }

    public Integer getSoftid() {
        return softid;
    }

    public void setSoftid(Integer softid) {
        this.softid = softid;
    }

    public String getSoftwarecategory() {
        return softwarecategory;
    }

    public void setSoftwarecategory(String softwarecategory) {
        this.softwarecategory = softwarecategory;
    }

    public String getSoftwarename() {
        return softwarename;
    }

    public void setSoftwarename(String softwarename) {
        this.softwarename = softwarename;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }
}
