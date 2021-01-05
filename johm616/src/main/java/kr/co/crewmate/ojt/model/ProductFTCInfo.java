package kr.co.crewmate.ojt.model;

import java.sql.Date;

public class ProductFTCInfo {
    /**
     * 상품코드
     */
    private String prdtCode;
    /**
     * 공정위정보일련번호
     */
    private String ftcInfoSeq;
    /**
     * 정보고시내용
     */
    private String infoNotcCont;
    /**
     * 노출여부
     */
    private String dispYn;
    /**
     * 등록일시
     */
    private String rgstDtm;
    /**
     * 관리자아이디
     */
    private String adminId;
    /**
     * 관리자아이디
     */
    private String[] ftcInfoSeqs;
    /**
     * 관리자아이디
     */
    private String[] dispYns;
    /**
     * 관리자아이디
     */
    private String[] infoNotcConts;

    public ProductFTCInfo() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public ProductFTCInfo(String prdtCode, String ftcInfoSeq, String infoNotcCont, String dispYn, String rgstDtm,
            String adminId, String[] dispYns, String[] ftcInfoSeqs, String[] infoNotcConts) {
        super();
        this.prdtCode = prdtCode;
        this.ftcInfoSeq = ftcInfoSeq;
        this.infoNotcCont = infoNotcCont;
        this.dispYn = dispYn;
        this.rgstDtm = rgstDtm;
        this.adminId = adminId;
        this.dispYns = dispYns;
        this.ftcInfoSeqs = ftcInfoSeqs;
        this.infoNotcConts = infoNotcConts;
    }
    public String getPrdtCode() {
        return prdtCode;
    }
    public void setPrdtCode(String prdtCode) {
        this.prdtCode = prdtCode;
    }
    public String getFtcInfoSeq() {
        return ftcInfoSeq;
    }
    public void setFtcInfoSeq(String ftcInfoSeq) {
        this.ftcInfoSeq = ftcInfoSeq;
    }
    public String getInfoNotcCont() {
        return infoNotcCont;
    }
    public void setInfoNotcCont(String infoNotcCont) {
        this.infoNotcCont = infoNotcCont;
    }
    public String getDispYn() {
        return dispYn;
    }
    public void setDispYn(String dispYn) {
        this.dispYn = dispYn;
    }
    public String getRgstDtm() {
        return rgstDtm;
    }
    public void setRgstDtm(String rgstDtm) {
        this.rgstDtm = rgstDtm;
    }
    public String getAdminId() {
        return adminId;
    }
    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }
    public String[] getDispYns() {
        return dispYns;
    }
    public void setDispYns(String[] dispYns) {
        this.dispYns = dispYns;
    }
    public String[] getFtcInfoSeqs() {
        return ftcInfoSeqs;
    }
    public void setFtcInfoSeqs(String[] ftcInfoSeqs) {
        this.ftcInfoSeqs = ftcInfoSeqs;
    }
    public String[] getInfoNotcConts() {
        return infoNotcConts;
    }
    public void setInfoNotcConts(String[] infoNotcConts) {
        this.infoNotcConts = infoNotcConts;
    }
    
}
