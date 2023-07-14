package com.selab.demo.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.TypeUtils;
import com.selab.demo.dao.ProcessDao;
import com.selab.demo.dao.TestReviewDao;
import com.selab.demo.model.TestReviewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestReviewService {
    @Autowired
    ProcessDao processDao;
    @Autowired
    TestReviewDao testReviewDao;


    public Integer insert(String postJson) {
        System.out.println(postJson);
        TestReviewModel testReviewModel = new TestReviewModel();
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        JSONArray tableData = jsonObject.getJSONArray("tableData");
        System.out.println(tableData);
        for(Integer i = 0; i < tableData.size(); i++){
            JSONObject j =  tableData.getJSONObject(i);
            String Duty = j.getString("Duty");
            String Sign = j.getString("Sign");
            String EvaluationOpinion = j.getString("EvaluationOpinion");
            String Date = j.getString("Date");
            TestReviewModel.SignClass signClass = new TestReviewModel.SignClass(Duty, Sign, EvaluationOpinion, Date);
            switch (Duty) {
                case "测试工程师" -> {
                    testReviewModel.tableData[0] = signClass;
                    testReviewModel.setTE_Opinion(testReviewModel.classToOpinion(signClass));
                }
                case "测试室负责人" -> {
                    testReviewModel.tableData[1] = signClass;
                    testReviewModel.setTRM_Opinion(testReviewModel.classToOpinion(signClass));
                }
                case "质量负责人" -> {
                    testReviewModel.tableData[2] = signClass;
                    testReviewModel.setQM_Opinion(testReviewModel.classToOpinion(signClass));
                }
                case "技术负责人" -> {
                    testReviewModel.tableData[3] = signClass;
                    testReviewModel.setTD_Opinion(testReviewModel.classToOpinion(signClass));
                }
                case "监督人" -> {
                    testReviewModel.tableData[4] = signClass;
                    testReviewModel.setSI_Opinion(testReviewModel.classToOpinion(signClass));
                }
                default -> {
                    return -1;
                }
            }
        }
        testReviewModel.setSoftwareName(jsonObject.getString("SoftWareName"));
        testReviewModel.setPID(jsonObject.getInteger("PID"));
        testReviewModel.setVersionNumber(jsonObject.getString("VersionNumber"));
        testReviewModel.setProjectNum(jsonObject.getString("ProjectNum"));
        testReviewModel.setTestCategory(jsonObject.getString("TestCategory"));
        testReviewModel.setWritingNormality(jsonObject.getString("WritingNormality"));
        testReviewModel.setTestEnvironment(jsonObject.getString("TestEnvironment"));
        testReviewModel.setCompleteness(jsonObject.getString("Completeness"));
        testReviewModel.setTestcaseCover(jsonObject.getString("TestcaseCover"));
        testReviewModel.setSelectMethod(jsonObject.getString("SelectMethod"));
        testReviewModel.setInputOutputData(jsonObject.getString("InputOutputData"));
        testReviewModel.setTiming(jsonObject.getString("Timing"));
        testReviewModel.setHumanResourcesArrangement(jsonObject.getString("HumanResourcesArrangement"));
        try{
            if (processDao.findByPID(testReviewModel.getPID()) == null) return -2; // 不存在PID
            testReviewDao.insert(testReviewModel);
            processDao.setTRID(testReviewModel.getPID(), testReviewModel.getTRID());
        }catch (Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
        return testReviewModel.getTRID();
    }
    public TestReviewModel selectByTRID(String postJson){

        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer TRID = jsonObject.getInteger("TRID");
        TestReviewModel testReviewModel = testReviewDao.selectByTRID(TRID);
        if(testReviewModel == null) {
            System.out.println("不存在TRID = " + TRID.toString() + " 的测试方案评审表");
            return testReviewModel;
        }
        testReviewModel.tableData[0] = testReviewModel.opinionToClass(testReviewModel.getTE_Opinion());
        testReviewModel.tableData[1] = testReviewModel.opinionToClass(testReviewModel.getTRM_Opinion());
        testReviewModel.tableData[2] = testReviewModel.opinionToClass(testReviewModel.getQM_Opinion());
        testReviewModel.tableData[3] = testReviewModel.opinionToClass(testReviewModel.getTD_Opinion());
        testReviewModel.tableData[4] = testReviewModel.opinionToClass(testReviewModel.getSI_Opinion());
        // System.out.println(testReviewModel);
        return  testReviewModel;
    }
    public TestReviewModel selectByPID(String postJson){

        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer PID = jsonObject.getInteger("PID");
        TestReviewModel testReviewModel = testReviewDao.selectByPID(PID);
        if(testReviewModel == null) {
            System.out.println("不存在PID = " + PID.toString() + " 的测试方案评审表");
            return testReviewModel;
        }
        testReviewModel.tableData[0] = testReviewModel.opinionToClass(testReviewModel.getTE_Opinion());
        testReviewModel.tableData[1] = testReviewModel.opinionToClass(testReviewModel.getTRM_Opinion());
        testReviewModel.tableData[2] = testReviewModel.opinionToClass(testReviewModel.getQM_Opinion());
        testReviewModel.tableData[3] = testReviewModel.opinionToClass(testReviewModel.getTD_Opinion());
        testReviewModel.tableData[4] = testReviewModel.opinionToClass(testReviewModel.getSI_Opinion());
        return  testReviewModel;
    }

    public String update(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer TRID = jsonObject.getInteger("TRID");
        TestReviewModel testReviewModel = testReviewDao.selectByTRID(TRID);

        String SoftwareName = jsonObject.getString("SoftWareName");
        String VersionNumber = jsonObject.getString("VersionNumber");
        String ProjectNum = jsonObject.getString("ProjectNum");
        String TestCategory = jsonObject.getString("TestCategory");
        String WritingNormality = jsonObject.getString("WritingNormality");
        String TestEnvironment = jsonObject.getString("TestEnvironment");
        String Completeness = jsonObject.getString("Completeness");
        String TestcaseCover = jsonObject.getString("TestcaseCover");
        String SelectMethod = jsonObject.getString("SelectMethod");
        String InputOutputData = jsonObject.getString("InputOutputData");
        String Timing = jsonObject.getString("Timing");
        String HumanResourcesArrangement = jsonObject.getString("HumanResourcesArrangement");

        if (SoftwareName != null) testReviewModel.setSoftwareName(SoftwareName);
        if (VersionNumber != null) testReviewModel.setVersionNumber(VersionNumber);
        if (ProjectNum != null) testReviewModel.setProjectNum(ProjectNum);
        if (TestCategory != null) testReviewModel.setTestCategory(TestCategory);
        if (WritingNormality != null) testReviewModel.setWritingNormality(WritingNormality);
        if (TestEnvironment != null) testReviewModel.setTestEnvironment(TestEnvironment);
        if (Completeness != null) testReviewModel.setCompleteness(Completeness);
        if (TestcaseCover != null) testReviewModel.setTestcaseCover(TestcaseCover);
        if (SelectMethod != null) testReviewModel.setSelectMethod(SelectMethod);
        if (InputOutputData != null) testReviewModel.setInputOutputData(InputOutputData);
        if (Timing != null) testReviewModel.setTiming(Timing);
        if (HumanResourcesArrangement != null) testReviewModel.setHumanResourcesArrangement(HumanResourcesArrangement);

        JSONArray tableData = jsonObject.getJSONArray("tableData");
        for(Integer i = 0; i < tableData.size(); i++) {

            JSONObject j = tableData.getJSONObject(i);
            String Duty = j.getString("Duty");
            String Sign = j.getString("Sign");
            String EvaluationOpinion = j.getString("EvaluationOpinion");
            String Date = j.getString("Date");
            TestReviewModel.SignClass signClass = new TestReviewModel.SignClass(Duty, Sign, EvaluationOpinion, Date);
            //TODO: 可选参数的实现
            switch (Duty) {
                case "测试工程师" -> {

                    testReviewModel.tableData[0] = signClass;
                    testReviewModel.setTE_Opinion(testReviewModel.classToOpinion(signClass));
                }
                case "测试室负责人" -> {
                    testReviewModel.tableData[1] = signClass;
                    testReviewModel.setTRM_Opinion(testReviewModel.classToOpinion(signClass));
                }
                case "质量负责人" -> {
                    testReviewModel.tableData[2] = signClass;
                    testReviewModel.setQM_Opinion(testReviewModel.classToOpinion(signClass));
                }
                case "技术负责人" -> {
                    testReviewModel.tableData[3] = signClass;
                    testReviewModel.setTD_Opinion(testReviewModel.classToOpinion(signClass));
                }
                case "监督人" -> {
                    testReviewModel.tableData[4] = signClass;
                    testReviewModel.setSI_Opinion(testReviewModel.classToOpinion(signClass));
                }
                default -> {
                    return "Duty 不存在";
                }
            }

        }
        testReviewDao.update(testReviewModel);
        return "修改成功";
    }

    public String delete(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer TRID = jsonObject.getInteger("TRID");
        try{
            testReviewDao.delete(TRID);
        }catch (Exception e){
            return e.getMessage();
        }
        return "删除成功";
    }
}
