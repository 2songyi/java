<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계좌 생성</title>
</head>
<body>

<h3>계좌 만들기</h3>
<form:form method="post" modelAttribute="account">
	<label>회원 이메일</label>
	<form:input path="customer.email"/><br>
	<label>계좌 타입</label>
	<form:radiobuttons path="accType" 
					   itemValue="accTypeCode"
					   itemLabel="accTypeHost"
					   items="${accTypeProviderList}"/><br>
	<label>계좌 비밀번호</label>
	<form:input path="passwd"/><br>
	<input type="submit" value="계좌 생성하기">
</form:form>
</body>
</html>