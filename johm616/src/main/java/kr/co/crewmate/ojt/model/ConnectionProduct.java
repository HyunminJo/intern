package kr.co.crewmate.ojt.model;

public class ConnectionProduct {
    /**
     * 관련상품마스터코드
     */
    private String cntrPrdtMstrCode;
    /**
     * 관련상품코드
     */
    private String cntrPrdtCode;
    /**
     * 관련상품코드
     */
    private String[] cntrPrdtCodes;
    /**
     * 
     */
    private String[] stdCtrgYnId;

    public ConnectionProduct() {
        super();
        // TODO Auto-generated constructor stub
    }
    public ConnectionProduct(String cntrPrdtMstrCode, String cntrPrdtCode, String[] cntrPrdtCodes,
            String[] stdCtrgYnId) {
        super();
        this.cntrPrdtMstrCode = cntrPrdtMstrCode;
        this.cntrPrdtCode = cntrPrdtCode;
        this.cntrPrdtCodes = cntrPrdtCodes;
        this.stdCtrgYnId = stdCtrgYnId;
    }
    public String getCntrPrdtMstrCode() {
        return cntrPrdtMstrCode;
    }
    public void setCntrPrdtMstrCode(String cntrPrdtMstrCode) {
        this.cntrPrdtMstrCode = cntrPrdtMstrCode;
    }
    public String getCntrPrdtCode() {
        return cntrPrdtCode;
    }
    public void setCntrPrdtCode(String cntrPrdtCode) {
        this.cntrPrdtCode = cntrPrdtCode;
    }
    public String[] getCntrPrdtCodes() {
        return cntrPrdtCodes;
    }
    public void setCntrPrdtCodes(String[] cntrPrdtCodes) {
        this.cntrPrdtCodes = cntrPrdtCodes;
    }
    public String[] getStdCtrgYnId() {
        return stdCtrgYnId;
    }
    public void setStdCtrgYnId(String[] stdCtrgYnId) {
        this.stdCtrgYnId = stdCtrgYnId;
    }
    
}
