<%@ page language="java" import="java.net.URLEncoder" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
@import url('https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700;800&display=swap');
ul, li {
	list-style: none;
	margin: 0;
	padding: 0;
}

#wrap {
	max-width: 400px;
	margin: 0 auto;
	font-family: 'Nanum Gothic', sans-serif;
}

#wrap .title {
	text-align: center;
	font-size: 35px;
}
#content-wrapper .title {
	margin-bottom: 35px;
}

input {
	width: 100%;
	height: 40px;
	background-color: #f1f1f1;
	border: 1px solid #fff;
	box-sizing: border-box;
	padding: 10px 14px 10px 14px;
	transition: .3s;
}

input:hover {
	box-sizing: border-box;
	border: 1px solid grey;
}

input:focus {
	outline: none;
	border: 1px solid #87CEEB;
	box-sizing: border-box;
}

input.email {
	width: 65%;
}

input.addr {
	width: 86%;
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
	width: 400px;
	font-size: 15px;
	margin-top: 30px;
	transition: .3s;
}
button:hover {
	background-color: grey;	
	color: #fff;
}
</style>
<body>
	<div id="wrap">
		<div id="header">
			<jsp:include page="/incl/banner.jsp">
				<jsp:param name="sub-title" value="<%=URLEncoder.encode(\"mod007 : 배너\", \"UTF-8\") %>" />
			</jsp:include>
		</div>
		<div id="content-wrapper">
			<div class="title">회원가입</div>
			<form action="adduser.do" method="post">
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
						<input type="text" name="email1" class="email"><span>@</span> <select
						name="email2">
							<option value="naver.com">naver.com</option>
							<option value="gmail.com">gmail.com</option>
							<option value="daum.net">daum.net</option>
					</select></li>
					<li><p>주소</p>주소1 : <input type="text" name="addr1" class="addr"></li>
					<li>주소2 : <input type="text" name="addr2" class="addr"></li>
					<li><button type="submit">가입하기</button></li>
				</ul>
			</form>
		</div>
		<div id="footer">
			<%@ include file="/incl/footer.jsp"%>
		</div>
	</div>
</body>
</html>