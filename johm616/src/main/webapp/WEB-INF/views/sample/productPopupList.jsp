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
<title>Popup:Demomall:상품목록조회</title>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="Demomall admin">

<!-- <script type="text/javascript" src="/js/jquery/jquery-1.12.0.min.js"></script>
<script type="text/javascript" src="/js/jquery/jquery.alphanumeric.pack.js"></script>
<script type="text/javascript" src="/js/jquery/jquery.lazyload.min.js"></script>
<script type="text/javascript" src="/js/poshytip/jquery.poshytip.js" ></script>
<script type="text/javascript" src="/script/loadingBar.js"></script>
<script type="text/javascript" src="/script/common.js"></script>
<script type="text/javascript" src="/script/admin.js"></script> -->

<!-- <script type="text/javascript" src="/js/plugins/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="/js/plugins/jquery.tablesorter.min.js"></script> -->

<!-- external css style -->
<link rel="stylesheet" href="/css/bo/common.css" type="text/css">
<link rel="stylesheet" href="/css/bo/theme_typeA.css" type="text/css">
<link rel="stylesheet" href="/css/bo/icons/font-awesome.css"
	type="text/css">
<!-- <link href="/js/poshytip/tip-violet/tip-violet.css" rel="stylesheet" type="text/css" /> -->

<script type="text/javascript">
	jQuery(function($) {
		$("a.close").click(function() {
			self.close();
		});
	});
</script>


<!-- <link rel="stylesheet" type="text/css" href="/js/jquery/css/jquery-ui.min.css"/>
<link rel="stylesheet" type="text/css" href="/js/jquery/css/jquery-ui.theme.min.css" />
<script type="text/javascript" src="/js/jquery/jquery-ui.min.js"></script>
<script type="text/javascript" src="/js/calendar.js"></script>
<script type="text/javascript" src="/js/categorySelect.js"></script> -->

