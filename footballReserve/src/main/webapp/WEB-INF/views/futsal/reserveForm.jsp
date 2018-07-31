<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<script
	src="//mugifly.github.io/jquery-simple-datetimepicker/jquery.simple-dtpicker.js"></script>
<link rel="stylesheet"
	href="//mugifly.github.io/jquery-simple-datetimepicker/jquery.simple-dtpicker.css">
<link
	rel="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/reserveTable.css">

<script>
	$(document).ready(function() {
		$('.datetimepicker').appendDtpicker({
			locale : 'ko',
			autodateOnStart : false,
			todayButton : true,
			futureOnly : true
		//minDate: '${parkRegiDTO.regiStart}',
		//maxDate: '${parkRegiDTO.regiEnd}'
		});
		$('.datetimepicker2').appendDtpicker({
			locale : 'ko',
			autodateOnStart : false,
			todayButton : true,
			futureOnly : true,
		});
		
		$("#sido").change(function(){
			$("[name='futsalAddr']").val($("#sido").val())
			$("#gugun").html="";

			var sido=$("#sido").val();
			var options="<option value=''></option>";
			$.ajax({
				url:"${pageContext.request.contextPath}/search/selectGugun",
				data:"sido="+sido,
				dataType:"json",
				success: function(result){
 					$.each(result, function(index, item){
						options+="<option value='"+item+"'>"+item+"</option>"
					})
					$("#gugun").html(options);
				},
				error:function(request,status,error){
					alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
				}	
			})
		})
		
		$("#gugun").change(function(){
			$("[name='futsalAddr']").val($("#sido").val()+" "+$("#gugun").val())
			var sido=$("#gugun").val();
			var options="<option value=''></option>";
		})
		
		$("#search").click(function(){
			futsalChange()
		})
		
	function futsalChange(){
			
			var queryString = $("form[name=searchData]").serialize();
 			$.ajax({
				url:"${pageContext.request.contextPath}/search/selectFutsalList",
				data:queryString,
				dataType: "json",
				success : function(result){
					$('#dataDiv').empty();
					$('#pagingDiv').empty();
					$.each(result.futsalList, function(index, item){
						var futsalList = new Array();
						futsalList[0] = item.futsalImageDTO[0].futsalImagePath;
						futsalList[1] = item.futsalSub;
						futsalList[2] = item.futsalAddr;
						futsalList[3] = item.futsalMaxUser;
						futsalList[4] = item.futsalPPHDTO.futsalPrice;
						futsalList[5] = item.futsalFacilitiesDTO.futsalGrass;
						futsalList[6] = item.futsalFacilitiesDTO.futsalLight;
						futsalList[7] = item.futsalFacilitiesDTO.futsalShowerRoom;
						futsalList[8] = item.futsalFacilitiesDTO.futsalPark;
						futsalList[9] =	item.futsalNo;
						loadFutsalList(futsalList);
					})
					changePaging(result.paging);
				},
				error:function(request,status,error){
					alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
				}
			}) 
		}
		
		function loadFutsalList(futsalList){
					var listData="<table class='table'>"
					listData+="<tr><th rowspan='6' class='reserveImageth'>"
					listData+="<img src='${pageContext.request.contextPath}/resources/images/futsalImages/"+futsalList[0]+"/'></th>"
					listData+="<th>풋살장 이름</th><th colspan='2'>"+futsalList[1]+"</th></tr>"
					listData+="<tr><th>풋살장 주소</th><th colspan='2'>"+futsalList[2]+"</th></tr>"
					listData+="<tr><th>최대 사용자 수</th><th colspan='2'>"+futsalList[3]+"명</th></tr>"
					listData+="<tr><th>시간당 가격</th><th colspan='2'>"+futsalList[4]+"원</th></tr>"
					listData+="<tr><th>보유시설</th>"
					listData+="<th>"
					if(futsalList[5] == null){
						listData+="<span class='btn btn-info'>잔디</span>"
					}else{
						listData+="<span class='btn btn-default'>잔디</span>"
					}

					if(futsalList[6] == null){
						listData+="<span class='btn btn-info'>조명</span>"
					}else{
						listData+="<span class='btn btn-default'>조명</span>"
					}

					if(futsalList[7] == null){
						listData+="<span class='btn btn-info'>샤워룸</span>"		
					}else{
						listData+="<span class='btn btn-default'>샤워룸</span>"
					}

					if(futsalList[8] == null){
						listData+="<span class='btn btn-info'>주차장</span>"
					}else{
						listData+="<span class='btn btn-default'>주차장</span>"
					}
					
					listData+="</th>"
					listData+="</tr>"
					listData+="<tr><th colspan='3' class='thRight'><a href='${pageContext.request.contextPath}/futsal/reserveDetailForm/"+futsalList[9]+"'>"
					listData+="<button type='button' class='btn btn-primary'>예약하러가기</button></a></th></tr>"
					listData+="</table>"
				$('#dataDiv').append(listData);
		}		
		
		function changePaging(futsalPaging){
			var pagingData = ""
				if(futsalPaging.numberOfRecords != null && futsalPaging.numberOfRecords != '' && futsalPaging.numberOfRecords != 0){
				pagingData+="<div class='text-center marg-top'>"
				pagingData+="<ul class='pagination'>"
					if(futsalPaging.currentPageNo > 5){
						pagingData+="<li><a href='javascript:goPage("+futsalPaging.prevPageNo+","+futsalPaging.maxPost+")'>이전</a></li>"
					}
					for(i=futsalPaging.startPageNo; i<=futsalPaging.endPageNo; i++){
						if(i == futsalPaging.currentPageNo){
							pagingData+="<li class='active'><a href='javascript:goPage("+i+","+futsalPaging.maxPost+")'>"+i+"</a></li>"
						}else{
							pagingData+="<li><a href='javascript:goPage("+i+","+futsalPaging.maxPost+")'>"+i+"</a></li>"
						}
					} 
					
					if(futsalPaging.currentPageNo < futsalPaging.finalPageNo){
						pagingData+="<li><a href='javascript:goPage("+futsalPaging.nextPageNo+","+futsalPaging.maxPost+")'>다음</a></li>"
					} 
				pagingData+="</ul></div>"			
				}
			$('#pagingDiv').append(pagingData);
		}
	});
