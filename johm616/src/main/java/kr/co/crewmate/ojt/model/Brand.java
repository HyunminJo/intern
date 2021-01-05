package kr.co.crewmate.ojt.model;

import kr.co.crewmate.ojt.model.base.BaseModel;

public class Brand extends BaseModel {

    private String brandId;
    private String brandName;
    private String brandEngName;
    private String brandDesc;
    private String rgstDtm;
    private String useYn;
    private String lastModAdminId;
    private String lastModDtm;
    private String prmmYn;
    private String brandSrchWord;
    private String brandItrdnInfo;
    private String brandImageUrl1;
    private String brandImageUrl2;
    private String brandImageUrl3;
    private String brandImageUrl4;
    private String brandImageUrl5;
    private String brandImageUrl6;
    private String brandImageUrl7;
    private String brandImageUrl8;
    private String topVslArea;
    private String itrstBrandDispYn;
    private String dispOrder;
    public Brand() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Brand(String brandId, String brandName, String brandEngName, String brandDesc, String rgstDtm, String useYn,
            String lastModAdminId, String lastModDtm, String prmmYn, String brandSrchWord, String brandItrdnInfo,
            String brandImageUrl1, String brandImageUrl2, String brandImageUrl3, String brandImageUrl4,
            String brandImageUrl5, String brandImageUrl6, String brandImageUrl7, String brandImageUrl8,
            String topVslArea, String itrstBrandDispYn, String dispOrder) {
        super();
        this.brandId = brandId;
        this.brandName = brandName;
        this.brandEngName = brandEngName;
        this.brandDesc = brandDesc;
        this.rgstDtm = rgstDtm;
        this.useYn = useYn;
        this.lastModAdminId = lastModAdminId;
        this.lastModDtm = lastModDtm;
        this.prmmYn = prmmYn;
        this.brandSrchWord = brandSrchWord;
        this.brandItrdnInfo = brandItrdnInfo;
        this.brandImageUrl1 = brandImageUrl1;
        this.brandImageUrl2 = brandImageUrl2;
        this.brandImageUrl3 = brandImageUrl3;
        this.brandImageUrl4 = brandImageUrl4;
        this.brandImageUrl5 = brandImageUrl5;
        this.brandImageUrl6 = brandImageUrl6;
        this.brandImageUrl7 = brandImageUrl7;
        this.brandImageUrl8 = brandImageUrl8;
        this.topVslArea = topVslArea;
        this.itrstBrandDispYn = itrstBrandDispYn;
        this.dispOrder = dispOrder;
    }
    public String getBrandId() {
        return brandId;
    }
    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }
    public String getBrandName() {
        return brandName;
    }
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
    public String getBrandEngName() {
        return brandEngName;
    }
    public void setBrandEngName(String brandEngName) {
        this.brandEngName = brandEngName;
    }
    public String getBrandDesc() {
        return brandDesc;
    }
    public void setBrandDesc(String brandDesc) {
        this.brandDesc = brandDesc;
    }
    public String getRgstDtm() {
        return rgstDtm;
    }
    public void setRgstDtm(String rgstDtm) {
        this.rgstDtm = rgstDtm;
    }
    public String getUseYn() {
        return useYn;
    }
    public void setUseYn(String useYn) {
        this.useYn = useYn;
    }
    public String getLastModAdminId() {
        return lastModAdminId;
    }
    public void setLastModAdminId(String lastModAdminId) {
        this.lastModAdminId = lastModAdminId;
    }
    public String getLastModDtm() {
        return lastModDtm;
    }
    public void setLastModDtm(String lastModDtm) {
        this.lastModDtm = lastModDtm;
    }
    public String getPrmmYn() {
        return prmmYn;
    }
    public void setPrmmYn(String prmmYn) {
        this.prmmYn = prmmYn;
    }
    public String getBrandSrchWord() {
        return brandSrchWord;
    }
    public void setBrandSrchWord(String brandSrchWord) {
        this.brandSrchWord = brandSrchWord;
    }
    public String getBrandItrdnInfo() {
        return brandItrdnInfo;
    }
    public void setBrandItrdnInfo(String brandItrdnInfo) {
        this.brandItrdnInfo = brandItrdnInfo;
    }
    public String getBrandImageUrl1() {
        return brandImageUrl1;
    }
    public void setBrandImageUrl1(String brandImageUrl1) {
        this.brandImageUrl1 = brandImageUrl1;
    }
    public String getBrandImageUrl2() {
        return brandImageUrl2;
    }
    public void setBrandImageUrl2(String brandImageUrl2) {
        this.brandImageUrl2 = brandImageUrl2;
    }
    public String getBrandImageUrl3() {
        return brandImageUrl3;
    }
    public void setBrandImageUrl3(String brandImageUrl3) {
        this.brandImageUrl3 = brandImageUrl3;
    }
    public String getBrandImageUrl4() {
        return brandImageUrl4;
    }
    public void setBrandImageUrl4(String brandImageUrl4) {
        this.brandImageUrl4 = brandImageUrl4;
    }
    public String getBrandImageUrl5() {
        return brandImageUrl5;
    }
    public void setBrandImageUrl5(String brandImageUrl5) {
        this.brandImageUrl5 = brandImageUrl5;
    }
    public String getBrandImageUrl6() {
        return brandImageUrl6;
    }
    public void setBrandImageUrl6(String brandImageUrl6) {
        this.brandImageUrl6 = brandImageUrl6;
    }
    public String getBrandImageUrl7() {
        return brandImageUrl7;
    }
    public void setBrandImageUrl7(String brandImageUrl7) {
        this.brandImageUrl7 = brandImageUrl7;
    }
    public String getBrandImageUrl8() {
        return brandImageUrl8;
    }
    public void setBrandImageUrl8(String brandImageUrl8) {
        this.brandImageUrl8 = brandImageUrl8;
    }
    public String getTopVslArea() {
        return topVslArea;
    }
    public void setTopVslArea(String topVslArea) {
        this.topVslArea = topVslArea;
    }
    public String getItrstBrandDispYn() {
        return itrstBrandDispYn;
    }
    public void setItrstBrandDispYn(String itrstBrandDispYn) {
        this.itrstBrandDispYn = itrstBrandDispYn;
    }
    public String getDispOrder() {
        return dispOrder;
    }
    public void setDispOrder(String dispOrder) {
        this.dispOrder = dispOrder;
    }
    @Override
    public String toString() {
        return "Brand [brandId=" + brandId + ", brandName=" + brandName + ", brandEngName=" + brandEngName
                + ", brandDesc=" + brandDesc + ", rgstDtm=" + rgstDtm + ", useYn=" + useYn + ", lastModAdminId="
                + lastModAdminId + ", lastModDtm=" + lastModDtm + ", prmmYn=" + prmmYn + ", brandSrchWord="
                + brandSrchWord + ", brandItrdnInfo=" + brandItrdnInfo + ", brandImageUrl1=" + brandImageUrl1
                + ", brandImageUrl2=" + brandImageUrl2 + ", brandImageUrl3=" + brandImageUrl3 + ", brandImageUrl4="
                + brandImageUrl4 + ", brandImageUrl5=" + brandImageUrl5 + ", brandImageUrl6=" + brandImageUrl6
                + ", brandImageUrl7=" + brandImageUrl7 + ", brandImageUrl8=" + brandImageUrl8 + ", topVslArea="
                + topVslArea + ", itrstBrandDispYn=" + itrstBrandDispYn + ", dispOrder=" + dispOrder + "]";
    }
    
}
