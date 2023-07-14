package com.selab.demo.model;
import javax.persistence.Table;
import java.util.Date;

@Table
public class SoftwareDocCheckTableModel {
    private Integer tableid;
    private String reviewcategories;
    private String reviewitem;
    private String reviewcontent;
    private String revieweresultexplanation;
    private String radio;

    public SoftwareDocCheckTableModel(Integer tableid, String reviewcategories, String reviewitem, String reviewcontent, String revieweresultexplanation, String radio) {
        this.tableid = tableid;
        this.reviewcategories = reviewcategories;
        this.reviewitem = reviewitem;
        this.reviewcontent = reviewcontent;
        this.revieweresultexplanation = revieweresultexplanation;
        this.radio = radio;
    }

    public Integer getTableid() {
        return tableid;
    }

    public void setTableid(Integer tableid) {
        this.tableid = tableid;
    }

    public String getReviewcategories() {
        return reviewcategories;
    }

    public void setReviewcategories(String reviewcategories) {
        this.reviewcategories = reviewcategories;
    }

    public String getReviewitem() {
        return reviewitem;
    }

    public void setReviewitem(String reviewitem) {
        this.reviewitem = reviewitem;
    }

    public String getReviewcontent() {
        return reviewcontent;
    }

    public void setReviewcontent(String reviewcontent) {
        this.reviewcontent = reviewcontent;
    }

    public String getRevieweresultexplanation() {
        return revieweresultexplanation;
    }

    public void setRevieweresultexplanation(String revieweresultexplanation) {
        this.revieweresultexplanation = revieweresultexplanation;
    }

    public String getRadio() {
        return radio;
    }

    public void setRadio(String radio) {
        this.radio = radio;
    }
}
