<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/photoSlide.css">
<script src="${pageContext.request.contextPath}/resources/js/photoSlide.js"></script>

<div class="w3-content w3-display-container">
	<img class="mySlides"
		src="${pageContext.request.contextPath}/resources/images/1.jpg"
		style=""> <img class="mySlides"
		src="${pageContext.request.contextPath}/resources/images/2.jpg">
	<img class="mySlides"
		src="${pageContext.request.contextPath}/resources/images/3.jpg">
	<img class="mySlides"
		src="${pageContext.request.contextPath}/resources/images/4.jpg">
	<button class="w3-button w3-display-left" onclick="plusDivs(-1)">&#10094;</button>
	<button class="w3-button w3-display-right" onclick="plusDivs(+1)">&#10095;</button>
</div>

<script
	src="${pageContext.request.contextPath}/resources/js/photoSlide.js">
</script>
<br>