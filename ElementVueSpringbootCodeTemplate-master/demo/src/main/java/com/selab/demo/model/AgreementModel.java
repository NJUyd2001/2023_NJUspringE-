package com.selab.demo.model;
import javax.persistence.Table;

@Table
public class AgreementModel {
    private Integer AgID;
    private String client;
    private String legalrepresentative1;
    private String legalrepresentative2;
    private String name;
    private String date1;
    private String date2;

    public AgreementModel(Integer agID, String client, String legalrepresentative1, String legalrepresentative2, String name, String date1, String date2) {
        AgID = agID;
        this.client = client;
        this.legalrepresentative1 = legalrepresentative1;
        this.legalrepresentative2 = legalrepresentative2;
        this.name = name;
        this.date1 = date1;
        this.date2 = date2;
    }

    public Integer getAgID() {
        return AgID;
    }

    public void setAgID(Integer agID) {
        AgID = agID;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getLegalrepresentative1() {
        return legalrepresentative1;
    }

    public void setLegalrepresentative1(String legalrepresentative1) {
        this.legalrepresentative1 = legalrepresentative1;
    }

    public String getLegalrepresentative2() {
        return legalrepresentative2;
    }

    public void setLegalrepresentative2(String legalrepresentative2) {
        this.legalrepresentative2 = legalrepresentative2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public String getDate2() {
        return date2;
    }

    public void setDate2(String date2) {
        this.date2 = date2;
    }
}

