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

	<form name="form" onsubmit="return false;">
		<!-- <input type="hidden" name="userNm" value="" /> -->
		<input type="hidden" name="mode" value="create" /> <input
			type="hidden" name="updateType" value="USER" /> <input type="hidden"
			name="userIdDuplYn" value="N" /> <input type="hidden"
			name="duplCheckedUserId" value="" /> <input type="hidden"
			name="mailDuplYn" value="N" /> <input type="hidden"
			name="duplCheckedMail" value="" /> <input type="hidden"
			name="chkInfoType" value="checkplus" /> <input type="hidden"
			name="hpChangeYn" value="N" /> <input type="hidden"
			name="chkSmsAutnYn" value="N" /> <input type="hidden" name="mailYn"
			value="N"> <input type="hidden" name="smsYn" value="N">
		<input name="inRoute" type="hidden" value="" /> <input type="hidden"
			name="marketingYn" value="${paramMap.marketingYn}"> <input
			type="hidden" name="addInfoYn" value="${paramMap.addInfoYn}">


		<div class="content-wrap sub-wrap">
			<div class="content-inner">
				<div class="indicator-wrap">
					<ul class="indicator-list">
						<li><a href="http://www.nepamall.com/main.do"><img
								src="//img.nepamall.com/resources/images/common/front_home_indicator.png"
								alt="홈 아이콘" /> 홈</a></li>
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
						<li class="here">
							<div class="step-inner step3">
								<span>STEP 03. 회원정보 입력</span>
							</div>
						</li>
						<li class="last">
							<div class="step-inner step4">
								<span>STEP 04. 가입완료</span>
							</div>
						</li>
					</ul>
				</div>
				<!-- 인증 폼 -->
				<h3 class="sub-title">
					<span class="text-red">[필수]</span> 회원가입 정보 <span class="sub-txt">입력하신
						개인정보는 "마이페이지&gt;회원정보확인"에서 확인 및 수정이 가능합니다. </span>
				</h3>
				<div class="table-wrap">
					<table class="table-form2">
						<colgroup>
							<col style="width: 160px;" />
							<col style="width: auto;" />
						</colgroup>
						<tbody>
							<tr>
								<th scope="row" class="req">성명</th>
								<td class="input"><input type="text"
									class="tbl-input-name required" name="userNm" title="이름"
									value="${paramMap.userNm}" maxlength="10"></td>
							</tr>
							<tr>
								<th scope="row" class="req">생년월일</th>
								<td><tiles:insertDefinition name="boDateSelect4" />
									&nbsp;&nbsp;&nbsp; <label class="ui-radio first-row"><input
										type="radio" name="solarYn" value="Y" checked="checked"><span
										class="icon"></span> 양력</label> <label class="ui-radio first-row"><input
										type="radio" name="solarYn" value="N"><span
										class="icon"></span> 음력</label>
									<div class="desc">
										<span>* 설정하신 생일 기준으로 생일 혜택을 받으실 수 있습니다.</span>
									</div></td>
							</tr>
							<tr>
								<th scope="row" class="req">성별</th>
								<td><label class="ui-radio first-row"><input
										type="radio" name="sex" value="MAN" checked="checked"><span
										class="icon"></span> 남자</label> <label class="ui-radio first-row"><input
										type="radio" name="sex" value="WOMAN"><span
										class="icon"></span> 여자</label></td>
							</tr>
							<tr>
								<th scope="row" class="req">휴대폰번호</th>
								<td>
									<div>
										<input type="hidden" name="hp" value="" /> <input
											type="hidden" name="ipinHp" value="" /> <input type="hidden"
											name="hp1" value="${paramMap.hpNo1 }" /> <select
											name='hpNo1' class='tbl-select-phone1 required' title='휴대폰번호'>
											<option value=''>선택</option>
											<option value='010'>010</option>
											<option value='011'>011</option>
											<option value='016'>016</option>
											<option value='017'>017</option>
											<option value='018'>018</option>
											<option value='019'>019</option>
										</select> <input type="text" class="tbl-input-phone2 onlynum2 required"
											name="hp2" title="휴대폰번호" maxlength="4" value=""> <input
											type="text" class="tbl-input-phone3 onlynum2 required"
											name="hp3" title="휴대폰번호" maxlength="4" value="">
									</div>
									<div>
										<label class="ui-check first-row"> <input
											type="checkbox" class="chk-mkt marketingWay"
											data-role="check-one" name="chkSmsYn" /> <span
											class="text-dark-gray bold">이벤트/상품정보 문자(SMS) 수신 동의</span> <span
											class="text-lite-gray">(주문 관련 정보는 수신동의 여부와 관계 없이
												발송됩니다.)</span>
										</label>
									</div>
								</td>
							</tr>

							<tr>
								<th scope="row" class="req">아이디</th>
								<td>
									<div class="input-wrap">
										<input class="tbl-id required" type="text" name="userId"
											value="" title="아이디" maxlength="16" onkeyup="noKorean(this);">
										<button type="button" class="btn btn-sm btn-lite-gray bold"
											onclick="checkDuplUserId()">중복확인</button>

									</div>
									<div class="desc">
										<span class="text-red">* 아이디 신규 입력 시, 6자~16자 사이 입력
											(대소문자 구분, 한글/공백 입력 불가)</span> <span>* 영소문자, 영대문자, 숫자, 특수기호를
											사용하여 적어도 3가지 조합으로 만들어 주십시오.</span> <span>* 이메일 ID를 사용하실 경우,
											이메일 주소 변경이 제한될 수 있으니, 이 점 유의하여 주시기 바랍니다.</span>
									</div>
								</td>
							</tr>
							<tr>
								<th scope="row" class="req">비밀번호</th>
								<td>
									<div class="input-wrap">
										<input class="tbl-pw required" type="password" name="userPw"
											title="비밀번호" maxlength="16" onkeyup="noKorean(this);">
									</div>
									<div class="desc">
										<span class="text-red">* 비밀번호는 8자~16자 사이 입력 (대소문자 구분,
											한글/공백 입력 불가)</span> <span>* 타인이 쉽게 알아낼 수 있는 아이디, 전화번호, 생일 등
											개인정보와 연관된 숫자/문자 등은 사용하지 않는 것이 좋습니다.</span>
									</div>
								</td>
							</tr>
							<tr>
								<th scope="row" class="req">비밀번호 확인</th>
								<td>
									<div class="input-wrap">
										<input class="tbl-pw required" type="password" name="reUserPw"
											title="비밀번호확인" maxlength="16" onkeyup="noKorean(this);">
									</div>
								</td>
							</tr>
							<tr>
								<th scope="row">이메일</th>
								<td>
									<div>
										<input type="text" placeholder="이메일" name="mail1" title="이메일"
											onkeyup="noKorean(this);" maxlength="50" value=""> @
										<input type="text" placeholder="직접입력" id="mail2" name="mail2"
											title="이메일" onkeyup="noKorean(this);" maxlength="50" value="">
										<select name='mailDomain'
											onchange="setMailDomain(this.value);"><option
												value=''>선택</option>
											<c:forEach var="mail" items="${mailGroup}" varStatus="status"
												begin="0" end="12" step="1">
												<option value='${mail.code}'><c:out
														value="${mail.name}"></c:out></option>
											</c:forEach>
										</select>
									</div>
									<div>
										<label class="ui-check first-row"> <input
											type="checkbox" class="chk-mkt marketingWay"
											data-role="check-one" name="chkMailYn" /> <!-- 160603 수정 : 텍스트 수정 -->
											<span class="text-dark-gray bold">이벤트/상품정보 이메일 수신 동의</span> <span
											class="text-lite-gray">(주문 관련 정보는 수신동의 여부와 관계 없이
												발송됩니다.)</span>
										</label>
									</div>
								</td>
							</tr>
							<tr>
								<th scope="row" class="req">주소</th>
								<td class="address">
									<div class="zip-code">
										<input type="text" id="zipcode" name="zipcode" title="주소"
											readonly="readonly">
										<button type="button" class="btn btn-sm btn-white bold"
											onclick="javascript:openZipcode('zipcode', 'address','addressDetail');">주소찾기</button>
									</div>
									<div class="address-wrap">
										<input type="text" class="address-pre" id="address"
											name="address" value="" title="상세주소" readonly="readonly">
										<input type="text" class="address-etc" placeholder="나머지 주소"
											id="addressDetail" name="addressDetail" value=""
											title="나머지주소" maxlength="60">
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>

				<c:if test="${paramMap.addInfoYn == 'Y'}">
					<div id="addInfoForm" class="mgt-40">
						<h3 class="sub-title">
							<span class="text-red">[선택]</span> 회원가입 정보
						</h3>
						<div class="table-wrap">
							<table class="table-form2">
								<colgroup>
									<col style="width: 160px;" />
									<col style="width: auto;" />
								</colgroup>
								<tbody>
									<tr>
										<th scope="row">결혼여부</th>
										<td><label class="ui-radio first-row"><input
												type="radio" name="weddingYn" checked="checked" value="N"
												onchange="changeWeddingYn(this.value)"><span
												class="icon"></span> 미혼</label> <label class="ui-radio first-row"><input
												type="radio" name="weddingYn" value="Y"
												onchange="changeWeddingYn(this.value)"><span
												class="icon"></span> 기혼</label> <span>* 결혼기념일 입력 시 관련 혜택을 받으실
												수 있습니다.</span></td>
									</tr>
									<tr>
										<th scope="row">결혼기념일</th>
										<td><select class="tbl-select-year" id="wedding1"
											name="wedding1" title="결혼기념일" disabled='disabled'>
												<option value="">년</option>
												<c:forEach var="year" begin="1920" end="2020" step="1"
													varStatus="status">
													<option value="<c:out value='${status.index}'/>">
														<c:out value="${status.index}" />
													</option>
												</c:forEach>
										</select> <select class="tbl-select-month" id="wedding2"
											name="wedding2" title="결혼기념일" disabled='disabled'>
												<option value="">월</option>
												<c:forEach var="month" begin="1" end="12" step="1"
													varStatus="status">
													<c:if test="${status.index < '10'}">
														<option value="<c:out value="0${status.index}"/>">
															<c:out value="${status.index}" />
														</option>
													</c:if>
													<c:if test="${status.index > '9'}">
														<option value="<c:out value="${status.index}"/>">
															<c:out value="${status.index}" />
														</option>
													</c:if>
												</c:forEach>
										</select> <select class="tbl-select-day" id="wedding3" name="wedding3"
											title="결혼기념일" disabled='disabled'>
												<option value="">일</option>
												<c:forEach var="day" begin="1" end="31" step="1"
													varStatus="status">
													<c:if test="${status.index < '10'}">
														<option value="<c:out value="0${status.index}"/>">
															<c:out value="${status.index}" />
														</option>
													</c:if>
													<c:if test="${status.index > '9'}">
														<option value="<c:out value="${status.index}"/>">
															<c:out value="${status.index}" />
														</option>
													</c:if>
												</c:forEach>
										</select></td>
									</tr>
									<tr>
										<th scope="row">직업</th>
										<td><c:forEach var="job" items="${jobGroup}"
												varStatus="status" begin="0" end="6" step="1">
												<c:if test="${status.index < '5'}">
													<label class="first-row ui-radio"><input
														type="radio" name="job" value="${job.code}"><span
														class="icon"></span> <c:out value="${job.name}"></c:out></label>
												</c:if>
												<c:if test="${status.index > '4'}">
													<div class="has-input-wrap">
														<label class="first-row ui-radio"><input
															type="radio" name="jobDesc" value="${job.code}"><span
															class="icon"></span> <c:out value="${job.name}"></c:out></label>
														<input type="text">
													</div>
												</c:if>
											</c:forEach></td>
									</tr>
									<tr>
										<th scope="row">관심분야</th>
										<td><input type="hidden" name="hobbys" value="" /> <c:forEach
												var="hobby" items="${hobbyGroup}" varStatus="status"
												begin="0" end="15" step="1">
												<c:if test="${status.index < '14'}">
													<label class="first-row ui-check"><input
														type="checkbox" name="hobby${hobby.dispNo}"
														class="chk-hobby" value="${hobby.code}"
														onclick="changeHobby(this.value)"> <c:out
															value="${hobby.name}"></c:out></label>
												</c:if>
												<c:if test="${status.index > '13'}">
													<div class="has-input-wrap">
														<label class="ui-check has-input"><input
															type="checkbox" name="hobby${hobby.dispNo}"
															class="chk-hobby" value="${hobby.code}"
															onclick="changeHobby(this.value)"> <c:out
																value="${hobby.name}"></c:out></label><input type="text"
															name="hobbyDesc" value="" maxlength="65">
													</div>
												</c:if>
											</c:forEach></td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</c:if>


				<div class="btn-wrap">
					<button type="button" class="btn btn-lg btn-white"
						style="width: 150px;" onclick="goJoinHome()">취소</button>
					<button type="button" class="btn btn-lg btn-gray"
						style="width: 150px;" onclick="sendData()">가입완료</button>
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
	<script src="https://spi.maps.daum.net/imap/map_js_init/postcode.v2.js"></script>
	<%
		String strReferer = request.getHeader("referer");
	if (strReferer == null) {
	%>
	<script language="javascript">
		alert("URL 주소창에 주소를 직접 입력해서 접근하셨습니다.\n\n정상적인 경로를 통해 다시 접근해 주십시오.");
		document.location.href = "/nepa/join/agreeForm";
	</script>
	<%
		return;
	}
	%>
	<script type="text/javascript">
		$(document)
				.ready(
						function() {

							let addInfoYn = '${paramMap.addInfoYn}';
							let marketingYn = '${paramMap.marketingYn}';
							if (addInfoYn == null || addInfoYn == undefined
									|| addInfoYn == 'null'
									|| addInfoYn == 'undefined'
									|| addInfoYn == '') {
								location.href = "/nepa/join/agreeForm"
							}
							if (marketingYn == null || marketingYn == undefined
									|| marketingYn == 'null'
									|| marketingYn == 'undefined'
									|| marketingYn == '') {
								location.href = "/nepa/join/agreeForm"
							}

							$(".chk-mkt")
									.on(
											"click",
											function(event) {
												var dataRole = $(event.target)
														.data("role");
												var totalCnt = $("input[data-role='check-one']").length;
												var selectedCnt = $("input[data-role='check-one']:checked").length;
												var selectAllTarget = $("input[data-role=check-all]");

												if (dataRole == "check-all") {
													$(".marketingWay")
															.each(
																	function(i) {
																		$(this)
																				.prop(
																						"checked",
																						$(
																								event.target)
																								.is(
																										":checked"));
																		$(this)
																				.trigger(
																						"changeForce");
																	});
												} else {
													if (totalCnt == selectedCnt) {
														selectAllTarget
																.prop(
																		"checked",
																		true);
													} else {
														selectAllTarget.prop(
																"checked",
																false);
													}
													selectAllTarget
															.trigger("changeForce");
												}
											});

							$("select[name='hpNo1']").on("change", function() {
								var value = $("select[name='hpNo1']").val();
								$("input[name='hp1']").val(value);
							});
							$(".tbl-input-name required")
									.on(
											"change",
											function() {
												var value = $(
														"tbl-input-name required")
														.val();
												$("input[name='userNm']").val(
														value);
											});
						});
		// 공백체크
		function checkSpace(str) {
			if (str.search(/\s/) != -1) {
				return true;
			} else {
				return false;
			}
		}
		// 특수문자 체크
		function checkSpecial(str) {
			var specialPattern = /[`~!@#$%^&*|\\\'\";:\/?]/gi;
			if (specialPattern.test(str) == true) {
				return true;
			} else {
				return false;
			}
		}
		// 한글 체크
		function checkKorean(str) {
			var koreanPattern = /^[가-힣]+$/;
			if (str.search(/^[가-힣]+$/) != -1) {
				return true;
			} else {
				return false;
			}
		}

		function checkPattern(str) {
			var pattern1 = /^(?=.*[a-zA-Z])(?=.*[!@#$%^~*+=-])(?=.*[0-9]).{6,16}$/;
			var pattern2 = /^[a-zA-Z0-9]{6,16}$/;
			if (checkSpecial(str) && checkSpace(str)) {
				if (pattern1.test(str)) {
					return true;
				} else {
					alert("숫자, 영문자와 특수문자 조합으로 6~16자리를 사용해야 합니다");
					return false;
				}
			} else {
				if (pattern2.test(str)) {
					return true;
				} else {
					alert("숫자와 영문자 조합으로 6~16자리를 사용해야 합니다");
					return false;
				}
			}
		}

		function checkPassword(str) {
			var pattern = /^[a-zA-Z0-9]{6,16}$/;
			if (pattern.test(str)) {
				return true;
			} else {
				alert("비밀번호를 다시 확인해주세요.");
				$("input[name='userPw']").focus();
				return false;
			}
		}
		// 한국어
		function noKorean(obj) {
			obj.value = obj.value.replace(/[\ㄱ-ㅎㅏ-ㅣ|가-힣]/g, '').trim();
		}

		// 아이디 중복 확인
		function checkDuplUserId() {
			$("input[name='userIdDuplYn']").val("Y");
			$("td > .input-wrap strong").remove();
			let userId = $("input[name='userId']").val();

			if (checkPattern(userId) == false) {
				return false;
			}

			var $tab_content = $('td >.input-wrap')[0];
			var content = "";
			$
					.ajax({
						type : "post",
						url : "/nepa/join/checkDupUserId",
						data : {
							userId : userId
						},
						dataType : "json",
						success : function(countId) {
							if (countId.resultCode > 0) {
								$("input[name='userId']").focus();
								content += "<strong style='color:blue;'>사용 가능한 아이디입니다.</strong>";
								$("input[name='duplCheckedUserId']")
										.val(userId);
							} else {
								$("input[name='userId']").focus();
								content += "<strong style='color:red;'>이미 존재하는 아이디입니다. 다른 아이디를 사용해주세요.</strong>";
							}
							$tab_content.append($(content)[0]);
						}
					});
		}

		function setMailDomain(value) {
			$("#mail2").val(value);
		}
		// 이메일 체크
		function checkEmail(str) {
			var mailPattern = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
			if (mailPattern.test(str) == true) {
				return true;
			} else {
				return false;
			}
		}

		// 주소 검색
		function openZipcode(inputZipcode, inputAddr, inputAddrDetail) {
			new daum.Postcode(
					{
						oncomplete : function(data) {
							// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

							// 각 주소의 노출 규칙에 따라 주소를 조합한다.
							// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
							var fullAddr = ''; // 최종 주소 변수
							var extraAddr = ''; // 조합형 주소 변수

							// 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
							if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
								fullAddr = data.roadAddress;

							} else { // 사용자가 지번 주소를 선택했을 경우(J)
								fullAddr = data.jibunAddress;
							}

							// 사용자가 선택한 주소가 도로명 타입일때 조합한다.
							if (data.userSelectedType === 'R') {
								//법정동명이 있을 경우 추가한다.
								if (data.bname !== '') {
									extraAddr += data.bname;
								}
								// 건물명이 있을 경우 추가한다.
								if (data.buildingName !== '') {
									extraAddr += (extraAddr !== '' ? ', '
											+ data.buildingName
											: data.buildingName);
								}
								// 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
								fullAddr += (extraAddr !== '' ? ' ('
										+ extraAddr + ')' : '');
							}

							// 우편번호와 주소 정보를 해당 필드에 넣는다.
							document.getElementById(inputZipcode).value = data.zonecode; //5자리 새우편번호 사용
							document.getElementById(inputAddr).value = fullAddr;

							// 커서를 상세주소 필드로 이동한다.
							document.getElementById(inputAddrDetail).focus();
						}
					}).open();
		}

		// 결혼 여부
		function changeWeddingYn(value) {
			if (value != 'Y') {
				$("#wedding1").val("");
				$("#wedding2").val("");
				$("#wedding3").val("");
				$("#wedding1").attr("disabled", true);
				$("#wedding2").attr("disabled", true);
				$("#wedding3").attr("disabled", true);
			} else {
				$("#wedding1").removeAttr("disabled");
				$("#wedding2").removeAttr("disabled");
				$("#wedding3").removeAttr("disabled");
			}
		}

		// 관심분야
		function changeHobby(value) {
			if (value == '15') {
				$("input[name='hobbyDesc']").val("");
			}
		}

		// 가입완료
		function sendData() {

			// 이름
			let userNm = $("input[name='userNm']").val();
			if (userNm == '') {
				alert("이름을 입력해주세요.");
				return false;
			}

			// 생년월일 유효성 체크
			var date = new Date();

			let year = date.getFullYear(); //년도
			let month = date.getMonth() + 1; //월
			let day = date.getDate(); //일

			if ((month + "").length < 2) {
				month = "0" + month;
			} else {
				month = month.toString();
			}
			if ((day + "").length < 2) {
				day = "0" + day;
			} else {
				day = day.toString();
			}

			let getToday = year + month + day;

			let birthday1 = $("select[name='birthday1']").val();
			;
			let birthday2 = $("select[name='birthday2']").val();
			let birthday3 = $("select[name='birthday3']").val();
			let birthDt = birthday1 + birthday2 + birthday3;

			if (birthday1 == '') {
				alert("태어난 해를 입력해주세요.");
				$("select[name='birthday1']").focus();
				return false;
			}
			if (birthday2 == '') {
				alert("태어난 월을 입력해주세요.");
				$("select[name='birthday2']").focus();
				return false;
			}
			if (birthday3 == '') {
				alert("태어난 일을 입력해주세요.");
				$("select[name='birthday3']").focus();
				return false;
			}

			if (birthDt > getToday) {
				alert("생년월일을 정확히 입력하세요.");
				return false;
			}

			// 핸드폰 값
			let hpNo1 = $("select[name='hpNo1']").val();
			let hp1 = $("input[name='hp1']").val();
			let hp2 = $("input[name='hp2']").val();
			let hp3 = $("input[name='hp3']").val();

			if (hp1 == '' || hp2 == '' || hp3 == '') {
				alert("번호를 입력해주세요.");
				$("input[name='hp2']").focus();
				return false;
			}
			// 번호 조합
			if (hp1 != '' && hp2.length > 0 && hp3.length > 0) {
				hp = hp1 + "-" + hp2 + "-" + hp3;
				$("input[name='hp']").val(hp);
			}

			// 아이디 중복 체크
			let userIdDuplYn = $("input[name=userIdDuplYn]").val();
			let duplCheckedUserId = $("input[name=duplCheckedUserId]").val();
			let userId = $("input[name=userId]").val();

			if (userId == '') {
				alert("아이디를 입력해주세요.");
				return false;
			}

			if (userIdDuplYn == 'N' || duplCheckedUserId != userId) {
				alert("아이디 중복을 확인해주세요.");
				return false;
			}

			$("input[name='userId']").on("change", function() {
				alert("아이디 중복을 확인해주세요.");
				return false;
			});

			//비밀번호 유효성 체크
			let userPw = $("input[name='userPw']").val();
			let reUserPw = $("input[name='reUserPw']").val();

			if (userPw == '' || reUserPw == '') {
				alert("비밀번호를 입력해주세요.");
				return false;
			}
			if (userPw != reUserPw) {
				alert("비밀번호가 틀립니다.");
				return false;
			}
			/* if(checkSpace(userPw) == true && checkPassword(userPw) == true) {
				return true;
			} else {
				alert("비밀번호를 적확히 입력해주세요.");
				return false;
			} */

			// 이메일 유효성 체크
			let mail1 = $("input[name='mail1']").val();
			let mail2 = $("input[name='mail2']").val();
			let mailAddr = mail1 + "@" + mail2;
			if (mail1 != '' || mail2 != '') {
				if (checkEmail(mailAddr) == false) {
					alert("이메일 형식을 확인해주세요.");
					return false;
				}
			}

			// 주소
			let zipcode = $("#zipcode").val();
			let address = $("#address").val();
			let addressDetail = $("#addressDetail").val();

			if (zipcode == '') {
				alert("주소를 입력해주세요.");
				$("#zipcode").focus();
				return false;
			}
			if (addressDetail == '') {
				alert("나머지 주소를 입력해주세요.");
				$("#addressDetail").focus();
				return false;
			}

			// 마케팅 정보 수신 동의
			let chkSmsYn = $("input[name='chkSmsYn']").is(":checked");
			let chkEmailYn = $("input[name='chkMailYn']").is(":checked");
			if (chkSmsYn == true) {
				$("input[name='smsYn']").val("Y");
			} else {
				$("input[name='smsYn']").val("N");
			}
			if (chkEmailYn == true) {
				$("input[name='mailYn']").val("Y");
			} else {
				$("input[name='mailYn']").val("N");
			}

			if (chkEmailYn == true && mail1 == '' && mail2 == '') {
				alert("이메일 수신을 원하시면 이메일을 입력해주세요.");
				$("input[name='mail1']").focus();
				return false;
			}

			// 회원 가입 정보
			let marketingYn = $(".marketingWay:checked");
			let weddingYn = $("select[name='weddingYn']").val();
			let weddingY = $("select[name='wedding1']").val();
			let weddingM = $("select[name='wedding2']").val();
			let weddingD = $("select[name='wedding3']").val();
			let weddingDt = weddingY + weddingM + weddingD;

			if (marketingYn.length > 0) {
				if (weddingYn == 'Y') {
					if (weddingY == null && weddingM == null
							&& weddingD == null) {
						alert("결혼기념일을 입력하세요.");
						$("select[name='wedding1']").focus();
						return false;
					}
				}
				if (weddingDt > getToday) {
					alert("결혼기념일을 정확히 입력하세요.");
					$("select[name='wedding1']").focus();
					return false;
				}

				var hobby15 = $("input:checkbox[name='hobby15']")
						.is(":checked");
				var hobbyDesc = $("input[name=hobbyDesc]").val();

				if (hobby15 == true && hobbyDesc == '') {
					alert("취미를 입력하십시오.");
					$("input[name=hobbyDesc]").focus();
					return false;
				}
			}
			let hobbys = [];
			$.each($(".chk-hobby:checked"), function() {
				hobbys.push($(this).val());
			});

			var param = $("form[name='form']").serializeObject();
			param.hobbys += hobbys;
			param.birthDt = birthDt;
			param.mailAddr = mailAddr;
			param.weddingDt = weddingDt;

			$.ajax({
				url : "/nepa/join/addInfoForm",
				type : "post",
				dataType : "json",
				data : param,
				traditional : true,
				success : function(data) {
					if (data.resultCode == '1') {
						alert("통합 회원으로 가입 되었습니다.");
						location.href = "/nepa/join/completeForm?smsYn="
								+ param.smsYn + "&userNo=" + param.userNo;
					} else {
						var errorMessages = data.message;
						alert(errorMessages);
					}
				},
				error : function() {
					alert("시스템 오류가 발생했습니다. 관리자에게 문의하세요.");
					location.href = "/nepa/join/userConfirmForm";
				}
			});
		}
	</script>
</body>
</html>