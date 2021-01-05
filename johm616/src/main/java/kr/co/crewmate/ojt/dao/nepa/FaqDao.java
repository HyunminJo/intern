package kr.co.crewmate.ojt.dao.nepa;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.crewmate.ojt.dao.base.BaseDao;
import kr.co.crewmate.ojt.model.nepa.Code;
import kr.co.crewmate.ojt.model.nepa.Content;

@Repository
public class FaqDao extends BaseDao{

    public List<Content> getFaqBestList(Content content) {
        return super.selectList("Faq.selectFaqBestList", content);
    }

    public List<Code> getFaqCodeList(Code code) {
        return super.selectList("Faq.selectFaqCodeList", code);
    }

}
