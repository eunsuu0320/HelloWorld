<%@page import="com.yedam.common.SearchDTO"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@page import="com.yedam.service.BoardServiceImpl"%>
<%@page import="com.yedam.service.BoardService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL.jsp</title>
</head>
<body>

	<%
	request.setAttribute("msg", "Hello"); // 한 번 요청 후 객체 정보 사라짐
	session.setAttribute("errorMsg", "ID,PW확인"); // 일정기간 서버 상의 정보를 유지하기 위해 사용
	application.setAttribute("projectName", "BoardWeb"); // 종료할 때 까지 남아있음
	String name = "Hong ";
	System.out.print(name);
	BoardService svc = new BoardServiceImpl();
	SearchDTO search = new SearchDTO();
	search.setPage(1);
	List<BoardVO> list = svc.boardList(search);
	request.setAttribute("blist", list);
	%>
	<p>${10 - 5 }</p>
	<p>${!empty msg }</p>
	${errorMsg }
	<p>${empty hello }</p>
	
	<c:set var="name" value="Hongkildong"></c:set>
	<c:out value="${name }"></c:out>
	
	<c:set var="age" value="15"></c:set>
	<c:if test="${age >= 20 }">
	  <p>성인</p>
	</c:if>
	
	<c:choose>
	  <c:when test="${!empty logId }">
	    <p>로그인 상태</p>
	  </c:when>
	  <c:otherwise>
	    <p>로그아웃 상태</p>
	  </c:otherwise>
	</c:choose>
	
	<!-- 반복 -->
	<c:forEach var="i" begin="1" end="5" step="2">
	  <span>i의 값은 ${i }</span>
	</c:forEach>
	
	<!-- 반복2 -->
	<table border="1">
	<c:forEach var="board" items="${blist}">
	  <tr>
	    <td>${board.boardNo}</td> <!-- 여기서는 메소드 호출이 안됨. 왼쪽처럼 호출 그러면 오른쪽처럼 호출 한 것 마냥 호출됨. board.getBoardNo() -->
	    <td>${board.title}</td>
	    <td><c:out value="${board.writer}"/></td>
	    <td><fmt:formatDate value="${board.writeDate}" pattern="yyyy.MM.dd HH:mm:ss" /></td>
	  </tr>
	</c:forEach>
	</table>
</body>
</html>