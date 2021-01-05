package kr.co.crewmate.ojt.web.controller;

import org.apache.commons.codec.binary.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.crewmate.ojt.constants.Constants;
import kr.co.crewmate.ojt.model.BoardArticle;
import kr.co.crewmate.ojt.model.base.Result;
import kr.co.crewmate.ojt.service.FreeBoardArticleService;
import kr.co.crewmate.ojt.util.Util;
import kr.co.crewmate.ojt.web.exception.BadRequestException;

@Controller
public class FreeBoardController {

    private static final Logger log = LoggerFactory.getLogger(FreeBoardController.class);
    private final String BOARDID = "lkj";

    @Autowired
    FreeBoardArticleService freeBoardArticleService;

    /**
     * 
     * sample 게시판 목록
     *
     * @since 2020. 10. 28.
     * @author kjh8877
     *
     * @param model
     * @param boardArticle
     * @return
     */
    @RequestMapping({ "/sample/freeBoardList", "/sample/freeBoardList/popup" })
    public String freeBoardList(Model model, BoardArticle boardArticle) {

        boardArticle.setBoardId(BOARDID);
        Page<BoardArticle> list = freeBoardArticleService.getBoardArticleList(boardArticle);

        model.addAttribute("list", list);

        return "/sample/freeBoardList";
    }

    /**
     * 
     * sample 게시판 등록/수정 페이지
     *
     * @since 2020. 10. 28.
     * @author kjh8877
     *
     * @param model
     * @param boardArticle
     * @return
     */
    @RequestMapping({ "/sample/freeBoardFormReg", "/sample/freeBoardFormMod" })
    public String boardForm(Model model, BoardArticle boardArticle) {

        BoardArticle data = new BoardArticle();

        if (StringUtils.equals(Constants.Mode.UPDATE, boardArticle.getMode())) {
            boardArticle.setBoardId(BOARDID);
            data = freeBoardArticleService.getBoardOne(boardArticle.getBoardArtclSeq());
            if (data == null) {
                throw new BadRequestException(Constants.ExMsg.DATA_EMPTY);
            }
            freeBoardArticleService.updateBoardArticleHits(boardArticle);
        }

        model.addAttribute("data", data);

        return "/sample/freeBoardForm";
    }

    /**
     * 
     * sample 게시판 등록/수정
     *
     * @since 2020. 10. 28.
     * @author kjh8877
     *
     * @param board
     * @return
     */
    @ResponseBody
    @RequestMapping({ "/sample/freeBoardCreate", "/sample/freeBoardUpdate" })
    public Result boContSave(BoardArticle board) {
        // 유효성 체크
        Util.checkEmpty(board.getBoardArtclTitle(), board.getBoardArtclCont(), board.getWrtrName());
        board.setBoardId(BOARDID);
        Result result = new Result(100);

        // 공지사항 등록
        if (StringUtils.equals(Constants.Mode.CREATE, board.getMode())) {
            result = this.freeBoardArticleService.createBoard(board);
        }

        // 공지사항 수정
        if (StringUtils.equals(Constants.Mode.UPDATE, board.getMode())) {
            result = this.freeBoardArticleService.updateBoard(board);
        }

        return result;
    }

    /**
     * 
     * sample 게시판 삭제
     *
     * @since 2020. 10. 28.
     * @author kjh8877
     *
     * @param board
     * @return
     */
    @ResponseBody
    @RequestMapping({ "/sample/freeBoardDelete", "/sample/freeBoardFail" })
    public Result boContDelete(BoardArticle board, Model model) {
        // 유효성 체크
        board.setBoardId(BOARDID);
        Result result = new Result(100);
        
        result = this.freeBoardArticleService.deleteBoard(board);

        return result;
    }
}
