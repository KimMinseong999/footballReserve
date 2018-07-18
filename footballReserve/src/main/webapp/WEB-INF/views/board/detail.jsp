<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script>

</script>

<div class="container">
	<table class="table">
		<tr>
			<!-- <th>글번호</th> -->
			<th>글쓴이</th>
			<th>제목</th>
			<th>내용</th>
			<th>작성일</th>
			<th>조회수</th>
			<c:set var="authority" value="${sessionScope.userAuthority}"></c:set>
			<c:set var="loginUserId" value="${sessionScope.userId}"></c:set>
			<c:set var="writer" value="${boardDTO.userId}"></c:set>
			<c:if test="${authority eq 0 || loginUserId eq writer}">
				<th>수정</th>
				<th>삭제</th>
			</c:if>
		</tr>
		<tr>
			<th>${boardDTO.userId}</th>
			<th>${boardDTO.boardSub}</th>
			<th>${boardDTO.boardContent}</th>
			<th>${boardDTO.boardDt}</th>
			<th>${boardDTO.boardHit}</th>
			<c:if test="${authority eq 0 || loginUserId eq writer}">
				<th><a
					href="${pageContext.request.contextPath}/board/updateForm/${boardDTO.boardType}/${boardDTO.boardNo}"><button
							type="button">수정</button></a></th>
				<th><a
					href="${pageContext.request.contextPath}/board/delete/${boardDTO.boardType}/${boardDTO.boardNo}"><button
							type="button">삭제</button></a></th>
			</c:if>
		</tr>
	</table>

	<div id="pageBar">${pageBar}</div>

	<c:if test="${loginUserId ne null}">

		<a
			href="${pageContext.request.contextPath}/board/insertForm/${boardDTO.boardType}"><button
				type="button">글쓰기</button></a>
	</c:if>
	<br> <br>


	<table class="table">
		<tr>
			<th>리뷰</th>
			<th>리뷰 작성자</th>
			<th>리뷰 작성일</th>
		</tr>

		<c:forEach items="${reviewList}" var="reviewDTO">
			<tr>
				<th>${reviewDTO.reviewContent}</th>
				<th>${reviewDTO.reviewWriter}</th>
				<th>${reviewDTO.reviewDt}</th>
			</tr>
			<c:if test="${loginUserId ne null}">

				<tr>
					<th colspan="2"><form
							action="${pageContext.request.contextPath}/board/insertBoardReview/${reviewDTO.reviewOriginNo}">
							<input type="text" name="reviewContent" id="reviewContent" /> <input
								type="hidden" name="reviewNo" value="${reviewDTO.reviewNo}" />
							<input type="hidden" name="reviewWriter"
								value="${sessionScope.userId}" /> <input type="hidden"
								name="boardNo" value="${boardDTO.boardNo}" /> <input
								type="hidden" name="boardType" value="${boardDTO.boardType}" />
							<c:set var="groupOrd" value="${reviewDTO.groupOrd}" />
							<input type="hidden" name="groupOrd" value="${groupOrd+1}" />
							<c:set var="groupLayer" value="${reviewDTO.groupLayer}" />
							<input type="hidden" name="groupLayer" value="${groupLayer+1}" />
							<c:if test="${loginUserId ne null}">
								<button>대댓글 달기</button>
							</c:if>
						</form></th>
					<th>
					<a href="${pageContext.request.contextPath}/board/delteBoardReview/${reviewDTO.boardType}/${reviewDTO.boardNo}/${reviewDTO.reviewNo}"><button type="button">삭제</button></a>
					</th>
				</tr>
			</c:if>
		</c:forEach>
	</table>
	<br> <br>
	<form
		action="${pageContext.request.contextPath}/board/insertBoardReview">
		<table class="table">
			<tr>
				<th>댓글 :<input type="text" name="reviewContent"
					id="reviewContent" /> <input type="hidden" name="reviewWriter"
					value="${sessionScope.userId}" /> <input type="hidden"
					name="boardNo" value="${boardDTO.boardNo}" /> <input type="hidden"
					name="boardType" value="${boardDTO.boardType}" /> <input
					type="hidden" name="reviewOriginNo" value="0" /> <input
					type="hidden" name="groupOrd" value="0" /> <input type="hidden"
					name="groupLayer" value="0" /> <c:if test="${loginUserId ne null}">
						<button>댓글 달기</button>
					</c:if></th>
			</tr>
		</table>
	</form>
</div>
