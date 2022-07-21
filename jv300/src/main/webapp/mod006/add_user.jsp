<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
ul, li { list-style: none; }

#wrap {
	max-width: 500px;
	margin: 0 auto;
}
#wrap .title {
	text-align: center;
	font-size: 35px;
}
input {
	border: 1px solid g rey;
	box-sizing: border-box;
	padding: 10px 14px 10px 14px;
}
li span {
	margin-left: 3px;
	margin-right: 3px;
}
li select {
	padding: 10px 14px 10px 14px;
	margin: 0;
}
li p {
	font-weight: bold;
}
button {
	background-color: lightgrey;
	text-align: center;
	border: 1px solid grey;
	height: 45px;
	width: 500px;
	font-size: 15px;
	margin-top: 30px;
}</style>
<body>
<div id="wrap">
	<div class="title">회원가입</div>
	<form action="adduser.do" method="post">
		<ul>
			<li><p>아이디</p><input type="text" name="userId"></li>
			<li><p>비밀번호</p><input type="password" name="passwd"></li>
			<li><p>이름</p><input type="text" name="userName"></li>
			<li><p>주민번호</p><input type="text" name="ssn" placeholder="앞자리 6자만 입력하세요."></li>
			<li><p>이메일</p><input type="text" name="email1"><span>@</span>
				<select name="email2">
					<option value="naver.com">naver.com</option>
					<option value="gmail.com">gmail.com</option>
					<option value="daum.net">daum.net</option>
				</select>
			</li>
			<li><p>주소</p>주소1 : <input type="text" name="addr1"></li>
			<li>주소2 : <input type="text" name="addr2"></li>
			<li><button type="submit">가입하기</button></li>
		</ul>
	</form>
</div>
</body>
</html>