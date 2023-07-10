package com.selab.demo.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONArray;
import com.selab.demo.dao.ProcessDao;
import com.selab.demo.model.ProcessModel;
import com.selab.demo.model.enums.curr_state;
import com.selab.demo.model.enums.open_to_curr;
import com.selab.demo.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLSyntaxErrorException;
import java.util.Date;
import java.util.List;

@Service
public class ProcessService {
    @Autowired
    ProcessDao processDao;
    @Autowired
    FileUtil fileUtil;
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
            processDao.insert(processmodel);
            return processmodel.getPID();
        }catch(Exception e){
            System.out.println(e.getCause().getMessage());
            return -1;
        }
    }
    public List<ProcessModel> findByUID(String postJson){
        System.out.println(postJson);
        JSONObject jsonObject = JSONObject.parseObject(postJson);

        int UID= jsonObject.getInteger("UID");

        return processDao.findByUID(UID);

    }
    public ProcessModel findByPID(String postJson){
        System.out.println(postJson);
        JSONObject jsonObject = JSONObject.parseObject(postJson);

        int PID = jsonObject.getInteger("PID");
        return processDao.findByPID(PID);
    }
    // 返回AID
    public List<Integer> selectAIDsByState(String postJson){
        System.out.println(postJson);
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
    public String updateState(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer PID = jsonObject.getInteger("PID");
        String state = jsonObject.getString("state");
        try {
            processDao.updateState(PID, state);
        }catch (Exception e){
            return e.getMessage();
        }
        return "状态更新成功";
    }

    public String update(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer PID = jsonObject.getInteger("PID");

        String notes = jsonObject.getString("notes");
        // double price = jsonObject.getDouble("price");
        String state = jsonObject.getString("state");
        ProcessModel checker = processDao.findByPID(PID);

        if(checker == null){
            return ("不存在PID = "+ PID + "的进程");
        }
        else{
            if(notes != null) checker.setNotes(notes);
            try{
                double price = jsonObject.getDouble("price");
                checker.setPrice(price);
            } catch (NullPointerException e){
                return "价格不能为空！";
            }

            if(state != null) checker.setState(state);
            // TODO: 实现update
            System.out.println(checker.toString());
            processDao.update(checker);

            return ("进程信息已更新");
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
            fileUtil.killProcess(PID);
            return ("进程已成功删除");

        }
    }

}
