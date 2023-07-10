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

        int UID = -1;
        try {
            UID = jsonObject.getInteger("UID");
        }catch (Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
        String notes = jsonObject.getString("notes");
        String state = jsonObject.getString("state");

        System.out.println("收到内容："+ postJson);

        ProcessModel processModel = new ProcessModel();
        processModel.setState(state);
        processModel.setNotes(notes);
        processModel.setUID(UID);
        try {
            processDao.insert(processModel);
            return processModel.getPID();
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
    public String clearFiles(Integer PID){
        ProcessModel processModel = processDao.findByPID(PID);
        if (processModel == null) return "不存在PID = "+ PID + "的进程";
        try{
            processDao.clearFiles(PID);
        }catch (Exception e){
            return e.getMessage();
        }
        return "进程相关文件已删除";
    }

    public String update(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer PID = jsonObject.getInteger("PID");

        String notes = jsonObject.getString("notes");
        String state = jsonObject.getString("state");
        ProcessModel checker = processDao.findByPID(PID);

        if(checker == null){
            return ("不存在PID = "+ PID + "的进程");
        }
        else{
            if(notes != null) checker.setNotes(notes);
            if(state != null) checker.setState(state);
            System.out.println(checker);
            processDao.update(checker);

            return ("进程信息已更新");
        }
    }


    public String delete(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);

        int PID = jsonObject.getInteger("PID");
        Integer checker = processDao.findByPID2(PID);

        if(checker == null){
            return ("不存在PID = "+ PID + "的进程");
        }
        else{
            processDao.clearFiles(PID);
            processDao.delete(PID);
            fileUtil.killProcess(PID);
            return ("进程已成功删除");
        }
    }

}
