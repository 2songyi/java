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

<label>회원 이메일</label>: ${account.customer.email}<br>
<label>계좌 타입</label>: ${account.accType}<br>
<label>계좌 비밀번호</label>: ${account.passwd}<br>

</body>
</html>