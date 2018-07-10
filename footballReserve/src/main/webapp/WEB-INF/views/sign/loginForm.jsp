<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container">
	<div class="row">
		<div class="col-md-4 col-md-offset-4">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">로그인</h3>
				</div>
				<div class="panel-body">
					<form action="${pageContext.request.contextPath}/sign/login"
						method="post">
						<fieldset>
							<div>아이디</div>
							<div class="form-group">
								<input class="form-control" placeholder="아이디를 입력하세요"
									name="userId" type="text">
							</div>
							<div>비밀번호</div>
							<div class="form-group">
								<input class="form-control" placeholder="비밀번호를 입력하세요"
									name="userPwd" type="password" value="">
							</div>


							<input class="btn btn-lg btn-success btn-block" type="submit"
								value="로그인"> <br>
							<div>${message}</div>
						</fieldset>
					</form>
					<hr />
					<center> <a href="https://kauth.kakao.com/oauth/authorize?client_id=8257d32ce9fc9db4ae430497d4a8d227&redirect_uri=http://localhost:8000/controller/sign/kakaologin&response_type=code">
						<img src="${pageContext.request.contextPath}/resources/images/sign/kakao_account_login_btn_medium_narrow.png"></a>
					</center>
				</div>
			</div>
		</div>
	</div>
</div>
