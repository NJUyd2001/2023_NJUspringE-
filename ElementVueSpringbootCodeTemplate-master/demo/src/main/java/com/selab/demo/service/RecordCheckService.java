package com.selab.demo.service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONArray;
import com.selab.demo.model.*;
import com.selab.demo.dao.ReportCheckTableDao;
import com.selab.demo.dao.ReportCheckDao;
import com.selab.demo.dao.ProcessDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service

public class RecordCheckService {
    @Autowired
    ReportCheckDao reportCheckDao;
    @Autowired
    ReportCheckTableDao reportCheckTableDao;
    @Autowired
    ProcessDao processDao;
    public Integer findCHID(Integer PID){
        ProcessModel processModel = processDao.findByPID(PID);
        if(processModel == null){
            return null;
        }
        return processModel.getCHID();
    }

    public String JSONrepack1(String postJson){
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
            result.put("tableid", jsonObject.getInteger("tableid"));
            result.put("num", jsonObject.getString("num"));
            result.put("checkcontent",jsonObject.getString("checkcontent"));
            result.put("description", jsonObject.getString("description"));
            result.put("radio", jsonObject.getString("radio"));
            result2.add(result);
            ++i;
        }
        return JSON.toJSONString(result2);
    }

    public String insert(String postJson) {
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer PID = jsonObject.getInteger("PID");
        if (processDao.findByPID(PID) == null) {
            return "the process does not exist";
        }
        String softwarename = jsonObject.getString("SoftWareName");
        String client = jsonObject.getString("Client");
        String examiner = jsonObject.getString("Examiner");
        String date = jsonObject.getString("Date");
        JSONArray table1 = jsonObject.getJSONArray("tableData");
        JSONArray tableid = new JSONArray();
        if (table1 != null) {
            Integer r = table1.size();
            Integer i = 0;
            while (i < r) {
                JSONObject jsonObject1 = table1.getJSONObject(i);
                String num = jsonObject1.getString("num");
                String checkcontent = jsonObject1.getString("checkcontent");
                String description = jsonObject1.getString("description");
                String radio = jsonObject1.getString("radio");
                ReportCheckTableModel reportCheckTableModel = new ReportCheckTableModel(0, num,checkcontent,description,radio);
                reportCheckTableDao.insert(reportCheckTableModel);
                tableid.add(reportCheckTableModel.getTableid().toString());
                ++i;
            }
        }
        ReportCheckModel reportCheckModel = new ReportCheckModel(0,softwarename,client,softwarename,date,tableid.toJSONString());
        reportCheckDao.insert(reportCheckModel);
        Integer CHID = reportCheckModel.getCHID();
        processDao.setCHID(PID,CHID);
        JSONObject res = new JSONObject();
        res.put("CHID",CHID);
        res.put("PID",PID);
        res.put("tableid",tableid);
        return res.toJSONString();
    }

    public String select(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer PID = jsonObject.getInteger("PID");
        if(PID == null ||processDao.findByPID(PID) == null){
            return "the process does not exist";
        }
        Integer CHID = findCHID(PID);
        if(reportCheckDao.select2(CHID) == null){
            return new JSONArray().toString();
        }
        JSONObject table = JSON.parseArray(JSON.toJSONString(reportCheckDao.select(CHID))).getJSONObject(0);
        JSONArray tableid = table.getJSONArray("tableid");
        JSONArray tabledata = new JSONArray();
        if(tableid != null){
            Integer r=tableid.size();
            Integer i = 0;
            while(i<r){
                Integer tableid_ = tableid.getInteger(i);
                tabledata.add(JSON.parseArray(JSONrepack1(JSON.toJSONString(reportCheckTableDao.select(tableid_)))).get(0));
                ++i;
            }
        }
        JSONObject res = new JSONObject();
        res.put("PID",PID);
        res.put("CHID",CHID);
        res.put("SoftWareName",table.getString("softwarename"));
        res.put("Client",table.getString("client"));
        res.put("Examiner",table.getString("examiner"));
        res.put("Date",table.getString("date"));
        res.put("tableData",tabledata);
        JSONArray res2 = new JSONArray();
        res2.add(res);
        return JSON.toJSONString(res2);
    }

    public String update(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer PID = jsonObject.getInteger("PID");
        if(PID == null ||processDao.findByPID(PID) == null){
            return "the process does not exist";
        }
        Integer CHID = findCHID(PID);
        if(reportCheckDao.select2(CHID) == null){
            return "the ReportCheck dest not exist";
        }
        JSONObject oldjsonobject = JSON.parseArray(JSON.toJSONString(reportCheckDao.select(CHID))).getJSONObject(0);
        JSONArray failedid = new JSONArray();
        JSONArray idarray1 = oldjsonobject.getJSONArray("tableid");
        JSONArray tabledata1 = jsonObject.getJSONArray("tableData");
        if(tabledata1!=null){
            Integer r= tabledata1.size();
            Integer i=0;
            while(i<r){
                JSONObject res = tabledata1.getJSONObject(i);
                Integer tableid = res.getInteger("tableid");
                String delete = res.getString("delete");
                String num = res.getString("num");
                String checkcontent = res.getString("checkcontent");
                String description = res.getString("description");
                String radio = res.getString("radio");
                ReportCheckTableModel reportCheckTableModel = new ReportCheckTableModel(tableid,num,checkcontent,description,radio);

                if(tableid == null){
                    reportCheckTableDao.insert(reportCheckTableModel);
                    idarray1.add(reportCheckTableModel.getTableid().toString());
                }
                else{
                    if(reportCheckTableDao.select2(tableid)==null||idarray1==null||idarray1==new JSONArray()) {
                        failedid.add(tableid);
                    }
                    else {
                        Integer check =0;
                        Integer r2= idarray1.size();
                        Integer i2=0;
                        while(i2<r2) {
                            if(tableid==idarray1.getInteger(i2)) {
                                check =1;
                                break;
                            }
                            i2++;
                        }
                        if(check == 0) {
                            failedid.add(tableid);
                        }
                        else {
                            if (delete == null || !delete.equals("T")) {
                                JSONObject oldtest = JSON.parseArray(JSON.toJSONString(reportCheckTableDao.select(tableid))).getJSONObject(0);
                                if(num == null){
                                    num = oldtest.getString("num");
                                }
                                if(checkcontent == null){
                                    checkcontent = oldtest.getString("checkcontent");
                                }
                                if(description == null){
                                    description = oldtest.getString("description");
                                }
                                if(radio == null){
                                    radio = oldtest.getString("radio");
                                }
                                reportCheckTableModel = new ReportCheckTableModel(tableid,num,checkcontent,description,radio);
                                reportCheckTableDao.update(reportCheckTableModel);
                            } else {
                                reportCheckTableDao.delete(tableid);
                                idarray1.remove(tableid.toString());
                            }
                        }
                    }
                }
                i++;
            }
        }
        String softwarename = jsonObject.getString("SoftWareName");
        String client = jsonObject.getString("Client");
        String examiner = jsonObject.getString("Examiner");
        String date = jsonObject.getString("Date");

        if(softwarename == null){
            softwarename = oldjsonobject.getString("softwarename");
        }
        if(client == null){
            client = oldjsonobject.getString("client");
        }
        if(examiner == null){
            examiner = oldjsonobject.getString("examiner");
        }
        if(date == null){
            date = oldjsonobject.getString("date");
        }

        ReportCheckModel reportCheckModel =new ReportCheckModel(CHID,softwarename,client,examiner,date,idarray1.toJSONString());
        reportCheckDao.update(reportCheckModel);
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("FailedTableDataID",failedid);
        return JSON.toJSONString(jsonObject1);
    }

    public String delete(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer PID = jsonObject.getInteger("PID");
        if(PID == null ||processDao.findByPID(PID) == null){
            return "the process does not exist";
        }
        Integer CHID = findCHID(PID);
        if(reportCheckDao.select2(CHID) == null){
            return "the ReportCheck dest not exist";
        }

        JSONObject oldjsonobject = JSON.parseArray(JSON.toJSONString(reportCheckDao.select(CHID))).getJSONObject(0);
        JSONArray idarray1 = oldjsonobject.getJSONArray("tableid");
        if(idarray1!=new JSONArray()&&idarray1!=null){
            Integer r=idarray1.size();
            Integer i = 0;
            while(i<r){
                Integer id = idarray1.getInteger(i);
                reportCheckTableDao.delete(id);
                ++i;
            }
        }
        reportCheckDao.delete(CHID);
        return "ReportCheck delete completed";
    }



}
