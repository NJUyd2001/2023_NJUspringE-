package com.selab.demo.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.selab.demo.dao.TestReviewDao;
import com.selab.demo.model.TestReviewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestReviewService {

    @Autowired
    TestReviewDao testReviewDao;

    public Integer insert(String postJson) {
        // System.out.println(postJson);
        TestReviewModel testReviewModel = new TestReviewModel();
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        JSONArray tableData = jsonObject.getJSONArray("tableData");

        return -1;


    }
    public String update(String postJson){
        return "test";
    }
}
