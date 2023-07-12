package com.selab.demo.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONArray;
import com.selab.demo.dao.ReportTitleDao;
import com.selab.demo.dao.SampleCheckDao;
import com.selab.demo.model.ReportTitleModel;
import com.selab.demo.model.SampleCheckModel;
import com.selab.demo.dao.ProcessDao;
import com.selab.demo.model.ProcessModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SampleCheckService {

    @Autowired
    SampleCheckDao sampleCheckDao;
    @Autowired
    ProcessDao processDao;
    public Integer findSID(Integer PID){
        ProcessModel processModel = processDao.findByPID(PID);
        if(processModel == null){
            return null;
        }
        return processModel.getSID();
    }

    public String JSONrepack(String postJson,Integer PID){
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
            result.put("PID",PID);
            result.put("SID", jsonObject.getInteger("sID"));
            result.put("Views", jsonObject.getString("views"));
            result.put("Pass",jsonObject.getString("pass"));
            result2.add(result);
            ++i;
        }
        return JSON.toJSONString(result2);
    }

    public String insert(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer PID = jsonObject.getInteger("PID");
        if(processDao.findByPID(PID) == null){
            return "the process does not exist";
        }
        String views = jsonObject.getString("Views");
        String pass = jsonObject.getString("Pass");
        SampleCheckModel sampleCheckModel = new SampleCheckModel(0,views,pass);
        sampleCheckDao.insert(sampleCheckModel);
        Integer SID = sampleCheckModel.getSID();
        processDao.setSID(PID,SID);
        JSONObject res = new JSONObject();
        res.put("PID",PID);
        res.put("SID",SID);
        return res.toJSONString();



    }

    public String find(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        //System.out.print(JSON.toJSONString( quoteDao.findbyQID(10)));
        return JSONrepack(JSON.toJSONString(sampleCheckDao.select(findSID(jsonObject.getInteger("PID")))),jsonObject.getInteger("PID"));
    }

    public String update(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer PID = jsonObject.getInteger("PID");
        if(processDao.findByPID(PID) == null){
            return "the process does not exist";
        }
        Integer SID = findSID(PID);
        if(sampleCheckDao.select2(SID) == null){
            return ("the SampleCheck does not exist");
        }
        String views = jsonObject.getString("Views");
        String pass = jsonObject.getString("Pass");

        JSONObject oldjsonObject =  JSONObject.parseObject(JSON.toJSONString(sampleCheckDao.select(SID).get(0)));
        if(views == null)
        {
            views = oldjsonObject.getString("views");
        }
        if(pass == null){
            pass = oldjsonObject.getString("pass");
        }
        SampleCheckModel sampleCheckModel = new SampleCheckModel(SID,views,pass);
        sampleCheckDao.update(sampleCheckModel);
        return("SampleCheck update complete");

    }

    public String delete(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer PID = jsonObject.getInteger("PID");
        Integer SID = findSID(PID);
        if(sampleCheckDao.select2(SID) == null){
            return ("the SampleCheck does not exist");
        }
        sampleCheckDao.delete(SID);
        return ("SampleCheck delete complete");
    }
}
