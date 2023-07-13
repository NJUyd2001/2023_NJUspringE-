package com.selab.demo.service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONArray;
import com.selab.demo.model.*;
import com.selab.demo.dao.TestCharDao;
import com.selab.demo.dao.TestFuncDao;
import com.selab.demo.dao.TesttheContentDao;
import com.selab.demo.dao.ProcessDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TesttheContentService {

    @Autowired
    TesttheContentDao testtheContentDao;
    @Autowired
    TestFuncDao testFuncDao;
    @Autowired
    TestCharDao testCharDao;
    @Autowired
    ProcessDao processDao;
    public Integer findTID(Integer PID){
        ProcessModel processModel = processDao.findByPID(PID);
        if(processModel == null){
            return null;
        }
        return processModel.getTID();
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
            result.put("testid", jsonObject.getInteger("testid"));
            result.put("FunctionModule", jsonObject.getString("functionmodule"));
            result.put("FunctionRequirement",jsonObject.getString("functionrequirement"));
            result.put("TestResult", jsonObject.getString("testresult"));
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
            result.put("testid",jsonObject.getString("testid"));
            result.put("TestCharacteristic", jsonObject.getString("testcharacteristic"));
            result.put("TestSpecification", jsonObject.getString("testspecification"));
            result.put("TestResult",jsonObject.getString("testresult"));
            result2.add(result);
            ++i;
        }
        return JSON.toJSONString(result2);
    }
    public String insert(String postJson) {
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer PID = jsonObject.getInteger("PID");
        if (processDao.findByPID(PID) == null) {
            return "the process does not exist";
        }
        JSONArray table1 = jsonObject.getJSONArray("TableData1");
        JSONArray testid1 = new JSONArray();
        if (table1 != null) {
            Integer r = table1.size();
            Integer i = 0;
            while (i < r) {
                JSONObject jsonObject1 = table1.getJSONObject(i);
                String functionmodule = jsonObject1.getString("FunctionModule");
                String functionrequirement = jsonObject1.getString("FunctionRequirement");
                String testresult = jsonObject1.getString("TestResult");
                TestFuncModel testFuncModel = new TestFuncModel(0, functionmodule, functionrequirement, testresult);
                testFuncDao.insert(testFuncModel);
                testid1.add(testFuncModel.getTestid().toString());
                ++i;
            }
        }
        JSONArray table2 = jsonObject.getJSONArray("TableData2");
        JSONArray testid2 = new JSONArray();
        if (table2 != null) {
            Integer r = table2.size();
            Integer i = 0;
            while (i < r) {
                JSONObject jsonObject1 = table2.getJSONObject(i);
                String testcharacteristic = jsonObject1.getString("TestCharacteristic");
                String testspecification = jsonObject1.getString("TestSpecification");
                String testresult = jsonObject1.getString("TestResult");
                TestCharModel testCharModel = new TestCharModel(0, testcharacteristic, testspecification, testresult);
                testCharDao.insert(testCharModel);
                testid2.add(testCharModel.getTestid().toString());
                ++i;
            }
        }
        JSONArray table3 = jsonObject.getJSONArray("TableData3");
        JSONArray testid3 = new JSONArray();
        if (table3 != null) {
            Integer r = table3.size();
            Integer i = 0;
            while (i < r) {
                JSONObject jsonObject1 = table3.getJSONObject(i);
                String testcharacteristic = jsonObject1.getString("TestCharacteristic");
                String testspecification = jsonObject1.getString("TestSpecification");
                String testresult = jsonObject1.getString("TestResult");
                TestCharModel testCharModel = new TestCharModel(0, testcharacteristic, testspecification, testresult);
                testCharDao.insert(testCharModel);
                testid3.add(testCharModel.getTestid().toString());
                ++i;
            }
        }
        JSONArray table4 = jsonObject.getJSONArray("TableData4");
        JSONArray testid4 = new JSONArray();
        if (table4 != null) {
            Integer r = table4.size();
            Integer i = 0;
            while (i < r) {
                JSONObject jsonObject1 = table4.getJSONObject(i);
                String testcharacteristic = jsonObject1.getString("TestCharacteristic");
                String testspecification = jsonObject1.getString("TestSpecification");
                String testresult = jsonObject1.getString("TestResult");
                TestCharModel testCharModel = new TestCharModel(0, testcharacteristic, testspecification, testresult);
                testCharDao.insert(testCharModel);
                testid4.add(testCharModel.getTestid().toString());
                ++i;
            }
        }
        JSONArray table5 = jsonObject.getJSONArray("TableData5");
        JSONArray testid5 = new JSONArray();
        if (table5 != null) {
            Integer r = table5.size();
            Integer i = 0;
            while (i < r) {
                JSONObject jsonObject1 = table5.getJSONObject(i);
                String testcharacteristic = jsonObject1.getString("TestCharacteristic");
                String testspecification = jsonObject1.getString("TestSpecification");
                String testresult = jsonObject1.getString("TestResult");
                TestCharModel testCharModel = new TestCharModel(0, testcharacteristic, testspecification, testresult);
                testCharDao.insert(testCharModel);
                testid5.add(testCharModel.getTestid().toString());
                ++i;
            }
        }
        JSONArray table6 = jsonObject.getJSONArray("TableData6");
        JSONArray testid6 = new JSONArray();
        if (table6 != null) {
            Integer r = table6.size();
            Integer i = 0;
            while (i < r) {
                JSONObject jsonObject1 = table6.getJSONObject(i);
                String testcharacteristic = jsonObject1.getString("TestCharacteristic");
                String testspecification = jsonObject1.getString("TestSpecification");
                String testresult = jsonObject1.getString("TestResult");
                TestCharModel testCharModel = new TestCharModel(0, testcharacteristic, testspecification, testresult);
                testCharDao.insert(testCharModel);
                testid6.add(testCharModel.getTestid().toString());
                ++i;
            }
        }
        TesttheContentModel testtheContentModel = new TesttheContentModel(0,testid1.toJSONString(),testid2.toJSONString(),testid3.toJSONString(),testid4.toJSONString(),testid5.toJSONString(),testid6.toJSONString());
        testtheContentDao.insert(testtheContentModel);
        Integer TID = testtheContentModel.getTID();
        processDao.setTID(PID,TID);
        JSONObject res = new JSONObject();
        res.put("TID",TID);
        res.put("PID",PID);
        res.put("testid1",testid1);
        res.put("testid2",testid2);
        res.put("testid3",testid3);
        res.put("testid4",testid4);
        res.put("testid5",testid5);
        res.put("testid6",testid6);
        return res.toJSONString();
    }

    public String select(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer PID = jsonObject.getInteger("PID");
        if(processDao.findByPID(PID) == null){
            return "the process does not exist";
        }
        Integer TID = findTID(PID);
        if(testtheContentDao.select2(TID) == null){
            return new JSONArray().toString();
        }
        JSONObject table = JSON.parseArray(JSON.toJSONString(testtheContentDao.select(TID))).getJSONObject(0);
        JSONArray testid1 = table.getJSONArray("testid1");
        JSONArray tabledata1 = new JSONArray();
        if(testid1 != null){
            Integer r=testid1.size();
            Integer i = 0;
            while(i<r){
                Integer testid1_ = testid1.getInteger(i);
                tabledata1.add(JSON.parseArray(JSONrepack1(JSON.toJSONString(testFuncDao.select(testid1_)))).get(0));
                ++i;
            }
        }
        JSONArray testid2 = table.getJSONArray("testid2");
        JSONArray tabledata2 = new JSONArray();
        if(testid2 != null){
            Integer r=testid2.size();
            Integer i = 0;
            while(i<r){
                Integer testid2_ = testid2.getInteger(i);
                tabledata2.add(JSON.parseArray(JSONrepack2(JSON.toJSONString(testCharDao.select(testid2_)))).get(0));
                ++i;
            }
        }
        JSONArray testid3 = table.getJSONArray("testid3");
        JSONArray tabledata3 = new JSONArray();
        if(testid3 != null){
            Integer r=testid3.size();
            Integer i = 0;
            while(i<r){
                Integer testid3_ = testid3.getInteger(i);
                tabledata3.add(JSON.parseArray(JSONrepack2(JSON.toJSONString(testCharDao.select(testid3_)))).get(0));
                ++i;
            }
        }
        JSONArray testid4 = table.getJSONArray("testid4");
        JSONArray tabledata4 = new JSONArray();
        if(testid4 != null){
            Integer r=testid4.size();
            Integer i = 0;
            while(i<r){
                Integer testid4_ = testid4.getInteger(i);
                tabledata4.add(JSON.parseArray(JSONrepack2(JSON.toJSONString(testCharDao.select(testid4_)))).get(0));
                ++i;
            }
        }
        JSONArray testid5 = table.getJSONArray("testid5");
        JSONArray tabledata5 = new JSONArray();
        if(testid5 != null){
            Integer r=testid5.size();
            Integer i = 0;
            while(i<r){
                Integer testid5_ = testid5.getInteger(i);
                tabledata5.add(JSON.parseArray(JSONrepack2(JSON.toJSONString(testCharDao.select(testid5_)))).get(0));
                ++i;
            }
        }
        JSONArray testid6 = table.getJSONArray("testid6");
        JSONArray tabledata6 = new JSONArray();
        if(testid6 != null){
            Integer r=testid6.size();
            Integer i = 0;
            while(i<r){
                Integer testid6_ = testid3.getInteger(i);
                tabledata6.add(JSON.parseArray(JSONrepack2(JSON.toJSONString(testCharDao.select(testid6_)))).get(0));
                ++i;
            }
        }
        JSONObject res = new JSONObject();
        res.put("PID",PID);
        res.put("TID",TID);
        res.put("TableData1",tabledata1);
        res.put("TableData2",tabledata2);
        res.put("TableData3",tabledata3);
        res.put("TableData4",tabledata4);
        res.put("TableData5",tabledata5);
        res.put("TableData6",tabledata6);
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
        Integer TID = findTID(PID);
        if(testtheContentDao.select2(TID) == null){
            return "the TestContent dest not exist";
        }
        JSONObject oldjsonobject = JSON.parseArray(JSON.toJSONString(testtheContentDao.select(TID))).getJSONObject(0);
        JSONArray failedid1 = new JSONArray();
        JSONArray failedid2 = new JSONArray();
        JSONArray failedid3 = new JSONArray();
        JSONArray failedid4 = new JSONArray();
        JSONArray failedid5 = new JSONArray();
        JSONArray failedid6 = new JSONArray();
        JSONArray idarray1 = oldjsonobject.getJSONArray("testid1");
        JSONArray tabledata1 = jsonObject.getJSONArray("TableData1");
        if(tabledata1!=null){
            Integer r= tabledata1.size();
            Integer i=0;
            while(i<r){
                JSONObject res = tabledata1.getJSONObject(i);
                Integer testid = res.getInteger("testid");
                String delete = res.getString("delete");
                String functionmodule = res.getString("FunctionModule");
                String functionrequirement = res.getString("FunctionRequirement");
                String testresult = res.getString("TestResult");
                TestFuncModel testFuncModel = new TestFuncModel(testid,functionmodule,functionrequirement,testresult);

                if(testid == null){
                    testFuncDao.insert(testFuncModel);
                    idarray1.add(testFuncModel.getTestid().toString());
                }
                else{
                    if(testFuncDao.select2(testid)==null||idarray1==null||idarray1==new JSONArray()) {
                        failedid1.add(testid);
                    }
                    else {
                        Integer check =0;
                        Integer r2= idarray1.size();
                        Integer i2=0;
                        while(i2<r2) {
                            if(testid==idarray1.getInteger(i2)) {
                                check =1;
                                break;
                            }
                            i2++;
                        }
                        if(check == 0) {
                            idarray1.add(testid);
                        }
                        else {
                            if (delete == null || !delete.equals("T")) {
                                JSONObject oldtest = JSON.parseArray(JSON.toJSONString(testFuncDao.select(testid))).getJSONObject(0);
                                if(functionmodule == null){
                                    functionmodule = oldtest.getString("functionmodule");
                                }
                                if(functionrequirement == null){
                                    functionrequirement = oldtest.getString("functionrequirement");
                                }
                                if(testresult == null){
                                    testresult = oldtest.getString("testresult");
                                }
                                testFuncModel = new TestFuncModel(testid,functionmodule,functionrequirement,testresult);
                                testFuncDao.update(testFuncModel);
                            } else {
                                testFuncDao.delete(testid);
                                idarray1.remove(testid.toString());
                            }
                        }
                    }
                }
                i++;
            }
        }

        JSONArray idarray2 = oldjsonobject.getJSONArray("testid2");
        JSONArray tabledata2 = jsonObject.getJSONArray("TableData2");
        if(tabledata1!=null){
            Integer r= tabledata2.size();
            Integer i=0;
            while(i<r){
                JSONObject res = tabledata2.getJSONObject(i);
                Integer testid = res.getInteger("testid");
                String delete = res.getString("delete");
                String testcharacteristic = res.getString("TestCharacteristic");
                String testspecification = res.getString("TestSpecification");
                String testresult = res.getString("TestResult");
                TestCharModel testCharModel = new TestCharModel(testid,testcharacteristic,testspecification,testresult);

                if(testid == null){
                    testCharDao.insert(testCharModel);
                    idarray2.add(testCharModel.getTestid().toString());
                }
                else{
                    if(testCharDao.select2(testid)==null||idarray2==null||idarray2==new JSONArray()) {
                        failedid2.add(testid);
                    }
                    else {
                        Integer check =0;
                        Integer r2= idarray2.size();
                        Integer i2=0;
                        while(i2<r2) {
                            if(testid==idarray2.getInteger(i2)) {
                                check =1;
                                break;
                            }
                            i2++;
                        }
                        if(check == 0) {
                            failedid2.add(testid);
                        }
                        else {
                            if (delete == null || !delete.equals("T")) {
                                JSONObject oldtest = JSON.parseArray(JSON.toJSONString(testCharDao.select(testid))).getJSONObject(0);
                                if(testcharacteristic ==null){
                                    testcharacteristic = oldtest.getString("testcharacteristic");
                                }
                                if(testspecification == null){
                                    testspecification = oldtest.getString("testspecification");
                                }
                                if(testresult == null){
                                    testresult = oldtest.getString("testresult");
                                }
                                testCharModel = new TestCharModel(testid,testcharacteristic,testspecification,testresult);
                                testCharDao.update(testCharModel);
                            } else {
                                testCharDao.delete(testid);
                                idarray2.remove(testid.toString());
                            }
                        }
                    }
                }
                i++;
            }
        }
        JSONArray idarray3 = oldjsonobject.getJSONArray("testid3");
        JSONArray tabledata3 = jsonObject.getJSONArray("TableData3");
        if(tabledata1!=null){
            Integer r= tabledata3.size();
            Integer i=0;
            while(i<r){
                JSONObject res = tabledata3.getJSONObject(i);
                Integer testid = res.getInteger("testid");
                String delete = res.getString("delete");
                String testcharacteristic = res.getString("TestCharacteristic");
                String testspecification = res.getString("TestSpecification");
                String testresult = res.getString("TestResult");
                TestCharModel testCharModel = new TestCharModel(testid,testcharacteristic,testspecification,testresult);

                if(testid == null){
                    testCharDao.insert(testCharModel);
                    idarray3.add(testCharModel.getTestid().toString());
                }
                else{
                    if(testCharDao.select2(testid)==null||idarray3==null||idarray3==new JSONArray()) {
                        failedid3.add(testid);
                    }
                    else {
                        Integer check =0;
                        Integer r3= idarray3.size();
                        Integer i3=0;
                        while(i3<r3) {
                            if(testid==idarray3.getInteger(i3)) {
                                check =1;
                                break;
                            }
                            i3++;
                        }
                        if(check == 0) {
                            failedid3.add(testid);
                        }
                        else {
                            if (delete == null || !delete.equals("T")) {
                                JSONObject oldtest = JSON.parseArray(JSON.toJSONString(testCharDao.select(testid))).getJSONObject(0);
                                if(testcharacteristic ==null){
                                    testcharacteristic = oldtest.getString("testcharacteristic");
                                }
                                if(testspecification == null){
                                    testspecification = oldtest.getString("testspecification");
                                }
                                if(testresult == null){
                                    testresult = oldtest.getString("testresult");
                                }
                                testCharModel = new TestCharModel(testid,testcharacteristic,testspecification,testresult);
                                testCharDao.update(testCharModel);
                            } else {
                                testCharDao.delete(testid);
                                idarray3.remove(testid.toString());
                            }
                        }
                    }
                }
                i++;
            }
        }
        JSONArray idarray4 = oldjsonobject.getJSONArray("testid4");
        JSONArray tabledata4 = jsonObject.getJSONArray("TableData4");
        if(tabledata1!=null){
            Integer r= tabledata4.size();
            Integer i=0;
            while(i<r){
                JSONObject res = tabledata4.getJSONObject(i);
                Integer testid = res.getInteger("testid");
                String delete = res.getString("delete");
                String testcharacteristic = res.getString("TestCharacteristic");
                String testspecification = res.getString("TestSpecification");
                String testresult = res.getString("TestResult");
                TestCharModel testCharModel = new TestCharModel(testid,testcharacteristic,testspecification,testresult);

                if(testid == null){
                    testCharDao.insert(testCharModel);
                    idarray4.add(testCharModel.getTestid().toString());
                }
                else{
                    if(testCharDao.select2(testid)==null||idarray4==null||idarray4==new JSONArray()) {
                        failedid4.add(testid);
                    }
                    else {
                        Integer check =0;
                        Integer r4= idarray4.size();
                        Integer i4=0;
                        while(i4<r4) {
                            if(testid==idarray4.getInteger(i4)) {
                                check =1;
                                break;
                            }
                            i4++;
                        }
                        if(check == 0) {
                            failedid4.add(testid);
                        }
                        else {
                            if (delete == null || !delete.equals("T")) {
                                JSONObject oldtest = JSON.parseArray(JSON.toJSONString(testCharDao.select(testid))).getJSONObject(0);
                                if(testcharacteristic ==null){
                                    testcharacteristic = oldtest.getString("testcharacteristic");
                                }
                                if(testspecification == null){
                                    testspecification = oldtest.getString("testspecification");
                                }
                                if(testresult == null){
                                    testresult = oldtest.getString("testresult");
                                }
                                testCharModel = new TestCharModel(testid,testcharacteristic,testspecification,testresult);
                                testCharDao.update(testCharModel);
                            } else {
                                testCharDao.delete(testid);
                                idarray4.remove(testid.toString());
                            }
                        }
                    }
                }
                i++;
            }
        }
        JSONArray idarray5 = oldjsonobject.getJSONArray("testid5");
        JSONArray tabledata5 = jsonObject.getJSONArray("TableData5");
        if(tabledata1!=null){
            Integer r= tabledata5.size();
            Integer i=0;
            while(i<r){
                JSONObject res = tabledata5.getJSONObject(i);
                Integer testid = res.getInteger("testid");
                String delete = res.getString("delete");
                String testcharacteristic = res.getString("TestCharacteristic");
                String testspecification = res.getString("TestSpecification");
                String testresult = res.getString("TestResult");
                TestCharModel testCharModel = new TestCharModel(testid,testcharacteristic,testspecification,testresult);

                if(testid == null){
                    testCharDao.insert(testCharModel);
                    idarray5.add(testCharModel.getTestid().toString());
                }
                else{
                    if(testCharDao.select2(testid)==null||idarray5==null||idarray5==new JSONArray()) {
                        failedid5.add(testid);
                    }
                    else {
                        Integer check =0;
                        Integer r5= idarray5.size();
                        Integer i5=0;
                        while(i5<r5) {
                            if(testid==idarray5.getInteger(i5)) {
                                check =1;
                                break;
                            }
                            i5++;
                        }
                        if(check == 0) {
                            failedid5.add(testid);
                        }
                        else {
                            if (delete == null || !delete.equals("T")) {
                                JSONObject oldtest = JSON.parseArray(JSON.toJSONString(testCharDao.select(testid))).getJSONObject(0);
                                if(testcharacteristic ==null){
                                    testcharacteristic = oldtest.getString("testcharacteristic");
                                }
                                if(testspecification == null){
                                    testspecification = oldtest.getString("testspecification");
                                }
                                if(testresult == null){
                                    testresult = oldtest.getString("testresult");
                                }
                                testCharModel = new TestCharModel(testid,testcharacteristic,testspecification,testresult);
                                testCharDao.update(testCharModel);
                            } else {
                                testCharDao.delete(testid);
                                idarray5.remove(testid.toString());
                            }
                        }
                    }
                }
                i++;
            }
        }
        JSONArray idarray6 = oldjsonobject.getJSONArray("testid6");
        JSONArray tabledata6 = jsonObject.getJSONArray("TableData6");
        if(tabledata1!=null){
            Integer r= tabledata6.size();
            Integer i=0;
            while(i<r){
                JSONObject res = tabledata6.getJSONObject(i);
                Integer testid = res.getInteger("testid");
                String delete = res.getString("delete");
                String testcharacteristic = res.getString("TestCharacteristic");
                String testspecification = res.getString("TestSpecification");
                String testresult = res.getString("TestResult");
                TestCharModel testCharModel = new TestCharModel(testid,testcharacteristic,testspecification,testresult);

                if(testid == null){
                    testCharDao.insert(testCharModel);
                    idarray6.add(testCharModel.getTestid().toString());
                }
                else{
                    if(testCharDao.select2(testid)==null||idarray6==null||idarray6==new JSONArray()) {
                        failedid6.add(testid);
                    }
                    else {
                        Integer check =0;
                        Integer r6= idarray6.size();
                        Integer i6=0;
                        while(i6<r6) {
                            if(testid==idarray6.getInteger(i6)) {
                                check =1;
                                break;
                            }
                            i6++;
                        }
                        if(check == 0) {
                            failedid6.add(testid);
                        }
                        else {
                            if (delete == null || !delete.equals("T")) {
                                JSONObject oldtest = JSON.parseArray(JSON.toJSONString(testCharDao.select(testid))).getJSONObject(0);
                                if(testcharacteristic ==null){
                                    testcharacteristic = oldtest.getString("testcharacteristic");
                                }
                                if(testspecification == null){
                                    testspecification = oldtest.getString("testspecification");
                                }
                                if(testresult == null){
                                    testresult = oldtest.getString("testresult");
                                }
                                testCharModel = new TestCharModel(testid,testcharacteristic,testspecification,testresult);
                                testCharDao.update(testCharModel);
                            } else {
                                testCharDao.delete(testid);
                                idarray6.remove(testid.toString());
                            }
                        }
                    }
                }
                i++;
            }
        }
        TesttheContentModel testtheContentModel=new TesttheContentModel(TID,idarray1.toJSONString(),idarray2.toJSONString(),idarray3.toJSONString(),idarray4.toJSONString(),idarray5.toJSONString(),idarray6.toJSONString());
        testtheContentDao.update(testtheContentModel);
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("FailedTableDataID1",failedid1);
        jsonObject1.put("FailedTableDataID2",failedid2);
        jsonObject1.put("FailedTableDataID3",failedid3);
        jsonObject1.put("FailedTableDataID4",failedid4);
        jsonObject1.put("FailedTableDataID5",failedid5);
        jsonObject1.put("FailedTableDataID6",failedid6);
        return JSON.toJSONString(jsonObject1);
    }

    public String delete(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer PID = jsonObject.getInteger("PID");
        if(processDao.findByPID(PID) == null){
            return "the process does not exist";
        }
        Integer TID = findTID(PID);
        if(testtheContentDao.select2(TID) == null){
            return "the TestContent dest not exist";
        }

        JSONObject oldjsonobject = JSON.parseArray(JSON.toJSONString(testtheContentDao.select(TID))).getJSONObject(0);
        JSONArray idarray1 = oldjsonobject.getJSONArray("testid1");
        JSONArray idarray2 = oldjsonobject.getJSONArray("testid2");
        JSONArray idarray3 = oldjsonobject.getJSONArray("testid3");
        JSONArray idarray4 = oldjsonobject.getJSONArray("testid4");
        JSONArray idarray5 = oldjsonobject.getJSONArray("testid5");
        JSONArray idarray6 = oldjsonobject.getJSONArray("testid6");
        if(idarray1!=new JSONArray()&&idarray1!=null){
            Integer r=idarray1.size();
            Integer i = 0;
            while(i<r){
                Integer id = idarray1.getInteger(i);
                testFuncDao.delete(id);
                ++i;
            }
        }
        if(idarray2!=new JSONArray()&&idarray2!=null){
            Integer r=idarray2.size();
            Integer i = 0;
            while(i<r){
                Integer id = idarray2.getInteger(i);
                testCharDao.delete(id);
                ++i;
            }
        }
        if(idarray3!=new JSONArray()&&idarray3!=null){
            Integer r=idarray3.size();
            Integer i = 0;
            while(i<r){
                Integer id = idarray3.getInteger(i);
                testCharDao.delete(id);
                ++i;
            }
        }
        if(idarray4!=new JSONArray()&&idarray4!=null){
            Integer r=idarray4.size();
            Integer i = 0;
            while(i<r){
                Integer id = idarray4.getInteger(i);
                testCharDao.delete(id);
                ++i;
            }
        }
        if(idarray5!=new JSONArray()&&idarray5!=null){
            Integer r=idarray5.size();
            Integer i = 0;
            while(i<r){
                Integer id = idarray5.getInteger(i);
                testCharDao.delete(id);
                ++i;
            }
        }
        if(idarray6!=new JSONArray()&&idarray6!=null){
            Integer r=idarray6.size();
            Integer i = 0;
            while(i<r){
                Integer id = idarray6.getInteger(i);
                testCharDao.delete(id);
                ++i;
            }
        }
        testtheContentDao.delete(TID);
        return "TestContent delete completed";
    }


}
