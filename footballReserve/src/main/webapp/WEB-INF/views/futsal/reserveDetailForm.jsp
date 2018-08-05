<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/reserveTable.css">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css"
	type="text/css" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<script>
	$(function() {
		$("#Datepicker").datepicker({});
	});

	$.datepicker.setDefaults({
		dateFormat : 'yy-mm-dd',
		prevText : '이전 달',
		nextText : '다음 달',
		monthNames : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월',
				'10월', '11월', '12월' ],
		monthNamesShort : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월',
				'9월', '10월', '11월', '12월' ],
		dayNames : [ '일', '월', '화', '수', '목', '금', '토' ],
		dayNamesShort : [ '일', '월', '화', '수', '목', '금', '토' ],
		dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ],
		showMonthAfterYear : true,
		yearSuffix : '년',
		minDate : 0
	});

	$(document).ready(function() {
		$("#Datepicker").change(function() {
			TimeChange(this.value, $("#futsalNo").val())
		})
	})
	
	
	function TimeChange(date) {
		$
				.ajax({
					url : "${pageContext.request.contextPath}/search/selectReserveTime",
					data : "date=" + date + "&futsalNo=${futsalDTO.futsalNo}",
					dataType : "json",
					success : function(result) {
						$("#timeDiv").empty();
						timeData = "<br><table class='table'>"
						timeData += "<tr>"
						timeData += "<th>"
						timeData += "예약 시간"
						timeData += "</th>"
						timeData += "<th>"
						timeData += "예약 가능 여부"
						timeData += "</th>"
						timeData += "</tr>"
						for (hh = 6; hh < 24; hh++) {
							timeData += "<tr>"
							timeData += "<th>" + date+" " + hh + "~" + (hh+1) + "시</th>"
							timeData += "<th>"
							if(result.length > 0){
								$.each(result,function(index,item){
									if(new Date(item.reserveStart) <= new Date(date+" "+hh+":00:00.0")*1 && new Date(item.reserveEnd) > new Date(date+" "+hh+":00:00.0")*1){
										status = "예약불가"
										return false;
									}else{
										status = "<a href='${pageContext.request.contextPath}/futsal/reserve/"+date+"/"+hh+"/"+${futsalDTO.futsalNo}+"'><button type='button' id='reserveButton'>예약하기</button></a>"
									} 
								})
							}else{
								status = "<a href='${pageContext.request.contextPath}/futsal/reserve/"+date+"/"+hh+"/"+${futsalDTO.futsalNo}+"'><button type='button' id='reserveButton'>예약하기</button></a>"
							}
							timeData += status
							timeData += "</th>"
							timeData += "</tr>"
						}
						timeData += "</table>"
						$("#timeDiv").append(timeData);
					},
					error : function(result) {
						alert("code:" + request.status + "\n" + "message:"
								+ request.responseText + "\n" + "error:"
								+ error);
					}
				})

	}
</script>
<div class="container">
	<table class="table">
		<tr>
			<th rowspan="6" class="reserveImageth"><c:forEach
					items="${futsalDTO.futsalImageDTO}" var="futsalImageDTO" begin="0"
					end="0">
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
				</c:choose> <c:choose>
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
					<c:when
						test="${fn:trim(futsalDTO.futsalRentalDTO.futsalRentalBall) eq 1}">
						<span class="btn btn-info">공 대여</span>
					</c:when>
					<c:otherwise>
						<span class="btn btn-default">공 대여</span>
					</c:otherwise>
				</c:choose> <c:choose>
					<c:when
						test="${fn:trim(futsalDTO.futsalRentalDTO.futsalRentalBall) eq 1}">
						<span class="btn btn-info">유니폼 대여</span>
					</c:when>
					<c:otherwise>
						<span class="btn btn-default">유니폼 대여</span>
					</c:otherwise>
				</c:choose> <c:choose>
					<c:when
						test="${fn:trim(futsalDTO.futsalRentalDTO.futsalRentalShoes) eq 1}">
						<span class="btn btn-info">축구화 대여</span>
					</c:when>
					<c:otherwise>
						<span class="btn btn-default">축구화 대여</span>
					</c:otherwise>
				</c:choose></th>
		</tr>
	</table>
	<div>
		예약일 <input type="text" id="Datepicker">
	</div>
	<div id="timeDiv"></div>
</div>