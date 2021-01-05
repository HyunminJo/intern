package kr.co.crewmate.ojt.model;

public class ProductOptionMaster {
    /**
     * 상품코드
     */
    private String prdtCode;
    /**
     * 옵션마스터아이디
     */
    private String optnMstrId;
    /**
     * 옵션이름
     */
    private String optnMstrName;
    /**
     * 옵션마스터순서
     */
    private String optnMstrOrder;
    
    private String[] optnMstrOrders;
    private String[] optnMstrNames;
    private String[] optnMstrIds;

    public ProductOptionMaster() {
        super();
        // TODO Auto-generated constructor stub
    }
    public ProductOptionMaster(String prdtCode, String optnMstrId, String optnMstrName, String optnMstrOrder,
            String[] optnMstrOrders, String[] optnMstrNames, String[] optnMstrIds) {
        super();
        this.prdtCode = prdtCode;
        this.optnMstrId = optnMstrId;
        this.optnMstrName = optnMstrName;
        this.optnMstrOrder = optnMstrOrder;
        this.optnMstrOrders = optnMstrOrders;
        this.optnMstrNames = optnMstrNames;
        this.optnMstrIds = optnMstrIds;
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
    public String getOptnMstrName() {
        return optnMstrName;
    }
    public void setOptnMstrName(String optnMstrName) {
        this.optnMstrName = optnMstrName;
    }
    public String getOptnMstrOrder() {
        return optnMstrOrder;
    }
    public void setOptnMstrOrder(String optnMstrOrder) {
        this.optnMstrOrder = optnMstrOrder;
    }
    
    public String[] getOptnMstrOrders() {
        return optnMstrOrders;
    }
    public void setOptnMstrOrders(String[] optnMstrOrders) {
        this.optnMstrOrders = optnMstrOrders;
    }
    public String[] getOptnMstrNames() {
        return optnMstrNames;
    }
    public void setOptnMstrNames(String[] optnMstrNames) {
        this.optnMstrNames = optnMstrNames;
    }
    public String[] getOptnMstrIds() {
        return optnMstrIds;
    }
    public void setOptnMstrIds(String[] optnMstrIds) {
        this.optnMstrIds = optnMstrIds;
    }

    
}
