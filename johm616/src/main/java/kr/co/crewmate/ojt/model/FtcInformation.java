package kr.co.crewmate.ojt.model;

import java.sql.Date;

public class FtcInformation {
    /**
     * 공정위정보 일련번호
     */
    private int ftcInfoSeq;
    /**
     * 부모 공정위정보 일련번호
     */
    private int prntFtcInfoSeq;
    /**
     * 공정위정보 이름
     */
    private String ftcInfoName;
    /**
     * 사용여부
     */
    private String useYn;
    /**
     * 등록일시
     */
    private Date rgstDtm;
    /**
     * 공정위 순서
     */
    private int ftcOrder;
    /**
     * 관리자 아이디
     */
    private String adminId;

    public int getFtcInfoSeq() {
        return ftcInfoSeq;
    }

    public void setFtcInfoSeq(int ftcInfoSeq) {
        this.ftcInfoSeq = ftcInfoSeq;
    }

    public int getPrntFtcInfoSeq() {
        return prntFtcInfoSeq;
    }

    public void setPrntFtcInfoSeq(int prntFtcInfoSeq) {
        this.prntFtcInfoSeq = prntFtcInfoSeq;
    }

    public String getFtcInfoName() {
        return ftcInfoName;
    }

    public void setFtcInfoName(String ftcInfoName) {
        this.ftcInfoName = ftcInfoName;
    }

    public String getUseYn() {
        return useYn;
    }

    public void setUseYn(String useYn) {
        this.useYn = useYn;
    }

    public Date getRgstDtm() {
        return rgstDtm;
    }

    public void setRgstDtm(Date rgstDtm) {
        this.rgstDtm = rgstDtm;
    }

    public int getFtcOrder() {
        return ftcOrder;
    }

    public void setFtcOrder(int ftcOrder) {
        this.ftcOrder = ftcOrder;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

}
