package com.selab.demo.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.Arrays;

/**
 * @author 刘轩昂
 * @time 2023/7/12
 * @ 测试方案评审表
 * */

public class TestReviewModel {
    // 签字信息
    public static class SignClass {
        //@JsonProperty("Duty")

        private String Duty;

        public SignClass(String Duty, String EvaluationOpinion, String Sign, String Date) {
            this.Duty = Duty;
            this.EvaluationOpinion = EvaluationOpinion;
            this.Sign = Sign;
            this.Date = Date;
        }

        public SignClass() {
        }

        @Override
        public String toString() {
            return "SignClass{" +
                    "Duty='" + Duty + '\'' +
                    ", EvaluationOpinion='" + EvaluationOpinion + '\'' +
                    ", Sign='" + Sign + '\'' +
                    ", Date='" + Date + '\'' +
                    '}';
        }

        private String EvaluationOpinion;

        private String Sign;
        @JsonProperty("Duty")
        public String getDuty() {
            return Duty;
        }

        public void setDuty(String duty) {
            this.Duty = duty;
        }
        @JsonProperty("EvaluationOpinion")
        public String getEvaluationOpinion() {
            return EvaluationOpinion;
        }

        public void setEvaluationOpinion(String evaluationOpinion) {
            this.EvaluationOpinion = evaluationOpinion;
        }
        @JsonProperty("Sign")
        public String getSign() {
            return Sign;
        }

        public void setSign(String sign) {
            this.Sign = sign;
        }
        @JsonProperty("Date")
        public String getDate() {
            return Date;
        }

        public void setDate(String date) {
            this.Date = date;
        }

        private String Date;

    }

    private String SoftwareName;

    private String VersionNumber;

    private String ProjectNum;

    private Integer PID;
    @JsonProperty("PID")
    public Integer getPID() {
        return PID;
    }

    public void setPID(Integer PID) {
        this.PID = PID;
    }
    @JsonProperty("TRID")
    public Integer getTRID() {
        return TRID;
    }

    public void setTRID(Integer TRID) {
        this.TRID = TRID;
    }

    private Integer TRID;

    private String TestCategory;

    private String WritingNormality;

    private String TestEnvironment;

    private String Completeness;

    private String SelectMethod;

    private String TestcaseCover;

    private String InputOutputData;

    private String Timing;

    private String HumanResourcesArrangement;

    private String TE_Opinion;

    private String TRM_Opinion;
    @JsonProperty("TE_Opinion")
    public String getTE_Opinion() {
        return TE_Opinion;
    }

    public void setTE_Opinion(String TE_Opinion) {
        this.TE_Opinion = TE_Opinion;
    }
    @JsonProperty("TRM_Opinion")
    public String getTRM_Opinion() {
        return TRM_Opinion;
    }
    public void setTRM_Opinion(String TRM_Opinion) {
        this.TRM_Opinion = TRM_Opinion;
    }
    @JsonProperty("QM_Opinion")
    public String getQM_Opinion() {
        return QM_Opinion;
    }

    public void setQM_Opinion(String QM_Opinion) {
        this.QM_Opinion = QM_Opinion;
    }
    @JsonProperty("TD_Opinion")
    public String getTD_Opinion() {
        return TD_Opinion;
    }

    public void setTD_Opinion(String TD_Opinion) {
        this.TD_Opinion = TD_Opinion;
    }
    @JsonProperty("SI_Opinion")
    public String getSI_Opinion() {
        return SI_Opinion;
    }

    public void setSI_Opinion(String SI_Opinion) {
        this.SI_Opinion = SI_Opinion;
    }

    private String QM_Opinion;

    private String TD_Opinion;

    private String SI_Opinion;
    public SignClass[] tableData;
    // signClass与opinion转化
    public String classToOpinion(SignClass signClass){
        return signClass.Duty + "|"
                + signClass.EvaluationOpinion + "|"
                + signClass.Sign + "|"
                + signClass.Date;
    }
    public SignClass opinionToClass(String opinion){
        String[] split = opinion.split("\\|");
        SignClass signClass = new SignClass();
        signClass.setDuty(split[0]);
        signClass.setEvaluationOpinion(split[1]);
        signClass.setSign(split[2]);
        signClass.setDate(split[3]);
        return signClass;
    }
//    public SignClass jsonToClass(String json){
//
//    }
    public TestReviewModel() {
        this.tableData = new SignClass[5];
    }
    @JsonProperty("VersionNumber")
    public String getVersionNumber() {
        return VersionNumber;
    }

