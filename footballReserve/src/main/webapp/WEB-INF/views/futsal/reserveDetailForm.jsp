<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/reserveTable.css">

<div class="container">
		<table class="table">
			<tr>
				<th rowspan="6" class="reserveImageth"><c:forEach items="${futsalDTO.futsalImageDTO}"
						var="futsalImageDTO" begin="0" end="0">
						<img
							src="${pageContext.request.contextPath}/resources/images/futsalImages/${futsalImageDTO.futsalImagePath}" />
					</c:forEach></th>
				<th>풋살장 이름</th>
				<th colspan="2">${futsalDTO.futsalSub}</th>
			</tr>
			<tr>
				<th>풋살장 주소</th>
				<th colspan="2">${futsalDTO.futsalAddr}</th>
			</tr>
			<tr>
				<th>최대 사용자 수</th>
				<th colspan="2">${futsalDTO.futsalMaxUser}명</th>
			</tr>
			<tr>
				<th>시간당 가격</th>
				<th colspan="2">${futsalDTO.futsalPPHDTO.futsalPrice}원</th>
			</tr>
			<tr>
				<th>보유시설</th>
				<th><c:choose>
						<c:when
							test="${fn:trim(futsalDTO.futsalFacilitiesDTO.futsalGrass) eq 1}">
							<span class="btn btn-info">잔디</span>
						</c:when>
						<c:otherwise>
							<span class="btn btn-default">잔디</span>
						</c:otherwise>
					</c:choose> <c:choose>
						<c:when
							test="${fn:trim(futsalDTO.futsalFacilitiesDTO.futsalLight) eq 1}">
							<span class="btn btn-info">조명</span>
						</c:when>
						<c:otherwise>
							<span class="btn btn-default">조명</span>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when
							test="${fn:trim(futsalDTO.futsalFacilitiesDTO.futsalShowerRoom) eq 1}">
							<span class="btn btn-info">샤워룸</span>
						</c:when>
						<c:otherwise>
							<span class="btn btn-default">샤워룸</span>
						</c:otherwise>
					</c:choose> <c:choose>
						<c:when
							test="${fn:trim(futsalDTO.futsalFacilitiesDTO.futsalPark) eq 1}">
							<span class="btn btn-info">주차장</span>
						</c:when>
						<c:otherwise>
							<span class="btn btn-default">주차장</span>
						</c:otherwise>
					</c:choose></th>
			</tr>
			<tr>
				<th>대여가능 물품</th>
				<th><c:choose>
					<c:when test="${fn.trim(futsalDTO.futsalRetalDTO.RentalBall) eq 1}">
						응 공 빌릴수 있어						
					</c:when>
				</c:choose></th>
			</tr>
		</table>

	
</div>