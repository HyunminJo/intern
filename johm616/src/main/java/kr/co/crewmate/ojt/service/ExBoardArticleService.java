package kr.co.crewmate.ojt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import kr.co.crewmate.ojt.dao.ExBoardArticleDao;
import kr.co.crewmate.ojt.model.BoardArticle;
import kr.co.crewmate.ojt.model.base.Result;

@Service
public class ExBoardArticleService {

    @Autowired
    ExBoardArticleDao exBoardArticleDao;
    
    public Page<BoardArticle> getBoardArticleList(BoardArticle boardArticle) {
        return exBoardArticleDao.getBoardArticleList(boardArticle);
    }

    public BoardArticle getOneBoardArticle(int boardSeq) {
        return exBoardArticleDao.getOndeBoardArticle(boardSeq);
    }

    public void updateExBoardArticleHits(BoardArticle boardArticle) {
        exBoardArticleDao.updateExBoardArticleHits(boardArticle);
    }

    public Result createExBoard(BoardArticle boardArticle) {
        exBoardArticleDao.createExBoard(boardArticle);
        return new Result();
    }

    public Result updateExBoard(BoardArticle boardArticle) {
        exBoardArticleDao.updateExBoard(boardArticle);
        return new Result();
    }

    public Result deleteExBoard(BoardArticle boardarticle) {
        exBoardArticleDao.deleteExBoard(boardarticle);
        return new Result();
    }

}
