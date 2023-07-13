package com.selab.demo.model;

/**
 * @author 刘轩昂
 * @time 2023/7/12
 * @ 测试方案评审表
 * */

public class TestReviewModel {
    // 签字信息
    public static class SignClass {
        private String duty;

        public SignClass(String duty, String evaluationOpinion, String sign, String date) {
            this.duty = duty;
            this.evaluationOpinion = evaluationOpinion;
            this.sign = sign;
            this.date = date;
        }

        public SignClass() {
        }

        @Override
        public String toString() {
            return "SignClass{" +
                    "duty='" + duty + '\'' +
                    ", evaluationOpinion='" + evaluationOpinion + '\'' +
                    ", sign='" + sign + '\'' +
                    ", date='" + date + '\'' +
                    '}';
        }

        private String evaluationOpinion;
        private String sign;

        public String getDuty() {
            return duty;
        }

        public void setDuty(String duty) {
            this.duty = duty;
        }

        public String getEvaluationOpinion() {
            return evaluationOpinion;
        }

        public void setEvaluationOpinion(String evaluationOpinion) {
            this.evaluationOpinion = evaluationOpinion;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        private String date;

    }
    private String SoftwareName;
    private String VersionNumber;
    private String ProjectNum;
    private Integer PID;

    public Integer getPID() {
        return PID;
    }

    public void setPID(Integer PID) {
        this.PID = PID;
    }

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

    public String getTE_Opinion() {
        return TE_Opinion;
    }

    public void setTE_Opinion(String TE_Opinion) {
        this.TE_Opinion = TE_Opinion;
    }

    public String getTRM_Opinion() {
        return TRM_Opinion;
    }

    public void setTRM_Opinion(String TRM_Opinion) {
        this.TRM_Opinion = TRM_Opinion;
    }

    public String getQM_Opinion() {
        return QM_Opinion;
    }

    public void setQM_Opinion(String QM_Opinion) {
        this.QM_Opinion = QM_Opinion;
    }

    public String getTD_Opinion() {
        return TD_Opinion;
    }

    public void setTD_Opinion(String TD_Opinion) {
        this.TD_Opinion = TD_Opinion;
    }

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
        return signClass.duty + "|"
                + signClass.evaluationOpinion + "|"
                + signClass.sign + "|"
                + signClass.date;
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

    public String getVersionNumber() {
        return VersionNumber;
    }

    public void setVersionNumber(String versionNumber) {
        this.VersionNumber = versionNumber;
    }

    public String getProjectNum() {
        return ProjectNum;
    }

    public void setProjectNum(String projectNum) {
        ProjectNum = projectNum;
    }

    public String getTestCategory() {
        return TestCategory;
    }

    public void setTestCategory(String testCategory) {
        TestCategory = testCategory;
    }

    public String getWritingNormality() {
        return WritingNormality;
    }

    public void setWritingNormality(String writingNormality) {
        WritingNormality = writingNormality;
    }

    public String getTestEnvironment() {
        return TestEnvironment;
    }

    public void setTestEnvironment(String testEnvironment) {
        TestEnvironment = testEnvironment;
    }

    public String getCompleteness() {
        return Completeness;
    }

    public void setCompleteness(String completeness) {
        Completeness = completeness;
    }

    public String getSelectMethod() {
        return SelectMethod;
    }

    public void setSelectMethod(String selectMethod) {
        SelectMethod = selectMethod;
    }

    public String getTestcaseCover() {
        return TestcaseCover;
    }

    public void setTestcaseCover(String testcaseCover) {
        TestcaseCover = testcaseCover;
    }

    public String getInputOutputData() {
        return InputOutputData;
    }

    public void setInputOutputData(String inputOutputData) {
        InputOutputData = inputOutputData;
    }

    public String getTiming() {
        return Timing;
    }

    public void setTiming(String timing) {
        Timing = timing;
    }

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

    public String getSoftwareName() {
        return SoftwareName;
    }

    public void setSoftwareName(String softwareName) {
        SoftwareName = softwareName;
    }
}
