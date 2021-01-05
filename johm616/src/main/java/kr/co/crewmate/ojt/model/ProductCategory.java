package kr.co.crewmate.ojt.model;

public class ProductCategory {
    /**
     * 상품코드
     */
    private String prdtCode;
    /**
     * 카테고리아이디
     */
    private String ctgrId;
    /**
     * 기존카테고리
     */
    private String stdCtgrYn;
    /**
     * 상품등록시 카테고리아이디
     */
    private String[] ctgrIds;
    /**
     * 상품등록시 기존카테고리
     */
    private String stdCtrgYnId;

    public ProductCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

    public ProductCategory(String prdtCode, String ctgrId, String stdCtgrYn, String[] ctgrIds, String stdCtrgYnId) {
        super();
        this.prdtCode = prdtCode;
        this.ctgrId = ctgrId;
        this.stdCtgrYn = stdCtgrYn;
        this.ctgrIds = ctgrIds;
        this.stdCtrgYnId = stdCtrgYnId;
    }

    public String getPrdtCode() {
        return prdtCode;
    }

    public void setPrdtCode(String prdtCode) {
        this.prdtCode = prdtCode;
    }

    public String getCtgrId() {
        return ctgrId;
    }

    public void setCtgrId(String ctgrId) {
        this.ctgrId = ctgrId;
    }

    public String getStdCtgrYn() {
        return stdCtgrYn;
    }

    public void setStdCtgrYn(String stdCtgrYn) {
        this.stdCtgrYn = stdCtgrYn;
    }

    public String[] getCtgrIds() {
        return ctgrIds;
    }

    public void setCtgrIds(String[] ctgrIds) {
        this.ctgrIds = ctgrIds;
    }

    public String getStdCtrgYnId() {
        return stdCtrgYnId;
    }

    public void setStdCtrgYnId(String stdCtrgYnId) {
        this.stdCtrgYnId = stdCtrgYnId;
    }
    
}
