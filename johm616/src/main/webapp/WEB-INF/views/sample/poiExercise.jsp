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
<title>poi를 사용한 대용량 엑셀 다운</title>
<link rel="stylesheet" href="/nepa/css/default_front.css"
	type="text/css" />
<link rel="stylesheet" href="/nepa/css/layout_front.css" type="text/css" />
<link rel="stylesheet" href="/nepa/css/common_front.css" type="text/css" />
<link rel="stylesheet" href="/nepa/css/sub_front.css" type="text/css" />
<link rel="stylesheet" href="/nepa/css/front_new_2020.css"
	type="text/css" />
</head>
<body>
	<ul>
		<li><span>엑셀 출력 방법 1(SXSSFWorkbook)</span>
			<button id="btn-excel">엑셀 다운로드1</button></li>
		<li><span>엑셀 출력 방법 2(XSSFWorkbook)</span>
			<button>
				<a href="/sample/exportExcel1"> 엑셀 다운로드2</a>
			</button></li>
		<li><span>엑셀 출력 방법 3(XSSFWorkbook)</span>
			<button>
				<a href="/sample/exportExcel4"> 엑셀 다운로드2</a>
			</button></li>
	</ul>
	<!-- 파일 생성중 보여질 진행막대를 포함하고 있는 다이얼로그 입니다. -->
	<div title="Data Download" id="preparing-file-modal"
		style="display: none;">
		<div id="progressbar"
			style="width: 100%; height: 22px; margin-top: 20px;"></div>
	</div>
	<!-- 에러발생시 보여질 메세지 다이얼로그 입니다. -->
	<div title="Error" id="error-modal" style="display: none;">
		<p>생성실패.</p>
	</div>


	<link rel="stylesheet" href="<c:url value='/js/jquery-ui.min.css'/>" />
	<script src="<c:url value="/js/jquery-3.1.0.min.js"/>"></script>
	<script src="<c:url value="/js/jquery-ui.min.js"/>"></script>
	<script src="<c:url value="/js/jquery.fileDownload.js"/>"></script>
	<script type="text/javascript">
		//<![CDATA[ 
		$(function() {
			$("#btn-excel").on("click", function() {
				var $preparingFileModal = $("#preparing-file-modal");
				$preparingFileModal.dialog({
					modal : true
				});
				$("#progressbar").progressbar({
					value : false
				});
				$.fileDownload("/sample/exportExcel2", {
					successCallback : function(url) {
						$preparingFileModal.dialog('close');
					},
					failCallback : function(responseHtml, url) {
						$preparingFileModal.dialog('close');
						$("#error-modal").dialog({
							modal : true
						});
					}
				});
				// 버튼의 원래 클릭 이벤트를 중지 시키기 위해 필요합니다. 
				return false;
			});
		});
		//]]>
	</script>
</body>
</html>