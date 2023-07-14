package com.selab.demo.service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONArray;
import com.selab.demo.model.*;
import com.selab.demo.dao.SoftwareDocCheckDao;
import com.selab.demo.dao.SoftwareDocCheckTableDao;
import com.selab.demo.dao.ProcessDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class SoftwareDocCheckService {

    @Autowired
    SoftwareDocCheckTableDao softwareDocCheckTableDao;
    @Autowired
    SoftwareDocCheckDao softwareDocCheckDao;
    @Autowired
    ProcessDao processDao;
    public Integer findSCID(Integer PID){
        ProcessModel processModel = processDao.findByPID(PID);
        if(processModel == null){
            return null;
        }
        return processModel.getSCID();
    }

    public String JSONrepack1(String postJson){
        //System.out.print(postJson);
        JSONArray jsonArray = JSONArray.parseArray(postJson);
        Integer r = jsonArray.size();
        JSONArray res = new JSONArray();
        if(r==null)
            return postJson;
        Integer i=0;
        JSONArray result2 = new JSONArray();
        while(i<r) {
            JSONObject result = new JSONObject();
            JSONObject jsonObject = JSONObject.parseObject(JSON.toJSONString(jsonArray.get(i)));
            result.put("tableid", jsonObject.getInteger("tableid"));
            result.put("ReviewCategories", jsonObject.getString("reviewcategories"));
            result.put("Reviewitem",jsonObject.getString("reviewitem"));
            result.put("ReviewContent", jsonObject.getString("reviewcontent"));
            result.put("ReviewResultExplanation", jsonObject.getString("revieweresultexplanation"));
            result.put("radio", jsonObject.getString("radio"));
            result2.add(result);
            ++i;
        }
        return JSON.toJSONString(result2);
    }

    public String insert(String postJson) {
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer PID = jsonObject.getInteger("PID");
        if(PID == null ||processDao.findByPID(PID) == null){
            return "the process does not exist";
        }
        JSONArray table1 = jsonObject.getJSONArray("tableData");
        JSONArray tableid = new JSONArray();
        if (table1 != null) {
            Integer r = table1.size();
            Integer i = 0;
            while (i < r) {
                JSONObject jsonObject1 = table1.getJSONObject(i);
                String reviewcategories = jsonObject1.getString("ReviewCategories");
                String reviewitem = jsonObject1.getString("Reviewitem");
                String reviewcontent = jsonObject1.getString("ReviewContent");
                String revieweresultexplanation = jsonObject1.getString("ReviewResultExplanation");
                String radio = jsonObject1.getString("radio");
                SoftwareDocCheckTableModel softwareDocCheckTableModel= new SoftwareDocCheckTableModel(0,reviewcategories,reviewitem,reviewcontent,revieweresultexplanation,radio);
                softwareDocCheckTableDao.insert(softwareDocCheckTableModel);
                tableid.add(softwareDocCheckTableModel.getTableid().toString());
                ++i;
            }
        }
        SoftwareDocCheckModel softwareDocCheckModel = new SoftwareDocCheckModel(0,tableid.toJSONString());
        softwareDocCheckDao.insert(softwareDocCheckModel);
        Integer SCID = softwareDocCheckModel.getSCID();
        processDao.setSCID(PID,SCID);
        JSONObject res = new JSONObject();
        res.put("TRID",TRID);
        res.put("PID",PID);
        res.put("tableid",tableid);
        return res.toJSONString();
    }

}
