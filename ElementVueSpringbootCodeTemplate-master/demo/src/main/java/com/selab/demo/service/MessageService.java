package com.selab.demo.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONArray;
import com.selab.demo.dao.MessageDao;
import com.selab.demo.model.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;


@Service
public class MessageService {
    @Autowired
    MessageDao messageDao;
    public String insert(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);

        Integer sender_id = jsonObject.getInteger("sender_id");
        Integer receiver_id = jsonObject.getInteger("receiver_id");
        Date regTime = jsonObject.getDate("regTime");
        String message = jsonObject.getString("message");
        String doc_ex_path = jsonObject.getString("doc_ex_path");
        MessageModel  messageModel = new MessageModel(0,sender_id,receiver_id,regTime,message,doc_ex_path);
        messageDao.insert(messageModel);
        return ("message inserted successfully");


    }

    public String findbyMID(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer MID = jsonObject.getInteger("MID");
        JSONArray res = new JSONArray();
        res.add(JSON.toJSONString(messageDao.findbyMID(MID)));
        return JSON.toJSONString(messageDao.findbyMID(MID));
    }

    public String findbysender_id(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer sender_id = jsonObject.getInteger("sender_id");
        JSONArray res = new JSONArray();
        res.add(JSON.toJSONString(messageDao.finfbysender_id(sender_id)));
        return JSON.toJSONString(messageDao.finfbysender_id(sender_id));
    }

    public String findbyreceiver_id(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer receiver_id = jsonObject.getInteger("receiver_id");
        JSONArray res = new JSONArray();
        res.add(JSON.toJSONString(messageDao.findbyreceiver_id(receiver_id)));
        return JSON.toJSONString(messageDao.findbyreceiver_id(receiver_id));
    }

    public String update(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer MID = jsonObject.getInteger("MID");
        Integer sender_id = jsonObject.getInteger("sender_id");
        Integer receiver_id = jsonObject.getInteger("receiver_id");
        Date regTime = jsonObject.getDate("regTime");
        String message = jsonObject.getString("message");
        String doc_ex_path = jsonObject.getString("doc_ex_path");
        String checker = messageDao.findbyMID2(MID);
        if(checker == null){
            return ("the messages does not exist");
        }
        else{
            JSONObject oldjsonObject =  JSONObject.parseObject(JSON.toJSONString(messageDao.findbyMID(MID).get(0)) ) ;
            if(sender_id == null)
                sender_id = oldjsonObject.getInteger("sender_id");
            if(receiver_id == null)
                receiver_id = jsonObject.getInteger("receiver_id");
            if(regTime == null)
                regTime = jsonObject.getDate("regTime");
            if(message == null)
                message = jsonObject.getString("message");
            if(doc_ex_path == null)
                doc_ex_path = jsonObject.getString("doc_ex_path");

            MessageModel  messageModel = new MessageModel(MID,sender_id,receiver_id,regTime,message,doc_ex_path);
            messageDao.update(messageModel);
            return ("message update complete");
        }
    }
    public String delete(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer MID = jsonObject.getInteger("MID");
        String checker = messageDao.findbyMID2(MID);
        if(checker == null){
            return ("the process does not exist");
        }
        else{
            messageDao.delete(MID);
            return ("message delete successfully");
        }
    }
}
