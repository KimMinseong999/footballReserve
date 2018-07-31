<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/registForm.css">

<script>
$(document).ready(function(){
	$("#userId").keyup(function(){
		var userId=$("#userId").val();
			$.ajax({
				url:"${pageContext.request.contextPath}/sign/checkId",
				data: {'userId':$('#userId').val()},
				dataType: "text",
				success : function(result){
					$("#idCheck").empty();
					if(result=="duplicated"){
						$("#idCheck").append("아이디 중복입니다.");
						$("#singUpButton").prop("disabled", true);
					}else{
						$("#idCheck").append("사용가능한 아이디입니다.");
						$("#singUpButton").prop("disabled", false);
					}
				},
				error:function(request,status,error){
					alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
				}
			})
	})
})

function validate(){

	var regExpId = /^[a-z0-9_-]\w{5,10}$/; //아이디 체크 정규식
	var regExpPassword = /^(?=.*[a-zA-Z])(?=.*[0-9]).{6,16}$/;// 비밀번호 조합(영문, 숫자) 및 길이 체크 정규식
	var regExpEmail=/^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;// 이메일 체크 정규식
	var regExpMobile = /^01([016789]?)-?([0-9]{3,4})-?([0-9]{4})$/;// 휴대폰번호 정규식
	var regExpNumber = /^\d+$/;// 숫자만 사용 정규식
	var regExpName = /^[가-힣]{2,15}|[a-zA-Z]{2,15}\s[a-zA-Z]{2,15}$/; //한글과 영어만
	
	var userId = document.getElementById('userId');
	var userPwd = document.getElementById('userPwd');
	var confirmPwd =document.getElementById('confirmPwd');
	var userName = document.getElementById('userName');
	var userEmail =document.getElementById('userEmail');
	var userPhone = document.getElementById('userPhone');
	
	if(!check(regExpId,userId,"아이디는 영어와 숫자 조합의 5~10글자로 작성하세요.")){
		return false;
	}
	if(!check(regExpPassword,userPwd,"비밀번호는 영문과 숫자 조합으로 6~16자 내로 작성하세요.")){
		return false;
	}
	if(userPwd.value != confirmPwd.value){
		alert("비밀번호가 일치하지 않습니다.")
		confirmPwd.value=="";
		confirmPwd.focus();
		return false;
	}
	
	if(!check(regExpName, userName, "이름은 한글과 영어만 입력하세요.")){
		return false;
	}
	
	if(!check(regExpEmail,userEmail,"이메일 형식이 올바르지 않습니다.")){
		return false;
	}
	if(!check(regExpMobile,userPhone,"휴대폰 번호를 바르게 입력해주세요.")){
	 	return false;
	}
	
	return true;
}

function check(regExp, checkValue, msg) {
    if (regExp.test(checkValue.value)) {
            return true;
    }
    alert(msg);
    checkValue.value = "";
    checkValue.focus();
    return false;
}

</script>

<div class="container">
	<div class="row main">
		<div class="main-login main-center">
			<h2>회원가입</h2>

			<form action="${pageContext.request.contextPath}/sign/regist"
				method="post" name="regist" onsubmit="return validate();">
				<div class="form-group">
				
					<label for="userId" class="cols-sm-2 control-label">아이디</label>
					<div class="cols-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-users fa"
								aria-hidden="true"></i></span> <input type="text" class="form-control"
								name="userId" id="userId" placeholder="영문과 숫자를 조합하여 5~10자 아이디를 입력하세요."
								required="required" />
						</div>
					</div><div id="idCheck"></div>
				</div>
				
				<div class="form-group">
					<label for="userPwd" class="cols-sm-2 control-label">비밀번호</label>
					<div class="cols-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="fa fa-lock fa-lg" aria-hidden="true"></i></span> <input
								type="password" class="form-control" name="userPwd" id="userPwd"
								placeholder="영문과 숫자를 조합하여 5~16자 비밀번호를 입력하세요." required="required" />
						</div>
					</div>
				</div>

				<div class="form-group">
					<label for="confirmPwd" class="cols-sm-2 control-label">비밀번호
						확인</label>
					<div class="cols-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="fa fa-lock fa-lg" aria-hidden="true"></i></span> <input
								type="password" class="form-control" name="confirmPwd"
								id="confirmPwd" placeholder="비밀번호를 한번 더 입력해주세요."
								required="required" />
						</div>
					</div>
				</div>

				<div class="form-group">
					<label for="userName" class="cols-sm-2 control-label">이름</label>
					<div class="cols-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-user fa"
								aria-hidden="true"></i></span> <input type="text" class="form-control"
								name="userName" id="userName" placeholder="한글 또는 영문 이름을 입력해주세요."
								required="required" />
						</div>
					</div>
				</div>

				<div class="form-group">
					<label for="userEmail" class="cols-sm-2 control-label">이메일</label>
					<div class="cols-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="fa fa-envelope fa" aria-hidden="true"></i></span> <input
								type="text" class="form-control" name="userEmail" id="userEmail"
								placeholder="이메일을 입력해주세요." required="required" />
						</div>
					</div>
				</div>

				<div class="form-group">
					<label for="userPhone" class="cols-sm-2 control-label">핸드폰번호</label>
					<div class="cols-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-users fa"
								aria-hidden="true"></i></span> <input type="text" class="form-control"
								name="userPhone" id="userPhone" placeholder="핸드폰번호를 입력해주세요."
								required="required" />
						</div>
					</div>
				</div>
				<div class="form-group ">
					<button id="singUpButton"
						class="btn btn-primary btn-lg btn-block login-button" disabled="disabled">회원가입</button>
				</div>

			</form>
		</div>
	</div>
</div>

