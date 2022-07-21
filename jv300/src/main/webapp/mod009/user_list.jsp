<%@ page language="java" import="java.net.URLEncoder" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="header">
		<jsp:include page="/incl/banner.jsp">
			<jsp:param name="sub-title"
				value="<%=URLEncoder.encode(\"mod009 : 배너\", \"UTF-8\")%>" />
		</jsp:include>
	</div>
	회원목록
	<br>
	<c:forEach items="${userList}" var="userList">
		${userList}<br>
	</c:forEach>
</body>
</html>