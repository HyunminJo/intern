package kr.co.crewmate.ojt.model;

import java.sql.Date;

public class ProductImage {

    private String PrdtCode;
    private String PrdtImageCode;
    private String PrdtImagePath;
    private String RgstDtm;
    
    private String[] prdtImagePaths;
    private String[] prdtImageCodes;

    public ProductImage() {
        super();
        // TODO Auto-generated constructor stub
    }
    public ProductImage(String prdtCode, String prdtImageCode, String prdtImagePath, String rgstDtm,
            String[] prdtImagePaths, String[] prdtImageCodes) {
        super();
        PrdtCode = prdtCode;
        PrdtImageCode = prdtImageCode;
        PrdtImagePath = prdtImagePath;
        RgstDtm = rgstDtm;
        this.prdtImagePaths = prdtImagePaths;
        this.prdtImageCodes = prdtImageCodes;
    }
    public String getPrdtCode() {
        return PrdtCode;
    }
    public void setPrdtCode(String prdtCode) {
        PrdtCode = prdtCode;
    }
    public String getPrdtImageCode() {
        return PrdtImageCode;
    }
    public void setPrdtImageCode(String prdtImageCode) {
        PrdtImageCode = prdtImageCode;
    }
    public String getPrdtImagePath() {
        return PrdtImagePath;
    }
    public void setPrdtImagePath(String prdtImagePath) {
        PrdtImagePath = prdtImagePath;
    }
    public String getRgstDtm() {
        return RgstDtm;
    }
    public void setRgstDtm(String rgstDtm) {
        RgstDtm = rgstDtm;
    }
    
    public String[] getPrdtImagePaths() {
        return prdtImagePaths;
    }
    public void setPrdtImagePaths(String[] prdtImagePaths) {
        this.prdtImagePaths = prdtImagePaths;
    }
    public String[] getPrdtImageCodes() {
        return prdtImageCodes;
    }
    public void setPrdtImageCodes(String[] prdtImageCodes) {
        this.prdtImageCodes = prdtImageCodes;
    }

}
