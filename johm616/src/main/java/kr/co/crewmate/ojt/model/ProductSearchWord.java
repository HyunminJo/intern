package kr.co.crewmate.ojt.model;

public class ProductSearchWord {
    /**
     * 상품코드
     */
    private String prdtCode;
    /**
     * 검색일련번호
     */
    private int srchSeq;
    /**
     * 검색단어
     */
    private String srchWord;
    
    public ProductSearchWord() {
        super();
        // TODO Auto-generated constructor stub
    }
    public ProductSearchWord(String prdtCode, int srchSeq, String srchWord) {
        super();
        this.prdtCode = prdtCode;
        this.srchSeq = srchSeq;
        this.srchWord = srchWord;
    }
    public String getPrdtCode() {
        return prdtCode;
    }
    public void setPrdtCode(String prdtCode) {
        this.prdtCode = prdtCode;
    }
    public int getSrchSeq() {
        return srchSeq;
    }
    public void setSrchSeq(int srchSeq) {
        this.srchSeq = srchSeq;
    }
    public String getSrchWord() {
        return srchWord;
    }
    public void setSrchWord(String srchWord) {
        this.srchWord = srchWord;
    }
    @Override
    public String toString() {
        return "ProductSearchWord [prdtCode=" + prdtCode + ", srchSeq=" + srchSeq + ", srchWord=" + srchWord + "]";
    }
    
}
