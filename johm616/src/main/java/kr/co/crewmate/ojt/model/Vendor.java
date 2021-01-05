package kr.co.crewmate.ojt.model;

import java.sql.Date;
import java.sql.Timestamp;

import kr.co.crewmate.ojt.model.base.BaseModel;

public class Vendor extends BaseModel{

    /**
     * 업체 아이디
     */
    private String vndrId;
    /**
     * 업체 이름
     */
    private String vndrName;
    /**
     * 업체 계약 아이디
     */
    private String vndrCntrtId;
    /**
     * 계약 시작 일자
     */
    private String cntrtStartDt;
    /**
     * 계약 종료 일자
     */
    private String cntrtEndDt;
    /**
     * 업체 수수료율
     */
    private int vndrCmsnRate;

    public String getVndrId() {
        return vndrId;
    }

    public void setVndrId(String vndrId) {
        this.vndrId = vndrId;
    }

    public String getVndrName() {
        return vndrName;
    }

    public void setVndrName(String vndrName) {
        this.vndrName = vndrName;
    }

    public String getVndrCntrtId() {
        return vndrCntrtId;
    }

    public void setVndrCntrtId(String vndrCntrtId) {
        this.vndrCntrtId = vndrCntrtId;
    }

    public String getCntrtStartDt() {
        return cntrtStartDt;
    }

    public void setCntrtStartDt(String cntrtStartDt) {
        this.cntrtStartDt = cntrtStartDt;
    }

    public String getCntrtEndDt() {
        return cntrtEndDt;
    }

    public void setCntrtEndDt(String cntrtEndDt) {
        this.cntrtEndDt = cntrtEndDt;
    }

    public int getVndrCmsnRate() {
        return vndrCmsnRate;
    }

    public void setVndrCmsnRate(int vndrCmsnRate) {
        this.vndrCmsnRate = vndrCmsnRate;
    }

}