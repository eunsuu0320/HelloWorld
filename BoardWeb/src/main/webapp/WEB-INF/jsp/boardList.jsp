<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>



<h3>게시글 목록</h3>

<!-- 검색 조건 추가 -->
<form action="boardList.do">
	<div class="row">
		<div class="col-sm-4">
			<select name="searchCondition" class="form-control">
				<option value="">선택하세요</option>
				<option value="T"
					${!empty search.searchCondition && search.searchCondition == 'T' ? 'seleted' : '' }>제목</option>
				<option value="W"
					${!empty search.searchCondition && search.searchCondition == 'W' ? 'seleted' : '' }>작성자</option>
				<option value="TW"
					${!empty search.searchCondition && search.searchCondition == 'TW' ? 'seleted' : '' }>제목&작성자</option>
			</select>
		</div>
		<div class="col-sm-6">
			<input name="keyword" class="form-control"
				value="${empty search.keyword ? '' : search.keyword}">
		</div>
		<div class="col-sm-2">
			<input type="submit" value="검색" class="btn btn-primary">
		</div>
	</div>
</form>

<table class="table">
	<thead>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일시</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="board" items="${blist }">
			<tr>
				<td><a
					href="board.do?searchCondition=${search.searchCondition }&keyword=${search.keyword }&page=${pageInfo.currentPage }&bno=${board.boardNo }">${board.boardNo }</a></td>
				<td>${board.title }</td>
				<td>${board.writer }</td>
				<td><fmt:formatDate value="${board.writeDate }"
						pattern="yyyy.MM.dd HH:mm:ss" /></td>
				<td><fmt:formatNumber value="${board.readCnt }" pattern="#,###" /></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<!-- paging 시작. -->
<nav aria-label="Page navigation example">
	<ul class="pagination justify-content-center">
		<!-- 이전페이지 활성화. choose when dtherwise -->
		<c:choose>
			<c:when test="${!pageInfo.prev }">
				<li class="page-item disabled"><a class="page-link">Previous</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item"><a class="page-link"
					href="boardList.do?page=${pageInfo.start - 1 }">Previous</a></li>
			</c:otherwise>
		</c:choose>

		<!-- paging 정보를 활용. -->
		<c:forEach var="p" begin="${pageInfo.start }" end="${pageInfo.end }" step="1">
			<c:choose>
				<c:when test="${p == pageInfo.currentPage }">
					<li class="page-item active" aria-current="page"><a
						class="page-link" href="boardList.do?page=${p }">${p }</a></li>
				</c:when>
				<c:otherwise>
					<li class="page-item"><a class="page-link"
						href="boardList.do?searchCondition=SearchCondition${search.searchCondition }&keyword=${search.keyword }&page=${p }">${p }</a></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		<!-- 이후페이지 활성화. -->
		<c:choose>
			<c:when test="${!pageInfo.next }">
		<li class="page-item disabled"><a class="page-link">Next</a></li>			
			</c:when>
			<c:otherwise>			
		<li class="page-item"><a class="page-link"
			href="boardList.do?page=${pageInfo.end + 1 }">Next</a></li>
			</c:otherwise>
		</c:choose>
	</ul>
</nav>
<!-- paging 종료. -->
