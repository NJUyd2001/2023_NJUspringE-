package com.selab.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Table;

@Table
public class SoftwareDocReviewModel {
    private Integer PID;
    private Integer SDRID;
    private String SoftWareName;
    private String VersionNumber;
    private String Client;
    private String ReviewCompleteDate;
    private String Reviewer;
    private String Examiner;
    public static class SdrItem {
        private Integer ID;
        private Integer ReviewCategories;
        private Integer SDRID;
        private String ReviewItem;
        private String ReviewContent;
        private String ReviewResultExplanation;
        private String Radio;

        public SdrItem() {
        }


        @JsonProperty("ID")
        public Integer getID() {
            return ID;
        }
        @JsonProperty("SDRID")
        public Integer getSDRID() {
            return SDRID;
        }

        public void setSDRID(Integer SDRID) {
            this.SDRID = SDRID;
        }

        public void setID(Integer ID) {
            this.ID = ID;
        }
        @JsonProperty("ReviewCategories")
        public Integer getReviewCategories() {
            return ReviewCategories;
        }

        public void setReviewCategories(Integer reviewCategories) {
            ReviewCategories = reviewCategories;
        }
        @JsonProperty("ReviewItem")
        public String getReviewItem() {
            return ReviewItem;
        }

        public SdrItem(Integer SDRID, Integer reviewCategories, String reviewItem, String reviewContent, String reviewResultExplanation, String radio) {
            this.SDRID = SDRID;
            ReviewCategories = reviewCategories;
            ReviewItem = reviewItem;
            ReviewContent = reviewContent;
            ReviewResultExplanation = reviewResultExplanation;
            Radio = radio;
        }

        public void setReviewItem(String ReviewItem) {
            this.ReviewItem = ReviewItem;
        }
        @JsonProperty("ReviewContent")
        public String getReviewContent() {
            return ReviewContent;
        }

        public void setReviewContent(String reviewContent) {
            ReviewContent = reviewContent;
        }
        @JsonProperty("ReviewResultExplanation")
        public String getReviewResultExplanation() {
            return ReviewResultExplanation;
        }

        public void setReviewResultExplanation(String reviewResultExplanation) {
            ReviewResultExplanation = reviewResultExplanation;
        }
        @JsonProperty("Radio")
        public String getRadio() {
            return Radio;
        }

        public void setRadio(String radio) {
            Radio = radio;
        }
    }
    public SdrItem[] tableData;

    public SoftwareDocReviewModel() {
        this.tableData = new SdrItem[20];
    }
    @JsonProperty("PID")
    public Integer getPID() {
        return PID;
    }

    public void setPID(Integer PID) {
        this.PID = PID;
    }
    @JsonProperty("SDRID")
    public Integer getSDRID() {
        return SDRID;
    }

    public void setSDRID(Integer SDRID) {
        this.SDRID = SDRID;
    }
    @JsonProperty("SoftWareName")
    public String getSoftWareName() {
        return SoftWareName;
    }
    @JsonProperty("ReviewCompleteDate")
    public String getReviewCompleteDate() {
        return ReviewCompleteDate;
    }

    public void setReviewCompleteDate(String reviewCompleteDate) {
        ReviewCompleteDate = reviewCompleteDate;
    }

    public void setSoftWareName(String softWareName) {
        SoftWareName = softWareName;
    }
    @JsonProperty("VersionNumber")
    public String getVersionNumber() {
        return VersionNumber;
    }

    public void setVersionNumber(String versionNumber) {
        VersionNumber = versionNumber;
    }
    @JsonProperty("Client")
    public String getClient() {
        return Client;
    }

    public void setClient(String client) {
        Client = client;
    }
    @JsonProperty("Reviewer")
    public String getReviewer() {
        return Reviewer;
    }

    public void setReviewer(String reviewer) {
        Reviewer = reviewer;
    }
    @JsonProperty("Examiner")
    public String getExaminer() {
        return Examiner;
    }

    public void setExaminer(String examiner) {
        Examiner = examiner;
    }
    @JsonProperty("tableData")
    public SdrItem[] getTableData() {
        return tableData;
    }

    public void setTableData(SdrItem[] SdrItems) {
        this.tableData = SdrItems;
    }
}
