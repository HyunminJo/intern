package kr.co.crewmate.ojt.model;

import java.sql.Date;

import kr.co.crewmate.ojt.model.base.BaseModel;

public class Category extends BaseModel {

    private String ctgrId;
    private String prntCtgrId;
    private String ctgrName;
    private String useYn;
    private int dispOrder;
    private Date rgstDtm;
    private String lastModAdminId;
    private String ctgrImageUrl;
    private String path;
    public Category() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Category(String ctgrId, String prntCtgrId, String ctgrName, String useYn, int dispOrder, Date rgstDtm,
            String lastModAdminId, String ctgrImageUrl, String path) {
        super();
        this.ctgrId = ctgrId;
        this.prntCtgrId = prntCtgrId;
        this.ctgrName = ctgrName;
        this.useYn = useYn;
        this.dispOrder = dispOrder;
        this.rgstDtm = rgstDtm;
        this.lastModAdminId = lastModAdminId;
        this.ctgrImageUrl = ctgrImageUrl;
        this.path = path;
    }
    public String getCtgrId() {
        return ctgrId;
    }
    public void setCtgrId(String ctgrId) {
        this.ctgrId = ctgrId;
    }
    public String getPrntCtgrId() {
        return prntCtgrId;
    }
    public void setPrntCtgrId(String prntCtgrId) {
        this.prntCtgrId = prntCtgrId;
    }
    public String getCtgrName() {
        return ctgrName;
    }
    public void setCtgrName(String ctgrName) {
        this.ctgrName = ctgrName;
    }
    public String getUseYn() {
        return useYn;
    }
    public void setUseYn(String useYn) {
        this.useYn = useYn;
    }
    public int getDispOrder() {
        return dispOrder;
    }
    public void setDispOrder(int dispOrder) {
        this.dispOrder = dispOrder;
    }
    public Date getRgstDtm() {
        return rgstDtm;
    }
    public void setRgstDtm(Date rgstDtm) {
        this.rgstDtm = rgstDtm;
    }
    public String getLastModAdminId() {
        return lastModAdminId;
    }
    public void setLastModAdminId(String lastModAdminId) {
        this.lastModAdminId = lastModAdminId;
    }
    public String getCtgrImageUrl() {
        return ctgrImageUrl;
    }
    public void setCtgrImageUrl(String ctgrImageUrl) {
        this.ctgrImageUrl = ctgrImageUrl;
    }    
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    @Override
    public String toString() {
        return ctgrId + prntCtgrId + ctgrName + useYn + dispOrder + rgstDtm + lastModAdminId + ctgrImageUrl + path;
    }
    
   
}                                
