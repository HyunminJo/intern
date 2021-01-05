<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="/crewmate/core" prefix="core" %>

<div class="lnb-wrap">
    <div class="lnb-inner">
        <ul class="lnb-list">
            <li class="open">
                <a href="javascript://">게시판</a>
                <ul class="lnb-sub">
                    <li>
                        <a href="/sample/boardList">- <span class="menu-name">게시판 sample</span></a>
                    </li>
                    <li>
                        <a href="/sample/freeBoardList">- <span class="menu-name">자유게시판</span></a>
                    </li>
                    <li>
                        <a href="/sample/productSample">- <span class="menu-name">상품등록</span></a>
                    </li>
                    <li>
                    	<a href="/sample/productForm">- <span class="menu-name">상품등록연습</span></a>
                    </li>
                    <li>
                    	<a href="/sample/exerciseBoard">- <span class="menu-name">보드연습</span></a>
                    </li>
                    <li>
                    	<a href="/sample/listPopup">- <span class="menu-name">팝업창 관리</span></a>
                    </li>
                    <li>
                    	<a href="/nepa/nepaFAQ">- <span class="menu-name">nepa FAQ</span></a>
                    </li>
                    <li>
                    	<a href="/nepa/join/userConfirmForm">- <span class="menu-name">nepa 회원가입</span></a>
                    </li>
                    <li>
                    	<a href="/sample/poiExercise">- <span class="menu-name">poi 연습</span></a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
    <a href="javascript://" class="btn-lnb-ctrl"></a>
</div>