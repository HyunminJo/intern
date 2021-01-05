package kr.co.crewmate.ojt.web.controller;

import org.apache.commons.codec.binary.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.crewmate.ojt.constants.Constants;
import kr.co.crewmate.ojt.model.BoardArticle;
import kr.co.crewmate.ojt.model.base.Result;
import kr.co.crewmate.ojt.service.ExBoardArticleService;
import kr.co.crewmate.ojt.util.Util;
import kr.co.crewmate.ojt.web.exception.BadRequestException;


@Controller
public class ExBoardController {

    private static final Logger log = LoggerFactory.getLogger(ExBoardController.class);
    private final String BOARDID = "lkj";
    
    @Autowired
    ExBoardArticleService exBoardArticleService;
    
    /**
     * 
     * 게시판 목록 연습
     * 
     * @since 2020.11.28
     * @author johm616
     * 
     * @param model
     * @param boardArticle
     * @return
     */
    @RequestMapping("/sample/exerciseBoard")
    public String exBoardList(Model model, BoardArticle boardArticle) {
        
        boardArticle.setBoardId(BOARDID);
        Page<BoardArticle> list = exBoardArticleService.getBoardArticleList(boardArticle);
        model.addAttribute("list", list);
        
        return "/sample/boardExercise";
    }
    
    /**
     * 
     * 게시판 폼
     * 
     * @since 2020.11.28
     * @author johm616
     * 
     * @param model
     * @param boardArticle
     * @return
     */
    @RequestMapping({"/sample/exBoardFormReg", "/sample/exBoardFormMod"})
    public String addBoardForm(Model model, BoardArticle boardArticle) {
        
        BoardArticle data = new BoardArticle();
        
        if(StringUtils.equals(Constants.Mode.UPDATE, boardArticle.getMode())) {
            boardArticle.setBoardId(BOARDID);
            data = exBoardArticleService.getOneBoardArticle(boardArticle.getBoardArtclSeq());
            if(data == null) {
                throw new BadRequestException(Constants.ExMsg.DATA_EMPTY);
            }
            exBoardArticleService.updateExBoardArticleHits(boardArticle);
        }
        model.addAttribute("data", data);
        
        return "/sample/boardFormExercise";
    }
    
    /**
     * 
     * 게시판 등록, 수정
     * 
     * @since 2020.11.28
     * @author johm616
     * 
     * @param model
     * @param boardArticle
     * @return
     */
    @ResponseBody
    @RequestMapping({"/sample/exBoardCreate", "/sample/exBoardUpdate"})
    public Result addExBoardSave(BoardArticle boardArticle) {
        
        Util.checkEmpty(boardArticle.getBoardArtclTitle(), boardArticle.getBoardArtclCont(), boardArticle.getWrtrName());
        boardArticle.setBoardId(BOARDID);
        Result result = new Result(100);
        
        // 등록
        if(StringUtils.equals(Constants.Mode.CREATE, boardArticle.getMode())) {
            result = this.exBoardArticleService.createExBoard(boardArticle);
        }
        
        // 수정
        if(StringUtils.equals(Constants.Mode.UPDATE, boardArticle.getMode())) {
            result = this.exBoardArticleService.updateExBoard(boardArticle);
        }
        return result;
    }
    
    /**
     * 
     * 게시판 삭제
     * 
     * @since 2020.11.28
     * @author johm616
     * 
     * @param model
     * @param boardArticle
     * @return
     */
    @ResponseBody
    @RequestMapping({"/sample/exBoardDelete", "/sample/exBoardFail"})
    public Result deleteExBoard(BoardArticle boardarticle) {
        
        boardarticle.setBoardId(BOARDID);
        Result result = new Result(100);
        
        result = this.exBoardArticleService.deleteExBoard(boardarticle);

        return result;
    }
}
