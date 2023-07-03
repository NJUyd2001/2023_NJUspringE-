package com.selab.demo.model;
import javax.persistence.Table;



@Table
public class AuditinformationModel {
    private Integer auditID;
    private String security;
    private String finish;
    private String tool;
    private String testsample;
    private String requirementdocument;
    private String userdocument;
    private String operationducument;
    private String other;
    private String confirmopinion;
    private String opinionofacceptance;
    private String number;
    private String ps;

    public AuditinformationModel(Integer auditID, String security, String finish, String tool, String testsample, String requirementdocument, String userdocument, String operationducument, String other, String confirmopinion, String opinionofacceptance, String number, String ps) {
        this.auditID = auditID;
        this.security = security;
        this.finish = finish;
        this.tool = tool;
        this.testsample = testsample;
        this.requirementdocument = requirementdocument;
        this.userdocument = userdocument;
        this.operationducument = operationducument;
        this.other = other;
        this.confirmopinion = confirmopinion;
        this.opinionofacceptance = opinionofacceptance;
        this.number = number;
        this.ps = ps;
    }

    public Integer getAuditID() {
        return auditID;
    }

    public void setAuditID(Integer auditID) {
        this.auditID = auditID;
    }

    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    public String getTool() {
        return tool;
    }

    public void setTool(String tool) {
        this.tool = tool;
    }

    public String getTestsample() {
        return testsample;
    }

    public void setTestsample(String testsample) {
        this.testsample = testsample;
    }

    public String getRequirementdocument() {
        return requirementdocument;
    }

    public void setRequirementdocument(String requirementdocument) {
        this.requirementdocument = requirementdocument;
    }

    public String getUserdocument() {
        return userdocument;
    }

    public void setUserdocument(String userdocument) {
        this.userdocument = userdocument;
    }

    public String getOperationducument() {
        return operationducument;
    }

    public void setOperationducument(String operationducument) {
        this.operationducument = operationducument;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getConfirmopinion() {
        return confirmopinion;
    }

    public void setConfirmopinion(String confirmopinion) {
        this.confirmopinion = confirmopinion;
    }

    public String getOpinionofacceptance() {
        return opinionofacceptance;
    }

    public void setOpinionofacceptance(String opinionofacceptance) {
        this.opinionofacceptance = opinionofacceptance;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }
}
