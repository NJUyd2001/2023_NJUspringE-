package com.selab.demo.model;
import javax.persistence.Table;

@Table
public class ContractModel {
    private Integer CID;
    private String itemname;
    private String client;
    private String trustee;
    private String qc;
    private String date;
    private String periodofvalidity;
    private String ddl;
    private String changenumber;
    private String changeday;

    public ContractModel(Integer CID, String itemname, String client, String trustee, String qc, String date, String periodofvalidity, String ddl, String changenumber, String changeday) {
        this.CID = CID;
        this.itemname = itemname;
        this.client = client;
        this.trustee = trustee;
        this.qc = qc;
        this.date = date;
        this.periodofvalidity = periodofvalidity;
        this.ddl = ddl;
        this.changenumber = changenumber;
        this.changeday = changeday;
    }

    public Integer getCID() {
        return CID;
    }

    public void setCID(Integer CID) {
        this.CID = CID;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getTrustee() {
        return trustee;
    }

    public void setTrustee(String trustee) {
        this.trustee = trustee;
    }

    public String getQc() {
        return qc;
    }

    public void setQc(String qc) {
        this.qc = qc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPeriodofvalidity() {
        return periodofvalidity;
    }

    public void setPeriodofvalidity(String periodofvalidity) {
        this.periodofvalidity = periodofvalidity;
    }

    public String getDdl() {
        return ddl;
    }

    public void setDdl(String ddl) {
        this.ddl = ddl;
    }

    public String getChangenumber() {
        return changenumber;
    }

    public void setChangenumber(String changenumber) {
        this.changenumber = changenumber;
    }

    public String getChangeday() {
        return changeday;
    }

    public void setChangeday(String changeday) {
        this.changeday = changeday;
    }
}
