package kr.co.crewmate.ojt.model;

import kr.co.crewmate.ojt.model.base.BaseModel;

public class Popup extends BaseModel{
    /**
     * 팝업일련번호
     */
    private String popupSeq;
    /**
     * 전시여부
     */
    private String dispYn;
    /**
     * 레이어팝업여부
     */
    private String layerPopupYn;
    /**
     * 팝업크기X
     */
    private String popupSizeX;
    /**
     * 팝업크기Y
     */
    private String popupSizeY;
    /**
     * 쿠키사용여부
     */
    private String cokyUseYn;
    /**
     * 팝업이름
     */
    private String popupName;
    /**
     * 등록일시
     */
    private String rgstDtm;
    /**
     * 최종수정일시
     */
    private String lastModDtm;
    /**
     * 팝업내용
     */
    private String popupCont;
    /**
     * 전시시작일시
     */
    private String dispStartDtm;
    /**
     * 전시종료일시
     */
    private String dispEndDtm;
    /**
     * 최종수정관리자아이디
     */
    private String lastModAdminId;
    /**
     * 작성관리자아이디
     */
    private String writeAdminId;
    /**
     * 팝업위치X
     */
    private String popupPosX;
    /**
     * 팝업위치Y
     */
    private String popupPosY;
    /**
     * 전시시작시간
     */
    private String displayStartHour;
    /**
     * 전시시작분
     */
    private String displayStartMinute;
    /**
     * 전시마감시간
     */
    private String displayEndHour;
    /**
     * 전시마감분
     */
    private String displayEndMinute;
    
    public Popup() {
        // TODO Auto-generated constructor stub
    }
    public Popup(String popupSeq, String dispYn, String layerPopupYn, String popupSizeX, String popupSizeY,
            String cokyUseYn, String popupName, String rgstDtm, String lastModDtm, String popupCont,
            String dispStartDtm, String dispEndDtm, String lastModAdminId, String writeAdminId, String popupPosX,
            String popupPosY, String displayStartHour, String displayStartMinute, String displayEndHour,
            String displayEndMinute) {
        super();
        this.popupSeq = popupSeq;
        this.dispYn = dispYn;
        this.layerPopupYn = layerPopupYn;
        this.popupSizeX = popupSizeX;
        this.popupSizeY = popupSizeY;
        this.cokyUseYn = cokyUseYn;
        this.popupName = popupName;
        this.rgstDtm = rgstDtm;
        this.lastModDtm = lastModDtm;
        this.popupCont = popupCont;
        this.dispStartDtm = dispStartDtm;
        this.dispEndDtm = dispEndDtm;
        this.lastModAdminId = lastModAdminId;
        this.writeAdminId = writeAdminId;
        this.popupPosX = popupPosX;
        this.popupPosY = popupPosY;
        this.displayStartHour = displayStartHour;
        this.displayStartMinute = displayStartMinute;
        this.displayEndHour = displayEndHour;
        this.displayEndMinute = displayEndMinute;
    }
    public String getPopupSeq() {
        return popupSeq;
    }
    public void setPopupSeq(String popupSeq) {
        this.popupSeq = popupSeq;
    }
    public String getDispYn() {
        return dispYn;
    }
    public void setDispYn(String dispYn) {
        this.dispYn = dispYn;
    }
    public String getLayerPopupYn() {
        return layerPopupYn;
    }
    public void setLayerPopupYn(String layerPopupYn) {
        this.layerPopupYn = layerPopupYn;
    }
    public String getPopupSizeX() {
        return popupSizeX;
    }
    public void setPopupSizeX(String popupSizeX) {
        this.popupSizeX = popupSizeX;
    }
    public String getPopupSizeY() {
        return popupSizeY;
    }
    public void setPopupSizeY(String popupSizeY) {
        this.popupSizeY = popupSizeY;
    }
    public String getCokyUseYn() {
        return cokyUseYn;
    }
    public void setCokyUseYn(String cokyUseYn) {
        this.cokyUseYn = cokyUseYn;
    }
    public String getPopupName() {
        return popupName;
    }
    public void setPopupName(String popupName) {
        this.popupName = popupName;
    }
    public String getRgstDtm() {
        return rgstDtm;
    }
    public void setRgstDtm(String rgstDtm) {
        this.rgstDtm = rgstDtm;
    }
    public String getLastModDtm() {
        return lastModDtm;
    }
    public void setLastModDtm(String lastModDtm) {
        this.lastModDtm = lastModDtm;
    }
    public String getPopupCont() {
        return popupCont;
    }
    public void setPopupCont(String popupCont) {
        this.popupCont = popupCont;
    }
    public String getDispStartDtm() {
        return dispStartDtm;
    }
    public void setDispStartDtm(String dispStartDtm) {
        this.dispStartDtm = dispStartDtm;
    }
    public String getDispEndDtm() {
        return dispEndDtm;
    }
    public void setDispEndDtm(String dispEndDtm) {
        this.dispEndDtm = dispEndDtm;
    }
    public String getLastModAdminId() {
        return lastModAdminId;
    }
    public void setLastModAdminId(String lastModAdminId) {
        this.lastModAdminId = lastModAdminId;
    }
    public String getWriteAdminId() {
        return writeAdminId;
    }
    public void setWriteAdminId(String writeAdminId) {
        this.writeAdminId = writeAdminId;
    }
    public String getPopupPosX() {
        return popupPosX;
    }
    public void setPopupPosX(String popupPosX) {
        this.popupPosX = popupPosX;
    }
    public String getPopupPosY() {
        return popupPosY;
    }
    public void setPopupPosY(String popupPosY) {
        this.popupPosY = popupPosY;
    }
    public String getDisplayStartHour() {
        return displayStartHour;
    }
    public void setDisplayStartHour(String displayStartHour) {
        this.displayStartHour = displayStartHour;
    }
    public String getDisplayStartMinute() {
        return displayStartMinute;
    }
    public void setDisplayStartMinute(String displayStartMinute) {
        this.displayStartMinute = displayStartMinute;
    }
    public String getDisplayEndHour() {
        return displayEndHour;
    }
    public void setDisplayEndHour(String displayEndHour) {
        this.displayEndHour = displayEndHour;
    }
    public String getDisplayEndMinute() {
        return displayEndMinute;
    }
    public void setDisplayEndMinute(String displayEndMinute) {
        this.displayEndMinute = displayEndMinute;
    }
    @Override
    public String toString() {
        return "PopupList [popupSeq=" + popupSeq + ", dispYn=" + dispYn + ", layerPopupYn=" + layerPopupYn
                + ", popupSizeX=" + popupSizeX + ", popupSizeY=" + popupSizeY + ", cokyUseYn=" + cokyUseYn
                + ", popupName=" + popupName + ", rgstDtm=" + rgstDtm + ", lastModDtm=" + lastModDtm + ", popupCont="
                + popupCont + ", dispStartDtm=" + dispStartDtm + ", dispEndDtm=" + dispEndDtm + ", lastModAdminId="
                + lastModAdminId + ", writeAdminId=" + writeAdminId + ", popupPosX=" + popupPosX + ", popupPosY="
                + popupPosY + ", displayStartHour=" + displayStartHour + ", displayStartMinute=" + displayStartMinute
                + ", displayEndHour=" + displayEndHour + ", displayEndMinute=" + displayEndMinute + "]";
    }
}
