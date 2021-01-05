package kr.co.crewmate.ojt.model;

public class ProductOptionStock {
    /**
     * 상품코드
     */
    private String prdtCode;
    /**
     * 재고순번
     */
    private String stockSeq;
    /**
     * 재고수량
     */
    private String stockCount;
    /**
     * 판매수량
     */
    private String sellCount;
    /**
     * 전시여부
     */
    private String dispYn;
    /**
     * 삭제여부
     */
    private String delYn;
    /**
     * 옵션미사용
     */
    private String noOptionStockCount;

    
    public ProductOptionStock() {
        super();
        // TODO Auto-generated constructor stub
    }
  

    public ProductOptionStock(String prdtCode, String stockSeq, String stockCount, String sellCount, String dispYn, String delYn,
            String noOptionStockCount) {
        super();
        this.prdtCode = prdtCode;
        this.stockSeq = stockSeq;
        this.stockCount = stockCount;
        this.sellCount = sellCount;
        this.dispYn = dispYn;
        this.delYn = delYn;
        this.noOptionStockCount = noOptionStockCount;
    }

    public String getPrdtCode() {
        return prdtCode;
    }

    public void setPrdtCode(String prdtCode) {
        this.prdtCode = prdtCode;
    }

    public String getStockSeq() {
        return stockSeq;
    }

    public void setStockSeq(String stockSeq) {
        this.stockSeq = stockSeq;
    }

    public String getStockCount() {
        return stockCount;
    }

    public void setStockCount(String stockCount) {
        this.stockCount = stockCount;
    }

    public String getSellCount() {
        return sellCount;
    }

    public void setSellCount(String sellCount) {
        this.sellCount = sellCount;
    }

    public String getDispYn() {
        return dispYn;
    }

    public void setDispYn(String dispYn) {
        this.dispYn = dispYn;
    }

    public String getDelYn() {
        return delYn;
    }

    public void setDelYn(String delYn) {
        this.delYn = delYn;
    }

    public String getNoOptionStockCount() {
        return noOptionStockCount;
    }

    public void setNoOptionStockCount(String noOptionStockCount) {
        this.noOptionStockCount = noOptionStockCount;
    }

    
}