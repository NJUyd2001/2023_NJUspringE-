package com.selab.demo.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.selab.demo.dao.ProcessDao;
import com.selab.demo.dao.SoftwareDocReviewDao;
import com.selab.demo.model.SoftwareDocReviewModel;
import com.selab.demo.dao.SdrItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class SoftwareDocReviewService {
    @Autowired
    SoftwareDocReviewDao softwareDocReviewDao;
    @Autowired
    SdrItemDao sdrItemDao;
    @Autowired
    ProcessDao processDao;
    public Integer insert(String postJson) {
        System.out.println(postJson);
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        JSONArray table = jsonObject.getJSONArray("tableData");
        Integer PID = jsonObject.getInteger("PID");
        if(processDao.findByPID2(PID) == null) {
            System.out.println("进程不存在");
            return -1;
        }
        SoftwareDocReviewModel softwareDocReviewModel = new SoftwareDocReviewModel();
        softwareDocReviewModel.setSoftWareName(jsonObject.getString("SoftWareName"));
        softwareDocReviewModel.setVersionNumber(jsonObject.getString("VersionNumber"));
        softwareDocReviewModel.setClient(jsonObject.getString("Client"));
        softwareDocReviewModel.setReviewCompleteDate(jsonObject.getString("ReviewCompleteDate"));
        softwareDocReviewModel.setReviewer(jsonObject.getString("Reviewer"));
        softwareDocReviewModel.setPID(PID);

        softwareDocReviewModel.setExaminer(jsonObject.getString("Examiner"));
        try {
            softwareDocReviewDao.insert(softwareDocReviewModel);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
        for(Integer i = 0; i < table.size(); i++) {
            JSONObject j = table.getJSONObject(i);
            Integer ReviewCategories = j.getInteger("ReviewCategories");
            String ReviewItem = j.getString("ReviewItem");
            String ReviewContent = j.getString("ReviewContent");
            String ReviewResultExplanation = j.getString("ReviewResultExplanation");
            String radio = j.getString("radio");
            SoftwareDocReviewModel.SdrItem sdrItem = new SoftwareDocReviewModel.SdrItem(softwareDocReviewModel.getSDRID(),
                    ReviewCategories, ReviewItem, ReviewContent, ReviewResultExplanation, radio);
            try {
                softwareDocReviewModel.tableData[i] = sdrItem;
                sdrItemDao.insert(sdrItem);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return -1;
            }
        }

        processDao.setSDRID(PID, softwareDocReviewModel.getSDRID());
        return softwareDocReviewModel.getSDRID();
    }

    public SoftwareDocReviewModel selectBySDRID(String postJson) {
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer SDRID = jsonObject.getInteger("SDRID");
        SoftwareDocReviewModel softwareDocReviewModel = softwareDocReviewDao.selectBySDRID(SDRID);

        softwareDocReviewModel.tableData = sdrItemDao.selectBySDRID(softwareDocReviewModel.getSDRID());
        return softwareDocReviewModel;
    }
    public SoftwareDocReviewModel selectByPID(String postJson) {
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer PID = jsonObject.getInteger("PID");
        SoftwareDocReviewModel softwareDocReviewModel = softwareDocReviewDao.selectByPID(PID);

        softwareDocReviewModel.tableData = sdrItemDao.selectBySDRID(softwareDocReviewModel.getSDRID());
        return softwareDocReviewModel;
    }
    public String updateMain(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer SDRID = jsonObject.getInteger("SDRID");
        SoftwareDocReviewModel s = softwareDocReviewDao.selectBySDRID(SDRID);
        String SoftWareName = jsonObject.getString("SoftWareName");
        String VersionNumber = jsonObject.getString("VersionNumber");
        String Client = jsonObject.getString("Client");
        String ReviewCompleteDate = jsonObject.getString("ReviewCompleteDate");
        String Reviewer = jsonObject.getString("Reviewer");
        String Examiner = jsonObject.getString("Examiner");

        if(SoftWareName != null) s.setSoftWareName(SoftWareName);
        if(VersionNumber != null) s.setVersionNumber(VersionNumber);
        if(Client != null) s.setClient(Client);
        if(ReviewCompleteDate != null) s.setReviewCompleteDate(ReviewCompleteDate);
        if(Reviewer != null) s.setReviewer(Reviewer);
        if(Examiner != null) s.setExaminer(Examiner);
        try{
            softwareDocReviewDao.update(s);
        }catch (Exception e){
            return e.getMessage();
        }
        return "更新成功";
    }
    public String updateItem(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer ID = jsonObject.getInteger("ID");
        SoftwareDocReviewModel.SdrItem sdrItem = sdrItemDao.selectByID(ID);
        if(sdrItem == null) return "ID不存在";
        Integer ReviewCategories = jsonObject.getInteger("ReviewCategories");
        String ReviewItem = jsonObject.getString("ReviewItem");
        String ReviewContent = jsonObject.getString("ReviewContent");
        String ReviewResultExplanation = jsonObject.getString("ReviewResultExplanation");
        String radio = jsonObject.getString("radio");
        if(ReviewCategories != null) sdrItem.setReviewCategories(ReviewCategories);
        if(ReviewItem != null) sdrItem.setReviewItem(ReviewItem);
        if(ReviewContent != null) sdrItem.setReviewContent(ReviewContent);
        if(ReviewResultExplanation != null) sdrItem.setReviewResultExplanation(ReviewResultExplanation);
        if(radio != null) sdrItem.setRadio(radio);
        try{
            sdrItemDao.update(sdrItem);
        }catch (Exception e){
            return e.getMessage();
        }
        return "更新成功";
    }

    public String delete(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer SDRID = jsonObject.getInteger("SDRID");
        softwareDocReviewDao.delete(SDRID);
        sdrItemDao.deleteAll(SDRID);
        return "删除成功";
    }
}
