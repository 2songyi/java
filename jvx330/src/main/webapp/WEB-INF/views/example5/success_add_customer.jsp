<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>

<h3>회원가입되었습니다.</h3>
<label>e-mail</label> : ${customer.email}<br>
<label>이름</label> : ${customer.name}<br>
<label>주민번호</label> : ${customer.ssn}<br>
<label>연락처</label> : ${customer.phone}<br>


</body>
</html>