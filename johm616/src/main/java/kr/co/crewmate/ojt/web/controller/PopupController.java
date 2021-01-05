package kr.co.crewmate.ojt.web.controller;

import java.util.Date;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.crewmate.ojt.constants.Constants;
import kr.co.crewmate.ojt.model.Popup;
import kr.co.crewmate.ojt.model.base.Result;
import kr.co.crewmate.ojt.service.PopupService;
import kr.co.crewmate.ojt.util.Util;
import kr.co.crewmate.ojt.web.exception.BadRequestException;

@Controller
public class PopupController {

    private static final Logger log = LoggerFactory.getLogger(SampleController.class);
    @Autowired
    private PopupService popupService;

    /**
     * 
     * 팝업 조회
     *
     * @since 2020. 11. 30.
     * @author johm616
     *
     * @param model
     * @param product
     * @return
     */
    @RequestMapping({ "/sample/listPopup", "/sample/listPopup/popup" })
    public String getListPopup(Model model, Popup popupList) {
        
        Page<Popup> listPopup = popupService.getListPopup(popupList);
        model.addAttribute("listPopup", listPopup);

        return "/sample/listPopup";
    }

    /**
     * 
     * 팝업 폼
     *
     * @since 2020. 11. 30.
     * @author johm616
     *
     * @param model
     * @param product
     * @return
     */
    @RequestMapping({ "/sample/viewPopupFormMod", "/sample/viewPopupFormReg" })
    public String getOnePopupForm(Model model, Popup popupList) {
        
        Popup onePopupForm = new Popup();

        if (StringUtils.equals(Constants.Mode.UPDATE, popupList.getMode())) {
            // 유효성 체크
            Util.checkEmpty(popupList.getPopupSeq());
            onePopupForm = popupService.getOnePopupForm(popupList);
            if (onePopupForm == null) {
                throw new BadRequestException(Constants.ExMsg.DATA_EMPTY);
            }
            setDispDtm(onePopupForm, onePopupForm.getDispStartDtm(), onePopupForm.getDispEndDtm());
        }                
        model.addAttribute("onePopupForm", onePopupForm);

        return "/sample/viewPopup";
    }

    /**
     * 
     * 팝업 등록, 수정
     *
     * @since 2020. 12. 01.
     * @author johm616
     *
     * @param model
     * @param product
     * @return
     */
    @ResponseBody
    @RequestMapping({ "/sample/createPopupForm", "/sample/updatePopupForm" })
    public Result createPopupForm(Model model, Popup popupList) {
        
        Result result = new Result(1);
        
        // 유효성 체크
        Util.checkEmpty(popupList.getLayerPopupYn(), popupList.getDispYn(), popupList.getPopupSizeX(),
                popupList.getPopupSizeY(), popupList.getPopupPosX(), popupList.getPopupPosY(),
                popupList.getCokyUseYn());
        // YN 체크
        Util.checkYn(popupList.getLayerPopupYn(), popupList.getDispYn(), popupList.getCokyUseYn());
        // 날짜 유효성 체크
        int compare = popupList.getDispStartDtm().compareTo(popupList.getDispEndDtm());
        if(compare > 0) {
            result.setMessage("시작일은 종료일보다 클 수 없습니다.");
            result.setResultCode(-1);
            return result;
        }

        Date today = new Date();
        String dateFormat = DateFormatUtils.format(today, "yyyyMMdd HH:mm:ss");
        
        if(StringUtils.equals(popupList.getMode(),"create")) {
            popupList.setRgstDtm(dateFormat);
            popupList.setLastModDtm(dateFormat);
        } else if(StringUtils.equals(popupList.getMode(),"update")) {
            Util.checkEmpty(popupList.getPopupSeq());
            String startDate = popupList.getDispStartDtm();
            String endDate = popupList.getDispEndDtm();
            startDate += ":00";
            endDate += ":00";
            popupList.setLastModDtm(dateFormat);
            popupList.setDispStartDtm(startDate);
            popupList.setDispEndDtm(endDate);
        }
        
        try {
            // 등록
            if (StringUtils.equals(Constants.Mode.CREATE, popupList.getMode())) {
                result = this.popupService.createOnePopup(popupList);
            }
            // 수정
            if (StringUtils.equals(Constants.Mode.UPDATE, popupList.getMode())) {
                result = this.popupService.updateOnePopup(popupList);
            }
        } catch(Exception e) {
            result.setResultCode(-1);
            result.setMessage("시스템 오류, 관리자에게 문의하세요.");
        }
        return result;
    }

    /**
     * 
     * 팝업 삭제
     *
     * @since 2020. 12. 01.
     * @author johm616
     *
     * @param model
     * @param product
     * @return
     */
    @ResponseBody
    @RequestMapping({ "/sample/deletePopupList", "/sample/failPopupList" })
    public Result deleteOnePopup(Popup popupList) {
        
        Result result = new Result(1);
        this.popupService.deleteOnePopup(popupList.getPopupSeq());

        return result;
    }
    
    // setDispDtm
    private void setDispDtm(Popup popupList, String startDate, String endDate) {
        String[] startDtm = popupList.getDispStartDtm().substring(0,10).split("-");
        String[] endDtm = popupList.getDispEndDtm().substring(0, 10).split("-");
        String[] startDtmHour = popupList.getDispStartDtm().substring(11).split(":");
        String[] endDtmHour = popupList.getDispEndDtm().substring(11).split(":");
        String temp ="", temp2 = "";
        for(int i = 0; i < startDtm.length; i++) {
            temp += startDtm[i];
            temp2 += endDtm[i];
        }
        popupList.setDispStartDtm(temp);
        popupList.setDispEndDtm(temp2);
        popupList.setDisplayStartHour(startDtmHour[0]);
        popupList.setDisplayStartMinute(startDtmHour[1]);
        popupList.setDisplayEndHour(endDtmHour[0]);
        popupList.setDisplayEndMinute(endDtmHour[1]);
    }
}