</script>

<div class="container">

	<form name="searchData">
		<table class="table">
			<tr>
				<th><select id="sido" class="custom-select">
						<option value="sido" disabled selected hidden>시/도</option>
						<c:forEach items="${sidoList}" var="sido">
							<option value="${sido}">${sido}</option>
						</c:forEach>
				</select> <select id="gugun" class="custom-select">
						<option value="" disabled selected hidden>구/군</option>
				</select> <select name="futsalMaxUser" class="custom-select">
						<option value="" disabled selected hidden>인원수</option>
						<option value="6">6명 이상</option>
						<option value="4">4명</option>
						<option value="2">2명</option>
				</select></th>
			<tr>
				<th>시작 날짜 <input type="text"
					class='datetimepicker form-control' id="futsalStart"
					name="futsalStart" id="futsalStart" /> 종료 날짜 <input type="text"
					id="futsalEnd" class='datetimepicker2 form-control'
					name="futsalEnd" id="futsalEnd" />
				</th>
			</tr>
			<tr>
				<th class="thRight">
					<button type="button" class="btn btn-primary" id="search">검색</button>
					<input type="hidden" name="futsalAddr" /> <input type="reset"
					class="btn btn-primary" value="초기화" />
				</th>
			</tr>
		</table>
	</form>

	<div id="dataDiv"></div>
	<div id="pagingDiv"></div>
	
	<!-- 페이징  -->
<%-- 	<c:choose>
		<c:when
			test="${paging.numberOfRecords ne NULL and paging.numberOfRecords ne '' and paging.numberOfRecords ne 0}">
			<div class="text-center marg-top">
				<ul class="pagination">
					<c:if test="${paging.currentPageNo gt 5}">
						<!-- 현재 페이지가 5보다 크다면(즉, 6페이지 이상이라면) -->
						<li><a
							href="javascript:goPage(${paging.prevPageNo}, ${paging.maxPost})">이전</a></li>
						<!-- 이전페이지 표시 -->
					</c:if>
					<!-- 다른 페이지를 클릭하였을 시, 그 페이지의 내용 및 하단의 페이징 버튼을 생성하는 조건문-->
					<c:forEach var="i" begin="${paging.startPageNo}"
						end="${paging.endPageNo}" step="1">
						<!-- 변수선언 (var="i"), 조건식, 증감식 -->
						<c:choose>
							<c:when test="${i eq paging.currentPageNo}">
								<li class="active"><a
									href="javascript:goPage(${i}, ${paging.maxPost})">${i}</a></li>
								<!-- 1페이지부터 10개씩 뽑아내고, 1,2,3페이지순으로 나타내라-->
							</c:when>
							<c:otherwise>
								<li><a href="javascript:goPage(${i}, ${paging.maxPost})">${i}</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<!-- begin에 의해서 변수 i는 1이기 때문에, 처음에는 c:when이 수행된다. 그 후 페이징의 숫자 2를 클릭하면 ${i}는 2로변하고, 현재는 ${i}는 1이므로 otherwise를 수행한다
					         그래서 otherwise에 있는 함수를 수행하여 2페이지의 게시물이 나타나고, 반복문 실행으로 다시 forEach를 수행한다. 이제는 i도 2이고, currentPageNo도 2이기 때문에
					     active에 의해서 페이징부분의 2에 대해서만 파란색으로 나타난다. 그리고 나머지 1,3,4,5,이전,다음을 표시하기위해 다시 c:otherwise를 수행하여 페이징도 나타나게한다.-->
					<!-- // 다른 페이지를 클릭하였을 시, 그 페이지의 내용 및 하단의 페이징 버튼을 생성하는 조건문-->

					<!-- 소수점 제거 =>-->
					<fmt:parseNumber var="currentPage" integerOnly="true"
						value="${(paging.currentPageNo-1)/5}" />
					<fmt:parseNumber var="finalPage" integerOnly="true"
						value="${(paging.finalPageNo-1)/5}" />

					<c:if test="${currentPage < finalPage}">
						<!-- 현재 페이지가 마지막 페이지보다 작으면 '다음'을 표시한다. -->
						<li><a
							href="javascript:goPage(${paging.nextPageNo}, ${paging.maxPost})">다음</a></li>
					</c:if>
				</ul>
			</div>
		</c:when>
	</c:choose> --%>

