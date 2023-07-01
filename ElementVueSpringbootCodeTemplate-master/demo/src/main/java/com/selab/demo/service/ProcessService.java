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
import java.util.Date;

@Service
public class ProcessService {
    @Autowired
    ProcessDao processDao;
    public String insert(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);

        Integer client_id = jsonObject.getInteger("client_id");
        curr_state curr_state = jsonObject.getObject("curr_state", curr_state.class);
        String notes = jsonObject.getString("notes");
        Double price = jsonObject.getDouble("price");
        open_to_curr open_to_curr = jsonObject.getObject("open_to_curr", com.selab.demo.model.enums.open_to_curr.class);
        String file_path1 = jsonObject.getString("file_path1");
        String file_path2 = jsonObject.getString("file_path2");
        String file_path3 = jsonObject.getString("file_path3");
        String record_path = jsonObject.getString("record_path");
        ProcessModel processmodel = new ProcessModel(0,client_id,curr_state,notes,price,open_to_curr,file_path1,file_path2,file_path3,record_path);
        processDao.insert(processmodel);
        return ("process inserted successfully");


    }
    public String findbyclient_id(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer client_id= jsonObject.getInteger("client_id");
        JSONArray res = new JSONArray();
        res.add(JSON.toJSONString(processDao.findbyclient_id(client_id)));
        return JSON.toJSONString(processDao.findbyclient_id(client_id));
    }
    public String findbyPID(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer PID = jsonObject.getInteger("PID");
        JSONArray res = new JSONArray();
        res.add(JSON.toJSONString(processDao.findbyPID(PID)));
        return JSON.toJSONString(processDao.findbyPID(PID));
    }
    public String update(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer PID = jsonObject.getInteger("PID");
        Integer client_id = jsonObject.getInteger("client_id");
        curr_state curr_state = jsonObject.getObject("curr_state", curr_state.class);
        String notes = jsonObject.getString("notes");
        Double price = jsonObject.getDouble("price");
        open_to_curr open_to_curr = jsonObject.getObject("open_to_curr", com.selab.demo.model.enums.open_to_curr.class);
        String file_path1 = jsonObject.getString("file_path1");
        String file_path2 = jsonObject.getString("file_path2");
        String file_path3 = jsonObject.getString("file_path3");
        String record_path = jsonObject.getString("record_path");
        String checker = processDao.findbyPID2(PID);
        if(checker == null){
            return ("the process does not exist");
        }
        else{
            JSONObject oldjsonObject =  JSONObject.parseObject(JSON.toJSONString(processDao.findbyPID(PID).get(0)) ) ;
            if(client_id == null)
                client_id = jsonObject.getInteger("client_id");
            if(curr_state == null)
                curr_state = jsonObject.getObject("curr_state", curr_state.class);
            if(notes == null)
                notes = jsonObject.getString("notes");
            if(price == null)
                price = jsonObject.getDouble("price");
            if(open_to_curr == null)
                open_to_curr = jsonObject.getObject("open_to_curr", com.selab.demo.model.enums.open_to_curr.class);
            if(file_path1 == null)
                file_path1 = jsonObject.getString("file_path1");
            if(file_path2 == null)
                file_path2 = jsonObject.getString("file_path2");
            if(file_path3 == null)
                file_path3 = jsonObject.getString("file_path3");
            if(record_path == null)
                record_path = jsonObject.getString("record_path");

            ProcessModel processModel = new ProcessModel(PID,client_id,curr_state,notes,price,open_to_curr,file_path1,file_path2,file_path3,record_path);
            processDao.update(processModel);
            return ("process update complete");
        }
    }


    public String delete(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer PID = jsonObject.getInteger("PID");
        String checker = processDao.findbyPID2(PID);
        if(checker == null){
            return ("the process does not exist");
        }
        else{
            processDao.delete(PID);
            return ("process delete successfully");
        }
    }

}
