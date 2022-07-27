<%@ page language="java" import="java.net.URLEncoder" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
계좌 잔액 확인

<form action="get_balance" method="post">
	<input type="text" name="accountNum" placeholder="계좌번호를 입력해주세요">
	<button type="submit">계좌 잔액 확인</button>
</form>
계좌번호 : ${accountNum}<br>
잔액 : ${balance} 
</body>
</html>