    public void setVersionNumber(String versionNumber) {
        this.VersionNumber = versionNumber;
    }
    @JsonProperty("ProjectNum")
    public String getProjectNum() {
        return ProjectNum;
    }

    public void setProjectNum(String projectNum) {
        ProjectNum = projectNum;
    }
    @JsonProperty("TestCategory")
    public String getTestCategory() {
        return TestCategory;
    }

    public void setTestCategory(String testCategory) {
        TestCategory = testCategory;
    }
    @JsonProperty("WritingNormality")
    public String getWritingNormality() {
        return WritingNormality;
    }

    public void setWritingNormality(String writingNormality) {
        WritingNormality = writingNormality;
    }
    @JsonProperty("TestEnvironment")
    public String getTestEnvironment() {
        return TestEnvironment;
    }

    public void setTestEnvironment(String testEnvironment) {
        TestEnvironment = testEnvironment;
    }
    @JsonProperty("Completeness")
    public String getCompleteness() {
        return Completeness;
    }

    public void setCompleteness(String completeness) {
        Completeness = completeness;
    }
    @JsonProperty("SelectMethod")
    public String getSelectMethod() {
        return SelectMethod;
    }

    public void setSelectMethod(String selectMethod) {
        SelectMethod = selectMethod;
    }
    @JsonProperty("TestcaseCover")
    public String getTestcaseCover() {
        return TestcaseCover;
    }

    public void setTestcaseCover(String testcaseCover) {
        TestcaseCover = testcaseCover;
    }
    @JsonProperty("InputOutputData")
    public String getInputOutputData() {
        return InputOutputData;
    }

    public void setInputOutputData(String inputOutputData) {
        InputOutputData = inputOutputData;
    }
    @JsonProperty("Timing")
    public String getTiming() {
        return Timing;
    }

    @Override
    public String toString() {
        return "TestReviewModel{" +
                "SoftwareName='" + SoftwareName + '\'' +
                ", VersionNumber='" + VersionNumber + '\'' +
                ", ProjectNum='" + ProjectNum + '\'' +
                ", PID=" + PID +
                ", TRID=" + TRID +
                ", TestCategory='" + TestCategory + '\'' +
                ", WritingNormality='" + WritingNormality + '\'' +
                ", TestEnvironment='" + TestEnvironment + '\'' +
                ", Completeness='" + Completeness + '\'' +
                ", SelectMethod='" + SelectMethod + '\'' +
                ", TestcaseCover='" + TestcaseCover + '\'' +
                ", InputOutputData='" + InputOutputData + '\'' +
                ", Timing='" + Timing + '\'' +
                ", HumanResourcesArrangement='" + HumanResourcesArrangement + '\'' +
                ", TE_Opinion='" + TE_Opinion + '\'' +
                ", TRM_Opinion='" + TRM_Opinion + '\'' +
                ", QM_Opinion='" + QM_Opinion + '\'' +
                ", TD_Opinion='" + TD_Opinion + '\'' +
                ", SI_Opinion='" + SI_Opinion + '\'' +
                ", tableData=" + Arrays.toString(tableData) +
                '}';
    }

    public void setTiming(String timing) {
        Timing = timing;
    }
    @JsonProperty("HumanResourcesArrangement")
    public String getHumanResourcesArrangement() {
        return HumanResourcesArrangement;
    }

    public void setHumanResourcesArrangement(String humanResourcesArrangement) {
        HumanResourcesArrangement = humanResourcesArrangement;
    }

    public SignClass[] getTableData() {
        return tableData;
    }

    public void setTableData(SignClass[] tableData) {
        this.tableData = tableData;
    }
    @JsonProperty("SoftwareName")
    public String getSoftwareName() {
        return SoftwareName;
    }

    public void setSoftwareName(String softwareName) {
        SoftwareName = softwareName;
    }
}
