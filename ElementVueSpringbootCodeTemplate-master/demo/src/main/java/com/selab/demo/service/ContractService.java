package com.selab.demo.service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONArray;
import com.selab.demo.dao.ContractDao;
import com.selab.demo.dao.ProcessDao;
import com.selab.demo.model.ContractModel;
import com.selab.demo.model.ProcessModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractService {
    @Autowired
    ContractDao contractDao;

    @Autowired
    ProcessDao processDao;

    public Integer findCID(Integer PID){
        ProcessModel processModel = processDao.findByPID(PID);
        return processModel.getCID();
    }

    public String JSONrepack(String postJson){
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
            result.put("CID", jsonObject.getInteger("cID"));
            result.put("ItemName", jsonObject.getString("itemname"));
            result.put("Client", jsonObject.getString("client"));
            result.put("Trustee", jsonObject.getString("trustee"));
            result.put("QC", jsonObject.getString("qc"));
            result.put("date", jsonObject.getString("date"));
            result.put("PeriodOfValidity", jsonObject.getString("periodofvalidity"));
            result.put("ddl", jsonObject.getString("ddl"));
            result.put("ChangeNumber", jsonObject.getString("changenumber"));
            result.put("ChangeDay", jsonObject.getString("changeday"));
            result2.add(result);
            ++i;
        }
        return JSON.toJSONString(result2);
    }
    public String insert(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer PID = jsonObject.getInteger("PID");
        if(processDao.findByPID(PID) == null){
            return "the process does not exist";
        }
        String itemname =  jsonObject.getString("ItemName");
        String client = jsonObject.getString("Client");
        String trustee = jsonObject.getString("Trustee");
        String qc = jsonObject.getString("QC");
        String date = jsonObject.getString("date");
        String periodofvalidity = jsonObject.getString("PeriodOfValidity");
        String ddl = jsonObject.getString("ddl");
        String changenumber = jsonObject.getString("ChangeNumber");
        String changeday = jsonObject.getString("ChangeDay");
        ContractModel contractModel = new ContractModel(0,itemname,client,trustee,qc,date,periodofvalidity,ddl,changenumber,changeday);
        contractDao.insert(contractModel);
        Integer CID = contractModel.getCID();
        processDao.setCID(PID,CID);
        JSONObject res = new JSONObject();
        res.put("CID",CID);
        res.put("PID",PID);
        return JSON.toJSONString(res);
    }

    public String select_(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer CID = jsonObject.getInteger("CID");
        return JSONrepack(JSON.toJSONString(contractDao.select(CID)));

    }

    public String update_(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer CID = jsonObject.getInteger("CID") ;
        String itemname =  jsonObject.getString("ItemName");
        String client = jsonObject.getString("Client");
        String trustee = jsonObject.getString("Trustee");
        String qc = jsonObject.getString("QC");
        String date = jsonObject.getString("date");
        String periodofvalidity = jsonObject.getString("PeriodOfValidity");
        String ddl = jsonObject.getString("ddl");
        String changenumber = jsonObject.getString("ChangeNumber");
        String changeday = jsonObject.getString("ChangeDay");
        if(contractDao.select2(CID)  == null){
            return ("the contract does not exist");
        }
        JSONObject oldjsonObject =  JSONObject.parseObject(JSON.toJSONString(contractDao.select(CID).get(0)));
        if(itemname == null){
            itemname = oldjsonObject.getString("itemname");
        }
        if(client == null){
            client = oldjsonObject.getString("client");
        }
        if(trustee == null){
            trustee = oldjsonObject.getString("trustee");
        }
        if(qc == null){
            qc = oldjsonObject.getString("qc");
        }
        if(date == null){
            date = oldjsonObject.getString("date");
        }
        if(periodofvalidity == null){
            periodofvalidity = oldjsonObject.getString("periodofvalidity");
        }
        if(ddl == null){
            //自由！
            ddl = oldjsonObject.getString("ddl");
        }
        if(changenumber == null){
            changenumber = oldjsonObject.getString("changenumber");
        }
        if(changeday == null){
            changeday = oldjsonObject.getString("changeday");
        }

        ContractModel contractModel = new ContractModel(CID,itemname,client,trustee,qc,date,periodofvalidity,ddl,changenumber,changeday);
        contractDao.update(contractModel);
        return ("contract update complete");
    }

    public String delete_(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer CID = jsonObject.getInteger("CID");
        if(contractDao.select2(CID)  == null){
            return ("the contract does not exist");
        }
        contractDao.delete(CID);
        return("contract delete complete");
    }

    public String select(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer CID = findCID(jsonObject.getInteger("PID"));
        return JSONrepack(JSON.toJSONString(contractDao.select(CID)));

    }

    public String update(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer CID = findCID(jsonObject.getInteger("PID")) ;
        String itemname =  jsonObject.getString("ItemName");
        String client = jsonObject.getString("Client");
        String trustee = jsonObject.getString("Trustee");
        String qc = jsonObject.getString("QC");
        String date = jsonObject.getString("date");
        String periodofvalidity = jsonObject.getString("PeriodOfValidity");
        String ddl = jsonObject.getString("ddl");
        String changenumber = jsonObject.getString("ChangeNumber");
        String changeday = jsonObject.getString("ChangeDay");
        if(contractDao.select2(CID)  == null){
            return ("the contract does not exist");
        }
        JSONObject oldjsonObject =  JSONObject.parseObject(JSON.toJSONString(contractDao.select(CID).get(0)));
        if(itemname == null){
            itemname = oldjsonObject.getString("itemname");
        }
        if(client == null){
            client = oldjsonObject.getString("client");
        }
        if(trustee == null){
            trustee = oldjsonObject.getString("trustee");
        }
        if(qc == null){
            qc = oldjsonObject.getString("qc");
        }
        if(date == null){
            date = oldjsonObject.getString("date");
        }
        if(periodofvalidity == null){
            periodofvalidity = oldjsonObject.getString("periodofvalidity");
        }
        if(ddl == null){
            //自由！
            ddl = oldjsonObject.getString("ddl");
        }
        if(changenumber == null){
            changenumber = oldjsonObject.getString("changenumber");
        }
        if(changeday == null){
            changeday = oldjsonObject.getString("changeday");
        }

        ContractModel contractModel = new ContractModel(CID,itemname,client,trustee,qc,date,periodofvalidity,ddl,changenumber,changeday);
        contractDao.update(contractModel);
        return ("contract update complete");
    }

    public String delete(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer CID = findCID(jsonObject.getInteger("PID"));
        if(contractDao.select2(CID)  == null){
            return ("the contract does not exist");
        }
        contractDao.delete(CID);
        return("contract delete complete");
    }
}
