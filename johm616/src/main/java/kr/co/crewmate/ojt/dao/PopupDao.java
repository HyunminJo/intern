package kr.co.crewmate.ojt.dao;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import kr.co.crewmate.ojt.dao.base.BaseDao;
import kr.co.crewmate.ojt.model.Popup;

@Repository
public class PopupDao extends BaseDao{

    public Page<Popup> getListPopup(Popup popupList) {
        return super.selectPageList("Popup.selectPopupList", popupList);
    }

    public Popup getOnePopupForm(Popup popupList) {
        return super.selectOne("Popup.getOnePopupForm", popupList);
    }
    
    public int createOnePopup(Popup popupList) {
        return super.insert("Popup.createOnePopup", popupList);
    }

    public int updateOnePopup(Popup popupList) {
        return super.update("Popup.updateOnePopup", popupList);
    }

    public int deleteOnePopup(String popupSeq) {
        return super.update("Popup.deleteOnePopup", popupSeq);
    }

}
