package kr.co.crewmate.ojt.model.nepa;

import kr.co.crewmate.ojt.model.base.BaseModel;

public class Users extends BaseModel {
    /**
     * 회원 고유번호
     */
    private String userNo             ;
    /**
     * 회원 아이디
     */
    private String userId             ;
    /**
     * 회원비밀번호
     */
    private String userPw             ;
    /**
     * 회원그룹 아이디
     */
    private String userGroup          ;
    /**
     * ERP 고객번호
     */
    private String cusCd              ;
    /**
     * 블랙 컨슈머 여부
     */
    private String blackConsumerYn   ;
    /**
     * 회원상태 - 정상, 휴면, 탈퇴, 일시정지
     */
    private String userStat           ;
    /**
     * 최종 로그인 일시 - 휴면회원 처리시 필요
     */
    private String lastLoginDt       ;
    /**
     * 최종 비밀번호 변경 일시 - 비밀번호 변경 주기 체크시 필요
     */
    private String lastPwChangeDt   ;
    /**
     * 탈퇴사유
     */
    private String withdrawDesc       ;
    /**
     * 관리자 메모
     */
    private String memo                ;
    /**
     * 핸드폰번호
     */
    private String hp                  ;
    /**
     * 등록일시
     */
    private String regDt              ;
    /**
     * 탈퇴일시
     */
    private String withdrawDt         ;
    /**
     * 수정자
     */
    private String modNo              ;
    /**
     * 수정일시
     */
    private String modDt              ;
    /**
     * SMS 수신여부
     */
    private String smsYn              ;
    /**
     * 메일수신여부
     */
    private String mailYn             ;
    /**
     * 추가정보 동의 여부
     */
    private String addInfoYn         ;
    /**
     * 마케팅 수신 동의 여부
     */
    private String marketingYn        ;
    /**
     * 회원 이름
     */
    private String userNm             ;
    /**
     * 블랙리스트 선정 사유 코드
     */
    private String blackConsumerType ;
    /**
     * 환불계좌 예금주명
     */
    private String refundNm           ;
    /**
     * 환불계좌 은행코드
     */
    private String refundVactBankcode;
    /**
     * 환불계좌 계좌번호
     */
    private String refundNum          ;
    /**
     * 비밀번호 초기화 여부
     */
    private String userPwInitYn     ;
    /**
     * 정보갱신유형 - 관리자/사용자
     */
    private String updateType         ;
    /**
     * 블랙리스트 내용
     */
    private String blackConsumerDesc ;
    /**
     * 회원번호 - 네파 쇼핑몰 - 마이그용임
     */
    private String mNoNpc            ;
    /**
     * 회원번호 - 이젠벅 쇼핑몰 - 마이그용임
     */
    private String mNoIbk            ;
    /**
     * 결혼여부
     */
    private String weddingYn          ;
    /**
     * 결혼기념일
     */
    private String weddingDt          ;
    /**
     * mail 주소
     */
    private String mailAddr;
    /**
     * 생일
     */
    private String birthDt;
    /**
     * 음력양력
     */
    private String solarYn;
    /**
     * 성별
     */
    private String sex;
    
    private String jobGroup;
    private String[] hobbys;
    private String jobDesc;
    private String hobbyDesc;
    private String hp1;
    private String hp2;
    private String hp3;
    private String mail1;
    private String mail2;
    private String chkSmsYn;
    private String chkMailYn;
    private String wedding1;
    private String wedding2;
    private String wedding3;

    private String birthday1;
    private String birthday2;
    private String birthday3;

    
    

