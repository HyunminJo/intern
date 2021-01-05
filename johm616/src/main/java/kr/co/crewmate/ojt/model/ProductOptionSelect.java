package kr.co.crewmate.ojt.model;

public class ProductOptionSelect {
    /**
     * 상품코드
     */
    private String prdtCode;
    /**
     * 상품코드
     */
    private String optnMstrId;
    /**
     * 상품코드
     */
    private String optnId;
    /**
     * 상품코드
     */
    private String stockSeq; 
    
    
    // 등록시 필요 변수
    private String[] stockIndex;      
    private String[] selectedOptnDtlIds;    
    // 줄 순서
    private String[] stockSeqs;   
    // 재고
    private String[] selectedStockCounts;    
    // 전시여부
    private String[] selectedOptnDispYns;
    private String optnUseYn;    
    private String[] selectStockIndex;   
    
    public String[] getSelectStockIndex() {
        return selectStockIndex;
    }

    public void setSelectStockIndex(String[] selectStockIndex) {
        this.selectStockIndex = selectStockIndex;
    }

    public String getOptnUseYn() {
        return optnUseYn;
    }

    public void setOptnUseYn(String optnUseYn) {
        this.optnUseYn = optnUseYn;
    }

    public String[] getSelectedOptnDispYns() {
        return selectedOptnDispYns;
    }

    public void setSelectedOptnDispYns(String[] selectedOptnDispYns) {
        this.selectedOptnDispYns = selectedOptnDispYns;
    }

    public String[] getSelectedStockCounts() {
        return selectedStockCounts;
    }

    public void setSelectedStockCounts(String[] selectedStockCounts) {
        this.selectedStockCounts = selectedStockCounts;
    }

    public String[] getStockIndex() {
        return stockIndex;
    }

    public void setStockIndex(String[] stockIndex) {
        this.stockIndex = stockIndex;
    }

    public String[] getSelectedOptnDtlIds() {
        return selectedOptnDtlIds;
    }

    public void setSelectedOptnDtlIds(String[] selectedOptnDtlIds) {
        this.selectedOptnDtlIds = selectedOptnDtlIds;
    }

    public String[] getStockSeqs() {
        return stockSeqs;
    }

    public void setStockSeqs(String[] stockSeqs) {
        this.stockSeqs = stockSeqs;
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

    public String getStockSeq() {
        return stockSeq;
    }

    public void setStockSeq(String stockSeq) {
        this.stockSeq = stockSeq;
    }

}
