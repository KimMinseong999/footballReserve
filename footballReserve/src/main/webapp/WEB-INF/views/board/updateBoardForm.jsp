<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<div class="container">
		<h1>게시물 수정</h1>

		<form
			action="${pageContext.request.contextPath}/board/update/${boardDTO.boardType}/${boardDTO.boardNo}"
			method="post">
			<table class="table">
				<tr>
					<!-- <th>글번호</th> -->
					<th>글쓴이</th>
					<th>제목</th>
					<th>내용</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
				<tr>
					<th>${boardDTO.userId}</th>
					<th><input type="text" name="boardSub"
						value="${boardDTO.boardSub}" /></th>
					<th><input type="text" name="boardContent"
						value="${boardDTO.boardContent}" /></th>
					<th>${boardDTO.boardDt}</th>
					<th>${boardDTO.boardHit}</th>
				</tr>
			</table>
			<button>수정</button>
		</form>
	</div>
