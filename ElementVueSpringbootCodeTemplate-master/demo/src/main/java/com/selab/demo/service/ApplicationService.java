package com.selab.demo.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONArray;
import com.selab.demo.dao.ApplicationDao;
import com.selab.demo.model.ApplicationModel;
import com.selab.demo.model.enums.testTYPE;
import com.selab.demo.model.enums.PB_type;
import com.selab.demo.model.enums.ARCHITECTURE;
import com.selab.demo.model.enums.sARCHITECTURE;
import com.selab.demo.model.enums.MEDIUM;
import com.selab.demo.model.enums.SAMPLEDELETE;
import com.selab.demo.model.enums.state;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class ApplicationService {

    @Autowired
    ApplicationDao applicationDao;

    public String insert(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);

        int applicantID = jsonObject.getInteger("applicantID");
        int processID = jsonObject.getInteger("processID");
        Date time = jsonObject.getDate("time");
        String phone = jsonObject.getString("phone");
        testTYPE testTYPE  = jsonObject.getObject("testTYPE",testTYPE.class);
        String sNAME = jsonObject.getString("sNAME");
        String PA = jsonObject.getString("PA");
        String PAE = jsonObject.getString("PAE");
        String PB = jsonObject.getString("PB");
        PB_type PB_type  = jsonObject.getObject("PB_type",PB_type.class);
        String else_type = jsonObject.getString("else_type");
        String USS = jsonObject.getString("USS");
        String sDES = jsonObject.getString("sDES");
        String stestBASIS = jsonObject.getString("stestBASIS");
        String elsestestBASIS = jsonObject.getString("elsestestBASIS");
        String TESTINDEX = jsonObject.getString("TESTINDEX");
        String elseINDEX = jsonObject.getString("elseINDEX");
        int scale_num = jsonObject.getInteger("scale_num");
        int scale_score = jsonObject.getInteger("scale_score");
        int scale_lines = jsonObject.getInteger("scale_lines");
        char sTYPE = jsonObject.getObject("sTYPE",char.class);
        String ENVIRONMENTW = jsonObject.getString("ENVIRONMENTW");
        String ENVIRONMENTL = jsonObject.getString("ENVIRONMENTL");
        String ENVIRONMENTN = jsonObject.getString("ENVIRONMENTN");
        String ENVIRONMENTE = jsonObject.getString("ENVIRONMENTE");
        String ENVIRONMENT = jsonObject.getString("ENVIRONMENT");
        ARCHITECTURE ARCHITECTURE  = jsonObject.getObject("ARCHITECTURE",ARCHITECTURE.class);
        String hMEMORY = jsonObject.getString("hMEMORY");
        String hHARDDISK = jsonObject.getString("hHARDDISK");
        String hELSEDEMAND = jsonObject.getString("hELSEDEMAND");
        String sOS = jsonObject.getString("sOS");
        String sVERSION = jsonObject.getString("sVERSION");
        String sLANGUAGE = jsonObject.getString("sLANGUAGE");
        sARCHITECTURE sARCHITECTURE  = jsonObject.getObject("sARCHITECTURE",sARCHITECTURE.class);
        String sDATABASE = jsonObject.getString("sDATABASE");
        String sMIDDLEWARE = jsonObject.getString("sMIDDLEWARE");
        String sELSEDEMAND = jsonObject.getString("sELSEDEMAND");
        MEDIUM MEDIUM  = jsonObject.getObject("MEDIUM",MEDIUM.class);
        String doc_path1 = jsonObject.getString("doc_path1");
        String doc_path2 = jsonObject.getString("doc_path2");
        String doc_path3 = jsonObject.getString("doc_path3");
        String doc_path4 = jsonObject.getString("doc_path4");
        SAMPLEDELETE SAMPLEDELETE  = jsonObject.getObject("SAMPLEDELETE",SAMPLEDELETE.class);
        String EXDATE = jsonObject.getString("EXDATE");
        state t_state  = jsonObject.getObject("t_state",state.class);
        state m_state  = jsonObject.getObject("m_state",state.class);
        String auditinfor = jsonObject.getString("auditinfor");
        String version_num = jsonObject.getString("version_num");
        ApplicationModel applicationModel = new ApplicationModel(0,applicantID, processID, time, phone, testTYPE, sNAME, PA, PAE, PB, PB_type, else_type, USS, sDES, stestBASIS, elsestestBASIS, TESTINDEX, elseINDEX, scale_num, scale_score, scale_lines, sTYPE, ENVIRONMENTW, ENVIRONMENTL, ENVIRONMENTN, ENVIRONMENTE, ENVIRONMENT, ARCHITECTURE, hMEMORY, hHARDDISK, hELSEDEMAND, sOS, sVERSION, sLANGUAGE, sARCHITECTURE, sDATABASE, sMIDDLEWARE, sELSEDEMAND, MEDIUM, doc_path1, doc_path2, doc_path3, doc_path4, SAMPLEDELETE, EXDATE, t_state, m_state, auditinfor,version_num);
        applicationDao.insertApp(applicationModel);
        return "application inserted successfully";
    }

   public String checkbyuserA(String postJson){
       JSONObject jsonObject = JSONObject.parseObject(postJson);
       int username = jsonObject.getInteger("applicantID");
        JSONArray res = new JSONArray();
        res.add(JSON.toJSONString(applicationDao.findbyuserA(username)));
        return JSON.toJSONString(res);
    }

    public String checkbyprocess(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        int username = jsonObject.getInteger("processID");
        JSONArray res = new JSONArray();
        res.add(JSON.toJSONString(applicationDao.findbyprocess(username)));
        return JSON.toJSONString(res);
    }
    public String checkbyAID(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        int AID = jsonObject.getInteger("AID");
        JSONArray res = new JSONArray();
        res.add(JSON.toJSONString(applicationDao.findbyAID(AID)));
        return JSON.toJSONString(res);
    }
    public String updateapplication(String postJson) {
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        int AID = jsonObject.getInteger("AID");
        int applicantID = jsonObject.getInteger("applicantID");
        int processID = jsonObject.getInteger("processID");
        Date time = jsonObject.getDate("time");
        String phone = jsonObject.getString("phone");
        testTYPE testTYPE  = jsonObject.getObject("testTYPE",testTYPE.class);
        String sNAME = jsonObject.getString("sNAME");
        String PA = jsonObject.getString("PA");
        String PAE = jsonObject.getString("PAE");
        String PB = jsonObject.getString("PB");
        PB_type PB_type  = jsonObject.getObject("PB_type",PB_type.class);
        String else_type = jsonObject.getString("else_type");
        String USS = jsonObject.getString("USS");
        String sDES = jsonObject.getString("sDES");
        String stestBASIS = jsonObject.getString("stestBASIS");
        String elsestestBASIS = jsonObject.getString("elsestestBASIS");
        String TESTINDEX = jsonObject.getString("TESTINDEX");
        String elseINDEX = jsonObject.getString("elseINDEX");
        int scale_num = jsonObject.getInteger("scale_num");
        int scale_score = jsonObject.getInteger("scale_score");
        int scale_lines = jsonObject.getInteger("scale_lines");
        char sTYPE = jsonObject.getObject("sTYPE",char.class);
        String ENVIRONMENTW = jsonObject.getString("ENVIRONMENTW");
        String ENVIRONMENTL = jsonObject.getString("ENVIRONMENTL");
        String ENVIRONMENTN = jsonObject.getString("ENVIRONMENTN");
        String ENVIRONMENTE = jsonObject.getString("ENVIRONMENTE");
        String ENVIRONMENT = jsonObject.getString("ENVIRONMENT");
        ARCHITECTURE ARCHITECTURE  = jsonObject.getObject("ARCHITECTURE",ARCHITECTURE.class);
        String hMEMORY = jsonObject.getString("hMEMORY");
        String hHARDDISK = jsonObject.getString("hHARDDISK");
        String hELSEDEMAND = jsonObject.getString("hELSEDEMAND");
        String sOS = jsonObject.getString("sOS");
        String sVERSION = jsonObject.getString("sVERSION");
        String sLANGUAGE = jsonObject.getString("sLANGUAGE");
        sARCHITECTURE sARCHITECTURE  = jsonObject.getObject("sARCHITECTURE",sARCHITECTURE.class);
        String sDATABASE = jsonObject.getString("sDATABASE");
        String sMIDDLEWARE = jsonObject.getString("sMIDDLEWARE");
        String sELSEDEMAND = jsonObject.getString("sELSEDEMAND");
        MEDIUM MEDIUM  = jsonObject.getObject("MEDIUM",MEDIUM.class);
        String doc_path1 = jsonObject.getString("doc_path1");
        String doc_path2 = jsonObject.getString("doc_path2");
        String doc_path3 = jsonObject.getString("doc_path3");
        String doc_path4 = jsonObject.getString("doc_path4");
        SAMPLEDELETE SAMPLEDELETE  = jsonObject.getObject("SAMPLEDELETE",SAMPLEDELETE.class);
        String EXDATE = jsonObject.getString("EXDATE");
        state t_state  = jsonObject.getObject("t_state",state.class);
        state m_state  = jsonObject.getObject("m_state",state.class);
        String auditinfor = jsonObject.getString("auditinfor");
        String version_num = jsonObject.getString("version_num");


        String result = applicationDao.findbyAID2(AID);
        if (result == null) {
            return "the application does not exist";
        }
        ApplicationModel applicationModel = new ApplicationModel(AID,applicantID, processID, time, phone, testTYPE, sNAME, PA, PAE, PB, PB_type, else_type, USS, sDES, stestBASIS, elsestestBASIS, TESTINDEX, elseINDEX, scale_num, scale_score, scale_lines, sTYPE, ENVIRONMENTW, ENVIRONMENTL, ENVIRONMENTN, ENVIRONMENTE, ENVIRONMENT, ARCHITECTURE, hMEMORY, hHARDDISK, hELSEDEMAND, sOS, sVERSION, sLANGUAGE, sARCHITECTURE, sDATABASE, sMIDDLEWARE, sELSEDEMAND, MEDIUM, doc_path1, doc_path2, doc_path3, doc_path4, SAMPLEDELETE, EXDATE, t_state, m_state, auditinfor,version_num);


        applicationDao.updateapplication(applicationModel);


        return "update complete";
    }

    public String deleteapplication(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        int AID = jsonObject.getInteger("AID");
        String result = applicationDao.findbyAID2(AID);
        if (result == null) {
            return "the application does not exist";
        }
        applicationDao.deleteapplication(AID);
        return "delete complete";
    }
}