    public Users() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public String getUserNo() {
        return userNo;
    }
    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getUserPw() {
        return userPw;
    }
    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }
    public String getUserGroup() {
        return userGroup;
    }
    public void setUserGroup(String userGroup) {
        this.userGroup = userGroup;
    }
    public String getCusCd() {
        return cusCd;
    }
    public void setCusCd(String cusCd) {
        this.cusCd = cusCd;
    }
    public String getBlackConsumerYn() {
        return blackConsumerYn;
    }
    public void setBlackConsumerYn(String blackConsumerYn) {
        this.blackConsumerYn = blackConsumerYn;
    }
    public String getUserStat() {
        return userStat;
    }
    public void setUserStat(String userStat) {
        this.userStat = userStat;
    }
    public String getLastLoginDt() {
        return lastLoginDt;
    }
    public void setLastLoginDt(String lastLoginDt) {
        this.lastLoginDt = lastLoginDt;
    }
    public String getLastPwChangeDt() {
        return lastPwChangeDt;
    }
    public void setLastPwChangeDt(String lastPwChangeDt) {
        this.lastPwChangeDt = lastPwChangeDt;
    }
    public String getWithdrawDesc() {
        return withdrawDesc;
    }
    public void setWithdrawDesc(String withdrawDesc) {
        this.withdrawDesc = withdrawDesc;
    }
    public String getMemo() {
        return memo;
    }
    public void setMemo(String memo) {
        this.memo = memo;
    }
    public String getHp() {
        return hp;
    }
    public void setHp(String hp) {
        this.hp = hp;
    }
    public String getRegDt() {
        return regDt;
    }
    public void setRegDt(String regDt) {
        this.regDt = regDt;
    }
    public String getWithdrawDt() {
        return withdrawDt;
    }
    public void setWithdrawDt(String withdrawDt) {
        this.withdrawDt = withdrawDt;
    }
    public String getModNo() {
        return modNo;
    }
    public void setModNo(String modNo) {
        this.modNo = modNo;
    }
    public String getModDt() {
        return modDt;
    }
    public void setModDt(String modDt) {
        this.modDt = modDt;
    }
    public String getSmsYn() {
        return smsYn;
    }
    public void setSmsYn(String smsYn) {
        this.smsYn = smsYn;
    }
    public String getMailYn() {
        return mailYn;
    }
    public void setMailYn(String mailYn) {
        this.mailYn = mailYn;
    }
    public String getAddInfoYn() {
        return addInfoYn;
    }
    public void setAddInfoYn(String addInfoYn) {
        this.addInfoYn = addInfoYn;
    }
    public String getMarketingYn() {
        return marketingYn;
    }
    public void setMarketingYn(String marketingYn) {
        this.marketingYn = marketingYn;
    }
    public String getUserNm() {
        return userNm;
    }
    public void setUserNm(String userNm) {
        this.userNm = userNm;
    }
    public String getBlackConsumerType() {
        return blackConsumerType;
    }
    public void setBlackConsumerType(String blackConsumerType) {
        this.blackConsumerType = blackConsumerType;
    }
    public String getRefundNm() {
        return refundNm;
    }
    public void setRefundNm(String refundNm) {
        this.refundNm = refundNm;
    }
    public String getRefundVactBankcode() {
        return refundVactBankcode;
    }
    public void setRefundVactBankcode(String refundVactBankcode) {
        this.refundVactBankcode = refundVactBankcode;
    }
    public String getRefundNum() {
        return refundNum;
    }
    public void setRefundNum(String refundNum) {
        this.refundNum = refundNum;
    }
    public String getUserPwInitYn() {
        return userPwInitYn;
    }
    public void setUserPwInitYn(String userPwInitYn) {
        this.userPwInitYn = userPwInitYn;
    }
    public String getUpdateType() {
        return updateType;
    }
    public void setUpdateType(String updateType) {
        this.updateType = updateType;
    }
    public String getBlackConsumerDesc() {
        return blackConsumerDesc;
    }
    public void setBlackConsumerDesc(String blackConsumerDesc) {
        this.blackConsumerDesc = blackConsumerDesc;
    }
    public String getmNoNpc() {
        return mNoNpc;
    }
    public void setmNoNpc(String mNoNpc) {
        this.mNoNpc = mNoNpc;
    }
    public String getmNoIbk() {
        return mNoIbk;
    }
    public void setmNoIbk(String mNoIbk) {
        this.mNoIbk = mNoIbk;
    }
    public String getWeddingYn() {
        return weddingYn;
    }
    public void setWeddingYn(String weddingYn) {
        this.weddingYn = weddingYn;
    }
    public String getWeddingDt() {
        return weddingDt;
    }
    public void setWeddingDt(String weddingDt) {
        this.weddingDt = weddingDt;
    }
    public String getMailAddr() {
        return mailAddr;
    }
    public void setMailAddr(String mailAddr) {
        this.mailAddr = mailAddr;
    }
    public String getBirthDt() {
        return birthDt;
    }
    public void setBirthDt(String birthDt) {
        this.birthDt = birthDt;
    }
    public String getSolarYn() {
        return solarYn;
    }
    public void setSolarYn(String solarYn) {
        this.solarYn = solarYn;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public String[] getHobbys() {
        return hobbys;
    }

    public void setHobbys(String[] hobbys) {
        this.hobbys = hobbys;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }
    public String getHobbyDesc() {
        return hobbyDesc;
    }
    public void setHobbyDesc(String hobbyDesc) {
        this.hobbyDesc = hobbyDesc;
    }

    public String getHp1() {
        return hp1;
    }

    public void setHp1(String hp1) {
        this.hp1 = hp1;
    }

    public String getHp2() {
        return hp2;
    }

    public void setHp2(String hp2) {
        this.hp2 = hp2;
    }

    public String getHp3() {
        return hp3;
    }

    public void setHp3(String hp3) {
        this.hp3 = hp3;
    }

    public String getMail1() {
        return mail1;
    }

    public void setMail1(String mail1) {
        this.mail1 = mail1;
    }

    public String getMail2() {
        return mail2;
    }

    public void setMail2(String mail2) {
        this.mail2 = mail2;
    }

    public String getChkSmsYn() {
        return chkSmsYn;
    }

    public void setChkSmsYn(String chkSmsYn) {
        this.chkSmsYn = chkSmsYn;
    }

    public String getChkMailYn() {
        return chkMailYn;
    }

    public void setChkMailYn(String chkMailYn) {
        this.chkMailYn = chkMailYn;
    }

    public String getWedding1() {
        return wedding1;
    }

    public void setWedding1(String wedding1) {
        this.wedding1 = wedding1;
    }

    public String getWedding2() {
        return wedding2;
    }

    public void setWedding2(String wedding2) {
        this.wedding2 = wedding2;
    }

    public String getWedding3() {
        return wedding3;
    }

    public void setWedding3(String wedding3) {
        this.wedding3 = wedding3;
    }

    public String getBirthday1() {
        return birthday1;
    }

    public void setBirthday1(String birthday1) {
        this.birthday1 = birthday1;
    }

    public String getBirthday2() {
        return birthday2;
    }

    public void setBirthday2(String birthday2) {
        this.birthday2 = birthday2;
    }

    public String getBirthday3() {
        return birthday3;
    }

    public void setBirthday3(String birthday3) {
        this.birthday3 = birthday3;
    }
    
    
}
