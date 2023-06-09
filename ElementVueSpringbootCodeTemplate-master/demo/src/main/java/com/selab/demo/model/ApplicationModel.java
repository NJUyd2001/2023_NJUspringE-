package com.selab.demo.model;
import java.util.Date;

import com.selab.demo.model.enums.testTYPE;
import com.selab.demo.model.enums.PB_type;
import com.selab.demo.model.enums.ARCHITECTURE;
import com.selab.demo.model.enums.sARCHITECTURE;
import com.selab.demo.model.enums.MEDIUM;
import com.selab.demo.model.enums.SAMPLEDELETE;
import com.selab.demo.model.enums.state;


import javax.persistence.Table;

/**
 * @author 李晨博
 * @time 2023/6/27
 * Application 表单结构
 * */
@Table
public class ApplicationModel extends BaseEntity {
    private Integer AID;
    private Integer applicantID;//申请单ID
    private Integer processID;
    private String time;//时间
    private String phone;//手机号
    private String testTYPE;//测试类型，C：软件确认测试，I：成果/技术鉴定测试，A：转向资金验收测试
    private String sNAME;//软件名称
    private String PA;//委托方
    private String PAE;//委托方（英文）
    private String PB;//受委托方（开发单位）
    private String PB_type;//单位性质D：内资企业F：外（合）资企业G：港澳台企业S：科研院校O：政府事业团队E：其他
    //private String else_type;//单位性质为其他
    private String USS;//用户对象描述
    private String sDES;//软件描述（功能、简介）
    private String stestBASIS;//测试依据1:GB/T 25000.51-2016;2:GB/T 25000.10-2016;3:GB/T 28452-2012;4:GB/T 30961-2014;5:NST-03-Wl12-2011;6:NST-03-Wl13-2011;7:NST-03-Wl22-2014
    private String elsestestBASIS;//测试依据其他
    private String elseINDEX;
    private String TESTINDEX;
    private Integer scale_num;
    private Integer scale_score;
    private Integer scale_lines;
    private String sTYPE;
    private String ENVIRONMENTW;
    private String ENVIRONMENTL;
    private String ENVIRONMENTN;
    private String ENVIRONMENTE;
    private String ENVIRONMENT;
    private ARCHITECTURE ARCHITECTURE;
    private String hOPERATINGENVIRONMENT;
    private String hMEMORY;
    private String hHARDDISK;
    private String hELSEDEMAND;
    private String sOS;
    private String sVERSION;
    private String sLANGUAGE;
    private String sARCHITECTURE;
    private String sDATABASE;
    private String sMIDDLEWARE;
    private String sELSEDEMAND;
    private String sOPERATINGENVIRONMENT;
    private String MEDIUM;
    private String doc_path1;
    private String doc_path2;
    private String doc_path3;
    private String doc_path4;
    private String SAMPLEDELETE;
    private String EXDATE;
    private String auditinfor;
    private String version_num;
    private String mainfunction;
    private String tableid;

    private String version;
    private String confirmopinion;
    private Integer auditID;


