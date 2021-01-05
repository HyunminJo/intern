package kr.co.crewmate.ojt.model.nepa;

public class Address {
    
    private String addrNo;
    private String userNo;
    private String addrNm;
    private String recvNm;
    private String tel;
    private String hp;
    private String zipcode;
    private String address;
    private String addressDetail;
    private String defaultYn;
    private String regDt;
    public Address() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Address(String addrNo, String userNo, String addrNm, String recvNm, String tel, String hp, String zipcode,
            String address, String addressDetail, String defaultYn, String regDt) {
        super();
        this.addrNo = addrNo;
        this.userNo = userNo;
        this.addrNm = addrNm;
        this.recvNm = recvNm;
        this.tel = tel;
        this.hp = hp;
        this.zipcode = zipcode;
        this.address = address;
        this.addressDetail = addressDetail;
        this.defaultYn = defaultYn;
        this.regDt = regDt;
    }
    public String getAddrNo() {
        return addrNo;
    }
    public void setAddrNo(String addrNo) {
        this.addrNo = addrNo;
    }
    public String getUserNo() {
        return userNo;
    }
    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }
    public String getAddrNm() {
        return addrNm;
    }
    public void setAddrNm(String addrNm) {
        this.addrNm = addrNm;
    }
    public String getRecvNm() {
        return recvNm;
    }
    public void setRecvNm(String recvNm) {
        this.recvNm = recvNm;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getHp() {
        return hp;
    }
    public void setHp(String hp) {
        this.hp = hp;
    }
    public String getZipcode() {
        return zipcode;
    }
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddressDetail() {
        return addressDetail;
    }
    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }
    public String getDefaultYn() {
        return defaultYn;
    }
    public void setDefaultYn(String defaultYn) {
        this.defaultYn = defaultYn;
    }
    public String getRegDt() {
        return regDt;
    }
    public void setRegDt(String regDt) {
        this.regDt = regDt;
    }
    
    
    
}
