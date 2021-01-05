package kr.co.crewmate.ojt.service.nepa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.crewmate.ojt.dao.nepa.FaqDao;
import kr.co.crewmate.ojt.model.nepa.Code;
import kr.co.crewmate.ojt.model.nepa.Content;

@Service
public class FaqService {
    
    @Autowired
    FaqDao faqDao;

    public List<Content> getFaqBestList(Content content) {
        return faqDao.getFaqBestList(content);
    }

    public List<Code> getFaqCodeList(Code code) {
        return faqDao.getFaqCodeList(code);
    }

}
