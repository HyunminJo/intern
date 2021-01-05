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
<title>네파 회원가입</title>
<link rel="stylesheet" href="/nepa/css/default_front.css"
	type="text/css" />
<link rel="stylesheet" href="/nepa/css/layout_front.css" type="text/css" />
<link rel="stylesheet" href="/nepa/css/common_front.css" type="text/css" />
<link rel="stylesheet" href="/nepa/css/sub_front.css" type="text/css" />
<link rel="stylesheet" href="/nepa/css/front_new_2020.css"
	type="text/css" />
</head>
<body>
<form name="form" onsubmit="return false;">
<div class="content-wrap sub-wrap">
	<div class="content-inner">
		<div class="indicator-wrap">
			<ul class="indicator-list">
				<li><a href="#"><img src="/images/common/front_home_indicator.png" alt="홈 아이콘" /> 홈</a></li>
				<li class="last">회원가입</li>
			</ul>
		</div>
		<h2 class="title">통합회원가입</h2>
		
		<div class="desc-wrap">
			<img src="/images/common/front_bg_join_welcome.png" alt="NEPAmall 에 오신것을 환영합니다!">
			<ul class="list-bullet mgt-20">
				<li class="text-black">NEPA Mall 은 “네파몰 통합 회원”으로 가입을 받고 있습니다. </li>
				<li>네파몰 통합 회원이 되시면 통합된 회원 ID와 비밀번호로 네파몰 및 각 패밀리 브랜드의 다양한 서비스(마일리지 조회, 카드등록, 회원정보변경 서비스 등)을 <br />이용하실 수 있습니다.</li>
				<li>기존 네파, 이젠벅 브랜드 중 한 개 이상 가입되어 있는 경우 새로운 네파몰 통합 아이디(ID)를 생성하신 후 가입하실 수 있습니다.</li>
				<!-- <li class="text-black bold">Family Brand : NEPA, ISENBERG, NEPAKIDS</li> 2017.08.16 이젠벅 브랜드 삭제 -->
				<li class="text-black bold">Family Brand : NEPA, NEPAKIDS</li>
			</ul>
		</div>
		<div class="btn-wrap">
			<input name="inRoute" type="hidden" value="" />
			<input name="datakey" type="hidden" value="" />
			<input name="adpickCode" type="hidden" value="" />
			<input name="advertiserName" type="hidden" value="" />
			<input name="partnerYn" type="hidden" value="N" />
			
			<button type="button" class="btn btn-lg btn-gray" onclick="goJoin()">통합회원 신규가입</button>
		</div>
		<br/>
		
	<!-- 2020-07-14일 기존 회원가입 여부 삭제 -->
		<h3 class="sub-title">
			<div id="msgType">회원가입 여부를 먼저 확인해주세요</div>
		</h3>
		
		<div class="table-wrap">
			<table class="table-form">
				<colgroup>
				<col class="form-header" />
				<col style="width:auto;" />
				</colgroup>
				<tbody>
					<tr>
						<th scope="row">이름</th>
						<td class="input">
							<input type="text" class="tbl-input-name required" name="userNm" title="이름" value="${paramMap.userNm}" maxlength="10">
						</td>
					</tr>
					<tr>
						<th scope="row">휴대폰번호</th>
						<td class="select phone">
							<select name='hp1' class='tbl-select-phone1 required' title='휴대폰번호'>
								<option value=''>선택</option>
								<option value='010'>010</option>
								<option value='011'>011</option>
								<option value='016'>016</option>
								<option value='017'>017</option>
								<option value='018'>018</option>
								<option value='019'>019</option>
							</select>
							<input type="text" class="tbl-input-phone2 required onlynum2" name="hp2" title="휴대폰번호" value="${paramMap.hp2}" maxlength="4">
							<input type="text" class="tbl-input-phone3 required onlynum2" name="hp3" title="휴대폰번호" value="${paramMap.hp3}" maxlength="4">
						</td>
					</tr>
				</tbody>
			</table>
				<%-- <c:when test="${empty paramMap.userNm and empty paramMap.hp1 and empty paramMap.hp2 and empty paramMap.hp3}"> --%>
					<div id="btnType01" <c:if test="${!empty paramMap.userNm}"> style="display:none;"</c:if>> <br/>
						<span class="text-info text-black bold">네파 기존고객님 중 회원정보가 확인되지 않으시면, 고객센터로 연락 부탁드립니다. (Tel. 1666-2096)</span>
						<span class="text-info">입력하신 정보는 저장되지 않으며, 기존 회원가입 여부 확인 용도로만 활용됩니다.</span>
						<div class="btn-wrap">
							<button type="button" class="btn btn-md btn-white" onclick="sendData($('.tbl-input-name').val(), $('.tbl-select-phone1').val(), $('.tbl-input-phone2').val(), $('.tbl-input-phone3').val())">확인</button>
						</div>
					</div>
				<%-- </c:when> --%>
			<c:choose>
				<c:when test="${!empty findUserInfo}">
					<div id="btnType03">
						<span class="text-info"><div id="userNmStr">NEPA 통합회원으로 등록되어 있습니다. 
						</div></span>
						<div class="btn-wrap">
							<button type="button" class="btn btn-md btn-white" onclick="findLoginInfo('01')">아이디 찾기</button>
							<button type="button" class="btn btn-md btn-white" onclick="findLoginInfo('02')">비밀번호 찾기</button>
							<button type="button" class="btn btn-md btn-gray" style="width: 162px;" onclick="goLogin()">로그인</button>
						</div>
					</div>
				</c:when>
				<c:when test="${!empty paramMap.userNm }">
					<div id="btnType02"><br/>
						<span class="text-info">[다시 조회]를 눌러 회원정보를 재 확인하시거나, [통합회원 신규가입]을 해주시기 바랍니다.</span>
						<div class="btn-wrap">
							<button type="button" class="btn btn-md btn-white" onclick="sendData($('.tbl-input-name').val(), $('.tbl-select-phone1').val(), $('.tbl-input-phone2').val(), $('.tbl-input-phone3').val())">다시조회</button> 
							<button type="button" class="btn btn-md btn-gray" style="width: 222px;" onclick="goJoin()">통합회원 신규가입</button>
						</div>
					</div>
				</c:when>
			</c:choose>
			<!-- <div id="btnType04" style="display:none">
				<span class="text-info">[다시 조회]를 눌러 회원정보를 재 확인하시거나, [통합회원 전환가입]을 해주시기 바랍니다.</span>
				<div class="btn-wrap">
					<button type="button" class="btn btn-md btn-white" onclick="goUserConfirm()">다시조회</button>
					<button type="button" class="btn btn-md btn-gray" style="width: 222px;" onclick="goJoin()">통합회원 전환가입</button>
				</div>
			</div> -->
		</div>
	</div>
