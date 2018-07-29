<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script
	src="//mugifly.github.io/jquery-simple-datetimepicker/jquery.simple-dtpicker.js"></script>
<link rel="stylesheet"
	href="//mugifly.github.io/jquery-simple-datetimepicker/jquery.simple-dtpicker.css">
<link
	rel="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js" />
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

	});

	function fileInfo(f) {
		var file = f.files; // files 를 사용하면 파일의 정보를 알 수 있음

		// 파일의 갯수만큼 반복
		for (var i = 0; i < file.length; i++) {

			var reader = new FileReader(); // FileReader 객체 사용
			reader.onload = function(rst) {
				$('#img_box')
						.append(
								'<img src="' + rst.target.result + '" style="max-width: 300px; max-height: 300px; border: none;"/>'); // append 메소드를 사용해서 이미지 추가
				// 이미지는 base64 문자열로 추가
				// 이 방법을 응용하면 선택한 이미지를 미리보기 할 수 있음
			}
			reader.readAsDataURL(file[i]); // 파일을 읽는다
		}
	}

	// 유효성 체크
	function checkValid() {
		var f = window.document.insertFutsalForm;
		var regExp = /^[0-9]+$/;

		if (f.userId.value == "") {
			alert("로그인하고 이용하세요.");
			this.focus();
			return false;
		}
		if (f.futsalSub.value == "") {
			alert("풋살장 이름을 입력해 주세요.");
			this.focus();
			return false;
		}
		if (f.futsalAddr.value == "") {
			alert("풋살장 주소를 입력해 주세요.");
			this.focus();
			return false;
		}
		if (f.futsalMaxUser.value == "") {
			alert("최대 사용자수를 입력하세요.");
			this.focus();
			return false;
		}
		if (!regExp.test($(futsalMaxUser).val())) {
			alert("최대 사용자수에는 숫자를 입력하세요.");
			this.focus();
			return false;
		}
		if (f.futsalPrice.value == "") {
			alert("시간당 가격을 입력하세요.");
			this.focus();
			return false;
		}
		if (!regExp.test($(futsalPrice).val())) {
			alert("시간당 가격에는 숫자를 입력하세요.");
			this.focus();
			return false;
		}
		if (f.futsalContent.value == "") {
			alert("풋살장 설명을 입력하세요.");
			this.focus();
			return false;
		}
		if (f.futsalStart.value == "") {
			alert("예약 시작 시간을 입력하세요.");
			this.focus();
			return false;
		}
		if (f.futsalEnd.value <= f.futsalStart.value) {
			alert("올바른 예약 범위로 선택해주세요");
			f.futsalEnd.value = "";
			this.focus();
			return false;
		}
		if (f.futsalEnd.value == "") {
			alert("예약 종료 시간을 입력하세요.");
			this.focus();
			return false;
		}

		return true;
	}
</script>
<style>
tr th:first-child {
	width: 35%;
	text-align: center;
}

tr th:last-child {
	width: 65%;
}
</style>

<div class="container">

	<h1>풋살장 등록</h1>

	<form name="insertFutsalForm"
		action="${pageContext.request.contextPath}/futsal/insert"
		method="post" enctype="multipart/form-data"
		onSubmit='return checkValid()' class=".form-inline">
		<table class="table table-bordered">
			<tr>
				<th>글쓴이</th>
				<th>${sessionScope.userId}<input type="hidden" name="userId"
					value="${sessionScope.userId}" id="userId"></th>
			</tr>
			<tr>
				<th>풋살장 이름</th>
				<th><input type="text" name="futsalSub" id="futsalSub"
					class="form-control" /></th>
			</tr>
			<tr>
				<th>주소</th>
				<th><input type="text" name="futsalAddr" id="futsalAddr"
					class="form-control" /></th>
			</tr>
			<tr>
				<th>최대 사용자</th>
				<th><input type="text" name="futsalMaxUser"
					placeholder="숫자만 입력하세요" id="futsalMaxUser" class="form-control" /></th>
			</tr>
			<tr>
				<th>가격</th>
				<th><input type="text" name="futsalPrice"
					placeholder="숫자만 입력하세요" id="futsalPrice" class="form-control" /></th>
			</tr>
			<tr>
				<th>내용</th>
				<th><textarea name="futsalContent" cols="100%" rows="8"
						class="form-control"></textarea></th>
			</tr>
			<tr>
				<th>대여 가능 장비</th>
				<th><input type="checkbox" id="futsalRentalBall"
					name="futsalRentalBall" value="1">공 대여 <input
					type="checkbox" id="futsalRentalUniform" name="futsalRentalUniform"
					value="1">유니폼 대여 <input type="checkbox"
					id="futsalRentalShoes" name="futsalRentalShoes" value="1">풋살화
					대여</th>
			</tr>
			<tr>
				<th>풋살장 시설</th>
				<th><input type="checkbox" id="futsalGrass" name="futsalGrass"
					value="1">잔디 <input type="checkbox" id="futsalLight"
					name="futsalLight" value="1">조명 <input type="checkbox"
					id="futsalShowerRoom" name="futsalShowerRoom" value="1">샤워룸
					<input type="checkbox" id="futsalPark" name="futsalPark" value="1">주차장
				</th>
			</tr>
			<tr>
				<th>시작 날짜</th>
				<th><input type="text" class='datetimepicker form-control'
					id="futsalStart" name="futsalStart" id="futsalStart" /></th>
			</tr>
			<tr>
				<th>종료 날짜</th>
				<th><input type="text" id="futsalEnd"
					class='datetimepicker2 form-control' name="futsalEnd"
					id="futsalEnd" /></th>
			</tr>
			<tr>
				<th>이미지 업로드</th>
				<th><input class="form-control" type="file" name="files"
					accept="image/*" multiple onchange="fileInfo(this)"
					placeholder="주차장 사진을 등록해주세요.(여러장 업로드시 한번에 추가해주세요.)">
					<div id="img_box"></div></th>
			</tr>
		</table>


		<button>글쓰기</button>
	</form>
</div>
<br>