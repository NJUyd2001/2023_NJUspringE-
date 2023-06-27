package com.selab.demo.model;
import java.util.Date;
import com.selab.demo.model.enums.ApplicationState;
import com.selab.demo.model.enums.testTYPE;
import com.selab.demo.model.enums.PB_type;
import com.selab.demo.model.enums.ARCHITECTURE;
import com.selab.demo.model.enums.sARCHITECTURE;
import com.selab.demo.model.enums.MEDIUM;
import com.selab.demo.model.enums.SAMPLEDELETE;
import com.selab.demo.model.enums.state;
import org.apache.logging.log4j.util.Strings;
import org.springframework.core.codec.StringDecoder;


import javax.persistence.Table;

/**
 * @author 李晨博
 * @time 2023/6/27
 * Application 表单结构
 * */
@Table
public class ApplicationModel extends BaseEntity {
    private int AID;
    private int applicantID;//申请单ID
    private int processID;
    private Date time;//时间
    private String phone;//手机号
    private testTYPE testTYPE;
    private String sNAME;
    private String PA;
    private String PAE;
    private String PB;
    private PB_type PB_type;
    private String else_type;
    private String USS;
    private String sDES;
    private int stestBASIS;
    private String elsestestBASIS;
    private String elseINDEX;
    private int TESTINDEX;
    private int scale_num;
    private int scale_score;
    private int scale_lines;
    private char sTYPE;
    private String ENVIRONMENTW;
    private String ENVIRONMENTL;
    private String ENVIRONMENTN;
    private String ENVIRONMENTE;
    private String ENVIRONMENT;
    private ARCHITECTURE ARCHITECTURE;
    private String hMEMORY;
    private String hHARDDISK;
    private String hELSEDEMAND;
    private String sOS;
    private String sVERSION;
    private String sLANGUAGE;
    private sARCHITECTURE sARCHITECTURE;
    private String sDATABASE;
    private String sMIDDLEWARE;
    private String sELSEDEMAND;
    private MEDIUM MEDIUM;
    private String doc_path1;
    private String doc_path2;
    private String doc_path3;
    private String doc_path4;
    private SAMPLEDELETE SAMPLEDELETE;
    private String EXDATE;
    private state t_state;
    private state m_state;
    private String auditinfor;

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

    public ApplicationModel(int AID, int applicantID, int processID, Date time, String phone, testTYPE testTYPE, String sNAME, String PA, String PAE, String PB, PB_type PB_type, String else_type, String USS, String sDES, int stestBASIS, String elsestestBASIS,  int TESTINDEX, String elseINDEX, int scale_num, int scale_score, int scale_lines, char sTYPE, String ENVIRONMENTW, String ENVIRONMENTL, String ENVIRONMENTN, String ENVIRONMENTE, String ENVIRONMENT, ARCHITECTURE ARCHITECTURE, String hMEMORY, String hHARDDISK, String hELSEDEMAND, String sOS, String sVERSION, String sLANGUAGE, sARCHITECTURE sARCHITECTURE, String sDATABASE, String sMIDDLEWARE, String sELSEDEMAND, MEDIUM MEDIUM, String doc_path1, String doc_path2, String doc_path3, String doc_path4, SAMPLEDELETE SAMPLEDELETE, String EXDATE, state t_state, state m_state, String auditinfor) {
        this.AID = AID;
        this.applicantID = applicantID;
        this.processID = processID;
        this.phone = phone;
        this.time = time;
        this.testTYPE = testTYPE;
        this.sNAME = sNAME;
        this.PA = PA;
        this.PAE = PAE;
        this.PB = PB;
        this.PB_type = PB_type;
        this.else_type = else_type;
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
        this.MEDIUM = MEDIUM;
        this.doc_path1 = doc_path1;
        this.doc_path2 = doc_path2;
        this.doc_path3 = doc_path3;
        this.doc_path4 = doc_path4;
        this.SAMPLEDELETE = SAMPLEDELETE;
        this.EXDATE = EXDATE;
        this.t_state = t_state;
        this.m_state = m_state;
        this.auditinfor = auditinfor;

    }


    public int getAID() {
        return AID;
    }

    public void setAID(int AID) {
        this.AID = AID;
    }

    public int getApplicantID() {
        return applicantID;
    }

    public void setApplicantID(int applicantID) {
        this.applicantID = applicantID;
    }

    public int getProcessID() {
        return processID;
    }

    public void setProcessID(int processID) {
        this.processID = processID;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
    public testTYPE getTestTYPE(){return testTYPE;}

    public void setTestTYPE(com.selab.demo.model.enums.testTYPE testTYPE) {
        this.testTYPE = testTYPE;
    }

    public String getsNAME() {
        return sNAME;
    }
    public void setsNAME(String sNAME) {
        this.sNAME = sNAME;
    }
    public String getPA(){
        return PA;
    }

    public void setPA(String PA) {
        this.PA = PA;
    }
    public String getPAE(){
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

    public com.selab.demo.model.enums.PB_type getPB_type() {
        return PB_type;
    }

    public void setPB_type(com.selab.demo.model.enums.PB_type PB_type) {
        this.PB_type = PB_type;
    }

    public String getElse_type() {
        return else_type;
    }

    public void setElse_type(String else_type) {
        this.else_type = else_type;
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

    public int getStestBASIS() {
        return stestBASIS;
    }

    public void setStestBASIS(int stestBASIS) {
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

    public int getTESTINDEX() {
        return TESTINDEX;
    }

    public void setTESTINDEX(int TESTINDEX) {
        this.TESTINDEX = TESTINDEX;
    }

    public int getScale_num() {
        return scale_num;
    }

    public void setScale_num(int scale_num) {
        this.scale_num = scale_num;
    }

    public int getScale_score() {
        return scale_score;
    }

    public void setScale_score(int scale_score) {
        this.scale_score = scale_score;
    }

    public int getScale_lines() {
        return scale_lines;
    }

    public void setScale_lines(int scale_lines) {
        this.scale_lines = scale_lines;
    }

    public char getsTYPE() {
        return sTYPE;
    }

    public void setsTYPE(char sTYPE) {
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

    public com.selab.demo.model.enums.sARCHITECTURE getsARCHITECTURE() {
        return sARCHITECTURE;
    }

    public void setsARCHITECTURE(com.selab.demo.model.enums.sARCHITECTURE sARCHITECTURE) {
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

    public com.selab.demo.model.enums.MEDIUM getMEDIUM() {
        return MEDIUM;
    }

    public void setMEDIUM(com.selab.demo.model.enums.MEDIUM MEDIUM) {
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

    public com.selab.demo.model.enums.SAMPLEDELETE getSAMPLEDELETE() {
        return SAMPLEDELETE;
    }

    public void setSAMPLEDELETE(com.selab.demo.model.enums.SAMPLEDELETE SAMPLEDELETE) {
        this.SAMPLEDELETE = SAMPLEDELETE;
    }

    public String getEXDATE() {
        return EXDATE;
    }

    public void setEXDATE(String EXDATE) {
        this.EXDATE = EXDATE;
    }

    public state getT_state() {
        return t_state;
    }

    public void setT_state(state t_state) {
        this.t_state = t_state;
    }

    public state getM_state() {
        return m_state;
    }

    public void setM_state(state m_state) {
        this.m_state = m_state;
    }

    public String getAuditinfor() {
        return auditinfor;
    }

    public void setAuditinfor(String auditinfor) {
        this.auditinfor = auditinfor;
    }


}


