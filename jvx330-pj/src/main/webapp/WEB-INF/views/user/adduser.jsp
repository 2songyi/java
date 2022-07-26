<%@ page language="java" import="java.net.URLEncoder" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="userform" method="get">
				<ul>
					<li><p>아이디</p>
						<input type="text" name="userId"></li>
					<li><p>비밀번호</p>
						<input type="password" name="passwd"></li>
					<li><p>이름</p>
						<input type="text" name="userName"></li>
					<li><p>주민번호</p>
						<input type="text" name="ssn" placeholder="앞자리 6자만 입력하세요."></li>
					<li><p>이메일</p>
						<input type="text" name="email" class="email"></li>
					<li><p>주소</p>
						<input type="text" name="addr" class="addr"></li>
					<li><button type="submit">가입하기</button></li>
				</ul>
		</form>
</body>
</html>