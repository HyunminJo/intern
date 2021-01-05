package kr.co.crewmate.ojt.model;

public class ProductColor {

    private String prdtCode;
    private String colorId;
    public ProductColor() {
        super();
        // TODO Auto-generated constructor stub
    }
    public ProductColor(String prdtCode, String colorId) {
        super();
        this.prdtCode = prdtCode;
        this.colorId = colorId;
    }
    public String getPrdtCode() {
        return prdtCode;
    }
    public void setPrdtCode(String prdtCode) {
        this.prdtCode = prdtCode;
    }
    public String getColorId() {
        return colorId;
    }
    public void setColorId(String colorId) {
        this.colorId = colorId;
    }
    @Override
    public String toString() {
        return "ProductColor [prdtCode=" + prdtCode + ", colorId=" + colorId + "]";
    }
    
}
