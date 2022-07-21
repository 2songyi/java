<%@ page language="java" import="java.net.URLDecoder" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="banner">
	<!-- 
	<h4><%=URLDecoder.decode(request.getParameter("sub-title"),"UTF-8") %></h4>
	상단 메뉴 버튼 만들고 누르면 해당 servlet으로 넘어가게 -->
	<a href="http://localhost:8080/jv300/mod009/add_user.jsp">회원가입</a>
	<a href="http://localhost:8080/jv300/mod009/user_list.do">회원목록</a>
	<a href="http://localhost:8080/jv300/mod009/find_user.jsp">정보수정</a>
	<a href='<c:url value="/mod010/logout"/>'>로그아웃</a>
</div>