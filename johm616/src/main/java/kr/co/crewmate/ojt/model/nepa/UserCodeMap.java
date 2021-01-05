package kr.co.crewmate.ojt.model.nepa;

public class UserCodeMap {
    
    private String userNo;
    private String codeGroup;
    private String code;
    private String codeDesc;
    public UserCodeMap() {
        super();
        // TODO Auto-generated constructor stub
    }
    public UserCodeMap(String userNo, String codeGroup, String code, String codeDesc) {
        super();
        this.userNo = userNo;
        this.codeGroup = codeGroup;
        this.code = code;
        this.codeDesc = codeDesc;
    }
    public String getUserNo() {
        return userNo;
    }
    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }
    public String getCodeGroup() {
        return codeGroup;
    }
    public void setCodeGroup(String codeGroup) {
        this.codeGroup = codeGroup;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getCodeDesc() {
        return codeDesc;
    }
    public void setCodeDesc(String codeDesc) {
        this.codeDesc = codeDesc;
    }
    
    
}
