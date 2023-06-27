package com.selab.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.selab.demo.dao.InsertDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
// test insert
@Service
public class InsertService{

    @Autowired
    InsertDao insertDao;
    public String insert(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        String dataString = jsonObject.getString("data");
        System.out.print(postJson);
        insertDao.insertTest(dataString);
        return "success";
    }
}
