package com.selab.demo.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONArray;
import com.selab.demo.dao.SoftwareTestDao;
import com.selab.demo.model.*;
import com.selab.demo.dao.StableDao;
import com.selab.demo.dao.ProcessDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SoftwareTestService {
    @Autowired
    SoftwareTestDao softwareTestDao;
    @Autowired
    StableDao stableDao;
    @Autowired
    ProcessDao processDao;

    private JSONArray StringtoArray(String words, JSONArray array){
        if(words == null) return array;
        Integer i = words.length();
        Integer j = 0;
        while (i>j){
            String unit = new String();
            while(i>j&&words.charAt(j)!=','){
                if(words.charAt(j)!='\0')
                    unit += words.charAt(j);
                j++;
            }
            //unit += '\0';
            //System.out.print(unit+'\n');
            array.add(unit);
            j++;
        }
        return array;
    }

    private JSONArray StringtoArray2(String words){
        JSONArray array = new JSONArray();
        if(words == null) return array;
        Integer i = words.length();
        Integer j = 0;
        while (i>j){
            String unit = new String();
            while(i>j&&words.charAt(j)!=','){
                if(words.charAt(j)!='\0')
                    unit += words.charAt(j);
                j++;
            }
            //unit += '\0';
            //System.out.print(unit+'\n');
            array.add(unit);
            j++;
        }
        return array;
    }

    private String ArraytoString(String words, JSONArray array){
        Integer r = array.size();
        if (r != null) {
            Integer i = 0;
            while (i < r) {
                words += array.get(i);
                if (i < r - 1) {
                    words += ',';
                }
                i++;
            }
        }
        if(r==null)
        {
            return null;
        }
        return words;
    }

    public Integer findSTID(Integer PID){
        ProcessModel processModel = processDao.findByPID(PID);
        if(processModel == null){
            return null;
        }
        return processModel.getSTID();
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
            result.put("STID", jsonObject.getInteger("sTID"));
            result.put("Mark", jsonObject.getJSONArray("mark"));
            result.put("SystemOverview",jsonObject.getString("systemoverview"));
            result.put("DocumentationOverview", jsonObject.getString("documentationoverview"));
            result.put("BaseLine", jsonObject.getString("baseline"));
            result.put("Hardware", jsonObject.getString("hardware"));
            result.put("Software", jsonObject.getString("software"));
            result.put("Other",jsonObject.getString("other"));
            result.put("ParticipatingOrganization", jsonObject.getString("participatingorganization"));
            result.put("Personnel", jsonObject.getString("personnel"));
            result.put("TestLevel", jsonObject.getString("testlevel"));
            result.put("TestCategory", jsonObject.getString("testcatagory"));
            result.put("GeneralTestCondtion", jsonObject.getString("generaltestcondition"));
            result.put("PlannedExecutionTest", jsonObject.getString("plannedexecutiontest"));
            result.put("TestCase", jsonObject.getString("testcase"));
            result.put("TraceabilityOfRequirement", jsonObject.getString("traceabilityodrequirement"));
            result.put("softtableid",jsonObject.getString("softtableid"));
            result2.add(result);
            ++i;
        }
        return JSON.toJSONString(result2);
    }

    public String JSONrepack_(String postJson){
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
            result.put("stableid",jsonObject.getString("stableid"));
            result.put("MilestonesTasks", jsonObject.getInteger("sTID"));
            result.put("Workload", jsonObject.getJSONArray("time"));
            result.put("Start",jsonObject.getString("softwarename"));
            result.put("End", jsonObject.getString("item"));
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
        String mark = jsonObject.getString("Mark");
        String systemoverview = jsonObject.getString("SystemOverview");
        String documentationoverview = jsonObject.getString("DocumentationOverview");
        String baseline = jsonObject.getString("BaseLine");
        String hardware = jsonObject.getString("Hardware");
        String software = jsonObject.getString("Software");
        String other = jsonObject.getString("Other");
        String participatingorganization = jsonObject.getString("ParticipatingOrganization");
        String personnel = jsonObject.getString("Personnel");
        String testlevel = jsonObject.getString("TestLevel");
        String testcatagory = jsonObject.getString("TestCategory");
        String generaltestcondition = jsonObject.getString("GeneralTestCondtion");
        String plannedexecutiontest = jsonObject.getString("PlannedExecutionTest");
        String testcase = jsonObject.getString("TestCase");
        String traceabilityodrequirement = jsonObject.getString("TraceabilityOfRequirement");

        JSONArray tabledata = jsonObject.getJSONArray("tableData");
        JSONArray stableid = new JSONArray();
        String softtableid = new String();
        if(tabledata!=null){
            Integer r = tabledata.size();
            Integer i=0;
            while (i<r){
                String milestonetasks = jsonObject.getString("MilestonesTasks");
                String workload = jsonObject.getString("Workload");
                String start = jsonObject.getString("Start");
                String end = jsonObject.getString("End");

                StableModel stableModel = new StableModel(0,milestonetasks,workload,start,end);
                stableDao.insert(stableModel);

                stableid.add(stableModel.getStableid().toString()) ;


                ++i;
            }
        }
        softtableid = ArraytoString(softtableid,stableid);
        SoftwareTestModel softwareTestModel = new SoftwareTestModel(0,mark,software,documentationoverview,baseline,hardware,software,other,participatingorganization,personnel,testlevel,testcatagory,generaltestcondition,plannedexecutiontest,testcase,traceabilityodrequirement,softtableid);
        softwareTestDao.insert(softwareTestModel);

        JSONObject res = new JSONObject();
        res.put("STID",softwareTestModel.getSTID());
        Integer STID = softwareTestModel.getSTID();
        processDao.setSTID(PID,STID);
        res.put("PID",PID);
        return JSON.toJSONString(res);
    }

    public String select(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer PID = jsonObject.getInteger("PID");
        if(processDao.findByPID(PID) == null){
            return "the process does not exist";
        }
        Integer STID = findSTID(PID);
        JSONArray res = JSON.parseArray(JSONrepack(JSON.toJSONString(softwareTestDao.select(STID))));
        JSONArray res3 = new JSONArray();
        if(res!=null){
            Integer r = res.size();
            Integer i = 0;
            while(i<r){
                JSONObject res2 = JSON.parseObject(JSON.toJSONString(res.get(i)));
                String softtableid = res2.getString("softtableid");
                JSONArray stid = StringtoArray2(softtableid);
                JSONArray tabledata = new JSONArray();
                if(stid!=new JSONArray()) {
                    Integer r2 = stid.size();
                    Integer i2 = 0;
                    while(i2<r2){
                        tabledata.add(JSON.toJSONString(JSONrepack_(JSON.toJSONString(stableDao.select((Integer) stid.get(i))))));
                        ++i2;
                    }

                }
                res2.put("tableData",tabledata);
                res2.remove("softtableid");
                res3.add(res2);


                ++i;
            }
        }

       // JSONObject res = JSON.parseObject(JSON.toJSONString(JSON.parseArray(JSONrepack(JSON.toJSONString(softwareTestDao.select(STID)))).get(0)));
        return JSON.toJSONString(res3);
    }
}
