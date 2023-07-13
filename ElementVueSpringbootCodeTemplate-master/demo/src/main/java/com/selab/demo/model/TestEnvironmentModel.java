package com.selab.demo.model;

import javax.persistence.Table;
@Table
public class TestEnvironmentModel {
    private Integer TEID;
    private String hardid;
    private String softid;
    private String neededstandard;
    private String referencematerial;

    public TestEnvironmentModel(Integer TEID, String hardid, String softid, String neededstandard, String referencematerial) {
        this.TEID = TEID;
        this.hardid = hardid;
        this.softid = softid;
        this.neededstandard = neededstandard;
        this.referencematerial = referencematerial;
    }

    public Integer getTEID() {
        return TEID;
    }

    public void setTEID(Integer TEID) {
        this.TEID = TEID;
    }

    public String getHardid() {
        return hardid;
    }

    public void setHardid(String hardid) {
        this.hardid = hardid;
    }

    public String getSoftid() {
        return softid;
    }

    public void setSoftid(String softid) {
        this.softid = softid;
    }

    public String getNeededstandard() {
        return neededstandard;
    }

    public void setNeededstandard(String neededstandard) {
        this.neededstandard = neededstandard;
    }

    public String getReferencematerial() {
        return referencematerial;
    }

    public void setReferencematerial(String referencematerial) {
        this.referencematerial = referencematerial;
    }
}
