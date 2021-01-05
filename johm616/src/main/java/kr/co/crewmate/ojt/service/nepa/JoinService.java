package kr.co.crewmate.ojt.service.nepa;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.crewmate.ojt.dao.nepa.JoinDao;
import kr.co.crewmate.ojt.model.nepa.Address;
import kr.co.crewmate.ojt.model.nepa.Code;
import kr.co.crewmate.ojt.model.nepa.UserCodeMap;
import kr.co.crewmate.ojt.model.nepa.Users;
import kr.co.crewmate.ojt.util.HashUtil;

@Service
public class JoinService {

    @Autowired
    private JoinDao joinDao;

    public List<Users> getUserInfo(Users users) {
        return joinDao.getUserInfo(users);
    }

    public int getCheckDupUserId(Users users) {
        return joinDao.getCheckDupUserId(users);
    }

    public List<Code> getCodeGroup(Code code) {
        return joinDao.getCodeGroup(code);
    }

    public void insertUserInfo(Users users, Address addr, UserCodeMap codeMap) {
        String thisUserNo = joinDao.selectOneUserNo(users);
        Date date = new Date();
        String todayFormat = DateFormatUtils.format(date, "yyyyMMddhhmmss");

        users.setUserNo(thisUserNo);
        codeMap.setUserNo(thisUserNo);
        addr.setUserNo(thisUserNo);

        insertUserInfo(users, todayFormat, thisUserNo);
        insertUserCodeMap(codeMap, users);
        insertUserAddr(addr, users, todayFormat);
    }

    private void insertUserInfo(Users users, String todayFormat, String thisUserNo) {

        String userPw = HashUtil.sha512(users.getUserPw());

        users.setUserPw(userPw);
        users.setUserGroup("COMMON");
        users.setUserStat("10");
        users.setLastPwChangeDt(todayFormat);
        users.setHp(users.getHp());
        users.setRegDt(todayFormat);
        users.setModNo(thisUserNo);
        users.setModDt(todayFormat);
        users.setAddInfoYn("N");
        users.setWeddingDt(users.getWeddingDt());
        users.setBirthDt(users.getBirthDt());
        users.setUserPwInitYn("N");
        users.setMailAddr(users.getMailAddr());

        joinDao.insertUserInfo(users);
    }

    private void insertUserAddr(Address addr, Users users, String todayFormat) {

        addr.setAddrNm("기본배송지");
        addr.setRecvNm(users.getUserNm());
        addr.setHp(users.getHp());
        addr.setDefaultYn("Y");
        addr.setRegDt(todayFormat);

        joinDao.insertUserAddr(addr);
    }

    private void insertUserCodeMap(UserCodeMap codeMap, Users users) {

        codeMap.setCodeGroup("JOB");
        if("09".equals(users.getJobGroup())) {
            codeMap.setCodeDesc(users.getJobDesc());
        }
        codeMap.setCode(users.getJobGroup());
        codeMap.setCodeGroup("HOBBY");
        for (String hobby : users.getHobbys()) {
            if ("15".equals(hobby)) {
                codeMap.setCodeDesc(users.getHobbyDesc());
            }
            codeMap.setCode(hobby);
            joinDao.insertUserCodeMap(codeMap);
        }
    }

    public int getCheckDupUserHp(Users users) {
        return joinDao.getCheckDupUserHp(users);
    }

    public List<Users> selectUsersList() {
        return joinDao.selectUsersList();
    }
}