    /**
     * {
     *     "applicantID":"1",
     *     "processID":"1",
     *     "time":"2017-09-02 10:29:14",
     *     "phone":"1",
     *     "testTYPE":"C",
     *     "sNAME":"1",
     *     "PA":"1",
     *     "PAE":"1",
     *     "PB":"1",
     *     "PB_type":"D",
     *     "else_type":"1",
     *     "USS":"1",
     *     "sDES":"1",
     *     "stestBASIS":"1",
     *     "elsestestBASIS":"1",
     *     "TESTINDEX":"1",
     *     "elseINDEX":"1",
     *     "scale_num":"1",
     *     "scale_score":"1",
     *     "scale_lines":"1",
     *     "sTYPE":"1",
     *     "ENVIRONMENTW":"1",
     *     "ENVIRONMENTL":"1",
     *     "ENVIRONMENTN":"1",
     *     "ENVIRONMENTE":"1",
     *     "ENVIRONMENT":"1",
     *     "ARCHITECTURE":"U",
     *     "hMEMORY":"1",
     *     "hHARDDISK":"1",
     *     "hELSEDEMAND":"1",
     *     "sOS":"1",
     *     "sVERSION":"1",
     *     "sLANGUAGE":"1",
     *     "sARCHITECTURE":"C",
     *     "sDATABASE":"1",
     *     "sMIDDLEWARE":"1",
     *     "sELSEDEMAND":"1",
     *     "MEDIUM":"E",
     *     "doc_path1":"E",
     *     "doc_path2":"E",
     *     "doc_path3":"E",
     *     "doc_path4":"E",
     *     "SAMPLEDELETE":"A",
     *     "EXDATE":"E",
     *     "t_state":"A",
     *     "m_state":"A",
     *     "auditinfor":"E"
     *
     *
     * }
     * **/
    public ApplicationModel(Integer AID, Integer applicantID, Integer processID, String time, String phone, String testTYPE, String sNAME, String PA, String PAE, String PB, String PB_type, String USS, String sDES, String stestBASIS, String elsestestBASIS, String elseINDEX, String TESTINDEX, Integer scale_num, Integer scale_score, Integer scale_lines, String sTYPE, String ENVIRONMENTW, String ENVIRONMENTL, String ENVIRONMENTN, String ENVIRONMENTE, String ENVIRONMENT, com.selab.demo.model.enums.ARCHITECTURE ARCHITECTURE, String hOPERATINGENVIRONMENT, String hMEMORY, String hHARDDISK, String hELSEDEMAND, String sOS, String sVERSION, String sLANGUAGE, String sARCHITECTURE, String sDATABASE, String sMIDDLEWARE, String sELSEDEMAND, String sOPERATINGENVIRONMENT, String MEDIUM, String doc_path1, String doc_path2, String doc_path3, String doc_path4, String SAMPLEDELETE, String EXDATE, String auditinfor, String version_num, String mainfunction, String tableid, String version, String confirmopinion, Integer auditID) {
        this.AID = AID;
        this.applicantID = applicantID;
        this.processID = processID;
        this.time = time;
        this.phone = phone;
        this.testTYPE = testTYPE;
        this.sNAME = sNAME;
        this.PA = PA;
        this.PAE = PAE;
        this.PB = PB;
        this.PB_type = PB_type;
        this.USS = USS;
        this.sDES = sDES;
        this.stestBASIS = stestBASIS;
        this.elsestestBASIS = elsestestBASIS;
        this.elseINDEX = elseINDEX;
        this.TESTINDEX = TESTINDEX;
        this.scale_num = scale_num;
        this.scale_score = scale_score;
        this.scale_lines = scale_lines;
        this.sTYPE = sTYPE;
        this.ENVIRONMENTW = ENVIRONMENTW;
        this.ENVIRONMENTL = ENVIRONMENTL;
        this.ENVIRONMENTN = ENVIRONMENTN;
        this.ENVIRONMENTE = ENVIRONMENTE;
        this.ENVIRONMENT = ENVIRONMENT;
        this.ARCHITECTURE = ARCHITECTURE;
        this.hOPERATINGENVIRONMENT = hOPERATINGENVIRONMENT;
        this.hMEMORY = hMEMORY;
        this.hHARDDISK = hHARDDISK;
        this.hELSEDEMAND = hELSEDEMAND;
        this.sOS = sOS;
        this.sVERSION = sVERSION;
        this.sLANGUAGE = sLANGUAGE;
        this.sARCHITECTURE = sARCHITECTURE;
        this.sDATABASE = sDATABASE;
        this.sMIDDLEWARE = sMIDDLEWARE;
        this.sELSEDEMAND = sELSEDEMAND;
        this.sOPERATINGENVIRONMENT = sOPERATINGENVIRONMENT;
        this.MEDIUM = MEDIUM;
        this.doc_path1 = doc_path1;
        this.doc_path2 = doc_path2;
        this.doc_path3 = doc_path3;
        this.doc_path4 = doc_path4;
        this.SAMPLEDELETE = SAMPLEDELETE;
        this.EXDATE = EXDATE;
        this.auditinfor = auditinfor;
        this.version_num = version_num;
        this.mainfunction = mainfunction;
        this.tableid = tableid;
        this.version = version;
        this.confirmopinion = confirmopinion;
        this.auditID = auditID;
    }

    public Integer getAID() {
        return AID;
    }

    public void setAID(Integer AID) {
        this.AID = AID;
    }

    public Integer getApplicantID() {
        return applicantID;
    }

