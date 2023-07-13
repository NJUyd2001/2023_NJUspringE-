package com.selab.demo.model;
import javax.persistence.Table;
@Table
public class TestFuncModel {
    private Integer testid;
    private String functionmodule;
    private String functionrequirement;
    private String testresult;

    public TestFuncModel(Integer testid, String functionmodule, String functionrequirement, String testresult) {
        this.testid = testid;
        this.functionmodule = functionmodule;
        this.functionrequirement = functionrequirement;
        this.testresult = testresult;
    }


    public Integer getTestid() {
        return testid;
    }

    public void setTestid(Integer testid) {
        this.testid = testid;
    }

    public String getFunctionmodule() {
        return functionmodule;
    }

    public void setFunctionmodule(String functionmodule) {
        this.functionmodule = functionmodule;
    }

    public String getFunctionrequirement() {
        return functionrequirement;
    }

    public void setFunctionrequirement(String functionrequirement) {
        this.functionrequirement = functionrequirement;
    }

    public String getTestresult() {
        return testresult;
    }

    public void setTestresult(String testresult) {
        this.testresult = testresult;
    }
}
