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
<meta charset="utf-8">
<title>Demomall:팝업창 관리</title>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="Demomall admin">

<link rel="stylesheet" href="/css/bo/common.css" type="text/css">
<link rel="stylesheet" href="/css/bo/theme_typeA.css" type="text/css">
<link rel="stylesheet" href="/css/bo/icons/font-awesome.css"
	type="text/css">
</head>
<body style="padding-top: 0px;">
<div class="container">
	<article class="contents">
		<header class="contents-header">
			<h3 class="heading-title">
				<i class="awesome-large awesome-file"></i>팝업창 관리
			</h3>
			<ol class="location">
				<li><a href="/admin/main"><i class="entypo-home"></i>Home</a></li>
				<li><i class="entypo-right-open-mini"></i>운영관리</li>
				<li><i class="entypo-right-open-mini"></i>공지관리</li>
				<li class="active"><i class="entypo-right-open-mini"></i><strong>팝업창
						관리</strong></li>
			</ol>
		</header>

		<!-- 메뉴아이디 00070103 -->
		<section class="contents-inner">

			<div id="errorMessagesArea"></div>
			<form id="popupSerchForm" name="popupSerchForm" method="post"
				action=${"/sample/listPopup"}>
				<div class="form-group table">
					<table>
						<colgroup>
							<col width="15%">
							<col width="*">
						</colgroup>
						<tr>
							<th>전시일자</th>
							<td><tiles:insertDefinition name="boDateSelect2" />
						</tr>
						<tr>
							<th>팝업구분</th>
							<td><input type="radio" name="layerPopupYn" value=""
								checked="checked" id="layerPopupYn" /><label for="layerPopupYn">전체&nbsp;</label>
								<input type="radio" name="layerPopupYn" value="Y"
								id="layerPopupYn1" /><label for="layerPopupYn1">레이어&nbsp;</label>
								<input type="radio" name="layerPopupYn" value="N"
								id="layerPopupYn2" /><label for="layerPopupYn2">윈도우&nbsp;</label>
							</td>
						</tr>
						<tr>
							<th>전시여부</th>
							<td><input type="radio" name="dispYn" value=""
								checked="checked" id="dispYn" /><label for="dispYn">전체&nbsp;</label>
								<input type="radio" name="dispYn" value="Y" id="dispYn1" /><label
								for="dispYn1">예&nbsp;</label> <input type="radio" name="dispYn"
								value="N" id="dispYn2" /><label for="dispYn2">아니오&nbsp;</label>
							</td>
						</tr>
						<tr>
							<th>팝업창명</th>
							<td><input type="text" name="popupName" id="popupName"
								value="<c:out value='${paramMap.popupName}'/>" max="20"
								style="width: 80%" /></td>
						</tr>
					</table>
					<div class="grid-box">
						<div class="fl-r">
							<input type="submit"
								class="btn btn-blue btn-icon btnSearch btn-submit" value="검색">
							<a href="javascript://" class="btn btn-danger btnReset">초기화</a>
						</div>
					</div>
				</div>
				<div class="orm-group table list mt30">
					<c:set var="listSizeArray2">
						<tiles:getAsString name="listSizeArray" defaultValue="20,50,100" />
					</c:set>
					<c:set var="onChangeFun">
						<tiles:getAsString name="onChangeFun"
							defaultValue="listSizeSelectChange(this);" />
					</c:set>
					<c:set var="attr">
						<tiles:getAsString name="attr" defaultValue="" />
					</c:set>
					<div class="grid-box mb5">
						<div class="fl-l">
							<i class="entypo-search"></i> 전체 <span class="fc-01">${list.totalElements}</span>
							건 (<span class="fc-01">${list.numberOfElements eq 0 ? list.numberOfElements : list.number}/${list.totalPages}</span>
							페이지)
						</div>
						<div class="fl-r">
							<a href="/sample/viewPopupFormReg"
								class="btn btn-primary btn-sm">팝업창 등록</a> <select
								name="listSize" class="listSize" onchange="${onChangeFun }"
								${attr }>
								<c:forEach items="${fn:split(listSizeArray2,',') }" var="i"
									varStatus="s">
									<option value="${i}"
										<c:if test="${productList.size eq i}">selected</c:if>>${i}개씩
										보기</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<table class="group-center">
						<colgroup>
							<col width="8%" />
							<col width="10%" />
							<col width="10%" />
							<col width="*" />
							<col width="15%" />
							<col width="15%" />
							<col width="10%" />
							<col width="15%" />
						</colgroup>
						<tr>
							<th>번호</th>
							<th>팝업구분</th>
							<th>전시여부</th>
							<th>팝업창명</th>
							<th>전시시작일시</th>
							<th>전시종료일시</th>
							<th>등록자ID</th>
							<th>등록일시</th>
						</tr>

						<c:if test="${empty listPopup.content }">
							<tr>
								<td colspan="8">등록된 데이터가 없습니다.</td>
							</tr>
						</c:if>
						<c:if test="${!empty listPopup.content}">
							<c:forEach items="${listPopup.content}" var="list"
								varStatus="status">
								<tr>
									<td><c:out
											value="${listPopup.totalElements - ((listPopup.number - 1) * listPopup.size) - status.index }" /></td>
									<td><c:out
											value="${list.layerPopupYn eq 'Y'? '레이어' : '윈도우'}" /></td>
									<td><c:out value="${list.dispYn eq 'Y'? '예' : '아니오'}" /></td>
									<td class="align-left"><a
										href="/sample/viewPopupFormMod?popupSeq=${list.popupSeq}&searchData=<core:param encode="true" />"
										class="fc-02 bold link" value="">${list.popupName}</a></td>
									<td>${list.dispStartDtm}</td>
									<td>${list.dispEndDtm}</td>
									<td>${list.writeAdminId}</td>
									<td>${list.rgstDtm}</td>
								</tr>
							</c:forEach>
						</c:if>
					</table>
					<div class="pagination clearfix align-center">
						<div class="table-pagination">
							<!-- <a href="javascript://" class="paginate_button current">1</a> -->
							<core:pagination listResultName="listPopup" />
						</div>
					</div>
				</div>
			</form>

		</section>
	</article>
