package com.selab.demo.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONArray;
import com.selab.demo.dao.ProcessDao;
import com.selab.demo.dao.QuoteDao;
import com.selab.demo.model.ProcessModel;
import com.selab.demo.model.QuoteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuoteService {
    @Autowired
    QuoteDao quoteDao;

    @Autowired
    ProcessDao processDao;


    public Integer findQID(Integer PID){
        ProcessModel processModel = processDao.findByPID(PID);
        if(processModel == null){
            return null;
        }
        return processModel.getQID();
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
            result.put("QID", jsonObject.getInteger("qID"));
            result.put("Time", jsonObject.getJSONArray("time"));
            result.put("SoftwareName",jsonObject.getString("softwarename"));
            result.put("item", jsonObject.getString("item"));
            result.put("description", jsonObject.getString("description"));
            result.put("UnitPrice", jsonObject.getString("unitprice"));
            result.put("PS", jsonObject.getString("ps"));
            result.put("SubTotalPrice", jsonObject.getString("subtotalprice"));
            result.put("Tax", jsonObject.getString("tax"));
            result.put("TotalPrice", jsonObject.getString("totalprice"));
            result.put("Provider", jsonObject.getString("provider"));
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
        String time = jsonObject.getString("Time");
        String softwarename = jsonObject.getString("SoftwareName");
        String item = jsonObject.getString("item");
        String description = jsonObject.getString("description");
        String unitprice = jsonObject.getString("UnitPrice");
        String ps = jsonObject.getString("PS");
        String subtotalprice = jsonObject.getString("SubTotalPrice");
        String tax = jsonObject.getString("Tax");
        String totalprice = jsonObject.getString("TotalPrice");
        String provider = jsonObject.getString("Provider");

        QuoteModel quoteModel = new QuoteModel(0,time,softwarename,item,description,unitprice,ps,subtotalprice,tax,totalprice,provider);

        quoteDao.insert(quoteModel);
        JSONObject res = new JSONObject();
        res.put("QID",quoteModel.getQID());
        Integer QID = quoteModel.getQID();
        processDao.setQID(PID,QID);
        res.put("PID",PID);
        return JSON.toJSONString(res);
    }

    public String findbyPID(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        //System.out.print(JSON.toJSONString( quoteDao.findbyQID(10)));
        return JSONrepack(JSON.toJSONString(quoteDao.findbyQID(findQID(jsonObject.getInteger("PID")))));
    }

    public String update(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer PID = jsonObject.getInteger("PID");
        if(processDao.findByPID(PID) == null){
            return "the process does not exist";
        }
        Integer QID = findQID(PID);
        if(quoteDao.select2(QID) == null){
            return ("the quote does not exist");
        }
        String time = jsonObject.getString("Time");
        String softwarename = jsonObject.getString("SoftwareName");
        String item = jsonObject.getString("item");
        String description = jsonObject.getString("description");
        String unitprice = jsonObject.getString("UnitPrice");
        String ps = jsonObject.getString("PS");
        String subtotalprice = jsonObject.getString("SubTotalPrice");
        String tax = jsonObject.getString("Tax");
        String totalprice = jsonObject.getString("TotalPrice");
        String provider = jsonObject.getString("Provider");


        JSONObject oldjsonObject =  JSONObject.parseObject(JSON.toJSONString(quoteDao.findbyQID(QID).get(0)));
        if(time == null)
        {
            time = oldjsonObject.getString("time");
        }
        if(softwarename == null){
            softwarename = oldjsonObject.getString("softwarename");
        }
        if(item == null){
            item = oldjsonObject.getString("item");
        }
        if(description == null){
            description = oldjsonObject.getString("description");
        }
        if(unitprice == null){
            unitprice = oldjsonObject.getString("unitprice");
        }
        if (ps == null){
            ps = oldjsonObject.getString("ps");
        }
        if(subtotalprice == null){
            subtotalprice = oldjsonObject.getString("subtotalprice");
        }
        if(tax == null){
            tax = oldjsonObject.getString("tax");
        }
        if(totalprice == null){
            totalprice = oldjsonObject.getString("totalprice");
        }
        if(provider == null){
            provider = oldjsonObject.getString("provider");
        }

        QuoteModel quoteModel = new QuoteModel(0,time,softwarename,item,description,unitprice,ps,subtotalprice,tax,totalprice,provider);
        return("quote update complete");

    }
    public String delete(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer PID = jsonObject.getInteger("PID");
        Integer QID = findQID(PID);
        if(quoteDao.select2(QID) == null){
            return ("the quote does not exist");
        }
        quoteDao.delete(QID);
        return ("quote delete complete");
    }

    public String findbyQID(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        //System.out.print(JSON.toJSONString( quoteDao.findbyQID(10)));
        return JSONrepack(JSON.toJSONString(quoteDao.findbyQID(jsonObject.getInteger("QID"))));
    }

    public String update_(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer QID = jsonObject.getInteger("QID");
        if(quoteDao.select2(QID) == null){
            return ("the quote does not exist");
        }
        String time = jsonObject.getString("Time");
        String softwarename = jsonObject.getString("SoftwareName");
        String item = jsonObject.getString("item");
        String description = jsonObject.getString("description");
        String unitprice = jsonObject.getString("UnitPrice");
        String ps = jsonObject.getString("PS");
        String subtotalprice = jsonObject.getString("SubTotalPrice");
        String tax = jsonObject.getString("Tax");
        String totalprice = jsonObject.getString("TotalPrice");
        String provider = jsonObject.getString("Provider");


        JSONObject oldjsonObject =  JSONObject.parseObject(JSON.toJSONString(quoteDao.findbyQID(QID).get(0)));
        if(time == null)
        {
            time = oldjsonObject.getString("time");
        }
        if(softwarename == null){
            softwarename = oldjsonObject.getString("softwarename");
        }
        if(item == null){
            item = oldjsonObject.getString("item");
        }
        if(description == null){
            description = oldjsonObject.getString("description");
        }
        if(unitprice == null){
            unitprice = oldjsonObject.getString("unitprice");
        }
        if (ps == null){
            ps = oldjsonObject.getString("ps");
        }
        if(subtotalprice == null){
            subtotalprice = oldjsonObject.getString("subtotalprice");
        }
        if(tax == null){
            tax = oldjsonObject.getString("tax");
        }
        if(totalprice == null){
            totalprice = oldjsonObject.getString("totalprice");
        }
        if(provider == null){
            provider = oldjsonObject.getString("provider");
        }

        QuoteModel quoteModel = new QuoteModel(0,time,softwarename,item,description,unitprice,ps,subtotalprice,tax,totalprice,provider);
        return("quote update complete");

    }
    public String delete_(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer QID = jsonObject.getInteger("QID");
        if(quoteDao.select2(QID) == null){
            return ("the quote does not exist");
        }
        quoteDao.delete(QID);
        return ("quote delete complete");
    }

}
