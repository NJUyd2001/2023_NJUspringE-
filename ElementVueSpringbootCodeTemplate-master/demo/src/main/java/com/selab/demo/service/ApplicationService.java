package com.selab.demo.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONArray;
import com.selab.demo.dao.ApplicationDao;
import com.selab.demo.model.ApplicationModel;
import com.selab.demo.model.enums.ApplicationState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class ApplicationService {

    @Autowired
    ApplicationDao applicationDao;

    public String insert(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);

        int applicantID = jsonObject.getInteger("applicantID");
        int auditorID = jsonObject.getInteger("auditorID");
        ApplicationState curr_state = jsonObject.getObject("curr_state",ApplicationState.class);
        String doc_path = jsonObject.getString("doc_path");
        String phone = jsonObject.getString("phone");
        Date time = jsonObject.getDate("time");
        String title = jsonObject.getString("title");

        ApplicationModel applicationModel = new ApplicationModel(0,applicantID,auditorID,curr_state,doc_path,phone,time,title);

        applicationDao.insertApp(applicationModel);
        return "application inserted successfully";
    }

   public String checkbyuserA(String username){
        JSONArray res = new JSONArray();
        res.add(JSON.toJSONString(applicationDao.findbyuserA(username)));
        return JSON.toJSONString(res);
    }

    public String checkbyuserB(String username){
        JSONArray res = new JSONArray();
        res.add(JSON.toJSONString(applicationDao.findbyuserB(username)));
        return JSON.toJSONString(res);
    }
    public String checkbyAID(int AID){
        JSONArray res = new JSONArray();
        res.add(JSON.toJSONString(applicationDao.findbyAID(AID)));
        return JSON.toJSONString(res);
    }
    public String updateapplication(String postJson) {
        JSONObject jsonObject = JSONObject.parseObject(postJson);

        int AID = jsonObject.getInteger("AID");
        int applicantID = jsonObject.getInteger("applicantID");
        int auditorID = jsonObject.getInteger("auditorID");
        ApplicationState curr_state = jsonObject.getObject("curr_state", ApplicationState.class);
        String doc_path = jsonObject.getString("doc_path");
        String phone = jsonObject.getString("phone");
        Date time = jsonObject.getDate("time");
        String title = jsonObject.getString("title");

        String result = applicationDao.findbyAID2(AID);
        if (result == null) {
            return "the application does not exist";
        }
        ApplicationModel applicationModel = new ApplicationModel(AID, applicantID, auditorID, curr_state, doc_path, phone, time, title);

        applicationDao.updateapplication(applicationModel);


        return "update complete";
    }

    public String deleteapplication(int AID){
        String result = applicationDao.findbyAID2(AID);
        if (result == null) {
            return "the application does not exist";
        }
        applicationDao.deleteapplication(AID);
        return "delete complete";
    }
}




