package com.selab.demo.model;
import javax.persistence.Table;

@Table

public class StableModel {
    private Integer stableid;
    private String milestonetasks;
    private String workload;
    private String start;
    private String end;

    public StableModel(Integer stableid, String milestonetasks, String workload, String start, String end) {
        this.stableid = stableid;
        this.milestonetasks = milestonetasks;
        this.workload = workload;
        this.start = start;
        this.end = end;
    }

    public Integer getStableid() {
        return stableid;
    }

    public void setStableid(Integer stableid) {
        this.stableid = stableid;
    }

    public String getMilestonetasks() {
        return milestonetasks;
    }

    public void setMilestonetasks(String milestonetasks) {
        this.milestonetasks = milestonetasks;
    }

    public String getWorkload() {
        return workload;
    }

    public void setWorkload(String workload) {
        this.workload = workload;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
