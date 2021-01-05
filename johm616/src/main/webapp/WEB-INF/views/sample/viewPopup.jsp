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
<link rel="stylesheet" href="/css/bo/icons/font-awesome.css" type="text/css">
<script type="text/javascript" src="/js/calendar.js"></script>
</head>
<body style="padding-top: 0px;">
	<div class="container">
		<article class="contents">
			<header class="contents-header">
				<h3 class="heading-title">
					<i class="awesome-large awesome-file"></i>팝업창 관리
				</h3>
				<ol class="location">
					<li><a href="/admin/main"><i class="entypo-home"></i>Home</a>
					</li>
					<li><i class="entypo-right-open-mini"></i>운영관리</li>
					<li><i class="entypo-right-open-mini"></i>공지관리</li>
					<li class="active"><i class="entypo-right-open-mini"></i><strong>팝업창
							관리</strong></li>
				</ol>
			</header>
			<!-- 메뉴아이디 00070103 -->
			<section class="contents-inner">
				<div id="errorMessagesArea"></div>
				<div class="form-group table">
					<form id="createPopupForm" name="createPopupForm" method="post">
						<c:choose>
							<c:when test="${mode eq 'create'}">
								<input type="hidden" name="mode" value="create" />
							</c:when>
							<c:otherwise>
								<input type="hidden" name="mode" value="update" />
							</c:otherwise>
						</c:choose>
						<table>
							<colgroup>
								<col width="15%" />
								<col width="*" />
								<col width="15%" />
								<col width="35%" />
							</colgroup>
							<tr>
								<th>전시일시<i class="entypo-check"></i></th>
								<td colspan="3">
									<tiles:insertDefinition name="boDateSelect3" />
								</td>
							</tr>
							<tr>
								<th>팝업구분</th>
								<td><input type="radio" name="layerPopupYn" value="Y"
									checked="checked" id="layerPopupYn1" /><label
									for="layerPopupYn1">레이어&nbsp;</label> <input type="radio"
									name="layerPopupYn" value="N" id="layerPopupYn2" /><label
									for="layerPopupYn2">윈도우&nbsp;</label></td>
								<th>전시여부</th>
								<td><input type="radio" name="dispYn" value="Y"
									checked="checked" id="dispYn1" /><label for="dispYn1">예&nbsp;</label>
									<input type="radio" name="dispYn" value="N" id="dispYn2" /><label
									for="dispYn2">아니오&nbsp;</label></td>
							</tr>
							<tr>
								<th>팝업크기<i class="entypo-check"></i></th>
								<td>
									<p class="mb5">
										가로 : <input type="text" name="popupSizeX"
											value="${onePopupForm.popupSizeX}" class="inputNumberText"
											maxlength="4" /><br>
									</p>
									<p>
										세로 : <input type="text" name="popupSizeY"
											value="${onePopupForm.popupSizeY}" class="inputNumberText"
											maxlength="4" />
									</p>
								</td>
								<th>팝업 시작점<i class="entypo-check"></i></th>
								<td>
									<p class="mb5">
										상단 : <input type="text" name="popupPosX"
											value="${onePopupForm.popupPosX}" class="inputNumberText"
											maxlength="4" /><br>
									</p>
									<p>
										좌측 : <input type="text" name="popupPosY"
											value="${onePopupForm.popupPosY}" class="inputNumberText"
											maxlength="4" />
									</p>
								</td>
							</tr>
							<tr>
								<th>하단버튼</th>
								<td colspan="3"><input type="radio" name="cokyUseYn"
									value="Y" checked="checked" id="cokyUseyn1" /><label
									for="cokyUseYn1">오늘&nbsp;하루&nbsp;열지&nbsp;않음+&nbsp;닫기&nbsp;</label>
									<input type="radio" name="cokyUseyn" value="N"
									id="cokyUseYn2" /><label for="cokyUseYn2">&nbsp;닫기&nbsp;</label>
								</td>
							</tr>
							<tr>
								<th>팝업창명<i class="entypo-check"></i></th>
								<td colspan="3"><input type="text" name="popupName"
									value="${onePopupForm.popupName}" maxlength="40" size="160" /> <input
									type="hidden" name="popupSeq" value="${onePopupForm.popupSeq}" /> <input
									type="hidden" name="lastModAdminId"
									value="${onePopupForm.lastModAdminId}"></td>
							</tr>
							<tr>
								<th>내용<i class="entypo-check"></i></th>
								<td colspan="3"><textarea name="popupCont" rows="8"
										cols="60">${onePopupForm.popupCont}</textarea> <script
										type="text/javascript"
										src="/js/ckeditor/ckeditor.js?t=B37D54V"></script> <script
										type="text/javascript">
											//<![CDATA[
											CKEDITOR.replace('popupCont', {
												"width" : "98%",
												"height" : "500px"
											});
											//]]>
										</script></td>
							</tr>
							<tr>
								<c:if test="${mode eq 'update'}">
									<th>등록자ID/등록일시</th>
									<td>${onePopupForm.writeAdminId}/${onePopupForm.rgstDtm}
									<th>수정자ID/수정일시</th>
									<td>${onePopupForm.lastModAdminId}/${onePopupForm.lastModDtm}</td>
								</c:if>
							</tr>
						</table>
						<div class="grid-box">
							<p class="fl-r">
								<c:choose>
									<c:when test="${mode eq 'create'}">
										<a href="javascript://" class="btn btn-primary btnCreate"
											id="create" onclick="createPopup();">저장</a>
									</c:when>
									<c:otherwise>
										<a href="javascript://" class="btn btn-primary btnUpdate"
											id="update" onclick="createPopup();">수정</a>
										<a href="javascript://" class="btn btn-primary btnDelete"
											id="delete" onclick="deletePopup();">삭제</a>
									</c:otherwise>
								</c:choose>
								<button type="button" class="btn btn-cancel list" onclick="location.href='/sample/listPopup';">취소</button>
							</p>
						</div>
					</form>
				</div>
			</section>
		</article>
	</div>

	<script type="text/javascript" src="/js/jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="/js/jquery-ui-1.12.1.min.js"></script>
	<script type="text/javascript" src="/js/common.js"></script>
	<tiles:insertDefinition name="boCommonScript" />
	<script type="text/javascript" src="/js/form.js"></script>
	<script src="http://malsup.github.com/jquery.form.js"></script>
	<script type="text/javascript">
		$(document).ready(function(event) {
			// 날짜 검색 유효성체크
			$(".date-from").on("change", function() {
				if($('.date-to').val() == '') {
					$(".date-to").focus;
				} else {
					if($(this).val() > $(".date-to").val()) {
						alert("시작일은 종료일보다 클 수 없습니다.");
						$(this).val($(".date-to").val());
					}
				}
			});
			// 날짜 검색 유효성체크
			$(".date-to").on("change", function() {
				if($(".date-from").val() == $(".date-to").val()) {
					alert("종료일자는 시작일자보다 커야합니다.");
					$(".date-to").focus;
					return false;
				} else {
					if($(this).val() < $(".date-from").val()) {
						alert("종료일은 시작일보다 작을 수 없습니다.");
						$(this).val($(".date0from").val());
					}
				}
			});
			// 날짜 검색조건 readonly
			$("input[name$=Dt]").attr('readonly', 'readonley');
			// 시간 값 설정하기
			let displayStartHour = '${onePopupForm.displayStartHour}';
			let displayStartMinute = '${onePopupForm.displayStartMinute}';
			let displayEndHour = '${onePopupForm.displayEndHour}';
			let displayEndMinute = '${onePopupForm.displayEndMinute}';
			if(displayStartHour.length <= 1) {
				$("select[name='displayStartHour']").val('00').prop("selected", true);
			} else {
				$("select[name='displayStartHour'] option").each(function() {
					if(this.value == displayStartHour) {
						$("select[name='displayStartHour']").val(this.value).prop("selected", true);
					}
				});
			}
			if(displayStartMinute.length <= 1) {
				$("select[name='displayStartMinute']").val('00').prop("selected", true);
			} else {
				$("select[name='displayStartMinute'] option").each(function() {
					if(this.value == displayStartMinute) {
						$("select[name='displayStartMinute']").val(this.value).prop("selected", true);
					}
				});
			}
			if(displayEndHour.length <= 1) {
				$("select[name='displayEndHour']").val('00').prop("selected", true);
			} else {
				$("select[name='displayEndHour'] option").each(function() {
					if(this.value == displayEndHour) {
						$("select[name='displayEndHour']").val(this.value).prop("selected", true);
					}
				});
			}
			if(displayEndMinute.length <= 1) {
				$("select[name='displayEndMinute']").val('00').prop("selected", true);
			} else {
				$("select[name='displayEndMinute'] option").each(function() {
					if(this.value == displayEndMinute) {
						$("select[name='displayEndMinute']").val(this.value).prop("selected", true);
					}
				});
			}
		});

		function validateCheck() {
			// 날짜 선택 유효성체크
			if($(".date-from").val() == '') {
				alert("전시 마감일시를 입력해주세요.");
				$(".date-from").focus();
				return false;
			}
			// 날짜 선택 유효성체크
			if($(".date-to").val() == '') {
				alert("전시 일시를 입력해주세요.");
				$(".date-to").focus();
				return false;
			}
			// 날짜 선택 유효성체크
			if($(".date-from").val() == $(".date-to").val()) {
				alert("종료일자는 시작일자보다 커야합니다.");
				$(".date-to").focus;
				return false;
			}
			// 팝업 가로 사이즈
			if($("input[name='popupSizeX']").val() == '') {
				alert("팝업 가로 사이즈를 입력해주세요.");
				$("input[name='popupSizeX']").focus();
				return false;
			}
			// 팝업 세로 사이즈
			if($("input[name='popupSizeY']").val() == '') {
				alert("팝업 세로 사이즈를 입력해주세요.");
				$("input[name='popupSizeY']").focus();
				return false;
			}
			// 팝업 시작점 상단
			if($("input[name='popupPosX']").val() == '') {
				alert("팝업 시작점 상단을 입력해주세요.");
				$("input[name='popupPosX']").focus();
				return false;
			}
			// 팝업 시작점 좌측
			if($("input[name='popupPosY']").val() =='') {
				alert("팝업 시작점 좌측을 입력해주세요.");
				$("input[name='popupPosY']").focus();
				return false;
			}
			// 팝업 팝업창명
			if($("input[name='pupupName']").val() == '') {
				alert("팝업 팝업창명을 입력해주세요.");
				$("input[name='popupName']").focus();
				return false;
			}
			// 팝업 내용
			if($("textarea[name='popupCont']").val() == '') {
				alert("팝업 내용을 입력해주세요.");
				$("textarea[name='popupCont']").focus();
				return false;
			}
		}

		function createPopup() {
			// textarea
			$("textarea[name='popupCont']").val(CKEDITOR.instances.popupCont.getData());
			// form 값
			var param = $("#createPopupForm").serializeObject();
			// validate
			if(validateCheck()) {
				return;
			}
			if(param.meod == "create") {
				if(!confirm("등록하시겠습니까?")) {
					return false;
				} else {
					confirm("수정하시겠습니까?");
				}
			}
			param.dispStartDtm += " " + param.displayStartHour + ":" + param.displayStartMinute;
			param.dispEndDtm += " " + param.displayEndHour + ":" + param.displayEndMinute;
			console.log(param.dispstartDtm);
			console.log(param.dispEndDtm);
			
			$.ajax({
				url : param.mode == "create" ? "/sample/createPopupForm" : "/sample/updatePopupForm",
				type : "post",
				dataType : "json",
				data : param,
				traditional : true,
				success : function(data) {
					if(data.resultCode == 1) {
						if(param.mode == "create") {
							alert("등록되었습니다.");
							location.href="/sample/listPopup";
						} else if(param.mode == "update") {
							alert("수정되었습니다.");
							location.href="/sample/viewPopupFormMod?popupSeq=" + param.popupSeq;
						}
					} else {
						var errorMessages = data.message;
						$("div#errorMessagesArea").html("");
						for ( var i = 0; i < errorMessages.length; i++) {
							$('div#errorMessagesArea').append('<strong style="color:red">'+ errorMessages[i]+ '</strong>'+ '<br/>');
						}
					}
				},
				error : function(requet, status, error) {
					alert("시스템 오류가 발생 했습니다. 관리자에게 문의하세요.");
				}
			});
		}
		
		function deletePopup() {
			// textarea
			$("textarea[name='popupCont']").val(CKEDITOR.instances.popupCont.getData());
			// form 값
			var param = $("#createPopupForm").serializeObject();
			if (!confirm("삭제하시겠습니까?")) {
				return;
			}
			
			$.ajax({
				url : param.mode == "delete" ? "/sample/deletePopupList" : "/sample/failPopupList",
				type : "post",
				dataType : "json",
				data : param,
				traditional : true,
				success : function(data) {
					alert("삭제되었습니다.");
					location.href="/sample/listPopup";
				},
				error : function(requet, status, error) {
					alert("시스템 오류가 발생 했습니다. 관리자에게 문의하세요.");
				}
			});
		}
	</script>
</body>
</html>