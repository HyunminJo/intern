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
<!-- 160905 수정 : 메타 태그 값 수정 -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- 160905 추가 : IE 호환성 모드 추가 -->
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<title>네파 포털 | 고객센터</title>
<!-- <link rel="stylesheet" href="/css/bo/common.css" type="text/css">
<link rel="stylesheet" href="/css/bo/theme_typeA.css" type="text/css">
<link rel="stylesheet" href="/css/bo/icons/font-awesome.css"
	type="text/css"> -->
<link rel="stylesheet" href="/nepa/css/default_front.css"
	type="text/css" />
<link rel="stylesheet" href="/nepa/css/layout_front.css" type="text/css" />
<link rel="stylesheet" href="/nepa/css/common_front.css" type="text/css" />
<link rel="stylesheet" href="/nepa/css/sub_front.css" type="text/css" />
<link rel="stylesheet" href="/nepa/css/front_new_2020.css"
	type="text/css" />
</head>
<body>


				<div class="indicator-wrap" style="position: absolute;">
					<ul class="indicator-list">
						<li><a href="#">홈</a></li>
						<!-- 160628 추가 : 홈 아이콘 추가 -->
						<li><a href="#">고객센터</a></li>
						<li class="last">FAQ</li>
					</ul>
				</div>
				
				<div class="cs-content-right">
					<!-- TITLE -->
					<div class="title">FAQ</div>
					<!-- //TITLE -->
					<!-- Search -->
					<div class="faq-search-wrap">
						<input type="text" id="keyword" value="${paramMap.keyword }">
						<button type="button" class="btn btnx-xmd btn-gray"
							onclick="changeTap($('#keyword').val(), '');">검색</button>
					</div>
					<!-- //Search -->
					<!-- 분류 -->
					<div class="faq-type-list-wrap">
						<ul class="faq-type-list">
							<li
								<c:if test="${empty paramMap.contentGroup and empty paramMap.keyword}">class="here"</c:if>><a
								href="#" class="btn" onclick="changeTap('','')">FAQ BEST 10</a></li>
							<c:forEach items="${faqCodeList}" var="faqCode"
								varStatus="status">
								<li <c:if test="${paramMap.contentGroup eq faqCode.code}">class="here"</c:if>><a href="#" class="btn"
									onclick="changeTap('${paramMap.keyword}','${faqCode.code}');">
										<c:out value="${faqCode.name}" />
								</a></li>
							</c:forEach>
						</ul>
					</div>
					<!-- //분류 -->
					<!-- 리스트 -->
					<div class="faq-list-wrap">
						<span class="faq-type-name"> FAQ <span class="text-mint">
							<c:choose>
								<c:when test="${!empty paramMap.contentGroup}">
									<c:forEach items="${faqCodeList}" var="faqCode"
										varStatus="status">
											<c:if test="${paramMap.contentGroup eq faqCode.code }">
												<c:out value="${faqCode.name}" />
											</c:if>
										</c:forEach>
									</c:when>
								<c:otherwise>
									<c:if test="${empty paramMap.keyword}">
										BEST 10
									</c:if>
								</c:otherwise>
							</c:choose>
						</span>
						</span>
						<!-- 검색 결과 -->
						<span class="faq-search-result" 
						<c:if test="${empty paramMap.keyword}">
						style="display:none;"</c:if>> <span
							class="text-red bold"><c:out value="'${paramMap.keyword}'"/></span> 의 검색결과 <span
							class="text-black bold"><c:out value="(${faqBestList.size()})"/></span>
						</span>
						<!-- //검색 결과 -->
						<div class="faq-list-wrap-inner">
							<dl class="faq-list fold-list">
								<c:forEach items="${faqBestList}" var="list" varStatus="status">
									<dt class="">
										<a href="#" class="btn"> <span class="faq-type"><c:out
													value="${list.title}" /></span>
										</a>
									</dt>
									<dd>
										<c:out value="${list.content}" />
									</dd>
								</c:forEach>
							</dl>
						</div>
					</div>
					<!-- // -->
				</div>
				<!-- //구조 변경 20160628 -->

	<script type="text/javascript" src="/js/jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="/js/jquery-ui-1.12.1.min.js"></script>
	<script type="text/javascript" src="/js/common.js"></script>
	<tiles:insertDefinition name="boCommonScript" />
	<script type="text/javascript" src="/js/form.js"></script>
	<script src="http://malsup.github.com/jquery.form.js"></script>
	<script type="text/javascript"
		src="/nepa/vendors/jquery/jquery.numeric.min.js"></script>
	<script type="text/javascript" src="/nepa/js/common_front.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$(".faq-type-list li a").on("click", function(event) {
				if (!$(this).parent().hasClass("here")) {
					$(".faq-type-list li").removeClass("here");
					$(this).parent().addClass("here");
					console.log($(this).text());
				}
			});

			$(".faq-list dt a").on("click", function(event) {
				var isOpened = $(this).parent().hasClass("opened");
				$(".faq-list dt").removeClass("opened");
				if (!isOpened) {
					$(this).parent().addClass("opened");
				}
			});
		});

		//탭변경
		function changeTap(keyword, contentGroup) {
			if (contentGroup != '') {
				keyword = $('#keyword').val();
			}
			location.href = '/nepa/nepaFAQ?keyword=' + keyword
					+ '&contentGroup=' + contentGroup;
		}
	</script>
</body>
</html>