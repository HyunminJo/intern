<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/crewmate/core" prefix="core"%>

<%-- 검색 영역 시작 --%>
<div class="table-form-wrap">
	<c:if test="${popupYn ne 'Y'}">
		<header class="contents-header">
			<h3 class="heading-title">
				<i class="awesome-large awesome-file"></i>브랜드관리
			</h3>
			<ol class="location">
				<li><a href="/admin/main"><i class="entypo-home"></i>Home</a></li>
				<li><i class="entypo-right-open-mini"></i>상품관리</li>
				<li><i class="entypo-right-open-mini"></i>브랜드관리</li>
				<li class="active"><i class="entypo-right-open-mini"></i><strong>브랜드관리</strong></li>
			</ol>
		</header>
	</c:if>

	<form name="searchForm"
		action=${popupYn eq 'Y' ? "/product/brandList/popup": "/prduct/brandList"}
		method="get">
		<table class="table-form">
			<colgroup>
				<col style="width: 121px">
				<col>
				<col style="width: 121px">
				<col>
			</colgroup>
			<tbody>
				<tr>
					<th>국문 브랜드명</th>
					<td class="tl form-100p" colspan="2"><input type="text"
						name="brandName" value="<c:out value='${paramMap.brandName}'/>" />
					</td>
				</tr>
				<tr>
					<th>영문 브랜드명</th>
					<td class="tl form-100p" colspan="2"><input type="text"
						name="brandEngName	"
						value="<c:out value='${paramMap.brandEngName}'/>" /></td>
				</tr>
				<tr>
					<th>브랜드 ID</th>
					<td class="tl form-100p" colspan="2"><input type="text"
						name="brandId" value="<c:out value='${paramMap.brandId}'/>" /></td>
				</tr>

			</tbody>
		</table>
		<tiles:insertDefinition name="boSearchBtn" />
	</form>
</div>
<%-- 검색 영역 종료 --%>

<%-- 목록 영역 시작 --%>
<div class="table-list-wrap">

	<div class="table-header">
		<tiles:insertDefinition name="boListSizeSelect" />
	</div>

	<table class="table-list">
		<colgroup>
			<c:if test="${popupYn eq 'Y'}">
				<col style="width: 5%;" />
			</c:if>
			<col class="seq">
			<col style="width: 25%;" />
			<col style="width: 10%;" />
			<col style="width: 15%;" />
			<col style="width: 15%;" />
			<col style="width: 5%;" />
		</colgroup>
		<thead>
			<tr>
				<c:if test="${popupYn eq 'Y'}">
					<th></th>
				</c:if>
				<th>번호</th>
				<th>국문 브랜드명</th>
				<th>영문 브랜드명</th>
				<th>브랜드 ID</th>
				<th>프리미엄 여부</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty brandList.content }">
				<tr>
					<td colspan="6">등록된 데이터가 없습니다.</td>
				</tr>
			</c:if>
			<c:forEach items="${brandList.content}" var="brand"
				varStatus="status">
				<tr>
					<td></td>
					<td><c:out
							value="${brandList.totalElements - ((brandList.number - 1) * brandList.size) - status.index }" />
					</td>
					<td><a
						onclick="selectBrand('${brand.brandName}','${brand.brandId}')"><c:out
								value="${brand.brandName}" /></a>
					</td>
					<td><c:out value="${brand.brandEngName}" /></td>
					<td><c:out value="${brand.brandId}" /></td>
					<td><c:out value="${brand.prmmYn}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="table-footer">
		<div class="table-pagination">
			<core:pagination listResultName="brandList" />
		</div>
	</div>
</div>
<%-- 목록 영역 종료 --%>

<script type="text/javascript" src="/js/form.js"></script>
<script>
	function selectBrand(brandName, brandId) {
		opener.callbackBrandPopup(brandName, brandId);
		window.close();
	}
	
	$("#btnSearch").click(function(event) {
    	$("form#searchForm").submit();
    });
</script>
