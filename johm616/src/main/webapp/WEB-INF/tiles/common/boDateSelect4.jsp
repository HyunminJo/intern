<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="/crewmate/core" prefix="core"%>


<c:if test="${empty dispStartDtm}">
	<c:set var="dispStartDtm">dispStartDtm</c:set>
</c:if>
<c:if test="${empty dispEndDtm}">
	<c:set var="dispEndDtm">dispEndDtm</c:set>
</c:if>

<c:if test="${empty dispStartDtm}">
	<c:set var="dispStartDtm">${paramMap.dispStartDtm}</c:set>
</c:if>
<c:if test="${empty dispEndDtm}">
	<c:set var="dispEndDtm">${paramMap.dispEndDtm}</c:set>
</c:if>

<c:if test="${empty rangeSelectYn}">
	<c:set var="rangeSelectYn">
		<tiles:getAsString name="rangeSelectYn" defaultValue="Y" />
	</c:set>
</c:if>


<%-- 시작/종료일자 기본값 처리 로직 추가 --%>

<select id="birthday1" name="birthday1" title="생년월일"
	class="tbl-select-year required">
	<option value=''>년</option>
	<c:forEach var="year" begin="1920" end="2020" step="1"
		varStatus="status">
		<option value="<c:out value='${status.index}'/>">
			<c:out value="${status.index}" />
		</option>
	</c:forEach>
</select>
<select id="birthday2" name="birthday2" title="생년월일"
	class="tbl-select-month required">
	<option value=''>월</option>
	<c:forEach var="month" begin="1" end="12" step="1" varStatus="status">
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
</select>
<select id="birthday3" name="birthday3" title="생년월일"
	class="tbl-select-day required">
	<option value=''>일</option>
	<c:forEach var="day" begin="1" end="31" step="1" varStatus="status">
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
</select>

