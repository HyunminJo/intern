package kr.co.crewmate.ojt.model;

import java.sql.Date;

public class OriginCode {

    private String codeClass;
    private String codeName;
    private String codeValue;
    private int codeOrder;
    private String codeDesc;
    private Date rgstDtm;
    private String codeUseYn;
    public OriginCode() {
        super();
    }
    public OriginCode(String codeClass, String codeName, String codeValue, int codeOrder, String codeDesc, Date rgstDtm,
            String codeUseYn) {
        super();
        this.codeClass = codeClass;
        this.codeName = codeName;
        this.codeValue = codeValue;
        this.codeOrder = codeOrder;
        this.codeDesc = codeDesc;
        this.rgstDtm = rgstDtm;
        this.codeUseYn = codeUseYn;
    }
    public String getCodeClass() {
        return codeClass;
    }
    public void setCodeClass(String codeClass) {
        this.codeClass = codeClass;
    }
    public String getCodeName() {
        return codeName;
    }
    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }
    public String getCodeValue() {
        return codeValue;
    }
    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue;
    }
    public int getCodeOrder() {
        return codeOrder;
    }
    public void setCodeOrder(int codeOrder) {
        this.codeOrder = codeOrder;
    }
    public String getCodeDesc() {
        return codeDesc;
    }
    public void setCodeDesc(String codeDesc) {
        this.codeDesc = codeDesc;
    }
    public Date getRgstDtm() {
        return rgstDtm;
    }
    public void setRgstDtm(Date rgstDtm) {
        this.rgstDtm = rgstDtm;
    }
    public String getCodeUseYn() {
        return codeUseYn;
    }
    public void setCodeUseYn(String codeUseYn) {
        this.codeUseYn = codeUseYn;
    }
    @Override
    public String toString() {
        return codeClass + codeName + codeValue + codeOrder + codeDesc + rgstDtm + codeUseYn;
    }
}
