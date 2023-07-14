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
            result.put("STID", jsonObject.getInteger("sTID"));
            result.put("Mark", jsonObject.getString("mark"));
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
            result.put("GeneralTestCondition", jsonObject.getString("generaltestcondition"));
            result.put("PlannedExecutionTest", jsonObject.getString("plannedexecutiontest"));
            result.put("TestCase", jsonObject.getString("testcase"));
            result.put("TraceabilityOfRequirement", jsonObject.getString("traceabilityodrequirement"));
            result.put("softtableid",jsonObject.getString("softtableid"));
            result.put("ApplicationFile",jsonObject.getString("applicationfile"));
            result.put("VersionNumber",jsonObject.getString("versionnumber"));
            result.put("SoftWareName",jsonObject.getString("softwarename"));
            result.put("TypeTest",jsonObject.getString("typetest"));
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
            result.put("MilestonesTasks", jsonObject.getString("milestonestasks"));
            result.put("Workload", jsonObject.getString("workload"));
            result.put("Start",jsonObject.getString("start"));
            result.put("End", jsonObject.getString("end"));
            result2.add(result);
            ++i;
        }
        return JSON.toJSONString(result2);
    }

    public String insert(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer PID = jsonObject.getInteger("PID");
        if(PID == null ||processDao.findByPID(PID) == null){
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
        String generaltestcondition = jsonObject.getString("GeneralTestCondition");
        String plannedexecutiontest = jsonObject.getString("PlannedExecutionTest");
        String testcase = jsonObject.getString("TestCase");
        String traceabilityodrequirement = jsonObject.getString("TraceabilityOfRequirement");
        String applicationfile = jsonObject.getString("ApplicationFile");
        String versionnumber = jsonObject.getString("VersionNumber");
        String softwarename = jsonObject.getString("SoftWareName");
        String typetest = jsonObject.getString("TypeTest");
        JSONArray tabledata = jsonObject.getJSONArray("tableData");


        JSONArray stableid = new JSONArray();
        String softtableid = new String();
        if(tabledata!=null){
            Integer r = tabledata.size();
            Integer i=0;
            while (i<r){
                JSONObject table  = JSON.parseObject(JSON.toJSONString(tabledata.get(i)));
                String milestonetasks = table.getString("MilestonesTasks");
                String workload = table.getString("Workload");
                String start = table.getString("Start");
                String end = table.getString("End");

                StableModel stableModel = new StableModel(0,milestonetasks,workload,start,end);
                stableDao.insert(stableModel);

                stableid.add(stableModel.getStableid().toString()) ;


                ++i;
            }
        }
        softtableid = ArraytoString(softtableid,stableid);
        SoftwareTestModel softwareTestModel = new SoftwareTestModel(0,mark,systemoverview,documentationoverview,baseline,hardware,software,other,participatingorganization,personnel,testlevel,testcatagory,generaltestcondition,plannedexecutiontest,testcase,traceabilityodrequirement,softtableid,applicationfile,versionnumber,softwarename,typetest);
        softwareTestDao.insert(softwareTestModel);

        JSONObject res = new JSONObject();
        res.put("STID",softwareTestModel.getSTID());
        Integer STID = softwareTestModel.getSTID();
        processDao.setSTID(PID,STID);
        res.put("PID",PID);
        res.put("stableid",stableid);
        return JSON.toJSONString(res);
    }

    public String select(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer PID = jsonObject.getInteger("PID");
        if(PID == null ||processDao.findByPID(PID) == null){
            return "the process does not exist";
        }
        Integer STID = findSTID(PID);
        if(softwareTestDao.select2(STID) == null){
            return new JSONArray().toString();
        }
        JSONArray res = JSON.parseArray(JSONrepack(JSON.toJSONString(softwareTestDao.select(STID)),jsonObject.getInteger("PID")));
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
                        //System.out.print(JSONrepack_(JSON.toJSONString(stableDao.select( stid.getInteger(i2)))));
                        tabledata.add(JSON.parseArray(JSONrepack_(JSON.toJSONString(stableDao.select( stid.getInteger(i2))))).getJSONObject(0) );
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

    public String update (String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer PID = jsonObject.getInteger("PID");
        if(PID == null ||processDao.findByPID(PID) == null){
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
        String generaltestcondition = jsonObject.getString("GeneralTestCondition");
        String plannedexecutiontest = jsonObject.getString("PlannedExecutionTest");
        String testcase = jsonObject.getString("TestCase");
        String traceabilityodrequirement = jsonObject.getString("TraceabilityOfRequirement");
        String applicationfile = jsonObject.getString("ApplicationFile");
        String versionnumber = jsonObject.getString("VersionNumber");
        String softwarename = jsonObject.getString("SoftWareName");
        String typetest = jsonObject.getString("TypeTest");

        Integer STID = findSTID(PID);
        if(softwareTestDao.select2(STID)==null){
            return "the SoftwareTest does not exist";
        }

        JSONObject res = JSON.parseArray(JSONrepack(JSON.toJSONString(softwareTestDao.select(STID)),jsonObject.getInteger("PID"))).getJSONObject(0);
        String softtableid = res.getString("softtableid");
        JSONArray softtable = StringtoArray2(softtableid);
        JSONArray tabledata = jsonObject.getJSONArray("tableData");
        JSONArray failedid = new JSONArray();
        JSONArray newid = new JSONArray();
        //JSONArray stableid = new JSONArray();
        if(tabledata!=null){
            Integer r = tabledata.size();
            Integer i=0;
            while (i<r){
                JSONObject table  = tabledata.getJSONObject(i);
                Integer stableid = table.getInteger("stableid");
                String milestonetasks = table.getString("MilestonesTasks");
                String workload = table.getString("Workload");
                String start = table.getString("Start");
                String end = table.getString("End");

                if(stableid == null) {
                    StableModel stableModel = new StableModel(0, milestonetasks, workload, start, end);
                    stableDao.insert(stableModel);
                    softtable.add(stableModel.getStableid().toString());
                }
                else{
                    if(stableDao.select2(stableid) == null||softtable==null||softtable==new JSONArray()){
                        failedid.add(stableid.toString());
                    }
                    else{
                        Integer check = 0;
                        Integer i2 = 0;
                        if(tabledata!=null){
                            Integer r2 = softtable.size();

                            while(i2<r2){

                                String id  = softtable.getString(i2);
                                //System.out.print(Integer.parseInt(id) +"!="+stableid+'\n');
                                if(Integer.parseInt(id) == stableid){
                                    check = 1;
                                    break;
                                }
                                ++i2;

                            }
                        }
                        if(check == 0){
                            failedid.add(stableid.toString());
                        }
                        else {
                            JSONObject ol = JSON.parseObject(JSON.toJSONString(JSON.parseArray(JSON.toJSONString(stableDao.select(stableid))).get(0)));
                            if(milestonetasks == null){
                                milestonetasks = ol.getString("milestonetasks");
                            }
                            if(workload == null){
                                workload = ol.getString("workload");
                            }
                            if(start == null){
                                start = ol.getString("start");
                            }
                            if(end == null){
                                end = ol.getString("end");
                            }
                            String delete = table.getString("delete");
                            if(delete == null || !delete.equals("T")) {
                                StableModel stableModel = new StableModel(stableid, milestonetasks, workload, start, end);
                                stableDao.update(stableModel);
                            }
                            else{
                                stableDao.delete(stableid);
                                softtable.remove(stableid.toString());
                            }
                        }
                    }
                }
                ++i;
            }
        }
        //JSONObject old = JSON.parseObject(JSON.toJSONString(JSON.parseArray(JSON.toJSONString(softwareTestDao.select(stableid))).get(0)));
        if(mark == null){
            mark = res.getString("mark");
        }
        if(systemoverview == null){
            systemoverview = res.getString("systemoverview");
        }
        if(documentationoverview == null){
            documentationoverview = res.getString("documentationoverview");
        }
        if(baseline == null){
            baseline = res.getString("baseline");
        }
        if(hardware == null){
            hardware = res.getString("hardware");
        }
        if(software == null){
            software = res.getString("software");
        }
        if(other == null){
            other = res.getString("other");
        }
        if(participatingorganization == null){
            participatingorganization = res.getString("participatingorganization");
        }
        if(personnel == null){
            personnel = res.getString("personnel");
        }
        if(testlevel == null){
            testlevel = res.getString("testlevel");
        }
        if(testcatagory == null){
            testcatagory = res.getString("testcatagory");
        }
        if(generaltestcondition == null){
            generaltestcondition = res.getString("generaltestcondition");
        }
        if(plannedexecutiontest == null){
            plannedexecutiontest = res.getString("plannedexecutiontest");
        }
        if(testcase == null){
            testcase = res.getString("testcase");
        }
        if(traceabilityodrequirement == null){
            traceabilityodrequirement = res.getString("traceabilityodrequirement");
        }
        if(applicationfile == null){
            applicationfile = res.getString("applicationfile");
        }
        if(versionnumber == null){
            versionnumber = res.getString("versionnumber");
        }
        if(softwarename == null){
            softwarename = res.getString("softwarename");
        }
        if(typetest == null){
            typetest = res.getString("typetest");
        }
        softtableid = new String();
        softtableid = ArraytoString(softtableid,softtable);
        SoftwareTestModel softwareTestModel = new SoftwareTestModel(STID,mark,systemoverview,documentationoverview,baseline,hardware,software,other,participatingorganization,personnel,testlevel,testcatagory,generaltestcondition,plannedexecutiontest,testcase,traceabilityodrequirement,softtableid,applicationfile,versionnumber,softwarename,typetest);
        softwareTestDao.update(softwareTestModel);
        String failid = new String();
        failid = ArraytoString(failid,failedid);
        JSONObject resss = new JSONObject();
        resss.put("failedid",failedid);
        resss.put("stableid",softtable);
        return(JSON.toJSONString(resss));




    }

    public String delete(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer PID = jsonObject.getInteger("PID");
        if(PID == null ||processDao.findByPID(PID) == null){
            return "the process does not exist";
        }

        Integer STID = findSTID(PID);
        if(softwareTestDao.select2(STID)==null){
            return "the SoftwareTest does not exist";
        }

        JSONObject res = JSON.parseArray(JSONrepack(JSON.toJSONString(softwareTestDao.select(STID)),jsonObject.getInteger("PID"))).getJSONObject(0);
        String softtableid = res.getString("softtableid");
        JSONArray softtable = StringtoArray2(softtableid);
        if(softtable!=new JSONArray()){
            Integer r=softtable.size();
            Integer i = 0;
            while(i<r){
                Integer id = softtable.getInteger(i);
                stableDao.delete(id);
                ++i;
            }
        }
        softwareTestDao.delete(STID);
        return "SoftwareTest delete completed";
    }



}