<script type="text/javascript">
	var idx = 1;
	function categorySelectLoad(obj, maxLength, divId, inputName) {
		prntCtgrId = obj.value;
		$(obj).nextAll().remove();
		if (prntCtgrId == undefined || prntCtgrId == "") {
			prntCtgrId = "00";
		}
		if (maxLength == undefined || maxLength == "") {
			maxLength = 0;
		}
		if (divId == undefined || divId == '') {
			divId = "categorySelect";
		}
		if (inputName == undefined || inputName == '') {
			inputName = 'selectCategory';
		}
		var params = "prntCtgrId=" + prntCtgrId;
		params += "&maxLength=" + maxLength;
		params += "&divId=" + divId;
		params += "&inputName=" + inputName;
		$
				.ajax({
					type : "GET",
					url : "/product/listCategoryForSelect",
					data : encodeURI(params),
					dataType : "json",
					async : false,
					success : function(html) {
						if (html.infoMap == null) {
							return false;
						} else {
							var $tab_content = $('td >#listProductSelectCategory')[0];
							var content = '<select id="selectCategorys'
									+ idx
									+ '" name="selectCategorys" onchange="categorySelectLoad(this, '
									+ '0' + ', ' + 'listProductSelectCategory'
									+ ', ' + 'selectCategorys' + ');">'
							content += '<option value="00">---- 선택 ----</option>'
							$.each(html.infoMap.list, function(index, item) {
								content += '<option value="'+item.ctgrId+'">'
										+ item.ctgrName + '</option>';
							})
									+ '</select>';
							$tab_content.append($(content)[0]);
							idx++;
						}
					}
				});
	}

	jQuery(function($) {
		// 카테고리
		let selectCategory = '${paramMap.selectCategorys}'.split(',');
		if (selectCategory.length <= 1) {
			$("#selectCategorys0").val('').prop("selected", true);
		} else {
			for (var i = 0; i < selectCategory.length; i++) {
				$('#selectCategorys' + (i)).val(selectCategory[i]).change();
			}
		}
		// 상품명
		$("input[name='prdtEngName']").focus();
		// 검색버튼
		$(".btnSearch").click(function() {
			$('form').submit();
		});
		// 리스트사이즈
		$("select[name='listSize']").change(function() {
			$("form[name='productSearchForm']").submit();
		});
		// 시작일
		$("#rgstStartDtm").datepicker({});
		// 종료일
		$("#rgstEndDtm").datepicker({});
		// 전체선택
		$('#prdtPopupAllChecked').change(
				function() {
					$("input[name='listCheck']").each(
							function() {
								$(this).prop(
										"checked",
										$('#prdtPopupAllChecked')
												.is(":checked"));
							});
				});

		/* 판매상태 체크박스 */
		let prdtStatCode = '${paramMap.prdtStatCode}';
		var prdtStatCodeCheckLength = $("input[name='prdtStatCode']:checked").length;
		var prdtStatCodeLength = $("input[name='prdtStatCode']").length;
		if ((prdtStatCodeLength - 1 == prdtStatCodeCheckLength)
				|| prdtStatCode === "") {
			$("input[name='prdtStatCode']").prop("checked", true);
		} else {
			var splitCode = '${paramMap.prdtStatCode}'.split(',');
			if (splitCode.length == 3) {
				$("input[name='prdtStatCode']").prop("checked", true);
			} else {
				for (var i = 0; i < splitCode.length; i++) {
					if (splitCode[i].includes('P')) {
						$("#prdtStatCode0").prop("checked", false);
						$("#prdtStatCode1").prop("checked", true);
					} else if (splitCode[i].includes('S')) {
						$("#prdtStatCode0").prop("checked", false);
						$("#prdtStatCode2").prop("checked", true);
					} else if (splitCode[i].includes('F')) {
						$("#prdtStatCode0").prop("checked", false);
						$("#prdtStatCode3").prop("checked", true);
					} else {
						$("#prdtStatCode0").prop("checked", true);
					}
				}
			}
		}
		$("input[name='prdtStatCode']")
				.click(
						function() {
							if ($(this).val() == "") {
								$("input[name='prdtStatCode']").prop("checked",
										this.checked);
							} else {
								$("input[name='prdtStatCode']:eq(0)").prop(
										"checked", false);

								if ($("input[name='prdtStatCode']:checked").length == 3) {
									$("input[name='prdtStatCode']").prop(
											"checked", this.checked);
								}
							}
						});

		// 전시여부
		let dispYn = '${paramMap.dispYn}';
		if (dispYn === "") {
			$("#dispYn").attr("checked", true);
		} else if (dispYn == 'true') {
			$("#dispYn1").attr("checked", true);
		} else {
			$("#dispYn2").attr("checked", true);
		}
		//업체중지상품제외
		$("#vndrStopPrdtEscp[value='${paramMap.vndrStopPrdtEscp}']").prop(
				"checked", true);
		//정렬
		var sortType = '${paramMap.sortType}';
		if (sortType == "orderByType1Asc") {
			$("#sortA").css("color", "yellow").css("font-weight", "bold").find(
					"i").attr("class", "entypo-down-open");
		} else if (sortType == "orderByType1Desc") {
			$("#sortA").css("color", "yellow").css("font-weight", "bold").find(
					"i").attr("class", "entypo-up-open");
		} else if (sortType == "orderByType2Asc") {
			$("#sortB").css("color", "yellow").css("font-weight", "bold").find(
					"i").attr("class", "entypo-down-open");
		} else if (sortType == "orderByType2Desc") {
			$("#sortB").css("color", "yellow").css("font-weight", "bold").find(
					"i").attr("class", "entypo-up-open");
		} else if (sortType == "orderByType3Asc") {
			$("#sortC").css("color", "yellow").css("font-weight", "bold").find(
					"i").attr("class", "entypo-down-open");
		} else if (sortType == "orderByType3Desc") {
			$("#sortC").css("color", "yellow").css("font-weight", "bold").find(
					"i").attr("class", "entypo-up-open");
		} else if (sortType == "orderByType4Asc") {
			$("#sortD").css("color", "yellow").css("font-weight", "bold").find(
					"i").attr("class", "entypo-down-open");
		} else if (sortType == "orderByType4Desc") {
			$("#sortD").css("color", "yellow").css("font-weight", "bold").find(
					"i").attr("class", "entypo-up-open");
		} else if (sortType == "orderByType5Asc") {
			$("#sortE").css("color", "yellow").css("font-weight", "bold").find(
					"i").attr("class", "entypo-down-open");
		} else if (sortType == "orderByType5Desc") {
			$("#sortE").css("color", "yellow").css("font-weight", "bold").find(
					"i").attr("class", "entypo-up-open");
		} else if (sortType == "orderByType6Asc") {
			$("#sortF").css("color", "yellow").css("font-weight", "bold").find(
					"i").attr("class", "entypo-down-open");
		} else if (sortType == "orderByType6Desc") {
			$("#sortF").css("color", "yellow").css("font-weight", "bold").find(
					"i").attr("class", "entypo-up-open");
		} else if (sortType == "orderByType7Asc") {
			$("#sortG").css("color", "yellow").css("font-weight", "bold").find(
					"i").attr("class", "entypo-down-open");
		} else if (sortType == "orderByType7Desc") {
			$("#sortG").css("color", "yellow").css("font-weight", "bold").find(
					"i").attr("class", "entypo-up-open");
		} else if (sortType == "orderByType8Asc") {
			$("#sortH").css("color", "yellow").css("font-weight", "bold").find(
					"i").attr("class", "entypo-down-open");
		} else if (sortType == "orderByType8Desc") {
			$("#sortH").css("color", "yellow").css("font-weight", "bold").find(
					"i").attr("class", "entypo-up-open");
		}

		$("#sortA").click(function() {
			var sortType = $("input[name='sortType']").val();
			if (sortType == "orderByType1Asc") {
				$("input[name='sortType']").val("orderByType1Desc");
			} else if (sortType == "orderByType1Desc") {
				$("input[name='sortType']").val("orderByType1Asc");
			} else {
				$("input[name='sortType']").val("orderByType1Asc");
			}
			$("#productSearchForm").submit();
		});

		$("#sortB").click(function() {
			var sortType = $("input[name='sortType']").val();
			if (sortType == "orderByType2Asc") {
				$("input[name='sortType']").val("orderByType2Desc");
			} else if (sortType == "orderByType2Desc") {
				$("input[name='sortType']").val("orderByType2Asc");
			} else {
				$("input[name='sortType']").val("orderByType2Asc");
			}
			$("#productSearchForm").submit();
		});

		$("#sortC").click(function() {
			var sortType = $("input[name='sortType']").val();
			if (sortType == "orderByType3Asc") {
				$("input[name='sortType']").val("orderByType3Desc");
			} else if (sortType == "orderByType3Desc") {
				$("input[name='sortType']").val("orderByType3Asc");
			} else {
				$("input[name='sortType']").val("orderByType3Asc");
			}
			$("#productSearchForm").submit();
		});

		$("#sortD").click(function() {
			var sortType = $("input[name='sortType']").val();
			if (sortType == "orderByType4Asc") {
				$("input[name='sortType']").val("orderByType4Desc");
			} else if (sortType == "orderByType4Desc") {
				$("input[name='sortType']").val("orderByType4Asc");
			} else {
				$("input[name='sortType']").val("orderByType4Asc");
			}
			$("#productSearchForm").submit();
		});

		$("#sortE").click(function() {
			var sortType = $("input[name='sortType']").val();
			if (sortType == "orderByType5Asc") {
				$("input[name='sortType']").val("orderByType5Desc");
			} else if (sortType == "orderByType5Desc") {
				$("input[name='sortType']").val("orderByType5Asc");
			} else {
				$("input[name='sortType']").val("orderByType5Asc");
			}
			$("#productSearchForm").submit();
		});

		$("#sortF").click(function() {
			var sortType = $("input[name='sortType']").val();
			if (sortType == "orderByType6Asc") {
				$("input[name='sortType']").val("orderByType6Desc");
			} else if (sortType == "orderByType6Desc") {
				$("input[name='sortType']").val("orderByType6Asc");
			} else {
				$("input[name='sortType']").val("orderByType6Asc");
			}
			$("#productSearchForm").submit();
		});

		$("#sortG").click(function() {
			var sortType = $("input[name='sortType']").val();
			if (sortType == "orderByType7Asc") {
				$("input[name='sortType']").val("orderByType7Desc");
			} else if (sortType == "orderByType7Desc") {
				$("input[name='sortType']").val("orderByType7Asc");
			} else {
				$("input[name='sortType']").val("orderByType7Asc");
			}
			$("#productSearchForm").submit();
		});

		$("#sortH").click(function() {
			var sortType = $("input[name='sortType']").val();
			if (sortType == "orderByType8Asc") {
				$("input[name='sortType']").val("orderByType8Desc");
			} else if (sortType == "orderByType8Desc") {
				$("input[name='sortType']").val("orderByType8Asc");
			} else {
				$("input[name='sortType']").val("orderByType8Asc");
			}
			$("#productSearchForm").submit();
		});
	});

	function openBrandPopup(multiYn) {
		if (multiYn == undefined || multiYn == "" || multiYn != "Y") {
			multiYn = "N";
		}
		window
				.open(
						"/product/brandList/popup?callback=callbackBrandPopup&decorator=adminPopup&multiYn="
								+ multiYn, 'popupBrandList',
						'width=1024 ,height=768 ,scrollbars=yes,resizable=yes');
		return false;
	}
	function callbackBrandPopup(brandName, brandId) {
		$('#brandEngName').val(brandName);
		$('#brandId').val(brandId);
	}
	
	var jsonList = ${core:toJson(productList.content)};
	var callbackFn = null;
	function setProductList(multiYn, index) {
		var list = new Array();
		
		if(typeof index == "undefined") {
			if($("input[name=listCheck]:checked").length == 0) {
				alert('선택한 항목이 없습니다.');
				return;
			}
			$.each($("input[name=listCheck]:checked"), function() {
				list.push(jsonList[$(this).val()]);
			});
		} else {
			list.push(jsonList[index]);
		}
		
		var data = new Object();
		data.list = list;
		if(typeof(callbackFn) == "function") {
			callbackFn(data);
		} else if(typeof(opener.callbackProductListPopup) == "function") {
			console.log("콜백?");
			opener.callbackProductListPopup(multiYn, data);
		}
		window.close();
	}
