package com.selab.demo.service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONArray;
import com.selab.demo.dao.AgreementDao;
import com.selab.demo.dao.ProcessDao;
import com.selab.demo.model.AgreementModel;
import com.selab.demo.model.ProcessModel;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgreementService {
    @Autowired
    AgreementDao agreementDao;
    @Autowired
    ProcessDao processDao;

    public Integer findAgID(Integer PID){
        ProcessModel processModel = processDao.findByPID(PID);
        return processModel.getAgID();
    }
    public String JSONrepack(String postJson,Integer PID){
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
            result.put("AgID", jsonObject.getInteger("agID"));
            result.put("PID",PID);
            result.put("Client", jsonObject.getString("client"));
            result.put("Trustee",jsonObject.getString("trustee"));
            result.put("LegalRepresentative1", jsonObject.getString("legalrepresentative1"));
            result.put("LegalRepresentative2", jsonObject.getString("legalrepresentative2"));
            result.put("Name", jsonObject.getString("name"));
            result.put("Date1", jsonObject.getString("date1"));
            result.put("Date2", jsonObject.getString("date2"));

            result2.add(result);
            ++i;
        }
        return JSON.toJSONString(result2);
    }

    public String insert(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer PID = jsonObject.getInteger("PID");
        if(PID == null ||processDao.findByPID(PID) == null){
            return "the process does not exist";
        }
        String client = jsonObject.getString("Client");
        String trustee = jsonObject.getString("Trustee");
        String legalrepresentative1 = jsonObject.getString("LegalRepresentative1");
        String legalrepresentative2 = jsonObject.getString("LegalRepresentative2");
        String name = jsonObject.getString("Name");
        String date1 = jsonObject.getString("Date1");
        String date2 = jsonObject.getString("Date2");
        AgreementModel agreementModel = new AgreementModel(0,client,trustee,legalrepresentative1,legalrepresentative2,name,date1,date2);
        agreementDao.insert(agreementModel);
        Integer AgID = agreementModel.getAgID();
        processDao.setAgID(PID,AgID);
        JSONObject res = new JSONObject();
        res.put("AgID",AgID);
        res.put("PID",PID);
        return JSON.toJSONString(res);
    }

    public String select(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer AgID = findAgID(jsonObject.getInteger("PID"));
        return JSONrepack(JSON.toJSONString(agreementDao.select(AgID)),jsonObject.getInteger("PID"));

    }

    public String update(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer PID = jsonObject.getInteger("PID");
        if(PID == null||processDao.findByPID(PID) == null){
            return "the process does not exist";
        }
        String client = jsonObject.getString("Client");
        String trustee = jsonObject.getString("Trustee");
        String legalrepresentative1 = jsonObject.getString("LegalRepresentative1");
        String legalrepresentative2 = jsonObject.getString("LegalRepresentative2");
        String name = jsonObject.getString("Name");
        String date1 = jsonObject.getString("Date1");
        String date2 = jsonObject.getString("Date2");
        JSONObject oldjsonObject =  JSONObject.parseObject(JSON.toJSONString(agreementDao.select(findAgID(PID)).get(0)));
        if(client == null){
            client = oldjsonObject.getString("client");
        }
        if(trustee == null){
            trustee = oldjsonObject.getString("trustee");
        }
        if (legalrepresentative1 == null){
            legalrepresentative1 = oldjsonObject.getString("legalrepresentative1");
        }
        if(legalrepresentative2 == null){
            legalrepresentative2 = oldjsonObject.getString("legalrepresentative2");
        }
        if(name == null){
            name = oldjsonObject.getString("name");
        }
        if(date1 == null){
            date1 = oldjsonObject.getString("date1");
        }
        if(date2 == null){
            date2 = oldjsonObject.getString("date2");
        }
        AgreementModel agreementModel = new AgreementModel(findAgID(PID),client,trustee,legalrepresentative1,legalrepresentative2,name,date1,date2);
        agreementDao.update(agreementModel);
        return ("agreement update complete");



    }
    public String delete(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer AgID = findAgID(jsonObject.getInteger("PID"));
        if(agreementDao.select2(AgID)  == null){
            return ("the agreement does not exist");
        }
        agreementDao.delete(AgID);
        return("agreement delete complete");
    }

    public String select_(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer AgID = jsonObject.getInteger("AgID");
        return JSONrepack(JSON.toJSONString(agreementDao.select(AgID)),0);

    }

    public String update_(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer AgID = jsonObject.getInteger("AgID");
        String client = jsonObject.getString("Client");
        String trustee = jsonObject.getString("Trustee");
        String legalrepresentative1 = jsonObject.getString("LegalRepresentative1");
        String legalrepresentative2 = jsonObject.getString("LegalRepresentative2");
        String name = jsonObject.getString("Name");
        String date1 = jsonObject.getString("Date1");
        String date2 = jsonObject.getString("Date2");
        JSONObject oldjsonObject =  JSONObject.parseObject(JSON.toJSONString(agreementDao.select(AgID).get(0)));
        if(client == null){
            client = oldjsonObject.getString("client");
        }
        if(trustee == null){
            trustee = oldjsonObject.getString("trustee");
        }
        if (legalrepresentative1 == null){
            legalrepresentative1 = oldjsonObject.getString("legalrepresentative1");
        }
        if(legalrepresentative2 == null){
            legalrepresentative2 = oldjsonObject.getString("legalrepresentative2");
        }
        if(name == null){
            name = oldjsonObject.getString("name");
        }
        if(date1 == null){
            date1 = oldjsonObject.getString("date1");
        }
        if(date2 == null){
            date2 = oldjsonObject.getString("date2");
        }
        AgreementModel agreementModel = new AgreementModel(AgID,client,trustee,legalrepresentative1,legalrepresentative2,name,date1,date2);
        agreementDao.update(agreementModel);
        return ("agreement update complete");



    }
    public String delete_(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer AgID = jsonObject.getInteger("AgID");
        if(agreementDao.select2(AgID)  == null){
            return ("the agreement does not exist");
        }
        agreementDao.delete(AgID);
        return("agreement delete complete");
    }

}
