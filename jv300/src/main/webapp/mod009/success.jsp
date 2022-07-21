<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
ul, li {
	list-style: none;
}

#wrap {
	max-width: 400px;
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
	width: 400px;
	font-size: 15px;
	margin-top: 30px;
}
</style>
<body>
	<div id="wrap">
		<div id="header">
			<jsp:include page="/incl/banner.jsp">
				<jsp:param name="sub-title" value="mod007 : Java Beans and include" />
			</jsp:include>
		</div>
		<div id="content-wrapper">
			<h3>회원가입 되었습니다.</h3>
			아이디 : ${user.userId}<br>
			이름 : <br>
		</div>
		<div id="footer">
			<%@ include file="/incl/footer.jsp"%>
		</div>
	</div>
</body>
</html>