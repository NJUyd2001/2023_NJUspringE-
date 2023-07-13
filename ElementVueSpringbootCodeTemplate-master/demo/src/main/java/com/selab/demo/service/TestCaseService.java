package com.selab.demo.service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONArray;
import com.selab.demo.model.*;
import com.selab.demo.dao.TestCaseTableDao;
import com.selab.demo.dao.TestCaseDao;
import com.selab.demo.dao.ProcessDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestCaseService {
    @Autowired
    TestCaseDao testCaseDao;
    @Autowired
    TestCaseTableDao testCaseTableDao;
    @Autowired
    ProcessDao processDao;

    public Integer findTCID(Integer PID){
        ProcessModel processModel = processDao.findByPID(PID);
        if(processModel == null){
            return null;
        }
        return processModel.getTCID();
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
            result.put("TestClassification", jsonObject.getString("testclassificaion"));
            result.put("Num",jsonObject.getString("num"));
            result.put("TestCaseDesign", jsonObject.getString("testcasedesign"));
            result.put("StockDescription", jsonObject.getString("stockdescription"));
            result.put("ExpectedResult", jsonObject.getString("expectedresult"));
            result.put("Designer",jsonObject.getString("designer"));
            result.put("TestTime", jsonObject.getString("testtime"));
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
        JSONArray table1 = jsonObject.getJSONArray("TableData");
        JSONArray tableid = new JSONArray();
        if (table1 != null) {
            Integer r = table1.size();
            Integer i = 0;
            while (i < r) {
                JSONObject jsonObject1 = table1.getJSONObject(i);
                String testclassificaion = jsonObject1.getString("TestClassification");
                String num = jsonObject1.getString("Num");
                String testcasedesign = jsonObject1.getString("TestCaseDesign");
                String stockdescription = jsonObject1.getString("StockDescription");
                String expectedresult = jsonObject1.getString("ExpectedResult");
                String designer = jsonObject1.getString("Designer");
                String testtime = jsonObject1.getString("TestTime");
                TestCaseTableModel testCaseTableModel = new TestCaseTableModel(0, testclassificaion, num, testcasedesign,stockdescription,expectedresult,designer,testtime);
                testCaseTableDao.insert(testCaseTableModel);
                tableid.add(testCaseTableModel.getTableid().toString());
                ++i;
            }
        }
        TestCaseModel testCaseModel = new TestCaseModel(0,tableid.toJSONString());
        testCaseDao.insert(testCaseModel);
        Integer TCID = testCaseModel.getTCID();
        processDao.setTCID(PID,TCID);
        JSONObject res = new JSONObject();
        res.put("TCID",TCID);
        res.put("PID",PID);
        res.put("tableid",tableid);
        return res.toJSONString();
    }



    public String select(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer PID = jsonObject.getInteger("PID");
        if(PID == null ||processDao.findByPID(PID) == null){
            return "the process does not exist";
        }
        Integer TCID = findTCID(PID);
        if(testCaseDao.select2(TCID) == null){
            return new JSONArray().toString();
        }
        JSONObject table = JSON.parseArray(JSON.toJSONString(testCaseDao.select(TCID))).getJSONObject(0);
        JSONArray tableid = table.getJSONArray("tableid");
        JSONArray tabledata = new JSONArray();
        if(tableid != null){
            Integer r=tableid.size();
            Integer i = 0;
            while(i<r){
                Integer tableid_ = tableid.getInteger(i);
                tabledata.add(JSON.parseArray(JSONrepack1(JSON.toJSONString(testCaseTableDao.select(tableid_)))).get(0));
                ++i;
            }
        }
        JSONObject res = new JSONObject();
        res.put("PID",PID);
        res.put("TCID",TCID);
        res.put("TableData",tabledata);
        JSONArray res2 = new JSONArray();
        res2.add(res);
        return JSON.toJSONString(res2);
    }

    public String update(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer PID = jsonObject.getInteger("PID");
        if(PID == null ||processDao.findByPID(PID) == null){
            return "the process does not exist";
        }
        Integer TCID = findTCID(PID);
        if(testCaseDao.select2(TCID) == null){
            return "the TestCase dest not exist";
        }
        JSONObject oldjsonobject = JSON.parseArray(JSON.toJSONString(testCaseDao.select(TCID))).getJSONObject(0);
        JSONArray failedid = new JSONArray();
        JSONArray idarray1 = oldjsonobject.getJSONArray("tableid");
        JSONArray tabledata1 = jsonObject.getJSONArray("TableData");
        if(tabledata1!=null){
            Integer r= tabledata1.size();
            Integer i=0;
            while(i<r){
                JSONObject res = tabledata1.getJSONObject(i);
                Integer tableid = res.getInteger("tableid");
                String delete = res.getString("delete");
                String testclassificaion = res.getString("TestClassification");
                String num = res.getString("Num");
                String testcasedesign = res.getString("TestCaseDesign");
                String stockdescription = res.getString("StockDescription");
                String expectedresult = res.getString("ExpectedResult");
                String designer = res.getString("Designer");
                String testtime = res.getString("TestTime");
                TestCaseTableModel testCaseTableModel = new TestCaseTableModel(tableid,testclassificaion,num,testcasedesign,stockdescription,expectedresult,designer,testtime);

                if(tableid == null){
                    testCaseTableDao.insert(testCaseTableModel);
                    idarray1.add(testCaseTableModel.getTableid().toString());
                }
                else{
                    if(testCaseTableDao.select2(tableid)==null||idarray1==null||idarray1==new JSONArray()) {
                        failedid.add(tableid);
                    }
                    else {
                        Integer check =0;
                        Integer r2= idarray1.size();
                        Integer i2=0;
                        while(i2<r2) {
                            if(tableid==idarray1.getInteger(i2)) {
                                check =1;
                                break;
                            }
                            i2++;
                        }
                        if(check == 0) {
                            failedid.add(tableid);
                        }
                        else {
                            if (delete == null || !delete.equals("T")) {
                                JSONObject oldtest = JSON.parseArray(JSON.toJSONString(testCaseTableDao.select(tableid))).getJSONObject(0);
                                if(testclassificaion == null){
                                    testclassificaion = oldtest.getString("testclassificaion");
                                }
                                if(num == null){
                                    num = oldtest.getString("num");
                                }
                                if(testcasedesign == null){
                                    testcasedesign = oldtest.getString("testcasedesign");
                                }
                                if(stockdescription == null){
                                    stockdescription = oldtest.getString("stockdescription");
                                }
                                if(expectedresult == null){
                                    expectedresult = oldtest.getString("expectedresult");
                                }
                                if(designer == null){
                                    designer = oldtest.getString("designer");
                                }
                                if(testtime == null){
                                    testtime = oldtest.getString("testtime");
                                }
                                testCaseTableModel = new TestCaseTableModel(tableid,testclassificaion,num,testcasedesign,stockdescription,expectedresult,designer,testtime);
                                testCaseTableDao.update(testCaseTableModel);
                            } else {
                                testCaseTableDao.delete(tableid);
                                idarray1.remove(tableid.toString());
                            }
                        }
                    }
                }
                i++;
            }
        }

        TestCaseModel testCaseModel=new TestCaseModel(TCID,idarray1.toJSONString());
        testCaseDao.update(testCaseModel);
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("FailedTableDataID",failedid);
        return JSON.toJSONString(jsonObject1);
    }

    public String delete(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer PID = jsonObject.getInteger("PID");
        if(PID == null ||processDao.findByPID(PID) == null){
            return "the process does not exist";
        }
        Integer TCID = findTCID(PID);
        if(testCaseDao.select2(TCID) == null){
            return "the TestCase dest not exist";
        }

        JSONObject oldjsonobject = JSON.parseArray(JSON.toJSONString(testCaseDao.select(TCID))).getJSONObject(0);
        JSONArray idarray1 = oldjsonobject.getJSONArray("tableid");
        if(idarray1!=new JSONArray()&&idarray1!=null){
            Integer r=idarray1.size();
            Integer i = 0;
            while(i<r){
                Integer id = idarray1.getInteger(i);
                testCaseTableDao.delete(id);
                ++i;
            }
        }
        testCaseDao.delete(TCID);
        return "TestCase delete completed";
    }


}
