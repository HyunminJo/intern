package kr.co.crewmate.ojt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import kr.co.crewmate.ojt.dao.PopupDao;
import kr.co.crewmate.ojt.model.Popup;
import kr.co.crewmate.ojt.model.base.Result;

@Service
public class PopupService {

    @Autowired
    PopupDao popupDao;
    
    public Page<Popup> getListPopup(Popup popupList) {
        return popupDao.getListPopup(popupList);
    }

    public Popup getOnePopupForm(Popup popupList) {
        return popupDao.getOnePopupForm(popupList);
    }

    public Result createOnePopup(Popup popupList) {
        popupDao.createOnePopup(popupList);
        return new Result();
    }
    
    public Result updateOnePopup(Popup popupList) {
        popupDao.updateOnePopup(popupList);
        return new Result();
    }

    public int deleteOnePopup(String popupSeq) {
        return popupDao.deleteOnePopup(popupSeq);
    }

}
