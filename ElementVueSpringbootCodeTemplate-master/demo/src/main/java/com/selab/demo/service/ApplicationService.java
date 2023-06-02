package com.selab.demo.service;

import com.alibaba.fastjson.JSONObject;
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

        ApplicationModel applicationModel = new ApplicationModel(applicantID,auditorID,curr_state,doc_path,phone,time,title);

        applicationDao.insertApp(applicationModel);
        return "application inserted successfully";
    }

}
