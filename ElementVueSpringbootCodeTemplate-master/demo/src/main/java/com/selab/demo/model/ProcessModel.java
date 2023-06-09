package com.selab.demo.model;
import com.selab.demo.model.enums.curr_state;
import com.selab.demo.model.enums.open_to_curr;


import javax.persistence.Table;



@Table
public class ProcessModel {
    private int PID;
    private String notes;
    private int RID;
    private int RCID;
    private int SID;
    private int RTID;
    private int TID;
    private int TEID;
    private int TCID;
    private int TRID;
    private int CHID;

    @Override
    public String toString() {
        return "ProcessModel{" +
                "PID=" + PID +
                ", notes='" + notes + '\'' +
                ", RID=" + RID +
                ", RCID=" + RCID +
                ", SID=" + SID +
                ", RTID=" + RTID +
                ", TID=" + TID +
                ", TEID=" + TEID +
                ", TCID=" + TCID +
                ", TRID=" + TRID +
                ", CHID=" + CHID +
                ", STID=" + STID +
                ", AgID=" + AgID +
                ", CID=" + CID +
                ", QID=" + QID +
                ", UID=" + UID +
                ", AID=" + AID +
                ", state='" + state + '\'' +
                '}';
    }

    public int getTCID() {
        return TCID;
    }

    public void setTCID(int TCID) {
        this.TCID = TCID;
    }

    public int getTRID() {
        return TRID;
    }

    public void setTRID(int TRID) {
        this.TRID = TRID;
    }

    public int getCHID() {
        return CHID;
    }

    public void setCHID(int CHID) {
        this.CHID = CHID;
    }

    public int getTID() {
        return TID;
    }

    public void setTID(int TID) {
        this.TID = TID;
    }

    public int getTEID() {
        return TEID;
    }

    public void setTEID(int TEID) {
        this.TEID = TEID;
    }

    private int STID;

    public int getSTID() {
        return STID;
    }

    public void setSTID(int STID) {
        this.STID = STID;
    }



    public int getRID() {
        return RID;
    }

    public void setRID(int RID) {
        this.RID = RID;
    }

    public int getRCID() {
        return RCID;
    }

    public void setRCID(int RCID) {
        this.RCID = RCID;
    }

    public int getSID() {
        return SID;
    }

    public void setSID(int SID) {
        this.SID = SID;
    }

    public int getRTID() {
        return RTID;
    }

    public void setRTID(int RTID) {
        this.RTID = RTID;
    }

    private int AgID;

    public int getAgID() {
        return AgID;
    }

    public void setAgID(int agID) {
        AgID = agID;
    }

    public ProcessModel(String notes, Integer CID, Integer QID, Integer UID, Integer AID, String state) {
        this.notes = notes;
        this.CID = CID;
        this.QID = QID;
        this.UID = UID;
        this.AID = AID;
        this.state = state;
    }

    public ProcessModel() {
    }

    public Integer getPID() {
        return PID;
    }

    public void setPID(Integer PID) {
        this.PID = PID;
    }


    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }


    public Integer getUID() {
        return UID;
    }

    public void setPID(int PID) {
        this.PID = PID;
    }

    public Integer getCID() {
        return CID;
    }

    public void setCID(Integer CID) {
        this.CID = CID;
    }

    public Integer getQID() {
        return QID;
    }

    public void setQID(Integer QID) {
        this.QID = QID;
    }

    public void setUID(Integer UID) {
        this.UID = UID;
    }

    public Integer getAID() {
        return AID;
    }

    public void setAID(Integer AID) {
        this.AID = AID;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    private Integer CID; // 对应合同草稿的编号
    private Integer QID; // 对应报价的编号
    private Integer UID; // 对应用户的编号
    private Integer AID; // 对应委托的编号
    private String state; /*发起委托(委托修改) 1    -> 市场部 通过 11 不通过 10 -> 测试部 通过 111 不通过 110
     *生成报价 2 客户接受报价  -> 21 不接受 20
     *生成合同草稿 3         -> 客户 接受并填写合同 31 不接受 30 -> 市场部 审核通过 311 不通过310
     *用户发送样品 4         -> 验收通过 41 不通过 40
     *测试部 编写测试方案 5   -> 质量部 通过 51 不通过 50
     *填写测试文档 6
     *测试完成，生成测试报告 7 -> 测试部主管通过 71 不通过 70 -> 用户审核通过 711 不通过710 -> 授权签字人 7111 7110
     *测试部 归档 发送测试报告 8 -> 确认接受 81
     */



}
