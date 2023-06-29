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

        Integer applicantID = jsonObject.getInteger("applicantID");
        Integer processID = jsonObject.getInteger("processID");
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
        Integer scale_num = jsonObject.getInteger("scale_num");
        Integer scale_score = jsonObject.getInteger("scale_score");
        Integer scale_lines = jsonObject.getInteger("scale_lines");
        Character sTYPE = jsonObject.getObject("sTYPE",char.class);
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
        String hOPERATINGENVIRONMENT = jsonObject.getString("hOPERATINGENVIRONMENT");
        String sOPERATINGENVIRONMENT = jsonObject.getString("sOPERATINGENVIRONMENT");
        ApplicationModel applicationModel = new ApplicationModel(0,applicantID, processID, time, phone, testTYPE, sNAME, PA, PAE, PB, PB_type, else_type, USS, sDES, stestBASIS, elsestestBASIS, TESTINDEX, elseINDEX, scale_num, scale_score, scale_lines, sTYPE, ENVIRONMENTW, ENVIRONMENTL, ENVIRONMENTN, ENVIRONMENTE, ENVIRONMENT, ARCHITECTURE, hMEMORY, hHARDDISK, hELSEDEMAND, sOS, sVERSION, sLANGUAGE, sARCHITECTURE, sDATABASE, sMIDDLEWARE, sELSEDEMAND, MEDIUM, doc_path1, doc_path2, doc_path3, doc_path4, SAMPLEDELETE, EXDATE, t_state, m_state, auditinfor,version_num,hOPERATINGENVIRONMENT,sOPERATINGENVIRONMENT);
        applicationDao.insertApp(applicationModel);
        return "application inserted successfully";
    }

   public String checkbyuserA(String postJson){
       JSONObject jsonObject = JSONObject.parseObject(postJson);
       int username = jsonObject.getInteger("applicantID");
        JSONArray res = new JSONArray();
        res.add(JSON.toJSONString(applicationDao.findbyuserA(username)));
        return JSON.toJSONString(applicationDao.findbyuserA(username));
    }

    public String checkbyprocess(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        int username = jsonObject.getInteger("processID");
        JSONArray res = new JSONArray();
        res.add(JSON.toJSONString(applicationDao.findbyprocess(username)));
        return JSON.toJSONString(applicationDao.findbyprocess(username));
    }
    public String checkbyAID(String postJson){
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        int AID = jsonObject.getInteger("AID");
        JSONArray res = new JSONArray();
        res.add(JSON.toJSONString(applicationDao.findbyAID(AID)));
        return JSON.toJSONString(applicationDao.findbyAID(AID));
    }
    public String updateapplication(String postJson) {
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        Integer AID = jsonObject.getInteger("AID");
        Integer applicantID = jsonObject.getInteger("applicantID");
        Integer processID = jsonObject.getInteger("processID");
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
        Integer scale_num = jsonObject.getInteger("scale_num");
        Integer scale_score = jsonObject.getInteger("scale_score");
        Integer scale_lines = jsonObject.getInteger("scale_lines");
        Character sTYPE = jsonObject.getObject("sTYPE",char.class);
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
        String hOPERATINGENVIRONMENT = jsonObject.getString("hOPERATINGENVIRONMENT");
        String sOPERATINGENVIRONMENT = jsonObject.getString("sOPERATINGENVIRONMENT");


        String result = applicationDao.findbyAID2(AID);
        if (result == null) {
            return "the application does not exist";
        }
        JSONArray res = new JSONArray();
        res.add(JSON.toJSONString(applicationDao.findbyAID(AID)));
        JSONObject oldjsonObject =  JSONObject.parseObject(JSON.toJSONString(applicationDao.findbyAID(AID).get(0)) ) ;
        if(applicantID == null)
            applicantID = oldjsonObject.getInteger("applicantID");
        if(processID == null)
            processID = oldjsonObject.getInteger("processID");
        if(time == null)
            time = oldjsonObject.getDate("time");
        if(phone == null)
            phone = oldjsonObject.getString("phone");
        if(testTYPE == null)
            testTYPE  = oldjsonObject.getObject("testTYPE",testTYPE.class);
        if(sNAME == null)
            sNAME = oldjsonObject.getString("sNAME");
        if(PA == null)
            PA = oldjsonObject.getString("pA");
        if(PAE == null)
            PAE = oldjsonObject.getString("pAE");
        if(PB == null)
            PB = oldjsonObject.getString("pB");
        if(PB_type == null)
            PB_type  = oldjsonObject.getObject("pB_type",PB_type.class);
        if(else_type == null)
            else_type = oldjsonObject.getString("else_type");
        if(USS == null)
            USS = oldjsonObject.getString("uSS");
        if(sDES==null)
            sDES = oldjsonObject.getString("sDES");
        if(stestBASIS == null)
            stestBASIS = oldjsonObject.getString("stestBASIS");
        if(elsestestBASIS == null)
            elsestestBASIS = oldjsonObject.getString("elsestestBASIS");
        if(TESTINDEX == null)
             TESTINDEX = oldjsonObject.getString("tESTINDEX");
        if(elseINDEX == null)
            elseINDEX = oldjsonObject.getString("elseINDEX");
        if(scale_num == null)
            scale_num = oldjsonObject.getInteger("scale_num");
        if(scale_score == null)
            scale_score = oldjsonObject.getInteger("scale_score");
        if(scale_lines == null)
            scale_lines = oldjsonObject.getInteger("scale_lines");
        if(sTYPE == null)
            sTYPE = oldjsonObject.getObject("sTYPE",char.class);
        if(ENVIRONMENTW == null)
            ENVIRONMENTW = oldjsonObject.getString("eNVIRONMENTW");
        if(ENVIRONMENTL == null)
            ENVIRONMENTL = oldjsonObject.getString("eNVIRONMENTL");
        if(ENVIRONMENTN == null)
            ENVIRONMENTN = oldjsonObject.getString("eNVIRONMENTN");
        if(ENVIRONMENTE == null)
            ENVIRONMENTE = oldjsonObject.getString("eNVIRONMENTE");
        if(ENVIRONMENT == null)
            ENVIRONMENT = oldjsonObject.getString("eNVIRONMENT");
        if(ARCHITECTURE == null)
            ARCHITECTURE  = oldjsonObject.getObject("aRCHITECTURE",ARCHITECTURE.class);
        if(hMEMORY == null)
            hMEMORY = oldjsonObject.getString("hMEMORY");
        if(hHARDDISK == null)
            hHARDDISK = oldjsonObject.getString("hHARDDISK");
        if(hELSEDEMAND == null)
            hELSEDEMAND = oldjsonObject.getString("hELSEDEMAND");
        if(sOS == null)
            sOS = oldjsonObject.getString("sOS");
        if(sVERSION == null)
            sVERSION = oldjsonObject.getString("sVERSION");
        if(sLANGUAGE == null)
            sLANGUAGE = oldjsonObject.getString("sLANGUAGE");
        if(sARCHITECTURE == null)
            sARCHITECTURE  = oldjsonObject.getObject("sARCHITECTURE",sARCHITECTURE.class);
        if(sDATABASE == null)
            sDATABASE = oldjsonObject.getString("sDATABASE");
        if(sMIDDLEWARE == null)
            sMIDDLEWARE = oldjsonObject.getString("sMIDDLEWARE");
        if(sELSEDEMAND == null)
            sELSEDEMAND = oldjsonObject.getString("sELSEDEMAND");
        if(MEDIUM == null)
            MEDIUM  = oldjsonObject.getObject("mEDIUM",MEDIUM.class);
        if(doc_path1 == null)
            doc_path1 = oldjsonObject.getString("doc_path1");
        if(doc_path2 == null)
            doc_path2 = oldjsonObject.getString("doc_path2");
        if(doc_path3 == null)
            doc_path3 = oldjsonObject.getString("doc_path3");
        if(doc_path4 == null)
            doc_path4 = oldjsonObject.getString("doc_path4");
        if(SAMPLEDELETE == null)
            SAMPLEDELETE  = oldjsonObject.getObject("sAMPLEDELETE",SAMPLEDELETE.class);
        if(EXDATE == null)
            EXDATE = oldjsonObject.getString("eXDATE");
        if(t_state == null)
            t_state  = oldjsonObject.getObject("t_state",state.class);
        if(m_state == null)
            m_state  = oldjsonObject.getObject("m_state",state.class);
        if(auditinfor == null)
            auditinfor = oldjsonObject.getString("auditinfor");
        if(version_num == null)
            version_num = oldjsonObject.getString("version_num");
        if(hOPERATINGENVIRONMENT == null)
            hOPERATINGENVIRONMENT = oldjsonObject.getString("hOPERATINGENVIRONMENT");
        if(sOPERATINGENVIRONMENT == null)   sOPERATINGENVIRONMENT = oldjsonObject.getString("sOPERATINGENVIRONMENT");


        ApplicationModel applicationModel = new ApplicationModel(AID,applicantID, processID, time, phone, testTYPE, sNAME, PA, PAE, PB, PB_type, else_type, USS, sDES, stestBASIS, elsestestBASIS, TESTINDEX, elseINDEX, scale_num, scale_score, scale_lines, sTYPE, ENVIRONMENTW, ENVIRONMENTL, ENVIRONMENTN, ENVIRONMENTE, ENVIRONMENT, ARCHITECTURE, hMEMORY, hHARDDISK, hELSEDEMAND, sOS, sVERSION, sLANGUAGE, sARCHITECTURE, sDATABASE, sMIDDLEWARE, sELSEDEMAND, MEDIUM, doc_path1, doc_path2, doc_path3, doc_path4, SAMPLEDELETE, EXDATE, t_state, m_state, auditinfor,version_num,hOPERATINGENVIRONMENT,sOPERATINGENVIRONMENT);


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




