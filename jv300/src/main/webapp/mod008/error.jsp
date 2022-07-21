<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
			<!-- jstl, el로 수정 -->
			<c:if test="${not empty errorMsgs}">
				<h3>다음과 같은 에러가 발생했습니다.</h3>
				<ul>
					<c:forEach var="message" items="${errorMsgs}">
						<li>${message}</li>
					</c:forEach>
					<c:when test="">
						<c:choose></c:choose>
					</c:when>
				</ul>
			</c:if>
		</div>
		<div id="footer">
			<%@ include file="/incl/footer.jsp"%>
		</div>
	</div>
</body>
</html>