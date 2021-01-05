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
<div class="day">
	<div class="datepicker-wrap">
		<input type="text" name="${dispStartDtm}" class="datepicker date-from"
			onkeydown="return false;"
			value="<core:mask pattern="########"><c:out value="${onePopupForm.dispStartDtm}" /></core:mask>" />
	</div>
	<select name="displayStartHour" class="select_class" tabindex="2">
		<c:forEach var="dtm" begin="0" end="23" step="1" varStatus="status">
			<c:if test="${status.index < '10'}">
				<option value="<c:out value="0${status.index}"/>">
					<c:out value="0${status.index}시" />
				</option>
			</c:if>
			<c:if test="${status.index > '9'}">
				<option value="<c:out value="${status.index}"/>">
					<c:out value="${status.index}시" />
				</option>
			</c:if>
		</c:forEach>
	</select> <select name="displayStartMinute" class="select_class" tabindex="2">
		<c:forEach var="dtm" begin="0" end="5" step="1" varStatus="status">
			<option value="<c:out value="${status.index}0"/>">
				<c:out value="${status.index}0분" />
			</option>
		</c:forEach>
	</select> ~
	<div class="datepicker-wrap">
		<input type="text" name="${dispEndDtm}" class="datepicker date-to"
			onkeydown="return false;"
			value="<core:mask pattern="########"><c:out value="${onePopupForm.dispEndDtm}" /></core:mask>" />
	</div>
	<select name="displayEndHour" class="select_class" tabindex="2">
		<c:forEach var="dtm" begin="0" end="23" step="1" varStatus="status">
			<c:if test="${status.index < '10'}">
				<option value="<c:out value="0${status.index}"/>">
					<c:out value="0${status.index}시" />
				</option>
			</c:if>
			<c:if test="${status.index > '9'}">
				<option value="<c:out value="${status.index}"/>">
					<c:out value="${status.index}시" />
				</option>
			</c:if>
		</c:forEach>
	</select> <select name="displayEndMinute" class="select_class" tabindex="2">
		<c:forEach var="dtm" begin="0" end="5" step="1" varStatus="status">
			<option value="<c:out value="${status.index}0"/>">
				<c:out value="${status.index}0분" />
			</option>
		</c:forEach>
	</select>
</div>

