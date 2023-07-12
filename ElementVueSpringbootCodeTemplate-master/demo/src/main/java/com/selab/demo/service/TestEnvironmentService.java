package com.selab.demo.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONArray;
import com.selab.demo.model.*;
import com.selab.demo.dao.TestHardDao;
import com.selab.demo.dao.TestSoftDao;
import com.selab.demo.dao.TestEnvironmentDao;
import com.selab.demo.dao.ProcessDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestEnvironmentService {
    @Autowired
    TestHardDao testHardDao;
    @Autowired
    TestSoftDao testSoftDao;
    @Autowired
    TestEnvironmentDao testEnvironmentDao;
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

    private JSONArray JSONArraytoJSONArray(JSONArray jsonArray,String key){
        if(jsonArray==null){
            return null;
        }
        JSONArray res = new JSONArray();
        if(jsonArray!=null&&jsonArray!=new JSONArray()){
            Integer r= jsonArray.size();
            Integer i=0;
            while(i<r){
                res.add(jsonArray.getJSONObject(i).get(key));
                ++i;
            }
        }
        return res;
    }

    private JSONArray JSONArraytoJSONArray2(JSONArray jsonArray,String key){
        JSONArray res = new JSONArray();
        if(jsonArray!=null&&jsonArray!=new JSONArray()){
            Integer r= jsonArray.size();
            System.out.print(r+"\n");
            Integer i=0;
            while(i<r){
                JSONObject jsonObject = new JSONObject();
                jsonObject.put(key,jsonArray.get(i));
                res.add(jsonObject);
                ++i;
            }
        }
        return res;
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

    public Integer findTEID(Integer PID){
        ProcessModel processModel = processDao.findByPID(PID);
        if(processModel == null){
            return null;
        }
        return processModel.getTEID();
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
            result.put("hardid", jsonObject.getInteger("hardid"));
            result.put("HardwareCategory", jsonObject.getString("hardwarecategory"));
            result.put("HardwareName",jsonObject.getString("hardwarename"));
            result.put("Setting", jsonObject.getString("setting"));
            result.put("Quantity", jsonObject.getString("quantity"));
            result2.add(result);
            ++i;
        }
        return JSON.toJSONString(result2);
    }

    public String JSONrepack2(String postJson){
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
            result.put("softid",jsonObject.getString("softid"));
            result.put("SoftwareCategory", jsonObject.getString("softwarecategory"));
            result.put("SoftwareName", jsonObject.getString("softwarename"));
            result.put("Edition",jsonObject.getString("edition"));
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
        JSONArray hard = jsonObject.getJSONArray("tableData1");
        JSONArray hardid = new JSONArray();
        if(hard != null){
            Integer r= hard.size();
            Integer i =0;
            while(i<r){
                JSONObject jsonObject1 = hard.getJSONObject(i);
                String hardwarecategory = jsonObject1.getString("HardwareCategory");
                String hardwarename = jsonObject1.getString("HardwareName");
                String setting = jsonObject1.getString("Setting");
                String quantity = jsonObject1.getString("Quantity");
                TestHardModel testHardModel = new TestHardModel(0,hardwarecategory,hardwarename,setting,quantity);
                testHardDao.insert(testHardModel);
                hardid.add(testHardModel.getHardid().toString());
                ++i;
            }
        }
        JSONArray soft = jsonObject.getJSONArray("tableData2");
        JSONArray softid = new JSONArray();
        if(soft != null){
            Integer r= soft.size();
            Integer i =0;
            while(i<r){
                JSONObject jsonObject1 = soft.getJSONObject(i);
                String softwarecategory = jsonObject1.getString("SoftwareCategory");
                String softwarename = jsonObject1.getString("SoftwareName");
                String edition = jsonObject1.getString("Edition");
                TestSoftModel testSoftModel = new TestSoftModel(0,softwarecategory,softwarename,edition);
                testSoftDao.insert(testSoftModel);
                softid.add(testSoftModel.getSoftid().toString());
                ++i;
            }
        }
        String hardid2 = JSON.toJSONString(hardid);
        String softid2 = JSON.toJSONString(softid);
        String needstandard = JSON.toJSONString(JSONArraytoJSONArray(jsonObject.getJSONArray("TableData1"),"NeededStandard"));
        String referencematerial = JSON.toJSONString(JSONArraytoJSONArray(jsonObject.getJSONArray("TableData2"),"ReferenceMaterial"));
        TestEnvironmentModel testEnvironmentModel = new TestEnvironmentModel(0,hardid2,softid2,needstandard,referencematerial);
        testEnvironmentDao.insert(testEnvironmentModel);
        Integer TEID = testEnvironmentModel.getTEID();
        processDao.setTEID(PID,TEID);
        JSONObject res = new JSONObject();
        res.put("PID",PID);
        res.put("TEID",TEID);
        return JSON.toJSONString(res);
    }

    public String select(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer PID = jsonObject.getInteger("PID");
        if(processDao.findByPID(PID) == null){
            return "the process does not exist";
        }
        Integer TEID = findTEID(PID);
        JSONObject table = JSON.parseArray(JSON.toJSONString(testEnvironmentDao.select(TEID))).getJSONObject(0);
        JSONArray hardid = table.getJSONArray("hardid");
        JSONArray tabledata1 = new JSONArray();
        if(hardid != null){
            Integer r=hardid.size();
            Integer i = 0;
            while(i<r){
                Integer hardid_ = hardid.getInteger(i);
                tabledata1.add(JSON.parseArray(JSONrepack1(JSON.toJSONString(testHardDao.select(hardid_)))).get(0));
                ++i;
            }
        }
        JSONArray softid = table.getJSONArray("softid");
        JSONArray tabledata2 = new JSONArray();
        if(softid != null){
            Integer r=softid.size();
            Integer i = 0;
            while(i<r){
                Integer softid_ = softid.getInteger(i);
                tabledata2.add(JSON.parseArray(JSONrepack2(JSON.toJSONString(testSoftDao.select(softid_)))).get(0));
                ++i;
            }
        }
        JSONObject res = new JSONObject();
        res.put("PID",PID);
        res.put("TEID",TEID);
        res.put("tableData1",tabledata1);
        res.put("tableData2",tabledata2);
        res.put("TableData1",JSONArraytoJSONArray2(table.getJSONArray("neededstandard"),"NeededStandard"));
        res.put("TableData2",JSONArraytoJSONArray2(table.getJSONArray("referencematerial"),"ReferenceMaterial"));
        JSONArray res2 = new JSONArray();
        res2.add(res);
        return JSON.toJSONString(res2);
    }

    public String update(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer PID = jsonObject.getInteger("PID");
        if(processDao.findByPID(PID) == null){
            return "the process does not exist";
        }
        Integer TEID = findTEID(PID);
        if(testEnvironmentDao.select2(TEID) == null){
            return "the TestEnvironment dest not exist";
        }
        JSONObject oldjsonobject = JSON.parseArray(JSON.toJSONString(testEnvironmentDao.select(TEID))).getJSONObject(0);
        JSONArray failedhid = new JSONArray();
        JSONArray failedsid = new JSONArray();
        JSONArray hardidarray = oldjsonobject.getJSONArray("hardid");
        JSONArray tabledata1 = jsonObject.getJSONArray("tableData1");
        if(tabledata1!=null){
            Integer r= tabledata1.size();
            Integer i=0;
            while(i<r){
                JSONObject res = tabledata1.getJSONObject(i);
                Integer hardid = res.getInteger("hardid");
                String delete = res.getString("delete");
                String hardwarecategory = res.getString("HardwareCategory");
                String hardwarename = res.getString("HardwareName");
                String setting = res.getString("Setting");
                String quantity = res.getString("Quantity");
                TestHardModel testHardModel = new TestHardModel(hardid,hardwarecategory,hardwarename,setting,quantity);

                if(hardid == null){
                    testHardDao.insert(testHardModel);
                    hardidarray.add(testHardModel.getHardid().toString());
                }
                else{
                    if(testHardDao.select2(hardid)==null||hardidarray==null||hardidarray==new JSONArray()) {
                        failedhid.add(hardid);
                    }
                    else {
                        Integer check =0;
                        Integer r2= hardidarray.size();
                        Integer i2=0;
                        while(i2<r2) {
                            if(hardid==hardidarray.getInteger(i2)) {
                                check =1;
                                break;
                            }
                            i2++;
                        }
                        if(check == 0) {
                            failedhid.add(hardid);
                        }
                        else {
                            if (delete == null || !delete.equals("T")) {
                                testHardDao.update(testHardModel);
                            } else {
                                testHardDao.delete(hardid);
                                hardidarray.remove(hardid.toString());
                            }
                        }
                    }
                }
                i++;
            }
        }

        JSONArray softidarray = oldjsonobject.getJSONArray("softid");
        JSONArray tabledata2 = jsonObject.getJSONArray("tableData2");
        if(tabledata1!=null){
            Integer r= tabledata2.size();
            Integer i=0;
            while(i<r){
                JSONObject res = tabledata2.getJSONObject(i);
                Integer softid = res.getInteger("softid");
                String delete = res.getString("delete");
                String softwarecategory = res.getString("SoftwareCategory");
                String softwarename = res.getString("SoftwareName");
                String edition = res.getString("Edition");
                TestSoftModel testSoftModel = new TestSoftModel(softid,softwarecategory,softwarename,edition);

                if(softid == null){
                    testSoftDao.insert(testSoftModel);
                    softidarray.add(testSoftModel.getSoftid().toString());
                }
                else{
                    if(testSoftDao.select2(softid)==null||softidarray==null||softidarray==new JSONArray()) {
                        failedsid.add(softid);
                    }
                    else {
                        Integer check =0;
                        Integer r2= softidarray.size();
                        Integer i2=0;
                        while(i2<r2) {
                            if(softid==softidarray.getInteger(i2)) {
                                check =1;
                                break;
                            }
                            i2++;
                        }
                        if(check == 0) {
                            failedsid.add(softid);
                        }
                        else {
                            if (delete == null || !delete.equals("T")) {
                                testSoftDao.update(testSoftModel);
                            } else {
                                testSoftDao.delete(softid);
                                softidarray.remove(softid.toString());
                            }
                        }
                    }
                }
                i++;
            }
        }
        String needstandard = JSON.toJSONString(JSONArraytoJSONArray(jsonObject.getJSONArray("TableData1"),"NeededStandard"));
        String referencematerial = JSON.toJSONString(JSONArraytoJSONArray(jsonObject.getJSONArray("TableData2"),"ReferenceMaterial"));
        if(needstandard.equals(JSON.toJSONString(null))) {
            needstandard = oldjsonobject.getString("needstandard");
        }
        if(referencematerial.equals(JSON.toJSONString(null))){
            referencematerial = oldjsonobject.getString("referencematerial");

        }
        TestEnvironmentModel testEnvironmentModel=new TestEnvironmentModel(TEID,JSON.toJSONString(hardidarray),JSON.toJSONString(softidarray),needstandard,referencematerial);
        testEnvironmentDao.update(testEnvironmentModel);
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("FailedHardId",failedhid);
        jsonObject1.put("FailedSoftId",failedsid);
        return JSON.toJSONString(jsonObject1);
    }

    public String delete(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer PID = jsonObject.getInteger("PID");
        if(processDao.findByPID(PID) == null){
            return "the process does not exist";
        }
        Integer TEID = findTEID(PID);
        if(testEnvironmentDao.select2(TEID) == null){
            return "the TestEnvironment dest not exist";
        }

        JSONObject oldjsonobject = JSON.parseArray(JSON.toJSONString(testEnvironmentDao.select(TEID))).getJSONObject(0);
        JSONArray hardidarray = oldjsonobject.getJSONArray("hardid");
        JSONArray softidarray = oldjsonobject.getJSONArray("softid");
        if(hardidarray!=new JSONArray()&&hardidarray!=null){
            Integer r=hardidarray.size();
            Integer i = 0;
            while(i<r){
                Integer id = hardidarray.getInteger(i);
                testHardDao.delete(id);
                ++i;
            }
        }
        if(softidarray!=new JSONArray()&&softidarray!=null){
            Integer r=softidarray.size();
            Integer i = 0;
            while(i<r){
                Integer id = softidarray.getInteger(i);
                testSoftDao.delete(id);
                ++i;
            }
        }
        testEnvironmentDao.delete(TEID);
        return "TestEnvironment delete completed";
    }

}
