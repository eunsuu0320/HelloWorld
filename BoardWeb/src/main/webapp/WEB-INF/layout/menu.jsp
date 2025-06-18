<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="border-end bg-white" id="sidebar-wrapper">
	<div class="sidebar-heading border-bottom bg-light">Start
		Bootstrap</div>
	<div class="list-group list-group-flush">
		<a class="list-group-item list-group-item-action list-group-item-light p-3" href="boardList.do">글 목록</a> 
		<c:choose>
		  <c:when test="${empty logId }">
		    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="loginForm.do">로그인</a>		    
		  </c:when>
		  <c:otherwise>		    
		    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="logout.do">로그아웃(${logId })
		    <img src="images/${img }" style="width:30px; border-radius=50%;">
		    </a> 
		  </c:otherwise>
		</c:choose>
		<a class="list-group-item list-group-item-action list-group-item-light p-3" href="allproduct.do">자바스크립트</a> 
		<a class="list-group-item list-group-item-action list-group-item-light p-3" href="chartpage.do">차트</a> 
		<a class="list-group-item list-group-item-action list-group-item-light p-3" href="selectable.html">캘린더</a> 
		<a class="list-group-item list-group-item-action list-group-item-light p-3" href="signup.do">회원가입</a>
	</div>
</div>