</div>
<script type="text/javascript" src="/js/form.js"></script>
<script type="text/javascript">
$(document).ready(function(event) {
	// 팝업구분
	let layerPopupYn = '${paramMap.layerPopupYn}';
	console.log(layerPopupYn);
	if (layerPopupYn == "N") {
		$("#layerPopupYn2").attr("checked", true);
	} else if (layerPopupYn == "Y") {
		$("#layerPopupYn1").attr("checked", true);
	} else {
		$("#layerPopupYn").attr("checked", true);
	}
	//전시여부
	let dispYn = '${paramMap.dispYn}';
	if (dispYn === 'N') {
		$("#dispYn2").attr("checked", true);
	} else if (dispYn == 'Y') {
		$("#dispYn1").attr("checked", true);
	} else {
		$("#dispYn").attr("checked", true);
	}
	// 초기화
	$(".btnReset").click(function(event){
		formClear($("form[name=popupSerchForm]"));
	});
	// 날짜 검색 유효성체크
	$(".date-from").on("change", function() {
		if($('.date-to').val() == '') {
			$(".date-to").val($(this).val());
		} else {
			if($(this).val() > $(".date-to").val()) {
				alert("시작일은 종료일보다 클 수 없습니다.");
				$(this).val($(".date-to").val());
			}
		}
	});
	// 날짜 검색 유효성체크
	$(".date-to").on("change", function() {
		if($(".date-from").val() == '') {
			$(".date-from").val($(this).val());
		} else {
			if($(this).val() < $(".date-from").val()) {
				alert("시작일은 종료일보다 클 수 없습니다.");
				$(this).val($(".date0from").val());
			}
		}		
	});
	// 날짜 검색 유지
	let dispStartDtm = '${paramMap.dispStartDtm}';
	let dispEndDtm = '${paramMap.dispEndDtm}';
	let arrayStart = dispStartDtm.split('.');
	let arrayEnd = dispEndDtm.split('.');
	let temp = "", temp2 = "";
	for(var i = 0; i < arrayStart.length; i++) {
		temp += arrayStart[i];
		temp2 += arrayEnd[i];
	}
	dispStartDtm = temp;
	dispEndDtm = temp2;
	$("input[name='dispStartDtm']").val(dispStartDtm);
	$("input[name='dispEndDtm']").val(dispEndDtm);
});
</script>

</body>
</html>