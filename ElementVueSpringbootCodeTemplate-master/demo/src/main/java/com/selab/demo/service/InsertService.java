package com.selab.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.selab.demo.dao.InsertDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
// test insert
@Service
public class InsertService{

    @Autowired
    InsertDao insertDao;
    public String insertID(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer id = jsonObject.getInteger("id");
        try{
            insertDao.insertID(id);
        } catch (Exception e){
            if (e instanceof DuplicateKeyException){

                return e.getMessage();
            }
        }
        return "success!";
    }
    public String insert(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        String dataString = jsonObject.getString("data");
<<<<<<< HEAD

=======
>>>>>>> 0f2217a67bed563e117423e2ddf5f05982f3b547
        try {
            insertDao.insertTest(dataString);
        } catch (Exception e){
            if (e instanceof DuplicateKeyException){
                return e.getMessage();
            }
        }

<<<<<<< HEAD
        System.out.print(postJson);
        insertDao.insertTest(dataString);

=======
>>>>>>> 0f2217a67bed563e117423e2ddf5f05982f3b547
        return "success";
    }
}
