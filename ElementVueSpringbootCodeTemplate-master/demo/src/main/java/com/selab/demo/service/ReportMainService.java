package com.selab.demo.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONArray;
import com.selab.demo.dao.ReportMainDao;
import com.selab.demo.model.ReportMainModel;
import com.selab.demo.dao.ProcessDao;
import com.selab.demo.model.ProcessModel;
import com.selab.demo.model.ReportTitleModel;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportMainService {

    @Autowired
    ReportMainDao reportMainDao;
    @Autowired
    ProcessDao processDao;

    public Integer findRID(Integer PID) {
        ProcessModel processModel = processDao.findByPID(PID);
        return processModel.getRID();
    }

    public String JSONrepack(String postJson) {
        //System.out.print(postJson);
        JSONArray jsonArray = JSONArray.parseArray(postJson);
        Integer r = jsonArray.size();
        JSONArray res = new JSONArray();
        if (r == null)
            return postJson;
        Integer i = 0;
        JSONArray result2 = new JSONArray();
        while (i < r) {
            JSONObject result = new JSONObject();
            JSONObject jsonObject = JSONObject.parseObject(JSON.toJSONString(jsonArray.get(i)));
            result.put("RID", jsonObject.getInteger("rID"));
            result.put("Client", jsonObject.getString("client"));
            result.put("ProjectNum", jsonObject.getString("projectnum"));
            result.put("SampleName", jsonObject.getString("samplename"));
            result.put("Version", jsonObject.getString("version"));
            result.put("SampleDate", jsonObject.getString("sampledate"));
            result.put("TypeTest", jsonObject.getString("typetest"));
            result.put("TestTime", jsonObject.getString("testtime"));
            result.put("DevelopmentCompany", jsonObject.getString("developmentcompany"));
            result.put("SampleStatus", jsonObject.getString("samplestatus"));
            result.put("NeededStandard", jsonObject.getString("neededstandard"));
            result.put("SampleList", jsonObject.getString("samplelist"));
            result.put("TestConclusion", jsonObject.getString("testconclusion"));
            result.put("Organizer", jsonObject.getString("organizer"));
            result.put("SampleDate1", jsonObject.getString("sampledate1"));
            result.put("Auditor", jsonObject.getString("auditor"));
            result.put("SampleDate2", jsonObject.getString("sampledate2"));
            result.put("Approver", jsonObject.getString("approver"));
            result.put("SampleDate3", jsonObject.getString("sampledate3"));
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
        String client = jsonObject.getString("Client");
        String projectnum = jsonObject.getString("ProjectNum");
        String samplename = jsonObject.getString("SampleName");
        String version = jsonObject.getString("Version");
        String sampledate = jsonObject.getString("SampleDate");
        String typetest = jsonObject.getString("TypeTest");
        String testtime = jsonObject.getString("TestTime");
        String developmentcompany = jsonObject.getString("DevelopmentCompany");
        String samplestatus = jsonObject.getString("SampleStatus");
        String neededstandard = jsonObject.getString("NeededStandard");
        String samplelist = jsonObject.getString("SampleList");
        String testconclusion = jsonObject.getString("TestConclusion");
        String organizer = jsonObject.getString("Organizer");
        String sampledate1 = jsonObject.getString("SampleDate1");
        String auditor = jsonObject.getString("Auditor");
        String sampledate2 = jsonObject.getString("SampleDate2");
        String approver = jsonObject.getString("Approver");
        String sampledate3 = jsonObject.getString("SampleDate3");

        ReportMainModel reportMainModel = new ReportMainModel(0,client,projectnum,samplename,version,sampledate,typetest,testtime,developmentcompany,samplestatus,neededstandard,samplelist,testconclusion,organizer,sampledate1,auditor,sampledate2    ,approver,sampledate3);
        reportMainDao.insert(reportMainModel);
        Integer RID = reportMainModel.getRID();
        processDao.setRID(PID,RID);
        JSONObject res = new JSONObject();
        res.put("PID",PID);
        res.put("RID",RID);
        return res.toJSONString();



    }

    public String find(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        //System.out.print(JSON.toJSONString( quoteDao.findbyQID(10)));
        return JSONrepack(JSON.toJSONString(reportMainDao.select(findRID(jsonObject.getInteger("PID")))));
    }

    public String update(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer PID = jsonObject.getInteger("PID");
        if(processDao.findByPID(PID) == null){
            return "the process does not exist";
        }
        Integer RID = findRID(PID);
        if(reportMainDao.select2(RID) == null){
            return ("the ReportMain does not exist");
        }
        String client = jsonObject.getString("Client");
        String projectnum = jsonObject.getString("ProjectNum");
        String samplename = jsonObject.getString("SampleName");
        String version = jsonObject.getString("Version");
        String sampledate = jsonObject.getString("SampleDate");
        String typetest = jsonObject.getString("TypeTest");
        String testtime = jsonObject.getString("TestTime");
        String developmentcompany = jsonObject.getString("DevelopmentCompany");
        String samplestatus = jsonObject.getString("SampleStatus");
        String neededstandard = jsonObject.getString("NeededStandard");
        String samplelist = jsonObject.getString("SampleList");
        String testconclusion = jsonObject.getString("TestConclusion");
        String organizer = jsonObject.getString("Organizer");
        String sampledate1 = jsonObject.getString("SampleDate1");
        String auditor = jsonObject.getString("Auditor");
        String sampledate2 = jsonObject.getString("SampleDate2");
        String approver = jsonObject.getString("Approver");
        String sampledate3 = jsonObject.getString("SampleDate3");

        JSONObject oldjsonObject =  JSONObject.parseObject(JSON.toJSONString(reportMainDao.select(RID).get(0)));
        if(client == null)
        {
            client = oldjsonObject.getString("client");
        }
        if(projectnum == null){
            projectnum = oldjsonObject.getString("projectnum");
        }
        if(samplename == null){
            samplename = oldjsonObject.getString("samplename");
        }
        if(typetest == null){
            typetest = oldjsonObject.getString("typetest");
        }
        if(version == null){
            version = oldjsonObject.getString("version");
        }
        if(sampledate == null){
            sampledate = oldjsonObject.getString("sampledate");
        }
        if(typetest == null){
            typetest = oldjsonObject.getString("typetest");
        }
        if(testtime == null){
            testtime = oldjsonObject.getString("testtime");
        }
        if(developmentcompany == null){
            developmentcompany = oldjsonObject.getString("developmentcompany");
        }
        if(samplestatus == null){
            samplestatus = oldjsonObject.getString("samplestatus");
        }
        if(neededstandard == null){
            neededstandard = oldjsonObject.getString("neededstandard");
        }
        if(samplelist == null){
            samplelist = oldjsonObject.getString("samplelist");
        }
        if(testconclusion == null){
            testconclusion = oldjsonObject.getString("testconclusion");
        }
        if(organizer == null){
            organizer = oldjsonObject.getString("organizer");
        }
        if(sampledate1 == null){
            sampledate1 = oldjsonObject.getString("sampledate1");
        }
        if(auditor == null){
            auditor = oldjsonObject.getString("auditor");
        }
        if(sampledate2 == null){
            sampledate2 = oldjsonObject.getString("sampledate2");
        }
        if(approver == null){
            approver = oldjsonObject.getString("approver");
        }
        if(sampledate3 == null){
            sampledate3 = oldjsonObject.getString("sampledate3");
        }
        ReportMainModel reportMainModel = new ReportMainModel(RID,client,projectnum,samplename,version,sampledate,typetest,testtime,developmentcompany,samplestatus,neededstandard,samplelist,testconclusion,organizer,sampledate1,auditor,sampledate2    ,approver,sampledate3);

        reportMainDao.update(reportMainModel);
        return("ReportMain update complete");

    }

    public String delete(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer PID = jsonObject.getInteger("PID");
        Integer RID = findRID(PID);
        if(reportMainDao.select2(RID) == null){
            return ("the ReportMain does not exist");
        }
        reportMainDao.delete(RID);
        return ("ReportMain delete complete");
    }

}
