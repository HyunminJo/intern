package kr.co.crewmate.ojt.web.controller;

import java.util.List;

import org.apache.commons.codec.binary.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.crewmate.ojt.model.nepa.Code;
import kr.co.crewmate.ojt.model.nepa.Content;
import kr.co.crewmate.ojt.service.nepa.FaqService;
import kr.co.crewmate.ojt.web.controller.SampleController;

@Controller
public class FaqController {

    private static final Logger log = LoggerFactory.getLogger(SampleController.class);
    @Autowired
    private FaqService faqService;
    
    /**
     * 
     * nepa FAQ
     *
     * @since 2020. 12. 07.
     * @author johm616
     *
     * @param model
     * @param faq
     * @return
     */
    @RequestMapping("/nepa/nepaFAQ")
    public String getNepaFaqList(Model model, Code code, Content content) {
        
        List<Code> faqCodeList = faqService.getFaqCodeList(code);
        List<Content> faqBestList = faqService.getFaqBestList(content);

        for(Content temp : faqBestList) {
            temp.setContent(temp.getContent().replace("\n", "<br>"));
        }
        
        model.addAttribute("faqCodeList", faqCodeList);
        model.addAttribute("faqBestList", faqBestList);
        
        return "/nepa/nepaFAQ";
    }
}
