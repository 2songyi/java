<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>success</title>
</head>
<style>
p {
	color: blue;
	font-size: 20px;
}
</style>
<body>
<p>
	<%
	String userName = (String)request.getAttribute("userName");
	out.println(userName);
	%>
	님 가입을 환영합니다.
</p>
</body>
</html>