</div>



<script>
	function goPage(pages, lines) {
		var queryString = $("form[name=searchData]").serialize();
			$.ajax({
			url:"${pageContext.request.contextPath}/search/selectFutsalList?pages="+pages,
			data:queryString,
			dataType: "json",
			success : function(result){
				$('#dataDiv').empty();
				$('#pagingDiv').empty();
				$.each(result.futsalList, function(index, item){
					var futsalList = new Array();
					futsalList[0] = item.futsalImageDTO[0].futsalImagePath;
					futsalList[1] = item.futsalSub;
					futsalList[2] = item.futsalAddr;
					futsalList[3] = item.futsalMaxUser;
					futsalList[4] = item.futsalPPHDTO.futsalPrice;
					futsalList[5] = item.futsalFacilitiesDTO.futsalGrass;
					futsalList[6] = item.futsalFacilitiesDTO.futsalLight;
					futsalList[7] = item.futsalFacilitiesDTO.futsalShowerRoom;
					futsalList[8] = item.futsalFacilitiesDTO.futsalPark;
					futsalList[9] =	item.futsalNo;
	 				loadFutsalList(futsalList);
			})
				changePaging(result.paging);
			},
			error:function(request,status,error){
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			} 
		})
		
		function loadFutsalList(futsalList){
				var listData="<table class='table'>"
				listData+="<tr><th rowspan='6' class='reserveImageth'>"
				listData+="<img src='${pageContext.request.contextPath}/resources/images/futsalImages/"+futsalList[0]+"/'></th>"
				listData+="<th>풋살장 이름</th><th colspan='2'>"+futsalList[1]+"</th></tr>"
				listData+="<tr><th>풋살장 주소</th><th colspan='2'>"+futsalList[2]+"</th></tr>"
				listData+="<tr><th>최대 사용자 수</th><th colspan='2'>"+futsalList[3]+"명</th></tr>"
				listData+="<tr><th>시간당 가격</th><th colspan='2'>"+futsalList[4]+"원</th></tr>"
				listData+="<tr><th>보유시설</th>"
				listData+="<th>"
				if(futsalList[5] == null){
					listData+="<span class='btn btn-info'>잔디</span>"
				}else{
					listData+="<span class='btn btn-default'>잔디</span>"
				}

				if(futsalList[6] == null){
					listData+="<span class='btn btn-info'>조명</span>"
				}else{
					listData+="<span class='btn btn-default'>조명</span>"
				}

				if(futsalList[7] == null){
					listData+="<span class='btn btn-info'>샤워룸</span>"		
				}else{
					listData+="<span class='btn btn-default'>샤워룸</span>"
				}

				if(futsalList[8] == null){
					listData+="<span class='btn btn-info'>주차장</span>"
				}else{
					listData+="<span class='btn btn-default'>주차장</span>"
				}
				
				listData+="</th>"
				listData+="</tr>"
				listData+="<tr><th colspan='3' class='thRight'><a href='${pageContext.request.contextPath}/futsal/reserveDetailForm/"+futsalList[9]+"'>"
				listData+="<button type='button' class='btn btn-primary'>예약하러가기</button></a></th></tr>"
				listData+="</table>"
			$('#dataDiv').append(listData);
	}
			
			function changePaging(futsalPaging){
				var pagingData = ""
					if(futsalPaging.numberOfRecords != null && futsalPaging.numberOfRecords != '' && futsalPaging.numberOfRecords != 0){
					pagingData+="<div class='text-center marg-top'>"
					pagingData+="<ul class='pagination'>"
						if(futsalPaging.currentPageNo > 5){
							pagingData+="<li><a href='javascript:goPage("+futsalPaging.prevPageNo+","+futsalPaging.maxPost+")'>이전</a></li>"
						}
						for(i=futsalPaging.startPageNo; i<=futsalPaging.endPageNo; i++){
							if(i == futsalPaging.currentPageNo){
								pagingData+="<li class='active'><a href='javascript:goPage("+i+","+futsalPaging.maxPost+")'>"+i+"</a></li>"
							}else{
								pagingData+="<li><a href='javascript:goPage("+i+","+futsalPaging.maxPost+")'>"+i+"</a></li>"
							}
						} 
						
						if(futsalPaging.currentPageNo < futsalPaging.finalPageNo){
							pagingData+="<li><a href='javascript:goPage("+futsalPaging.nextPageNo+","+futsalPaging.maxPost+")'>다음</a></li>"
						} 
					pagingData+="</ul></div>"			
					}
				$('#pagingDiv').append(pagingData);
			}
}
</script>