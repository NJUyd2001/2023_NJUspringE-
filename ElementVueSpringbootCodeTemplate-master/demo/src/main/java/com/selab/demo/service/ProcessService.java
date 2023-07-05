package com.selab.demo.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONArray;
import com.selab.demo.dao.ProcessDao;
import com.selab.demo.model.ProcessModel;
import com.selab.demo.model.enums.curr_state;
import com.selab.demo.model.enums.open_to_curr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLSyntaxErrorException;
import java.util.Date;
import java.util.List;

@Service
public class ProcessService {
    @Autowired
    ProcessDao processDao;
    public Integer insert(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);


        int UID = jsonObject.getInteger("UID");
        String notes = jsonObject.getString("notes");
        double price = jsonObject.getDouble("price");
        int AID = jsonObject.getInteger("AID");
        String state = jsonObject.getString("state");


        ProcessModel processmodel = new ProcessModel(notes, UID, AID, state, price);
        System.out.println("收到内容："+ processmodel.toString());
        try {
            return processDao.insert(processmodel);
        }catch(Exception e){
            System.out.println(e.getCause().getMessage());
            return -1;
        }
    }
    public List<ProcessModel> findByUID(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);

        int UID= jsonObject.getInteger("UID");

        return processDao.findByUID(UID);

    }
    public ProcessModel findByPID(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);

        int PID = jsonObject.getInteger("PID");
        return processDao.findByPID(PID);
    }
    // 返回AID
    public List<Integer> selectAIDsByState(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);

        String state = jsonObject.getString("state");
        return processDao.selectAIDsByState(state);
    }
    public List<Integer> selectPIDsByState(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);

        String state = jsonObject.getString("state");
        return processDao.selectPIDsByState(state);
    }
    public List<ProcessModel> findByAID(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        int AID = jsonObject.getInteger("AID");
        return processDao.findByAID(AID);
    }
    public List<ProcessModel> findAll(){

        return processDao.findAll();
    }
    public String update(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer PID = jsonObject.getInteger("PID");

        String notes = jsonObject.getString("notes");
        double price = jsonObject.getDouble("price");
        String state = jsonObject.getString("state");
        Integer checker = processDao.findByPID2(PID);

        if(checker == null){
            return ("不存在PID = "+ PID + "的进程");
        }
        else{

            // TODO: 实现update
            processDao.update();

            return ("process update complete");
        }
    }


    public String delete(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);

        int PID = jsonObject.getInteger("PID");
        Integer checker = processDao.findByPID2(PID);

        if(checker == null){
            return ("the process does not exist");
        }
        else{
            processDao.delete(PID);
            return ("process delete successfully");
        }
    }

}