</div>
</form>



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
			let hp = '${paramMap.hp}';
			let hp1 = hp.substring(0,3);
			let hp2 = hp.substring(3,7);
			let hp3 = hp.substring(7,11);			
			if(hp != null) {
				$("select[name='hp1']").val(hp1).prop("selected", true);
				$("input[name='hp2']").val(hp2);
				$("input[name='hp3']").val(hp3);
			}
			
			
		});

		function goJoin(){
			var url = "/nepa/join/agreeForm?inRoute=" + $('input[name=inRoute]').val() + "&datakey=" + $('input[name=datakey]').val();
			var adpickCode = $('input[name=adpickCode]').val();
			var advertiserName = $('input[name=advertiserName]').val();
			var partnerYn = $('input[name=partnerYn]').val();
			
			// adpick 관련 소스
			if(adpickCode != ""){
				url += "&adpickCode=" + $('input[name=adpickCode]').val() + "&advertiserName=" + $('input[name=advertiserName]').val();
			}
			
			if(partnerYn == "Y"){
				url += "&partnerYn="+partnerYn;
			}
			
			location.href = url;
		}
		
		//탭변경
		function sendData(userNm, hp1, hp2, hp3) {
			/* if (contentGroup != '') {
				userNm = $('#userNm').val();
			} */
			let hp = hp1+hp2+hp3;
			
			console.log(userNm);
			console.log(hp);
			location.href = '/nepa/join/userConfirmForm?userNm=' + userNm + '&hp=' + hp1+hp2+hp3;
		}
		
		/* function sendData() {
			let userNm = $("input[name=userNm]").val();
			let hp = $("select[name=hp1]").val()+$("input[name=hp2]").val()+$("input[name=hp3]").val();
			let params = '/nepa/join/userConfirmForm?userNm=' + userNm + '&hp=' + hp;
			
			$.ajax({
				type : "post"
				, url : "/nepa/findUserInfo"
				, data : {userNm : userNm, hp : hp}
				, dataType : "json"
				, success : function(data) {
						alert("a");
						
				}
				
			});
		} */
	</script>
</body>
</html>