package kr.co.crewmate.ojt.model;

public class ProductOptionDetail {
    /**
     * 상품코드
     */
    private String prdtCode;
    /**
     * 옵션마스터아이디
     */
    private String optnMstrId;
    /**
     * 옵션아이디
     */
    private String optnId;
    /**
     * 옵션값
     */
    private String optnValue;
    /**
     * 옵션순서
     */
    private String optnOrder;
    /**
     * 옵션금액
     */
    private String optnAmt;
    
    private String[] optnDetailMstrOrders;
    private String[] optnDetailIds;
    private String[] optnDetailAmts;
    private String[] optnDetailValues;

    public ProductOptionDetail() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public ProductOptionDetail(String prdtCode, String optnMstrId, String optnId, String optnValue, String optnOrder,
            String optnAmt, String[] optnDetailMstrOrders, String[] optnDetailIds, String[] optnDetailAmts,
            String[] optnDetailValues) {
        super();
        this.prdtCode = prdtCode;
        this.optnMstrId = optnMstrId;
        this.optnId = optnId;
        this.optnValue = optnValue;
        this.optnOrder = optnOrder;
        this.optnAmt = optnAmt;
        this.optnDetailMstrOrders = optnDetailMstrOrders;
        this.optnDetailIds = optnDetailIds;
        this.optnDetailAmts = optnDetailAmts;
        this.optnDetailValues = optnDetailValues;
    }

    public String getPrdtCode() {
        return prdtCode;
    }
    public void setPrdtCode(String prdtCode) {
        this.prdtCode = prdtCode;
    }
    public String getOptnMstrId() {
        return optnMstrId;
    }
    public void setOptnMstrId(String optnMstrId) {
        this.optnMstrId = optnMstrId;
    }
    public String getOptnId() {
        return optnId;
    }
    public void setOptnId(String optnId) {
        this.optnId = optnId;
    }
    public String getOptnValue() {
        return optnValue;
    }
    public void setOptnValue(String optnValue) {
        this.optnValue = optnValue;
    }
    public String getOptnOrder() {
        return optnOrder;
    }
    public void setOptnOrder(String optnOrder) {
        this.optnOrder = optnOrder;
    }
    public String getOptnAmt() {
        return optnAmt;
    }
    public void setOptnAmt(String optnAmt) {
        this.optnAmt = optnAmt;
    }
    
    public String[] getOptnDetailMstrOrders() {
        return optnDetailMstrOrders;
    }

    public void setOptnDetailMstrOrders(String[] optnDetailMstrOrders) {
        this.optnDetailMstrOrders = optnDetailMstrOrders;
    }

    public String[] getOptnDetailIds() {
        return optnDetailIds;
    }

    public void setOptnDetailIds(String[] optnDetailIds) {
        this.optnDetailIds = optnDetailIds;
    }

    public String[] getOptnDetailAmts() {
        return optnDetailAmts;
    }

    public void setOptnDetailAmts(String[] optnDetailAmts) {
        this.optnDetailAmts = optnDetailAmts;
    }

    public String[] getOptnDetailValues() {
        return optnDetailValues;
    }

    public void setOptnDetailValues(String[] optnDetailValues) {
        this.optnDetailValues = optnDetailValues;
    }

    
}