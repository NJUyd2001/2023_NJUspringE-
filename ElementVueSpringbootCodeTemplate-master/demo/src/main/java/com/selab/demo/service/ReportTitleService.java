package com.selab.demo.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONArray;
import com.selab.demo.dao.ReportTitleDao;
import com.selab.demo.model.QuoteModel;
import com.selab.demo.model.ReportTitleModel;
import com.selab.demo.dao.ProcessDao;
import com.selab.demo.model.ProcessModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportTitleService {
    @Autowired
    ReportTitleDao reportTitleDao;
    @Autowired
    ProcessDao processDao;
    public Integer findRTID(Integer PID){
        ProcessModel processModel = processDao.findByRTID(PID);
        return processModel.getRTID();
    }

    public String JSONrepack(String postJson){
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
            result.put("RTID", jsonObject.getInteger("rTID"));
            result.put("SoftwareName", jsonObject.getJSONArray("softwarename"));
            result.put("VersionNumber",jsonObject.getString("versionnumber"));
            result.put("Client", jsonObject.getString("client"));
            result.put("TypeTest", jsonObject.getString("typetest"));
            result.put("Date", jsonObject.getString("date"));
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
        String softwarename = jsonObject.getString("SoftwareName");
        String versionnumber = jsonObject.getString("VersionNumber");
        String client = jsonObject.getString("Client");
        String typetest = jsonObject.getString("TypeTest");
        String date = jsonObject.getString("Date");
        ReportTitleModel reportTitleModel = new ReportTitleModel(0,softwarename,versionnumber,client,typetest,date);
        reportTitleDao.insert(reportTitleModel);
        Integer RTID = reportTitleModel.getRTID();
        processDao.setRTID(PID,RTID);
        JSONObject res = new JSONObject();
        res.put("PID",PID);
        res.put("RTID",RTID);
        return res.toJSONString();



    }

    public String find(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        //System.out.print(JSON.toJSONString( quoteDao.findbyQID(10)));
        return JSONrepack(JSON.toJSONString(reportTitleDao.select(findRTID(jsonObject.getInteger("PID")))));
    }

    public String update(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer PID = jsonObject.getInteger("PID");
        if(processDao.findByPID(PID) == null){
            return "the process does not exist";
        }
        Integer RTID = findRTID(PID);
        if(reportTitleDao.select2(RTID) == null){
            return ("the ReportTitle does not exist");
        }
        String softwarename = jsonObject.getString("SoftwareName");
        String versionnumber = jsonObject.getString("VersionNumber");
        String client = jsonObject.getString("Client");
        String typetest = jsonObject.getString("TypeTest");
        String date = jsonObject.getString("Date");

        JSONObject oldjsonObject =  JSONObject.parseObject(JSON.toJSONString(reportTitleDao.select(RTID).get(0)));
        if(softwarename == null)
        {
            softwarename = oldjsonObject.getString("softwarename");
        }
        if(versionnumber == null){
            versionnumber = oldjsonObject.getString("versionnumber");
        }
        if(client == null){
            client = oldjsonObject.getString("client");
        }
        if(typetest == null){
            typetest = oldjsonObject.getString("typetest");
        }
        if(date == null){
            date = oldjsonObject.getString("date");
        }
        ReportTitleModel reportTitleModel = new ReportTitleModel(RTID,softwarename,versionnumber,client,typetest,date);
        reportTitleDao.update(reportTitleModel);
        return("ReportTitle update complete");

    }

    public String delete(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer PID = jsonObject.getInteger("PID");
        Integer QID = findRTID(PID);
        if(reportTitleDao.select2(QID) == null){
            return ("the ReportTitle does not exist");
        }
        reportTitleDao.delete(QID);
        return ("ReportTitle delete complete");
    }


    public String find_(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        //System.out.print(JSON.toJSONString( quoteDao.findbyQID(10)));
        return JSONrepack(JSON.toJSONString(reportTitleDao.select(jsonObject.getInteger("RTID"))));
    }

    public String update_(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer RTID = jsonObject.getInteger("RTID");
        if(reportTitleDao.select2(RTID) == null){
            return ("the ReportTitle does not exist");
        }
        String softwarename = jsonObject.getString("SoftwareName");
        String versionnumber = jsonObject.getString("VersionNumber");
        String client = jsonObject.getString("Client");
        String typetest = jsonObject.getString("TypeTest");
        String date = jsonObject.getString("Date");

        JSONObject oldjsonObject =  JSONObject.parseObject(JSON.toJSONString(reportTitleDao.select(RTID).get(0)));
        if(softwarename == null)
        {
            softwarename = oldjsonObject.getString("softwarename");
        }
        if(versionnumber == null){
            versionnumber = oldjsonObject.getString("versionnumber");
        }
        if(client == null){
            client = oldjsonObject.getString("client");
        }
        if(typetest == null){
            typetest = oldjsonObject.getString("typetest");
        }
        if(date == null){
            date = oldjsonObject.getString("date");
        }
        ReportTitleModel reportTitleModel = new ReportTitleModel(RTID,softwarename,versionnumber,client,typetest,date);
        reportTitleDao.update(reportTitleModel);
        return("ReportTitle update complete");

    }

    public String delete_(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer QID = jsonObject.getInteger("RTID");
        if(reportTitleDao.select2(QID) == null){
            return ("the ReportTitle does not exist");
        }
        reportTitleDao.delete(QID);
        return ("ReportTitle delete complete");
    }


}
