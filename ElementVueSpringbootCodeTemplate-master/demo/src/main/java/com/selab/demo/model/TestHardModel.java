package com.selab.demo.model;
import javax.persistence.Table;
@Table

public class TestHardModel {
    private Integer hardid;
    private String hardwarecategory;
    private String hardwarename;
    private String setting;
    private String quantity;

    public TestHardModel(Integer hardid, String hardwarecategory, String hardwarename, String setting, String quantity) {
        this.hardid = hardid;
        this.hardwarecategory = hardwarecategory;
        this.hardwarename = hardwarename;
        this.setting = setting;
        this.quantity = quantity;
    }

    public Integer getHardid() {
        return hardid;
    }

    public void setHardid(Integer hardid) {
        this.hardid = hardid;
    }

    public String getHardwarecategory() {
        return hardwarecategory;
    }

    public void setHardwarecategory(String hardwarecategory) {
        this.hardwarecategory = hardwarecategory;
    }

    public String getHardwarename() {
        return hardwarename;
    }

    public void setHardwarename(String hardwarename) {
        this.hardwarename = hardwarename;
    }

    public String getSetting() {
        return setting;
    }

    public void setSetting(String setting) {
        this.setting = setting;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