    public void setApplicantID(Integer applicantID) {
        this.applicantID = applicantID;
    }

    public Integer getProcessID() {
        return processID;
    }

    public void setProcessID(Integer processID) {
        this.processID = processID;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTestTYPE() {
        return testTYPE;
    }

    public void setTestTYPE(String testTYPE) {
        this.testTYPE = testTYPE;
    }

    public String getsNAME() {
        return sNAME;
    }

    public void setsNAME(String sNAME) {
        this.sNAME = sNAME;
    }

    public String getPA() {
        return PA;
    }

    public void setPA(String PA) {
        this.PA = PA;
    }

    public String getPAE() {
        return PAE;
    }

    public void setPAE(String PAE) {
        this.PAE = PAE;
    }

    public String getPB() {
        return PB;
    }

    public void setPB(String PB) {
        this.PB = PB;
    }

    public String getPB_type() {
        return PB_type;
    }

    public void setPB_type(String PB_type) {
        this.PB_type = PB_type;
    }

    public String getUSS() {
        return USS;
    }

    public void setUSS(String USS) {
        this.USS = USS;
    }

    public String getsDES() {
        return sDES;
    }

    public void setsDES(String sDES) {
        this.sDES = sDES;
    }

    public String getStestBASIS() {
        return stestBASIS;
    }

    public void setStestBASIS(String stestBASIS) {
        this.stestBASIS = stestBASIS;
    }

    public String getElsestestBASIS() {
        return elsestestBASIS;
    }

    public void setElsestestBASIS(String elsestestBASIS) {
        this.elsestestBASIS = elsestestBASIS;
    }

    public String getElseINDEX() {
        return elseINDEX;
    }

    public void setElseINDEX(String elseINDEX) {
        this.elseINDEX = elseINDEX;
    }

    public String getTESTINDEX() {
        return TESTINDEX;
    }

    public void setTESTINDEX(String TESTINDEX) {
        this.TESTINDEX = TESTINDEX;
    }

    public Integer getScale_num() {
        return scale_num;
    }

    public void setScale_num(Integer scale_num) {
        this.scale_num = scale_num;
    }

    public Integer getScale_score() {
        return scale_score;
    }

    public void setScale_score(Integer scale_score) {
        this.scale_score = scale_score;
    }

    public Integer getScale_lines() {
        return scale_lines;
    }

    public void setScale_lines(Integer scale_lines) {
        this.scale_lines = scale_lines;
    }

    public String getsTYPE() {
        return sTYPE;
    }

    public void setsTYPE(String sTYPE) {
        this.sTYPE = sTYPE;
    }

    public String getENVIRONMENTW() {
        return ENVIRONMENTW;
    }

    public void setENVIRONMENTW(String ENVIRONMENTW) {
        this.ENVIRONMENTW = ENVIRONMENTW;
    }

    public String getENVIRONMENTL() {
        return ENVIRONMENTL;
    }

    public void setENVIRONMENTL(String ENVIRONMENTL) {
        this.ENVIRONMENTL = ENVIRONMENTL;
    }

    public String getENVIRONMENTN() {
        return ENVIRONMENTN;
    }

    public void setENVIRONMENTN(String ENVIRONMENTN) {
        this.ENVIRONMENTN = ENVIRONMENTN;
    }

    public String getENVIRONMENTE() {
        return ENVIRONMENTE;
    }

    public void setENVIRONMENTE(String ENVIRONMENTE) {
        this.ENVIRONMENTE = ENVIRONMENTE;
    }

    public String getENVIRONMENT() {
        return ENVIRONMENT;
    }

    public void setENVIRONMENT(String ENVIRONMENT) {
        this.ENVIRONMENT = ENVIRONMENT;
    }

    public com.selab.demo.model.enums.ARCHITECTURE getARCHITECTURE() {
        return ARCHITECTURE;
    }

    public void setARCHITECTURE(com.selab.demo.model.enums.ARCHITECTURE ARCHITECTURE) {
        this.ARCHITECTURE = ARCHITECTURE;
    }

    public String gethOPERATINGENVIRONMENT() {
        return hOPERATINGENVIRONMENT;
    }

    public void sethOPERATINGENVIRONMENT(String hOPERATINGENVIRONMENT) {
        this.hOPERATINGENVIRONMENT = hOPERATINGENVIRONMENT;
    }

    public String gethMEMORY() {
        return hMEMORY;
    }

    public void sethMEMORY(String hMEMORY) {
        this.hMEMORY = hMEMORY;
    }

    public String gethHARDDISK() {
        return hHARDDISK;
    }

    public void sethHARDDISK(String hHARDDISK) {
        this.hHARDDISK = hHARDDISK;
    }

    public String gethELSEDEMAND() {
        return hELSEDEMAND;
    }

    public void sethELSEDEMAND(String hELSEDEMAND) {
        this.hELSEDEMAND = hELSEDEMAND;
    }

    public String getsOS() {
        return sOS;
    }

    public void setsOS(String sOS) {
        this.sOS = sOS;
    }

    public String getsVERSION() {
        return sVERSION;
    }

    public void setsVERSION(String sVERSION) {
        this.sVERSION = sVERSION;
    }

    public String getsLANGUAGE() {
        return sLANGUAGE;
    }

    public void setsLANGUAGE(String sLANGUAGE) {
        this.sLANGUAGE = sLANGUAGE;
    }

    public String getsARCHITECTURE() {
        return sARCHITECTURE;
    }

    public void setsARCHITECTURE(String sARCHITECTURE) {
        this.sARCHITECTURE = sARCHITECTURE;
    }

    public String getsDATABASE() {
        return sDATABASE;
    }

    public void setsDATABASE(String sDATABASE) {
        this.sDATABASE = sDATABASE;
    }

    public String getsMIDDLEWARE() {
        return sMIDDLEWARE;
    }

    public void setsMIDDLEWARE(String sMIDDLEWARE) {
        this.sMIDDLEWARE = sMIDDLEWARE;
    }

    public String getsELSEDEMAND() {
        return sELSEDEMAND;
    }

    public void setsELSEDEMAND(String sELSEDEMAND) {
        this.sELSEDEMAND = sELSEDEMAND;
    }

    public String getsOPERATINGENVIRONMENT() {
        return sOPERATINGENVIRONMENT;
    }

    public void setsOPERATINGENVIRONMENT(String sOPERATINGENVIRONMENT) {
        this.sOPERATINGENVIRONMENT = sOPERATINGENVIRONMENT;
    }

    public String getMEDIUM() {
        return MEDIUM;
    }

    public void setMEDIUM(String MEDIUM) {
        this.MEDIUM = MEDIUM;
    }

    public String getDoc_path1() {
        return doc_path1;
    }

    public void setDoc_path1(String doc_path1) {
        this.doc_path1 = doc_path1;
    }

    public String getDoc_path2() {
        return doc_path2;
    }

    public void setDoc_path2(String doc_path2) {
        this.doc_path2 = doc_path2;
    }

    public String getDoc_path3() {
        return doc_path3;
    }

    public void setDoc_path3(String doc_path3) {
        this.doc_path3 = doc_path3;
    }

    public String getDoc_path4() {
        return doc_path4;
    }

    public void setDoc_path4(String doc_path4) {
        this.doc_path4 = doc_path4;
    }

    public String getSAMPLEDELETE() {
        return SAMPLEDELETE;
    }

    public void setSAMPLEDELETE(String SAMPLEDELETE) {
        this.SAMPLEDELETE = SAMPLEDELETE;
    }

    public String getEXDATE() {
        return EXDATE;
    }

    public void setEXDATE(String EXDATE) {
        this.EXDATE = EXDATE;
    }

    public String getAuditinfor() {
        return auditinfor;
    }

    public void setAuditinfor(String auditinfor) {
        this.auditinfor = auditinfor;
    }

    public String getVersion_num() {
        return version_num;
    }

    public void setVersion_num(String version_num) {
        this.version_num = version_num;
    }

    public String getMainfunction() {
        return mainfunction;
    }

    public void setMainfunction(String mainfunction) {
        this.mainfunction = mainfunction;
    }

    public String getTableid() {
        return tableid;
    }

    public void setTableid(String tableid) {
        this.tableid = tableid;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getConfirmopinion() {
        return confirmopinion;
    }

    public void setConfirmopinion(String confirmopinion) {
        this.confirmopinion = confirmopinion;
    }

    public Integer getAuditID() {
        return auditID;
    }

    public void setAuditID(Integer auditID) {
        this.auditID = auditID;
    }
}
