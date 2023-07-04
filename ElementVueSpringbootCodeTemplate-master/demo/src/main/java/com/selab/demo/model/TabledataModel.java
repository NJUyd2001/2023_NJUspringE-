package com.selab.demo.model;

import javax.persistence.Table;
@Table
public class TabledataModel {
    private Integer TID;
    private Integer id;
    private String name;
    private String functions;

    public TabledataModel (Integer TID,Integer id, String name, String functions){
        this.TID = TID;
        this.id = id;
        this.name = name;
        this.functions = functions;
    }

    public Integer getTID() {
        return TID;
    }

    public void setTID(Integer TID) {
        this.TID = TID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFunctions() {
        return functions;
    }

    public void setFunctions(String function) {
        this.functions = functions;
    }
}
