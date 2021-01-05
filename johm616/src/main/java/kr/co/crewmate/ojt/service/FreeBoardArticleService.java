package kr.co.crewmate.ojt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import kr.co.crewmate.ojt.dao.FreeBoardArticleDao;
import kr.co.crewmate.ojt.model.BoardArticle;
import kr.co.crewmate.ojt.model.base.Result;

@Service
public class FreeBoardArticleService {

    @Autowired
    FreeBoardArticleDao freeBoardArticleDao;

    public Page<BoardArticle> getBoardArticleList(BoardArticle boardArticle) {
        return freeBoardArticleDao.selectFreeBoardArticleList(boardArticle);
    }

    public BoardArticle getBoardOne(int seq) {
        return freeBoardArticleDao.selectFreeBoardOne(seq);
    }

    public void updateBoardArticleHits(BoardArticle boardArticle) {
        freeBoardArticleDao.updateBoardArticleHits(boardArticle);
    }

    public Result createBoard(BoardArticle board) {
        freeBoardArticleDao.insertBoardReply(board);
        
        return new Result();
    }

    public Result updateBoard(BoardArticle board) {
        freeBoardArticleDao.updateBoard(board);
        
        return new Result();
    }

    public Result deleteBoard(BoardArticle board) {
        freeBoardArticleDao.deleteBoard(board);
        return new Result();
    }
    
}
