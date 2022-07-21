<%@ page language="java" import="java.net.URLEncoder"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	<h3>my page</h3>
	<a href='<c:url value="/mod010/logout"/>'>로그아웃</a>
	<br>
	<label>Last Access Time : </label> ${lastAccessTime}
</body>
</html>