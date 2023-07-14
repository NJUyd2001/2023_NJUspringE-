package com.selab.demo.service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONArray;
import com.selab.demo.model.*;
import com.selab.demo.dao.SoftwareDocCheckDao;
import com.selab.demo.dao.SoftwareDocCheckTableDao;
import com.selab.demo.dao.ProcessDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class SoftwareDocCheckService {

    @Autowired
    SoftwareDocCheckTableDao softwareDocCheckTableDao;
    @Autowired
    SoftwareDocCheckDao softwareDocCheckDao;
    @Autowired
    ProcessDao processDao;
    public Integer findSCID(Integer PID){
        ProcessModel processModel = processDao.findByPID(PID);
        if(processModel == null){
            return null;
        }
        return processModel.getSCID();
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
            result.put("ReviewCategories", jsonObject.getString("reviewcategories"));
            result.put("Reviewitem",jsonObject.getString("reviewitem"));
            result.put("ReviewContent", jsonObject.getString("reviewcontent"));
            result.put("ReviewResultExplanation", jsonObject.getString("revieweresultexplanation"));
            result.put("radio", jsonObject.getString("radio"));
            result2.add(result);
            ++i;
        }
        return JSON.toJSONString(result2);
    }

    public String insert(String postJson) {
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer PID = jsonObject.getInteger("PID");
        if(PID == null ||processDao.findByPID(PID) == null){
            return "the process does not exist";
        }
        JSONArray table1 = jsonObject.getJSONArray("tableData");
        JSONArray tableid = new JSONArray();
        if (table1 != null) {
            Integer r = table1.size();
            Integer i = 0;
            while (i < r) {
                JSONObject jsonObject1 = table1.getJSONObject(i);
                String reviewcategories = jsonObject1.getString("ReviewCategories");
                String reviewitem = jsonObject1.getString("Reviewitem");
                String reviewcontent = jsonObject1.getString("ReviewContent");
                String revieweresultexplanation = jsonObject1.getString("ReviewResultExplanation");
                String radio = jsonObject1.getString("radio");
                SoftwareDocCheckTableModel softwareDocCheckTableModel= new SoftwareDocCheckTableModel(0,reviewcategories,reviewitem,reviewcontent,revieweresultexplanation,radio);
                softwareDocCheckTableDao.insert(softwareDocCheckTableModel);
                tableid.add(softwareDocCheckTableModel.getTableid().toString());
                ++i;
            }
        }
        SoftwareDocCheckModel softwareDocCheckModel = new SoftwareDocCheckModel(0,tableid.toJSONString());
        softwareDocCheckDao.insert(softwareDocCheckModel);
        Integer SCID = softwareDocCheckModel.getSCID();
        processDao.setSCID(PID,SCID);
        JSONObject res = new JSONObject();
        res.put("SCID",SCID);
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
        Integer SCID = findSCID(PID);
        if(softwareDocCheckDao.select2(SCID) == null){
            return new JSONArray().toString();
        }
        JSONObject table = JSON.parseArray(JSON.toJSONString(softwareDocCheckDao.select(SCID))).getJSONObject(0);
        JSONArray tableid = table.getJSONArray("tableid");
        JSONArray tabledata = new JSONArray();
        if(tableid != null){
            Integer r=tableid.size();
            Integer i = 0;
            while(i<r){
                Integer tableid_ = tableid.getInteger(i);
                tabledata.add(JSON.parseArray(JSONrepack1(JSON.toJSONString(softwareDocCheckTableDao.select(tableid_)))).get(0));
                ++i;
            }
        }
        JSONObject res = new JSONObject();
        res.put("PID",PID);
        res.put("SCID",SCID);
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
        Integer SCID = findSCID(PID);
        if(softwareDocCheckDao.select2(SCID) == null){
            return "the SoftwareDocCheck dest not exist";
        }
        JSONObject oldjsonobject = JSON.parseArray(JSON.toJSONString(softwareDocCheckDao.select(SCID))).getJSONObject(0);
        JSONArray failedid = new JSONArray();
        JSONArray idarray1 = oldjsonobject.getJSONArray("tableid");
        JSONArray tabledata1 = jsonObject.getJSONArray("tableData");
        if(tabledata1!=null){
            Integer r= tabledata1.size();
            Integer i=0;
            while(i<r){
                JSONObject jsonObject1 = tabledata1.getJSONObject(i);
                Integer tableid = jsonObject1.getInteger("tableid");
                String delete = jsonObject1.getString("delete");
                String reviewcategories = jsonObject1.getString("ReviewCategories");
                String reviewitem = jsonObject1.getString("Reviewitem");
                String reviewcontent = jsonObject1.getString("ReviewContent");
                String revieweresultexplanation = jsonObject1.getString("ReviewResultExplanation");
                String radio = jsonObject1.getString("radio");
                SoftwareDocCheckTableModel softwareDocCheckTableModel= new SoftwareDocCheckTableModel(0,reviewcategories,reviewitem,reviewcontent,revieweresultexplanation,radio);

                if(tableid == null){
                    softwareDocCheckTableDao.insert(softwareDocCheckTableModel);
                    idarray1.add(softwareDocCheckTableModel.getTableid().toString());
                }
                else{
                    if(softwareDocCheckTableDao.select2(tableid)==null||idarray1==null||idarray1==new JSONArray()) {
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
                                JSONObject oldtest = JSON.parseArray(JSON.toJSONString(softwareDocCheckTableDao.select(tableid))).getJSONObject(0);
                                if(reviewcategories == null){
                                    reviewcategories = oldtest.getString("reviewcategories");
                                }
                                if(reviewitem == null){
                                    reviewitem = oldtest.getString("reviewitem");
                                }
                                if(reviewcontent == null){
                                    reviewcontent = oldtest.getString("reviewcontent");
                                }
                                if(revieweresultexplanation == null){
                                    revieweresultexplanation = oldtest.getString("revieweresultexplanation");
                                }
                                if(radio == null){
                                    radio = oldtest.getString("radio");
                                }

                                softwareDocCheckTableModel = new SoftwareDocCheckTableModel(0,reviewcategories,reviewitem,reviewcontent,revieweresultexplanation,radio);
                                softwareDocCheckTableDao.update(softwareDocCheckTableModel);
                            } else {
                                softwareDocCheckTableDao.delete(tableid);
                                idarray1.remove(tableid.toString());
                            }
                        }
                    }
                }
                i++;
            }
        }

        SoftwareDocCheckModel softwareDocCheckModel=new SoftwareDocCheckModel(SCID,idarray1.toJSONString());
        softwareDocCheckDao.update(softwareDocCheckModel);
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
        Integer SCID = findSCID(PID);
        if(softwareDocCheckDao.select2(SCID) == null){
            return "the SoftwareDocCheck dest not exist";
        }

        JSONObject oldjsonobject = JSON.parseArray(JSON.toJSONString(softwareDocCheckDao.select(SCID))).getJSONObject(0);
        JSONArray idarray1 = oldjsonobject.getJSONArray("tableid");
        if(idarray1!=new JSONArray()&&idarray1!=null){
            Integer r=idarray1.size();
            Integer i = 0;
            while(i<r){
                Integer id = idarray1.getInteger(i);
                softwareDocCheckDao.delete(id);
                ++i;
            }
        }
        softwareDocCheckDao.delete(SCID);
        return "SoftwareDocCheck delete completed";
    }



}