</script>


</head>
<body class="wrap-popup">
	<div class="wrap">
		<!-- <div class="bg-pop">
            <img src="//image.crewmate.co.kr/demoshop/h1_logo.png" alt="crewmate" />
            <a href="#닫기" class="btn btn-sm fl-r close">닫기</a>
        </div>  -->
		<div class="container-wrap" style="padding-top: 0px;">
			<div class="container-wrap-inner">
				<div class="container">
					<article class="contents">
						<section class="contents-inner">

							<h4 class="mb10">
								<i class="awesome-reorder"></i>상품목록조회
							</h4>
							<form id="productSearchForm" name="productSearchForm"
								method="post"
								action=${popupYn eq 'Y' ? "/product/productPopupList/popup": "/product/productList"}>
								<input type="hidden" name="sortType"
									value="${paramMap.sortType}" /> <input type="hidden"
									name="decorator" value="adminPopup"> <input
									type="hidden" name="multiYn" value="${paramMap.multiYn }">
								<input type='hidden' name='excelRowCount' value='129' />

								<div class="form-group table">
									<table>
										<colgroup>
											<col width="12%" />
											<col width="*" />
											<col width="12%" />
											<col width="15%" />
											<col width="12%" />
											<col width="25%" />
										</colgroup>
										<tr>
											<th>분류선택</th>
											<td colspan='3'>
												<div id="listProductSelectCategory">
													<select id="selectCategorys0" name="selectCategorys"
														onchange="categorySelectLoad(this, '0', 'listProductSelectCategory', 'selectCategorys');">
														<option value="">---- 선택 ----</option>
														<c:forEach var="category" items="${categoryList}"
															varStatus="status">
															<option value="${category.ctgrId}"><c:out
																	value="${category.ctgrName}"></c:out>
															</option>
														</c:forEach>
													</select>
												</div>
											</td>

											<th>업체</th>
											<td><select name="vndrId" id="idVndrId">
													<option value="">선택해 주세요</option>
													<c:forEach var="vendor" items="${vendorList}">
														<option value="${vendor.vndrId}"
															<c:if test="${vendor.vndrId eq paramMap.vndrId}">selected</c:if>><c:out
																value="${vendor.vndrName}" /></option>
													</c:forEach>
											</select></td>

										</tr>
										<tr>
											<th>상품명</th>
											<td><input type="text" name="prdtEngName"
												value="<c:out value='${paramMap.prdtEngName}'/>"
												maxlength="50" style="width: 80%;"></td>
											<th>상품코드</th>
											<td><input type="text" name="prdtCode"
												value="<c:out value='${paramMap.prdtCode}'/>" maxlength="15"
												class="inputNumberText"
												style="ime-mode: disabled; width: 80%;"></td>
											<th>브랜드</th>
											<td><input type="text" id="brandEngName"
												name="brandEngName"
												value="<c:out value='${paramMap.brandEngName}'/>"
												maxlength="30" style="width: 60%;"> <input
												type="hidden" id="brandId" name="brandId" value="">
												<a href="javascript://" onclick="openBrandPopup();"
												title="새창에서 열림" class="btn btn-blue btn-search"><i
													class="entypo-search"></i></a></td>
										</tr>
										<tr>
											<th>판매상태</th>
											<td><input type="checkbox" name="prdtStatCode" value=""
												class="check_class" checked="checked" id="prdtStatCode0" />
												<label for="prdtStatCode">전체&nbsp;</label> <input
												type="checkbox" name="prdtStatCode" value="P"
												class="check_class" id="prdtStatCode1" /><label
												for="prdtStatCode1">판매중&nbsp;</label> <input type="checkbox"
												name="prdtStatCode" value="S" class="check_class"
												id="prdtStatCode2" /><label for="prdtStatCode2">일시품절&nbsp;</label>
												<input type="checkbox" name="prdtStatCode" value="F"
												class="check_class" id="prdtStatCode3" /><label
												for="prdtStatCode3">판매중지&nbsp;</label></td>
											<th>상품가격</th>
											<td><input type="text" name="dscntStartSellPrice"
												value="" class="inputNumberText"
												style="ime-mode: disabled; width: 35%;" maxlength="10" />원
												~ <input type="text" name="dscntEndSellPrice" value=""
												class="inputNumberText"
												style="ime-mode: disabled; width: 35%;" maxlength="10" />원</td>
											<th>전시여부</th>
											<td><input type="radio" name="dispYn" value=""
												checked="checked" id="dispYn" /><label for="dispYn">전체&nbsp;</label>

												<input type="radio" name="dispYn" value="true" id="dispYn1" /><label
												for="dispYn1">전시&nbsp;</label> <input type="radio"
												name="dispYn" value="false" id="dispYn2" /><label
												for="dispYn2">미전시&nbsp;</label></td>
										</tr>
										<tr>
											<th>상품승인기간</th>
											<td colspan="3">
												<!-- <input type="text" id="rgstStartDtm"
												name="rgstStartDtm" value="" style="width: 80px;"
												maxlength="8" onKeyDown="onlyNum();" /> ~ <input
												type="text" id="rgstEndDtm" name="rgstEndDtm" value=""
												style="width: 80px;" maxlength="8" onKeyDown="onlyNum();" />
												<a href="javascript://" class="btn btn-sm btnToday">오늘</a> <a
												href="javascript://" class="btn btn-sm btnWeek">1주일</a> <a
												href="javascript://" class="btn btn-sm btnMonth">한달</a> <a
												href="javascript://" class="btn btn-sm btn-blue btnAll">전체</a> -->
												<tiles:insertDefinition name="boDateSelect" />
											</td>
											<th>업체중지상품제외</th>
											<td><input type="radio" name="vndrStopPrdtEscp"
												value="false" checked="checked" id="vndrStopPrdtEscp" /><label
												for="vndrStopPrdtEscp1">예&nbsp;</label> <input type="radio"
												name="vndrStopPrdtEscp" value="true" id="vndrStopPrdtEscp" /><label
												for="vndrStopPrdtEscp2">아니오&nbsp;</label></td>
										</tr>

									</table>
									<div class="grid-box">
										<div class="fl-r">
											<input type="submit"
												class="btn btn-blue btn-icon btnSearch btn-submit"
												value="검색"> <a
												href=${popupYn eq 'Y' ? "/product/productPopupList/popup":"/product/productList"}
												class="btn btn-danger btnReset">초기화</a>
										</div>
									</div>
								</div>

								<div class="form-group table mt30 product_a_list list">
									<c:set var="listSizeArray2">
										<tiles:getAsString name="listSizeArray"
											defaultValue="20,50,100" />
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
											<i class="entypo-search"></i> 전체 <span class="fc-01">${productList.totalElements}</span>
											건 (<span class="fc-01">${productList.numberOfElements eq 0 ? productList.numberOfElements : productList.number}/${productList.totalPages}</span>
											페이지)
										</div>
										<div class="fl-r">
											<a href="javascript://" class="btn btn-blue btn-xs"><span
												id="sortA">정상가<i class="entypo-up-open"></i></span></a> <a
												href="javascript://" class="btn btn-blue btn-xs"><span
												id="sortB">할인율<i class="entypo-up-open"></i></span></a> <a
												href="javascript://" class="btn btn-blue btn-xs"><span
												id="sortC">온라인할인율<i class="entypo-up-open"></i></span></a> <a
												href="javascript://" class="btn btn-blue btn-xs"><span
												id="sortD">판매가<i class="entypo-up-open"></i></span></a> <a
												href="javascript://" class="btn btn-blue btn-xs"><span
												id="sortE">재고<i class="entypo-up-open"></i></span></a> <a
												href="javascript://" class="btn btn-blue btn-xs"><span
												id="sortF">판매상태<i class="entypo-up-open"></i></span></a> <a
												href="javascript://" class="btn btn-blue btn-xs"><span
												id="sortG">전시여부<i class="entypo-up-open"></i></span></a> <a
												href="javascript://" class="btn btn-blue btn-xs"><span
												id="sortH">승인일<i class="entypo-up-open"></i></span></a> <select
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
											<col width="5%" />
											<col width="5%" />
											<col width="*" />
											<col width="17%" />
											<col width="6%" />
											<col width="5%" />
											<col width="5%" />
											<col width="6%" />
											<col width="5%" />
											<col width="7%" />
											<col width="5%" />
											<col width="5%" />
											<col width="9%" />
										</colgroup>
										<tr>
											<th><input type="checkbox" id="prdtPopupAllChecked"
												name="headCheck" /></th>
											<th>상품코드</th>
											<th>상품명</th>
											<th>카테고리</th>
											<th>정상가</th>
											<th>ERP할인율</th>
											<th>온라인할인율</th>
											<th>판매가</th>
											<th>재고</th>
											<th>판매상태</th>
											<th>전시여부</th>
											<th>고시여부</th>
											<th>승인일</th>
										</tr>

										<c:if test="${empty productList.content }">
											<tr>
												<td colspan="13">등록된 데이터가 없습니다.</td>
											</tr>
										</c:if>
										<c:if test="${!empty productList.content}">
											<c:forEach items="${productList.content}" var="product"
												varStatus="status">
												<tr>
													<c:if test="${popupYn eq 'Y' && paramMap.multYn eq 'Y' }"></c:if>
													<td><input type="checkbox" name="listCheck"
														value="<c:out value="${status.index}"/>" <%-- <c:out value="${product.prdtCode}"/> --%> /></td>
													<td><a href="javascript://" class="fc-02 bold link"><c:out
																value="${product.prdtCode}" /><span>${product.prdtCode}</span></a></td>
													<td class="product_info align-left"><a
														href="javascript://"
														onclick="ProductImagePopup('${product.prdtImagePath}');">
															<img
															data-original="//image.crewmate.co.kr/${product.prdtImagePath}"
															src="//image.crewmate.co.kr/${product.prdtImagePath}"
															alt="" class="lazy-loading smallImage" width="50"
															height="50" onerror="imageError(this)"
															style="display: inline;">
															<noscript>
																<img
																	src="//image.crewmate.co.kr/${product.prdtImagePath}" />
															</noscript>
													</a> <a href="javascript://"
														onclick="ProductImagePopup('${product.prdtImagePath}');"
														class="fc-02 bold link"> <span>[${product.brandName}]</span>
															<span>${product.prdtEngName}</span> <span></span></a></td>

													<td><c:out value="${product.category}" /></td>
													<td><c:out value="${product.prdtSellPrice}" /></td>
													<td>0</td>
													<td>0</td>
													<td><c:out value="${product.prdtSellPrice}" /></td>
													<td><c:out value="${product.laveCount}" /></td>
													<td><c:out
															value="${product.prdtStatCode eq 'P'? '판매중' :product.prdtStatCode eq 'F'? '판매중지':'일시품절'}" /></td>
													<td><c:out
															value="${product.dispYn eq 'Y'? '전시' : '미전시'}" /></td>
													<td><c:out value="${product.ftcYn}" /></td>
													<td><c:out value="${product.prmtDtm}" /></td>
												</tr>
											</c:forEach>
										</c:if>
										</tbody>
									</table>
									<div class="pagination clearfix align-center">
										<div class="table-pagination">
											<core:pagination listResultName="productList" />
										</div>
									</div>
									<c:if test="${popupYn eq 'Y'}">
										<div class="grid-box">
											<p class="fl-r">
												<a href="javascript://" class="btn btn-primary"
													onClick="setProductList('Y');">입력</a>
											</p>
										</div>
									</c:if>
								</div>
							</form>
						</section>
					</article>
				</div>
			</div>
		</div>
		<!-- <div class="bg-pop">
            <a href="#닫기" class="btn btn-sm fl-r close">닫기</a>
        </div> -->
	</div>
</body>
</html>