package kr.co.crewmate.ojt.dao;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import kr.co.crewmate.ojt.dao.base.BaseDao;
import kr.co.crewmate.ojt.model.BoardArticle;
import kr.co.crewmate.ojt.model.base.Result;

@Repository
public class ExBoardArticleDao extends BaseDao {

    public Page<BoardArticle> getBoardArticleList(BoardArticle boardArticle) {
        return super.selectPageList("ExBoardArticle.selectExBoardArticleList", boardArticle);
    }

    public BoardArticle getOndeBoardArticle(int boardSeq) {
        return super.selectOne("ExBoardArticle.selectOneExBoardArticle", boardSeq);
    }

    public void updateExBoardArticleHits(BoardArticle boardArticle) {
        super.update("ExBoardArticle.updateExBoardArticleHits", boardArticle);
    }

    public int createExBoard(BoardArticle boardArticle) {
        return super.insert("ExBoardArticle.createExBoard", boardArticle);
    }

    public int updateExBoard(BoardArticle boardArticle) {
        return super.update("ExBoardArticle.updateExBoard", boardArticle);
    }

    public int deleteExBoard(BoardArticle boardarticle) {
        return super.delete("ExBoardArticle.deleteExBoard", boardarticle);
    }

}
