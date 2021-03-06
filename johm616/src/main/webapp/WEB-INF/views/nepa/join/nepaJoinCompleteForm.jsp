<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/crewmate/core" prefix="core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta name="viewport"
	content="user-scalable=yes, maximum-scale=1.0, width=1280">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<title>네파 회원정보 입력</title>
<link rel="stylesheet" href="/nepa/css/default_front.css"
	type="text/css" />
<link rel="stylesheet" href="/nepa/css/layout_front.css" type="text/css" />
<link rel="stylesheet" href="/nepa/css/common_front.css" type="text/css" />
<link rel="stylesheet" href="/nepa/css/sub_front.css" type="text/css" />
<link rel="stylesheet" href="/nepa/css/front_new_2020.css"
	type="text/css" />
</head>
<body>
	<div class="content-wrap sub-wrap bg-join-complete">
		<div class="content-inner">
			<div class="indicator-wrap">
				<ul class="indicator-list">
					<li><a href="#"><img
							src="/images/common/front_home_indicator.png"
							alt="홈 아이콘" /> 홈</a></li>
					<!-- 160628 추가 : 홈 아이콘 추가 -->
					<li class="last">회원가입</li>
				</ul>
			</div>
			<h2 class="title">NEPA 통합회원가입</h2>
			<div class="step-wrap mgt-30">
				<ul class="step-list step-4 step-join">
					<li>
						<div class="step-inner step1">
							<span>STEP 01. 회원약관동의</span>
						</div>
					</li>
					<li>
						<div class="step-inner step2">
							<span>STEP 02. 본인인증</span>
						</div>
					</li>
					<li>
						<div class="step-inner step3">
							<span>STEP 03. 회원정보 입력</span>
						</div>
					</li>
					<li class="here last">
						<div class="step-inner step4">
							<span>STEP 04. 가입완료</span>
						</div>
					</li>
				</ul>
			</div>
			<!-- 인증 폼 -->
			<div class="complete-wrap">
				<p class="desc-title">
					<img src="/images/common/front_icon_join_complete.png"
						alt="NEPA mall" /> 통합 회원가입이 되신 것을 환영합니다!
				</p>
				<p class="desc-txt">
					입력하신 개인정보는 “마이페이지 > 회원정보확인”에서 확인이 가능합니다. <br />항상 최선을 다하는
					NEPAmall이 되겠습니다.
				</p>
			</div>
			<div class="btn-wrap">
				<!-- 160621 수정 : 홈 버튼 width 180px로 수정 -->
				<button type="button" class="btn btn-lg btn-white"
					style="width: 180px;">NEPAmall 홈</button>
				<button type="button" class="btn btn-lg btn-gray"
					style="width: 175px;">로그인</button>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="/js/jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="/js/jquery-ui-1.12.1.min.js"></script>
	<script type="text/javascript" src="/js/common.js"></script>
	<tiles:insertDefinition name="boCommonScript" />
	<script type="text/javascript" src="/js/form.js"></script>
	<script src="http://malsup.github.com/jquery.form.js"></script>
	<script type="text/javascript"
		src="/nepa/vendors/jquery/jquery.numeric.min.js"></script>
	<script type="text/javascript" src="/nepa/js/common_front.js"></script>
	<script src="https://spi.maps.daum.net/imap/map_js_init/postcode.v2.js"></script>
</body>
</html>