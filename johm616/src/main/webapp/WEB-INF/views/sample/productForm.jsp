<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="/crewmate/core" prefix="core"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<link rel="shortcut icon" href="/images/favicon.ico">
<link rel="stylesheet" type="text/css"
	href="/css/jquery-ui-1.12.1.min.css">
<link rel="stylesheet" href="/css/bo/common.css" type="text/css">
<link rel="stylesheet" href="/css/bo/theme_typeA.css" type="text/css">
<link rel="stylesheet" href="/css/bo/icons/font-awesome.css"
	type="text/css">
<!-- <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head> -->
<body>
	<div class="wrap">
		<div class="header-wrap"></div>
		<div class="container-wrap">
			<div class="container" style="padding-bottom: 7%;">
				<article class="contents">
					<header class="contents-header">
						<h3 class="heading-title">
							<i class="awesome-large awesome-file"></i> 상품등록
						</h3>
						<ol class="location">
							<li><a href=""> <i class="entypo-home">Home</i>
							</a></li>
							<li><i class="entypo-right-open-mini">상품관리</i></li>
							<li><i class="entypo-right-open-mini">상품관리</i></li>
							<li class="active"><i class="entypo-right-open-mini"></i> <strong>상품등록</strong>
							</li>
						</ol>
					</header>
					<section class="contents-inner">
						<form id="modifyProductForm" name="modifyProductForm"
							action=${popupYn eq 'Y' ? "/product/product/popup" : "/product/product"}
							method="post" enctype="multipart/form-data">
							<div id="errorMessagesArea"></div>
							<div class="form-group table">
								<div class="grid-box">
									<div class="fl-l">
										<h5>
											<i class="entypo-plus-squared"></i> 상품 기본정보
										</h5>
									</div>
									<div class="fl-r mb5">
										<a href="javascript://" class="btn btn-primary modifyProduct"
											id="create">저장</a>
									</div>
								</div>
								<table>
									<colgroup>
										<col width="15%">
										<col width="*">
										<col width="13%">
										<col width="37%">
									</colgroup>
									<tbody>
										<tr>
											<th>업체 <i class="entypo-check"></i>
											</th>
											<td colspan="3"><select name="vndrCntrtId"
												id="idVnderCntrtId">
													<option value>선택해주세요</option>
													<c:forEach var="vendor" items="${vendorList}">
														<option value="${vendor.vndrCntrtId}"><c:out
																value="${vendor.vndrName}"></c:out>(수수료:${vendor.vndrCmsnRate}%)
														</option>
													</c:forEach>
											</select></td>
										</tr>
										<tr>
											<th>영문/국문상품명 <i class="entypo-check"></i>
											</th>
											<td colspan="3"><input type="text" name="prdtEngName"
												style="width: 35%;" value="" maxlength="50">
												&nbsp;/&nbsp; <input type="text" name="prdtKorName"
												style="width: 35%;" value="" maxlength="50"></td>
										</tr>
										<tr>
											<th>상품코드</th>
											<td><span class="bold fc-01">[자동생성]</span> <input
												type="hidden" name="prdtCode" value></td>
											<th>브랜드 <i class="entypo-check"></i>
											</th>
											<td><input type="text" id="brandName" name="brandName"
												style="width: 100px;" value readonly="readonly"> <input
												type="hidden" id="brandId" name="brandId"
												style="width: 150px;" value> <a href="javascript://"
												class="btn btn-blue btn-search" onclick="openBrandPopup();">
													<i class="entypo-search"></i>
											</a></td>
										</tr>
										<tr>
											<th>원산지<i class="entypo-check"></i></th>
											<td><select name="cooCode" class="select_class">
													<option value="">선택해 주세요</option>
													<c:forEach var="origin" items="${originList}">
														<option value="${origin.codeName}"><c:out
																value="${origin.codeValue}"></c:out></option>
													</c:forEach>

											</select></td>
											<th>판매여부</th>
											<td><input type="radio" name="prdtStatCode" value="P"
												checked="checked" id="prdtStatCode1"><label
												for="prdtStatCode1">판매중&nbsp;</label> <input type="radio"
												name="prdtStatCode" value="S" id="prdtStatCode2"><label
												for="prdtStatCode2">일시품절&nbsp;</label> <input type="radio"
												name="prdtStatCode" value="F" id="prdtStatCode3"><label
												for="prdtStatCode3">판매중지&nbsp;</label></td>
										</tr>
										<tr>
											<th>제조사<i class="entypo-check"></i></th>
											<td><input type="text" name="mnftrName"
												style="width: 150px;" value="" maxlength="40"></td>
											<th>전시여부</th>
											<td><input type="radio" name="dispYn" value="true"
												checked="checked" id="dispYn1"><label for="dispYn1">전시&nbsp;</label>
												<input type="radio" name="dispYn" value="false" id="dispYn2"><label
												for="dispYn2">미전시&nbsp;</label></td>
										</tr>
										<tr>
											<th>상단아이콘설정</th>
											<td colspan="3"><input type="checkbox" name="upIconCode"
												value="01" id="upIconCode1"><label for="upIconCode1">신상품&nbsp;</label>
												<input type="checkbox" name="upIconCode" value="02"
												id="upIconCode2"><label for="upIconCode2">추천상품&nbsp;</label>
												<input type="checkbox" name="upIconCode" value="03"
												id="upIconCode3"><label for="upIconCode3">인기상품&nbsp;</label>
												<input type="checkbox" name="upIconCode" value="04"
												id="upIconCode4"><label for="upIconCode4">베스트상품&nbsp;</label>
												<input type="checkbox" name="upIconCode" value="05"
												id="upIconCode5"><label for="upIconCode5">HIT&nbsp;</label>
												<input type="checkbox" name="upIconCode" value="06"
												id="upIconCode6"><label for="upIconCode6">NEW&nbsp;</label>
											</td>
										</tr>
										<tr>
											<th>하단아이콘설정</th>
											<td colspan="3"><input type="checkbox"
												name="downIconCode" value="07" id="downIconCode1"><label
												for="downIconCode1">세일&nbsp;</label> <input type="checkbox"
												name="downIconCode" value="08" id="downIconCode2"><label
												for="downIconCode2">단독&nbsp;</label> <input type="checkbox"
												name="downIconCode" value="09" id="downIconCode3"><label
												for="downIconCode3">이벤트&nbsp;</label> <input type="checkbox"
												name="downIconCode" value="10" id="downIconCode4"><label
												for="downIconCode4">기획&nbsp;</label></td>
										</tr>
										<tr>
											<th>키워드설정</th>
											<td colspan="3"><input type="text" name="srchWord"
												style="width: 60%;" value="" maxlength="255"> ※키워드를
												쉼표(,)로 구분하여 주세요.</td>
										</tr>
									</tbody>
								</table>
							</div>

							<!-- 상품 분류정보 -->
							<div class="form-group table mt30">
								<h5 class="mb5">
									<i class="entypo-plus-squared"></i> 상품 분류정보
								</h5>
								<table class="prdtCtgrList group-center">
									<colgroup>
										<col width="12%">
										<col width="*">
										<col width="8%">
									</colgroup>
									<tbody>
										<tr>
											<td colspan="3" class="align-left"><span
												id="listProductSelectCategory"> <select
													name="selectCategorys"
													onchange="categorySelectLoad(this.value, '0', 'listProductSelectCategory', 'selectCategorys');">
														<option value="00">---- 선택 ----</option>
														<c:forEach var="category" items="${categoryList}"
															varStatus="status">
															<option value="${category.ctgrId}"><c:out
																	value="${category.ctgrName}"></c:out></option>
														</c:forEach>

												</select>
											</span> <span class="btn btn-sm btn-blue prdtCategoryAddBtn"
												onclick="addCategory();"> 추가 <i
													class="entypo-list-add"></i>
											</span></td>
										</tr>
										<tr>
											<th>기준상품분류</th>
											<th>상품분류정보</th>
											<th>삭제</th>
										</tr>
									</tbody>
								</table>
							</div>

							<!-- 상품 가격정보 -->
							<div class="form-group table mt30">
								<h5 class="mb5">
									<i class="entypo-plus-squared"></i>상품 가격정보
								</h5>
								<table>
									<colgroup>
										<col width="15%" />
										<col width="*" />
										<col width="15%" />
										<col width="35%" />
									</colgroup>
									<tr>
										<th>정상가<i class="entypo-check"></i></th>
										<td><input type="text" name="prdtSellPrice" value=""
											style="width: 80%; ime-mode: disabled;" maxlength="8"
											class="inputNumberText" onblur="chngErpSellPriceRate();" />원
										</td>
										<th>판매가<i class="entypo-check"></i></th>
										<td><input type="text" name="dscntErpSellPrice" value=""
											style="width: 57%; ime-mode: disabled;" maxlength="8"
											class="inputNumberText" onblur="chngErpSellPriceRate();" />원
											&nbsp;&nbsp; 할인율 <input type="text" name="erpSellPriceRate"
											style="width: 15%;" value="" readonly="readonly" />%</td>
									</tr>
									<tr>
										<th>최소구매수량<i class="entypo-check"></i></th>
										<td><input type="text" name="minBuyCount" value="1"
											style="width: 35%;" maxlength="5" class="inputNumberText"
											style="ime-mode: disabled;" /></td>
										<th>최대구매수량<i class="entypo-check"></i></th>
										<td><input type="text" name="maxBuyCount" value="99999"
											style="width: 35%;" maxlength="5" class="inputNumberText"
											style="ime-mode: disabled;" /></td>
									</tr>
									<tr>
										<th>배송비구분<i class="entypo-check"></i></th>
										<td colspan="3"><input type="radio" name="freeDlvyYn"
											value="true" id="freeDlvyYn1" /><label for="freeDlvyYn1">무료&nbsp;</label>
											<input type="radio" name="freeDlvyYn" value="false"
											checked="checked" id="freeDlvyYn2" /><label
											for="freeDlvyYn2">유료&nbsp;</label></td>
									</tr>
								</table>
							</div>

							<!-- 상품 옵션정보 -->
							<div class="form-group table mt30">
								<h5 class="mb5">
									<i class="entypo-plus-squared"></i>상품 옵션정보
								</h5>
								<table class="group-center">
									<colgroup>
										<col width="15%" />
										<col width="*" />
										<col width="15%" />
										<col width="35%" />
									</colgroup>
									<tr>
										<th>옵션사용여부 <i class="entypo-check"></i></th>
										<td class="align-left"><select name="optnUseYn"
											class="selectOptnUseYn">
												<option value="true">사용</option>
												<option value="false" selected>사용안함</option>
										</select></td>
										<th><span style="display:;" class="toggleUseOptnArea">옵션
												재고</span><span style="display: none;" class="toggleUseOptnArea">옵션
												분류 추가</span><i class="entypo-check"></i></th>
										<td class="align-left">
											<p style="display:;" class="toggleUseOptnArea">
												<input type="text" name="noOptionStockCount" value="0"
													class="inputNumberText" style="width: 80%">
											</p>
											<p style="display: none;" class="toggleUseOptnArea">
												<a href="#행추가"
													class="btn btn-sm btn-blue btnAddOptionMaster btnInvisible">추가<i
													class="entypo-list-add"></i></a>
											</p>
										</td>
									</tr>
								</table>
							</div>

							<div id="optionMasterArea" class="form-group table"></div>
							<div class="grid-box toggleUseOptnArea" style="display: none">
								<div class="fl-r">
									<a href="#옵션재고추가" class="btn btn-primary addOptionStockSelect">옵션재고추가</a>
									<a href="#옵션재고삭제"
										class="btn btn-danger respectOptionStockSelect"
										style="display: none">옵션재고삭제</a>
								</div>
							</div>
							<div id="addOptionSelectArea" class="form-group table"></div>
							<div id="optionSelectArea" class="form-group table"></div>

							<!-- 관련상품정보 -->
							<div class="form-group table mt30">
								<h5 class="mb5">
									<i class="entypo-plus-squared"></i>관련상품정보
								</h5>
								<table>
									<col width="20%" />
									<col width="*" />
									<tr>
										<th>관련상품정보 설정</th>
										<td><input type="radio" name="cntrPrdtUseYn" value="true"
											class="cntrPrdtUseYn" id="cntrPrdtUseYn1" /> <label
											for="cntrPrdtUseYn1">관련상품있음&nbsp;</label> <input type="radio"
											name="cntrPrdtUseYn" value="false" class="cntrPrdtUseYn"
											checked="checked" id="cntrPrdtUseYn2" /> <label
											for="cntrPrdtUseYn2">관련상품없음&nbsp;</label></td>
									</tr>
								</table>
								<div id="cntrPrdtList">
									<div class="grid-box mb5">
										<div class="fl-r">
											<a href="javascript://" onclick="productListPopup('Y');"
												title="새창에서 열림" class="btn btn-sm btn-blue">관련상품추가<i
												class="entypo-popup"></i></a>
										</div>
									</div>
									<table id="tableCntrPrdtList" class="group-center">
										<colgroup>
											<col width="8%" />
											<col width="15%" />
											<col width="*" />
											<col width="15%" />
											<col width="20%" />
											<col width="8%" />
										</colgroup>
										<tr>
											<th>번호</th>
											<th>상품코드</th>
											<th>상품명</th>
											<th>브랜드</th>
											<th>상품분류</th>
											<th>삭제</th>
										</tr>
									</table>
								</div>
							</div>

							<!-- 정보고시정보 -->
							<div class="form-group table mt30">
								<h5 class="mb5">
									<i class="entypo-plus-squared"></i>정보고시정보
								</h5>
								<p class="mb5">
									<select name="prntFtcInfoSeq">
										<option value="">선택해 주세요</option>
										<c:forEach var="ftcInfo" items="${ftcInfo}">
											<option value="${ftcInfo.ftcInfoSeq}"><c:out
													value="${ftcInfo.ftcInfoName}"></c:out></option>
										</c:forEach>
									</select>
								</p>
								<div id="ftcInfoList"></div>
							</div>

							<!-- 상품 이미지정보 -->
							<div class="form-group table mt30">
								<!-- start image_register -->
								<div class="image_register">
									<h5 class="mb5">
										<i class="entypo-plus-squared"></i>상품 이미지정보
									</h5>
									<table>
										<colgroup>
											<col width="41%" />
											<col width="*" />
										</colgroup>
										<tbody>
											<tr>
												<td>
													<div class="images_view">
														<p class="big_size">
															<img src="" alt="hello" id="prdtImagePath"
																class="lazy-loading" width="250" height="250"
																onerror="imageError(this)" />
														<noscript>
															<img src="//image.crewmate.co.kr" />
														</noscript>
														</p>
														<img src="" alt="hello" id="prdtImagePath1"
															class="lazy-loading smallImage" width="50" height="50"
															onerror="imageError(this)" />
														<noscript>
															<img src="//image.crewmate.co.kr" />
														</noscript>

														<img src="" alt="hello" id="prdtImagePath2"
															class="lazy-loading smallImage" width="50" height="50"
															onerror="imageError(this)" />
														<noscript>
															<img src="//image.crewmate.co.kr" />
														</noscript>

														<img src="" alt="hello" id="prdtImagePath3"
															class="lazy-loading smallImage" width="50" height="50"
															onerror="imageError(this)" />
														<noscript>
															<img src="//image.crewmate.co.kr" />
														</noscript>

														<img src="" alt="hello" id="prdtImagePath4"
															class="lazy-loading smallImage" width="50" height="50"
															onerror="imageError(this)" />
														<noscript>
															<img src="//image.crewmate.co.kr" />
														</noscript>

														<img src="" alt="hello" id="prdtImagePath5"
															class="lazy-loading smallImage" width="50" height="50"
															onerror="imageError(this)" />
														<noscript>
															<img src="//image.crewmate.co.kr" />
														</noscript>

														<img src="" alt="hello" id="prdtImagePath6"
															class="lazy-loading smallImage" width="50" height="50"
															onerror="imageError(this)" />
														<noscript>
															<img src="//image.crewmate.co.kr" />
														</noscript>

														<img src="" alt="hello" id="prdtImagePath7"
															class="lazy-loading smallImage" width="50" height="50"
															onerror="imageError(this)" />
														<noscript>
															<img src="//image.crewmate.co.kr" />
														</noscript>
													</div> <!-- end images_view -->
												</td>
												<td class="register">
													<ul>
														<li>최적의 이미지 사이즈는 <span class="fc-01">400 x 400
																pixel</span>입니다.
														</li>
														<li>파일명은 영문/숫자의 조합만 가능합니다.</li>
														<li>JPG 또는 GIF만 등록 가능합니다.</li>
													</ul>
													<ul class="register">

														<li class="first-child mb5"><span class="fc-01">
																필수 </span> 1. 대표이미지 <input type="text" id="prdtImagePath01"
															name="prdtImagePaths" style="width: 55%;" value=""
															class="" /> <input type="hidden" name="prdtImageCodes"
															value="01" /> <input type="file" id="prdtImageFile01"
															name="prdtImageFile01"
															onchange="displayFile(this, 'prdtImagePath01');"
															style="display: none;" /> <a href="javascript://"
															onclick="openFile('prdtImageFile01');"
															class="btn btn-blue btn-icon">찾아보기<i
																class="entypo-popup"></i></a> <a href="javascript://"
															class="btn btn-danger btn-search" onclick="clearImg(1);"><i
																class="entypo-cancel"></i></a></li>
														<li class="first-child mb5"><span class="fc-01">
																선택 </span> 2. 추가이미지 <input type="text" id="prdtImagePath02"
															name="prdtImagePaths" style="width: 55%;" value=""
															class="" /> <input type="hidden" name="prdtImageCodes"
															value="02" /> <input type="file" id="prdtImageFile02"
															name="prdtImageFile02"
															onchange="displayFile(this, 'prdtImagePath02');"
															style="display: none;" /> <a href="javascript://"
															onclick="openFile('prdtImageFile02');"
															class="btn btn-blue btn-icon">찾아보기<i
																class="entypo-popup"></i></a> <a href="javascript://"
															class="btn btn-danger btn-search" onclick="clearImg(2);"><i
																class="entypo-cancel"></i></a></li>
														<li class="first-child mb5"><span class="fc-01">
																선택 </span> 3. 추가이미지 <input type="text" id="prdtImagePath03"
															name="prdtImagePaths" style="width: 55%;" value=""
															class="" /> <input type="hidden" name="prdtImageCodes"
															value="03" /> <input type="file" id="prdtImageFile03"
															name="prdtImageFile03"
															onchange="displayFile(this, 'prdtImagePath03');"
															style="display: none;" /> <a href="javascript://"
															onclick="openFile('prdtImageFile03');"
															class="btn btn-blue btn-icon">찾아보기<i
																class="entypo-popup"></i></a> <a href="javascript://"
															class="btn btn-danger btn-search" onclick="clearImg(3);"><i
																class="entypo-cancel"></i></a></li>
														<li class="first-child mb5"><span class="fc-01">
																선택 </span> 4. 추가이미지 <input type="text" id="prdtImagePath04"
															name="prdtImagePaths" style="width: 55%;" value=""
															class="" /> <input type="hidden" name="prdtImageCodes"
															value="04" /> <input type="file" id="prdtImageFile04"
															name="prdtImageFile04"
															onchange="displayFile(this, 'prdtImagePath04');"
															style="display: none;" /> <a href="javascript://"
															onclick="openFile('prdtImageFile04');"
															class="btn btn-blue btn-icon">찾아보기<i
																class="entypo-popup"></i></a> <a href="javascript://"
															class="btn btn-danger btn-search" onclick="clearImg(4);"><i
																class="entypo-cancel"></i></a></li>
														<li class="first-child mb5"><span class="fc-01">
																선택 </span> 5. 추가이미지 <input type="text" id="prdtImagePath05"
															name="prdtImagePaths" style="width: 55%;" value=""
															class="" /> <input type="hidden" name="prdtImageCodes"
															value="05" /> <input type="file" id="prdtImageFile05"
															name="prdtImageFile05"
															onchange="displayFile(this, 'prdtImagePath05');"
															style="display: none;" /> <a href="javascript://"
															onclick="openFile('prdtImageFile05');"
															class="btn btn-blue btn-icon">찾아보기<i
																class="entypo-popup"></i></a> <a href="javascript://"
															class="btn btn-danger btn-search" onclick="clearImg(5);"><i
																class="entypo-cancel"></i></a></li>
														<li class="first-child mb5"><span class="fc-01">
																선택 </span> 6. 메인이미지 <input type="text" id="prdtImagePath06"
															name="prdtImagePaths" style="width: 55%;" value=""
															class="" /> <input type="hidden" name="prdtImageCodes"
															value="06" /> <input type="file" id="prdtImageFile06"
															name="prdtImageFile06"
															onchange="displayFile(this, 'prdtImagePath06');"
															style="display: none;" /> <a href="javascript://"
															onclick="openFile('prdtImageFile06');"
															class="btn btn-blue btn-icon">찾아보기<i
																class="entypo-popup"></i></a> <a href="javascript://"
															class="btn btn-danger btn-search" onclick="clearImg(6);"><i
																class="entypo-cancel"></i></a></li>
														<li class="first-child mb5"><span class="fc-01">
																선택 </span> 7. 목록이미지 <input type="text" id="prdtImagePath07"
															name="prdtImagePaths" style="width: 55%;" value=""
															class="" /> <input type="hidden" name="prdtImageCodes"
															value="07" /> <input type="file" id="prdtImageFile07"
															name="prdtImageFile07"
															onchange="displayFile(this, 'prdtImagePath07');"
															style="display: none;" /> <a href="javascript://"
															onclick="openFile('prdtImageFile07');"
															class="btn btn-blue btn-icon">찾아보기<i
																class="entypo-popup"></i></a> <a href="javascript://"
															class="btn btn-danger btn-search" onclick="clearImg(7);"><i
																class="entypo-cancel"></i></a></li>
													</ul>
													<p>메인/목록 이미지를 등록하지 않으면 대표이미지가 축소되어 저장됩니다.</p>
													<p>메인이미지의 최적 사이즈는 200 * 200 pixel 입니다.</p>
													<p>목록이미지의 최적 사이즈는 150 * 150 pixel 입니다.</p>
												</td>
											</tr>
										</tbody>
									</table>
								</div>
								<!-- end image_register -->
							</div>

							<!-- 상품 상세정보 -->
							<div class="form-group table mt30">
								<h5 class="mb5">
									<i class="entypo-plus-squared"></i>상품 상세정보
								</h5>
								텍스트 및 이미지로 제작한 파일을 업로드 해주세요.(동영상은 업로드 불가합니다.)
								<table>
									<tr>
										<td><textarea name="prdtDtlInfo" rows="8" cols="60"></textarea>
											<script type="text/javascript"
												src="/js/ckeditor/ckeditor.js?t=B37D54V"></script> <script
												type="text/javascript">
													//<![CDATA[
													CKEDITOR
															.replace(
																	'prdtDtlInfo',
																	{
																		"filebrowserUploadUrl" : "\/admin\/productImageUpload",
																		"height" : "500px"
																	});
													//]]>
												</script></td>
									</tr>
								</table>
								<div class="grid-box">
									<p class="fl-r">
										<a href="javascript://" class="btn btn-primary modifyProduct"
											id="create">저장</a>
									</p>
								</div>
							</div>
						</form>
					</section>
				</article>
			</div>
		</div>
	</div>
	<div class="footer-wrap">
		<footer class="footer">
			<address>copyright 2016 crewmate all right reserved.</address>
		</footer>
	</div>
</body>
<script type="text/javascript" src="/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="/js/jquery-ui-1.12.1.min.js"></script>
<script type="text/javascript" src="/js/common.js"></script>
<tiles:insertDefinition name="boCommonScript" />
<script type="text/javascript" src="/js/form.js"></script>
<script src="http://malsup.github.com/jquery.form.js"></script>
<script type="text/javascript">

</script>
</html>