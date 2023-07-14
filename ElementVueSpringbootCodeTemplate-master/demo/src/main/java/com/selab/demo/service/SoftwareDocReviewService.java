package com.selab.demo.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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
    public Integer insert(String postJson) {
        System.out.println(postJson);
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        JSONArray table = jsonObject.getJSONArray("tableData");

        SoftwareDocReviewModel softwareDocReviewModel = new SoftwareDocReviewModel();
        softwareDocReviewModel.setSoftWareName(jsonObject.getString("SoftWareName"));
        softwareDocReviewModel.setVersionNumber(jsonObject.getString("VersionNumber"));
        softwareDocReviewModel.setClient(jsonObject.getString("Client"));
        softwareDocReviewModel.setReviewCompleteDate(jsonObject.getString("ReviewCompleteDate"));
        softwareDocReviewModel.setReviewer(jsonObject.getString("Reviewer"));
        softwareDocReviewModel.setExaminer(jsonObject.getString("Examiner"));

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
        softwareDocReviewDao.insert(softwareDocReviewModel);
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

        return "";
    }
    public String updateItem(String postJson){
        return "";
    }

    public String delete(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer SDRID = jsonObject.getInteger("SDRID");
        softwareDocReviewDao.delete(SDRID);
        sdrItemDao.deleteAll(SDRID);
        return "删除成功";
    }
}
