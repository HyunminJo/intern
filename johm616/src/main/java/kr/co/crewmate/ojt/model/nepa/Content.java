package kr.co.crewmate.ojt.model.nepa;

import kr.co.crewmate.ojt.model.base.BaseModel;

public class Content extends BaseModel {
    /**
     * 컨텐츠 고유번호
     */
    private String contentNo;
    /**
     * 컨텐츠 타입
     */
    private String contentType;
    /**
     * 상위 컨텐츠 번호
     */
    private String parentContentNo;
    /**
     * 답변 단계
     */
    private String replyStep;
    /**
     * 사용여부
     */
    private String useYn;
    /**
     * 전시여부
     */
    private String dispYn;
    /**
     * 등록자
     */
    private String regNo;
    /**
     * 등록일시
     */
    private String regDt;
    /**
     * 수정자
     */
    private String modNo;
    /**
     * 수정일시
     */
    private String modDt;
    /**
     * 베스트 여부
     */
    private String bestYn;
    /**
     * 조회수
     */
    private String viewCnt;
    /**
     * 추천수
     */
    private String voteCnt;
    /**
     * 하위 컨텐츠 그룹
     */
    private String contentGroup;
    /**
     * 전시순서
     */
    private String dispNo;
    /**
     * 제목
     */
    private String title;
    /**
     * 내용
     */
    private String content;
    /**
     * 타입 이름
     */
    private String name;
    /**
     * 키워드
     */
    private String keyword;
    /*
     * 
     * private String topFixYn; private String reviewScore; private String itemId;
     * private String ordId; private String ordItemNo; private String userNo;
     * private String startDt; private String endDt; private String url; private
     * String contentReply; private String addInfo; private String url1; private
     * String url2; private String titleSub; private String brand; private String
     * publishDt; private String publishYn; private String snsTitle; private String
     * snsDesc; private String snsImage; private String snsImageW; private String
     * snsImageH;
     */

    public Content() {
        super();
        // TODO Auto-generated constructor stub
    }

    public String getKeyword() {
        return keyword;
    }
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    public String getContentNo() {
        return contentNo;
    }

    public void setContentNo(String contentNo) {
        this.contentNo = contentNo;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getParentContentNo() {
        return parentContentNo;
    }

    public void setParentContentNo(String parentContentNo) {
        this.parentContentNo = parentContentNo;
    }

    public String getReplyStep() {
        return replyStep;
    }

    public void setReplyStep(String replyStep) {
        this.replyStep = replyStep;
    }

    public String getUseYn() {
        return useYn;
    }

    public void setUseYn(String useYn) {
        this.useYn = useYn;
    }

    public String getDispYn() {
        return dispYn;
    }

    public void setDispYn(String dispYn) {
        this.dispYn = dispYn;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getRegDt() {
        return regDt;
    }

    public void setRegDt(String regDt) {
        this.regDt = regDt;
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

    public String getBestYn() {
        return bestYn;
    }

    public void setBestYn(String bestYn) {
        this.bestYn = bestYn;
    }

    public String getViewCnt() {
        return viewCnt;
    }

    public void setViewCnt(String viewCnt) {
        this.viewCnt = viewCnt;
    }

    public String getVoteCnt() {
        return voteCnt;
    }

    public void setVoteCnt(String voteCnt) {
        this.voteCnt = voteCnt;
    }

    public String getContentGroup() {
        return contentGroup;
    }

    public void setContentGroup(String contentGroup) {
        this.contentGroup = contentGroup;
    }

    public String getDispNo() {
        return dispNo;
    }

    public void setDispNo(String dispNo) {
        this.dispNo = dispNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
