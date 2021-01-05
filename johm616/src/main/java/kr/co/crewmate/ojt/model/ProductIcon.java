package kr.co.crewmate.ojt.model;

public class ProductIcon {
    /**
     * 상품코드
     */
    private String prdtCode;
    /**
     * 아이콘아이디
     */
    private String iconId;
    /**
     * 상품코드
     */
    private String[] upIconCode;
    /**
     * 아이콘아이디
     */
    private String[] downIconCode;

    public ProductIcon() {
        super();
        // TODO Auto-generated constructor stub
    }

    public ProductIcon(String prdtCode, String iconId, String[] upIconCode, String[] downIconCode) {
        super();
        this.prdtCode = prdtCode;
        this.iconId = iconId;
        this.upIconCode = upIconCode;
        this.downIconCode = downIconCode;
    }

    public String getPrdtCode() {
        return prdtCode;
    }

    public void setPrdtCode(String prdtCode) {
        this.prdtCode = prdtCode;
    }

    public String getIconId() {
        return iconId;
    }

    public void setIconId(String iconId) {
        this.iconId = iconId;
    }

    public String[] getUpIconCode() {
        return upIconCode;
    }

    public void setUpIconCode(String[] upIconCode) {
        this.upIconCode = upIconCode;
    }

    public String[] getDownIconCode() {
        return downIconCode;
    }

    public void setDownIconCode(String[] downIconCode) {
        this.downIconCode = downIconCode;
    }
    
}
