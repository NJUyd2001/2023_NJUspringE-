package com.selab.demo.service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONArray;
import com.selab.demo.model.*;
import com.selab.demo.dao.TestRecordTableDao;
import com.selab.demo.dao.TestRecordDao;
import com.selab.demo.dao.ProcessDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class TestRecordService {
    @Autowired
    TestRecordDao testRecordDao;
    @Autowired
    TestRecordTableDao testRecordTableDao;
    @Autowired
    ProcessDao processDao;
    public Integer findTRID(Integer PID){
        ProcessModel processModel = processDao.findByPID(PID);
        if(processModel == null){
            return null;
        }
        return processModel.getTRID();
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
            result.put("TestClassification", jsonObject.getString("testclassification"));
            result.put("SerialNum",jsonObject.getString("serialnum"));
            result.put("DesignSpecification", jsonObject.getString("designspecification"));
            result.put("Regulation", jsonObject.getString("regulation"));
            result.put("Precondition", jsonObject.getString("precondition"));
            result.put("ExecutionProcess",jsonObject.getString("executionprocess"));
            result.put("ExpectedResult", jsonObject.getString("expectedresult"));
            result.put("Designer", jsonObject.getString("designer"));
            result.put("ActualResult", jsonObject.getString("actualresult"));
            result.put("BugNum", jsonObject.getString("bugnum"));
            result.put("UsecaseExecutor", jsonObject.getString("usecaseexecutor"));
            result.put("TestingTime", jsonObject.getString("testingtime"));
            result.put("ConfirmPerson", jsonObject.getString("confirmperson"));
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
                String testclassification = jsonObject1.getString("TestClassification");
                String serialnum = jsonObject1.getString("SerialNum");
                String designspecification = jsonObject1.getString("DesignSpecification");
                String regulation = jsonObject1.getString("Regulation");
                String precondition = jsonObject1.getString("Precondition");
                String executionprocess = jsonObject1.getString("ExecutionProcess");
                String expectedresult = jsonObject1.getString("ExpectedResult");
                String designer = jsonObject1.getString("Designer");
                String actualresult = jsonObject1.getString("ActualResult");
                String bugnum = jsonObject1.getString("BugNum");
                String usecaseexecutor = jsonObject1.getString("UsecaseExecutor");
                String testingtime = jsonObject1.getString("TestingTime");
                String confirmperson = jsonObject1.getString("ConfirmPerson");
                TestRecordTableModel testRecordTableModel= new TestRecordTableModel(0, testclassification, serialnum, designspecification,regulation,precondition,executionprocess,expectedresult,designer,actualresult,bugnum,usecaseexecutor,testingtime,confirmperson);
                testRecordTableDao.insert(testRecordTableModel);
                tableid.add(testRecordTableModel.getTableid().toString());
                ++i;
            }
        }
        TestRecordModel testRecordModel = new TestRecordModel(0,tableid.toJSONString());
        testRecordDao.insert(testRecordModel);
        Integer TRID = testRecordModel.getTRID();
        processDao.setTRID(PID,TRID);
        JSONObject res = new JSONObject();
        res.put("TRID",TRID);
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
        Integer TRID = findTRID(PID);
        if(testRecordDao.select2(TRID) == null){
            return new JSONArray().toString();
        }
        JSONObject table = JSON.parseArray(JSON.toJSONString(testRecordDao.select(TRID))).getJSONObject(0);
        JSONArray tableid = table.getJSONArray("tableid");
        JSONArray tabledata = new JSONArray();
        if(tableid != null){
            Integer r=tableid.size();
            Integer i = 0;
            while(i<r){
                Integer tableid_ = tableid.getInteger(i);
                tabledata.add(JSON.parseArray(JSONrepack1(JSON.toJSONString(testRecordTableDao.select(tableid_)))).get(0));
                ++i;
            }
        }
        JSONObject res = new JSONObject();
        res.put("PID",PID);
        res.put("TRID",TRID);
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
        Integer TRID = findTRID(PID);
        if(testRecordDao.select2(TRID) == null){
            return "the TestRecord dest not exist";
        }
        JSONObject oldjsonobject = JSON.parseArray(JSON.toJSONString(testRecordDao.select(TRID))).getJSONObject(0);
        JSONArray failedid = new JSONArray();
        JSONArray idarray1 = oldjsonobject.getJSONArray("tableid");
        JSONArray tabledata1 = jsonObject.getJSONArray("TableData");
        if(tabledata1!=null){
            Integer r= tabledata1.size();
            Integer i=0;
            while(i<r){
                JSONObject jsonObject1 = tabledata1.getJSONObject(i);
                Integer tableid = jsonObject1.getInteger("tableid");
                String delete = jsonObject1.getString("delete");
                String testclassification = jsonObject1.getString("TestClassification");
                String serialnum = jsonObject1.getString("SerialNum");
                String designspecification = jsonObject1.getString("DesignSpecification");
                String regulation = jsonObject1.getString("Regulation");
                String precondition = jsonObject1.getString("Precondition");
                String executionprocess = jsonObject1.getString("ExecutionProcess");
                String expectedresult = jsonObject1.getString("ExpectedResult");
                String designer = jsonObject1.getString("Designer");
                String actualresult = jsonObject1.getString("ActualResult");
                String bugnum = jsonObject1.getString("BugNum");
                String usecaseexecutor = jsonObject1.getString("UsecaseExecutor");
                String testingtime = jsonObject1.getString("TestingTime");
                String confirmperson = jsonObject1.getString("ConfirmPerson");
                TestRecordTableModel testRecordTableModel= new TestRecordTableModel(0, testclassification, serialnum, designspecification,regulation,precondition,executionprocess,expectedresult,designer,actualresult,bugnum,usecaseexecutor,testingtime,confirmperson);

                if(tableid == null){
                    testRecordTableDao.insert(testRecordTableModel);
                    idarray1.add(testRecordTableModel.getTableid().toString());
                }
                else{
                    if(testRecordTableDao.select2(tableid)==null||idarray1==null||idarray1==new JSONArray()) {
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
                                JSONObject oldtest = JSON.parseArray(JSON.toJSONString(testRecordTableDao.select(tableid))).getJSONObject(0);
                                if(testclassification == null){
                                    testclassification = oldtest.getString("testclassification");
                                }
                                if(serialnum == null){
                                    serialnum = oldtest.getString("serialnum");
                                }
                                if(designspecification == null){
                                    designspecification = oldtest.getString("designspecification");
                                }
                                if(regulation == null){
                                    regulation = oldtest.getString("regulation");
                                }
                                if(precondition == null){
                                    precondition = oldtest.getString("precondition");
                                }
                                if(executionprocess == null){
                                    executionprocess = oldtest.getString("executionprocess");
                                }
                                if(expectedresult == null){
                                    expectedresult = oldtest.getString("expectedresult");
                                }
                                if(designer == null){
                                    designer = oldtest.getString("designer");
                                }
                                if(actualresult == null){
                                    actualresult = oldtest.getString("actualresult");
                                }
                                if(bugnum == null){
                                    bugnum = oldtest.getString("bugnum");
                                }
                                if(usecaseexecutor == null){
                                    usecaseexecutor = oldtest.getString("usecaseexecutor");
                                }
                                if(testingtime == null){
                                    testingtime = oldtest.getString("testingtime");
                                }
                                if(confirmperson == null) {
                                    confirmperson = oldtest.getString("confirmperson");
                                }
                                testRecordTableModel = new TestRecordTableModel(tableid,testclassification,serialnum,designspecification,regulation,precondition,executionprocess,expectedresult,designer,actualresult,bugnum,usecaseexecutor,testingtime,confirmperson);
                                testRecordTableDao.update(testRecordTableModel);
                            } else {
                                testRecordTableDao.delete(tableid);
                                idarray1.remove(tableid.toString());
                            }
                        }
                    }
                }
                i++;
            }
        }

        TestRecordModel testRecordModel=new TestRecordModel(TRID,idarray1.toJSONString());
        testRecordDao.update(testRecordModel);
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
        Integer TRID = findTRID(PID);
        if(testRecordDao.select2(TRID) == null){
            return "the TestRecord dest not exist";
        }

        JSONObject oldjsonobject = JSON.parseArray(JSON.toJSONString(testRecordDao.select(TRID))).getJSONObject(0);
        JSONArray idarray1 = oldjsonobject.getJSONArray("tableid");
        if(idarray1!=new JSONArray()&&idarray1!=null){
            Integer r=idarray1.size();
            Integer i = 0;
            while(i<r){
                Integer id = idarray1.getInteger(i);
                testRecordTableDao.delete(id);
                ++i;
            }
        }
        testRecordDao.delete(TRID);
        return "TestRecord delete completed";
    }

}
