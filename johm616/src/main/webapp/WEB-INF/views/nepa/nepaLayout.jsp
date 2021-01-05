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
<link rel="shortcut icon" href="/images/favicon.ico">
<title>네파 포털</title>
<link rel="stylesheet" href="/nepa/css/default_front.css"
	type="text/css" />
<link rel="stylesheet" href="/nepa/css/layout_front.css" type="text/css" />
<link rel="stylesheet" href="/nepa/css/common_front.css" type="text/css" />
<link rel="stylesheet" href="/nepa/css/sub_front.css" type="text/css" />
<link rel="stylesheet" href="/nepa/css/front_new_2020.css"
	type="text/css" />
<script type="text/javascript" src="/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="/js/jquery-ui-1.12.1.min.js"></script>
<script type="text/javascript" src="/js/common.js"></script>
<tiles:insertDefinition name="boCommonScript" />
<script type="text/javascript" src="/js/form.js"></script>
<script src="http://malsup.github.com/jquery.form.js"></script>
<script type="text/javascript"
	src="/nepa/vendors/jquery/jquery.numeric.min.js"></script>
<script type="text/javascript" src="/nepa/js/common_front.js"></script>
</head>
<body>
	<tiles:insertAttribute name="header" />
	<div class="wrap">
		<div class="content-wrap sub-wrap cs-wrap">
			<div class="content-inner">
				<tiles:insertAttribute name="left" />
				<tiles:insertAttribute name="body" />
			</div>
		</div>
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>