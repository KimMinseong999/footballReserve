<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/registForm.css">

<div class="container">
	<div class="row main">
		<div class="main-login main-center">
			<h2>회원가입</h2>

			<form action="${pageContext.request.contextPath}/sign/regist"
				method="post">
				<div class="form-group">
					<label for="userId" class="cols-sm-2 control-label">아이디</label>
					<div class="cols-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-users fa"
								aria-hidden="true"></i></span> <input type="text" class="form-control"
								name="userId" id="userId" placeholder="아이디를 입력해주세요."
								required="required" />
						</div>
					</div>
				</div>



				<div class="form-group">
					<label for="userPwd" class="cols-sm-2 control-label">비밀번호</label>
					<div class="cols-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="fa fa-lock fa-lg" aria-hidden="true"></i></span> <input
								type="password" class="form-control" name="userPwd" id="userPwd"
								placeholder="비밀번호를 입력해주세요." required="required" />
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
								name="userName" id="userName" placeholder="이름을 입력해주세요."
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
					<button id="button"
						class="btn btn-primary btn-lg btn-block login-button">회원가입</button>
				</div>

			</form>
		</div>
	</div>
</div>

