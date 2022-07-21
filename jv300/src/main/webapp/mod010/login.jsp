<%@ page language="java" import="java.net.URLEncoder" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<form action="login" method="post">
		아이디 : <input type="text" name="userId" /><br> 비밀번호 : <input
			type="password" name="passwd" /><br> <input type="submit"
			value="로그인" />
	</form>
</body>
</html>