package kr.co.crewmate.ojt.dao.nepa;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.crewmate.ojt.dao.base.BaseDao;
import kr.co.crewmate.ojt.model.nepa.Address;
import kr.co.crewmate.ojt.model.nepa.Code;
import kr.co.crewmate.ojt.model.nepa.UserCodeMap;
import kr.co.crewmate.ojt.model.nepa.Users;

@Repository
public class JoinDao extends BaseDao{

    public List<Users> getUserInfo(Users users) {
        return super.selectList("Join.selectJoinUserInfo", users);
    }

    public int getCheckDupUserId(Users users) {
        return super.selectOne("Join.selectUsersId", users);
    }

    public List<Code> getCodeGroup(Code code) {
        return super.selectList("Join.selectCodeGroup", code);
    }

    public String selectOneUserNo(Users users) {
        return super.selectOne("Join.selectOneUserNo", users);
    }

    public int insertUserInfo(Users users) {
        return super.insert("Join.insertUserInfo", users);
    }

    public int insertUserAddr(Address addr) {
        return super.insert("Join.insertUserAddr", addr);
    }

    public int insertUserCodeMap(UserCodeMap codeMap) {
        return super.insert("Join.insertUserCodeMap", codeMap);
    }

    public String selectOneAddrNo(Address addr) {
        return super.selectOne("Join.selectOneAddrNo", addr);
    }

    public int getCheckDupUserHp(Users users) {
        return super.selectOne("Join.selectUsersHp", users);
    }

    public List<Users> selectUsersList() {
        return super.selectList("Join.selectUsersList");
    }

}
