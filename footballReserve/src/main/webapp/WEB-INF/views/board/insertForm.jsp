<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<div class="container">

		<h1>게시물 쓰기</h1>

		<form
			action="${pageContext.request.contextPath}/board/insert/${boardType}"
			method="post">
			<table class="table">
				<tr>
					<!-- <th>글번호</th> -->
					<th>글쓴이</th>
					<th>제목</th>
					<th>내용</th>
				</tr>
				<tr>
					<th><input type="text" name="userId"
						value="${sessionScope.userId}" readonly="readonly"></th>
					<th><input type="text" name="boardSub"
						value="${boardDTO.boardSub}" /></th>
					<th><input type="text" name="boardContent"
						value="${boardDTO.boardContent}" /></th>
				</tr>
			</table>
			<button>글쓰기</button>
		</form>
	</div>
<br>