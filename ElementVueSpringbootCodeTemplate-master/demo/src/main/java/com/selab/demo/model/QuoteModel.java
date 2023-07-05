package com.selab.demo.model;
import javax.persistence.Table;
import java.util.Date;

@Table
public class QuoteModel {
    private Integer QID;
    private String time;
    private String softwarename;
    private String item;
    private String description;
    private String unitprice;
    private String ps;
    private String subtotalprice;
    private String tax;
    private String totalprice;
    private String provider;

    public QuoteModel(Integer QID, String time, String softwarename, String item, String description, String unitprice, String ps, String subtotalprice, String tax, String totalprice, String provider) {
        this.QID = QID;
        this.time = time;
        this.softwarename = softwarename;
        this.item = item;
        this.description = description;
        this.unitprice = unitprice;
        this.ps = ps;
        this.subtotalprice = subtotalprice;
        this.tax = tax;
        this.totalprice = totalprice;
        this.provider = provider;
    }

    public Integer getQID() {
        return QID;
    }

    public void setQID(Integer QID) {
        this.QID = QID;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSoftwarename() {
        return softwarename;
    }

    public void setSoftwarename(String softwarename) {
        this.softwarename = softwarename;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(String unitprice) {
        this.unitprice = unitprice;
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }

    public String getSubtotalprice() {
        return subtotalprice;
    }

    public void setSubtotalprice(String subtotalprice) {
        this.subtotalprice = subtotalprice;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(String totalprice) {
        this.totalprice = totalprice;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }
}
