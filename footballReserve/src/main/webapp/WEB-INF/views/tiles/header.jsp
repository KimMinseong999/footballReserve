<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>풋볼 예약 프로그램</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/header.css">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>


</head>
<body>
	<!-- Second navbar for categories -->
	<nav class="navbar navbar-default">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${pageContext.request.contextPath}/">FootballReserve</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="${pageContext.request.contextPath}/">메인</a></li>
					<li><a href="#">예약</a></li>
					<li><a
						href="${pageContext.request.contextPath}/board/list/free">커뮤니티</a></li>

					<c:choose>
						<c:when test="${empty sessionScope.userId}">
							<li><a
								href="${pageContext.request.contextPath}/sign/loginForm"
								class="btn btn-default btn-outline btn-circle collapsed">로그인
							</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="${pageContext.request.contextPath}/sign/logout"
								class="btn btn-default btn-outline btn-circle collapsed">로그아웃
							</a></li>
						</c:otherwise>
					</c:choose>
					<li><a
						href="${pageContext.request.contextPath}/sign/registForm"
						class="btn btn-default btn-outline btn-circle collapsed">회원가입<i
							class=""></i>
					</a></li>
				</ul>
				<!-- <ul class="collapse nav navbar-nav nav-collapse slide-down"
					role="search" id="nav-collapse4">
					<li><a href="#">Support</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false"><img
							class="img-circle"
							src="https://pbs.twimg.com/profile_images/588909533428322304/Gxuyp46N.jpg"
							alt="maridlcrmn" width="20" /> Maridlcrmn <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#">My profile</a></li>
							<li><a href="#">Favorited</a></li>
							<li><a href="#">Settings</a></li>
							<li class="divider"></li>
							<li><a href="#">Logout</a></li>
						</ul></li>
				</ul>

				<ul class="collapse nav navbar-nav nav-collapse" id="nav-collapse1">
					<li><a href="#">Web design</a></li>
					<li><a href="#">Development</a></li>
					<li><a href="#">Graphic design</a></li>
					<li><a href="#">Print</a></li>
					<li><a href="#">Motion</a></li>
					<li><a href="#">Mobile apps</a></li>
				</ul> -->
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>
	<!-- /.navbar -->