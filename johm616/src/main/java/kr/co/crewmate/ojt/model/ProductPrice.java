package kr.co.crewmate.ojt.model;

import java.sql.Date;

public class ProductPrice {
    /**
     * 상품가격일련번호
     */
    private String prdtPriceSeq;
    /**
     * 상품할인가격
     */
    private String prdtDscntPrice;
    /**
     * 할인시작일자
     */
    private String dscntStartDt;
    /**
     * 할인종료일자
     */
    private String dscntEndDt;
    /**
     * 등록일시
     */
    private String rgstDtm;
    /**
     * 상품코드
     */
    private String prdtCode;
    /**
     * 할인가격
     */
    private String dscntErpSellPrice;

    public ProductPrice() {
        super();
        // TODO Auto-generated constructor stub
    }

    public ProductPrice(String prdtPriceSeq, String prdtDscntPrice, String dscntStartDt, String dscntEndDt,
            String rgstDtm, String prdtCode, String dscntErpSellPrice) {
        super();
        this.prdtPriceSeq = prdtPriceSeq;
        this.prdtDscntPrice = prdtDscntPrice;
        this.dscntStartDt = dscntStartDt;
        this.dscntEndDt = dscntEndDt;
        this.rgstDtm = rgstDtm;
        this.prdtCode = prdtCode;
        this.dscntErpSellPrice = dscntErpSellPrice;
    }

    public String getPrdtPriceSeq() {
        return prdtPriceSeq;
    }

    public void setPrdtPriceSeq(String prdtPriceSeq) {
        this.prdtPriceSeq = prdtPriceSeq;
    }

    public String getPrdtDscntPrice() {
        return prdtDscntPrice;
    }

    public void setPrdtDscntPrice(String prdtDscntPrice) {
        this.prdtDscntPrice = prdtDscntPrice;
    }

    public String getDscntStartDt() {
        return dscntStartDt;
    }

    public void setDscntStartDt(String dscntStartDt) {
        this.dscntStartDt = dscntStartDt;
    }

    public String getDscntEndDt() {
        return dscntEndDt;
    }

    public void setDscntEndDt(String dscntEndDt) {
        this.dscntEndDt = dscntEndDt;
    }

    public String getRgstDtm() {
        return rgstDtm;
    }

    public void setRgstDtm(String rgstDtm) {
        this.rgstDtm = rgstDtm;
    }

    public String getPrdtCode() {
        return prdtCode;
    }

    public void setPrdtCode(String prdtCode) {
        this.prdtCode = prdtCode;
    }

    public String getDscntErpSellPrice() {
        return dscntErpSellPrice;
    }

    public void setDscntErpSellPrice(String dscntErpSellPrice) {
        this.dscntErpSellPrice = dscntErpSellPrice;
    }
   
    
}