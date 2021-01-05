package kr.co.crewmate.ojt.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.crewmate.ojt.model.base.Result;
import kr.co.crewmate.ojt.model.nepa.Address;
import kr.co.crewmate.ojt.model.nepa.Code;
import kr.co.crewmate.ojt.model.nepa.UserCodeMap;
import kr.co.crewmate.ojt.model.nepa.Users;
import kr.co.crewmate.ojt.service.nepa.JoinService;
import kr.co.crewmate.ojt.util.Util;

@Controller
public class UserJoinController {

    private static final Logger log = LoggerFactory.getLogger(SampleController.class);
    @Autowired
    private JoinService joinService;

    /**
     * 
     * 회원가입 메인페이지
     *
     * @since 2020. 12. 09.
     * @author johm616
     *
     * @param model
     * @param faq
     * @return
     */
    @RequestMapping({"/nepa/userConfirmForm","/nepa/join/userConfirmForm"})
    public String getJoinUserConfirmForm(Model model, Users users) {

        List<Users> findUserInfo = null;

        if ((users.getUserNm() != null && users.getUserNm() != "") || (users.getHp() != null && users.getHp() != "")) {
            if (users.getHp().length() == 11) {
                users.setHp(users.getHp().replaceFirst("(^[0-9]{3})([0-9]{4})([0-9]{4})$", "$1-$2-$3"));
            }
            findUserInfo = joinService.getUserInfo(users);
        }

        model.addAttribute("findUserInfo", findUserInfo);
        return "/nepa/join/nepaUserJoin";
    }

    /**
     * 
     * 회원가입 약관동의 페이지
     *
     * @since 2020. 12. 09.
     * @author johm616
     *
     * @param model
     * @param faq
     * @return
     */
    @RequestMapping({"/nepa/agreeForm", "/nepa/join/agreeForm"})
    public String getJoinAgreeForm(Model model, Users users) {

        return "/nepa/join/nepaJoinAgreeForm";
    }

    /**
     * 
     * 본인인증화면 보내기
     *
     * @since 2020. 12. 09.
     * @author johm616
     *
     * @param model
     * @param faq
     * @return
     */
    @ResponseBody
    @RequestMapping({"/nepa/getAuthPage", "/nepa/join/getAuthPage"})
    public Result getJoinAuthForm(Model model, Users users) {

        return new Result();
    }

    /**
     * 
     * 본인 인증페이지
     *
     * @since 2020. 12. 09.
     * @author johm616
     *
     * @param model
     * @param faq
     * @return
     */
    @RequestMapping({"/nepa/authForm", "/nepa/join/authForm"})
    public String addJoinAuthForm(Model model, Users users) {

        String addInfoYn = users.getAddInfoYn();
        String marketingYn = users.getMarketingYn();
        if((addInfoYn == "" || addInfoYn == null) &&(marketingYn == "" || marketingYn == null)) {
            return "/nepa/join/nepaJoinAgreeForm";
        }
        
        return "/nepa/join/nepaJoinAuthForm";
    }
    
    /**
     * 
     * 회원정보 입력화면 보내기
     *
     * @since 2020. 12. 09.
     * @author johm616
     *
     * @param model
     * @param faq
     * @return
     */
    @ResponseBody
    @RequestMapping({"/nepa/getInfoPage", "/nepa/join/getInfoPage"})
    public Result getJoinInfoForm(Model model, Users users) {

        return new Result();
    }

    /**
     * 
     * 회원정보 입력 페이지
     *
     * @since 2020. 12. 09.
     * @author johm616
     *
     * @param model
     * @param faq
     * @return
     */
    @RequestMapping({"/nepa/infoForm", "/nepa/join/infoForm"})
    public String addJoinInfoForm(Model model, Users users) {

        String addInfoYn = users.getAddInfoYn();
        String marketingYn = users.getMarketingYn();
        if((addInfoYn == "" || addInfoYn == null) &&(marketingYn == "" || marketingYn == null)) {
            return "/nepa/join/nepaJoinAgreeForm";
        }
        
        Code code = new Code();
        code.setCodeGroup("MAIL_DOMAIN");
        List<Code> mailGroup = joinService.getCodeGroup(code);
        model.addAttribute("mailGroup", mailGroup);
        code.setCodeGroup("JOB");
        List<Code> jobGroup = joinService.getCodeGroup(code);
        model.addAttribute("jobGroup", jobGroup);
        code.setCodeGroup("HOBBY");
        List<Code> hobbyGroup = joinService.getCodeGroup(code);
        model.addAttribute("hobbyGroup", hobbyGroup);

        return "/nepa/join/nepaJoinInfoForm";
    }

    /**
     * 
     * nepa checkDupUserId
     *
     * @since 2020. 12. 010.
     * @author johm616
     *
     * @param model
     * @param faq
     * @return
     */
    @ResponseBody
    @RequestMapping({"/nepa/join/checkDupUserId", "/nepa/join/checkDupUserId"})
    public Result getcheckDupUserId(Model model, Users users) {

        Util.checkEmpty(users.getUserId());
        Result result = new Result(1);
        Map<String, Object> map = new HashMap<>();
        int countId = joinService.getCheckDupUserId(users);

        if (countId > 0) {
            result.setResultCode(-1);
        }
        map.put("countId", countId);
        result.setInfoMap(map);
        model.addAttribute("countId", countId);

        return result;
    }

    /**
     * 
     * nepa InfoForm
     *
     * @since 2020. 12. 09.
     * @author johm616
     *
     * @param model
     * @param faq
     * @return
     */
    @ResponseBody
    @RequestMapping({"/nepa/addInfoForm", "/nepa/join/addInfoForm"})
    public Result addUsersInfoForm(Model model, Users users, Address addr, UserCodeMap codeMap) {

        Result result = new Result(1);
        // 유효성 체크
        Util.checkEmpty(users.getUserId(), users.getUserPw(), users.getHp(), users.getUserNm(), users.getBirthDt(),
                users.getSex(), addr.getAddressDetail(), addr.getAddress(), addr.getZipcode());
        Util.checkYn(users.getMailYn());
        
        // 아이디
        int countId = joinService.getCheckDupUserId(users);
        if (countId > 0) {
            result.setResultCode(-1);
            result.setMessage("중복된 아이디 입니다. 아이디를 확인해주세요.");
            return result;
        }
        // 회원 중복 가입여부 체크
        int countHp = joinService.getCheckDupUserHp(users);
        if(countHp > 0) {
            result.setResultCode(-1);
            result.setMessage("이미 가입된 회원 입니다.");
            return result;
        }
        
        if(StringUtils.equals(users.getChkMailYn(), "Y")) {
            Util.checkEmpty(users.getMailAddr());
            result.setResultCode(-1);
            result.setMessage("이메일 수신을 원하시면 이메일을 입력해주세요.");
        }
        
        if (StringUtils.equals(users.getAddInfoYn(), "Y")) {
            Util.checkYn(users.getWeddingYn());
        }
        
        try {
            joinService.insertUserInfo(users, addr, codeMap);
            result.setResultCode(1);
        } catch(Exception e) {
            result.setResultCode(1000);
            result.setMessage("시스템 오류, 관리자에게 문의하세요.");
        }

        return result;
    }

    /**
     * 
     * nepa InfoForm
     *
     * @since 2020. 12. 09.
     * @author johm616
     *
     * @param model
     * @param faq
     * @return
     */
    @RequestMapping({"/nepa/completeForm", "/nepa/join/completeForm"})
    public String getJoinCompleteForm(Model model, Users users) {

        return "/nepa/join/nepaJoinCompleteForm";
    }
}
