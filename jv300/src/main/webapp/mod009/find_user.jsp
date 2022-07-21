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
		<jsp:param name="sub-title" value="<%=URLEncoder.encode(\"mod007 : 배너\", \"UTF-8\") %>" />
	</jsp:include>
</div>
회원정보 수정<br>
<form action="find_user.do" method="get">
아이디를 입력하세요 <input type="text" name="userId">
<button type="submit">확인</button>
</form>
</body>
</html>