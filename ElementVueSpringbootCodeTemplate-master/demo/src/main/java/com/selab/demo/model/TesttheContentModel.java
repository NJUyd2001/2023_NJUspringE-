package com.selab.demo.model;
import javax.persistence.Table;
@Table
public class TesttheContentModel {
    private Integer TID;
    private String testid1;
    private String testid2;
    private String testid3;
    private String testid4;
    private String testid5;
    private String testid6;

    public TesttheContentModel(Integer TID, String testid1, String testid2, String testid3, String testid4, String testid5, String testid6) {
        this.TID = TID;
        this.testid1 = testid1;
        this.testid2 = testid2;
        this.testid3 = testid3;
        this.testid4 = testid4;
        this.testid5 = testid5;
        this.testid6 = testid6;
    }

    public Integer getTID() {
        return TID;
    }

    public void setTID(Integer TID) {
        this.TID = TID;
    }

    public String getTestid1() {
        return testid1;
    }

    public void setTestid1(String testid1) {
        this.testid1 = testid1;
    }

    public String getTestid2() {
        return testid2;
    }

    public void setTestid2(String testid2) {
        this.testid2 = testid2;
    }

    public String getTestid3() {
        return testid3;
    }

    public void setTestid3(String testid3) {
        this.testid3 = testid3;
    }

    public String getTestid4() {
        return testid4;
    }

    public void setTestid4(String testid4) {
        this.testid4 = testid4;
    }

    public String getTestid5() {
        return testid5;
    }

    public void setTestid5(String testid5) {
        this.testid5 = testid5;
    }

    public String getTestid6() {
        return testid6;
    }

    public void setTestid6(String testid6) {
        this.testid6 = testid6;
    }
}
