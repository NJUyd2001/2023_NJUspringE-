package com.selab.demo.model;

import javax.persistence.Table;
@Table
public class TabledataModel {
    private Integer TID;
    private String name;
    private Integer id;

    private String functions;

    public TabledataModel(Integer TID, String name, Integer id, String functions) {
        this.TID = TID;
        this.name = name;
        this.id = id;
        this.functions = functions;
    }

    public Integer getTID() {
        return TID;
    }

    public void setTID(Integer TID) {
        this.TID = TID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFunctions() {
        return functions;
    }

    public void setFunctions(String functions) {
        this.functions = functions;
    }
}
