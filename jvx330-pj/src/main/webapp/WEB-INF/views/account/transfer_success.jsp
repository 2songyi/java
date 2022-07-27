<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
계좌 이체 완료되었습니다.

보내는 분 계좌 : ${outAccountNum}<br>
받는 분 계좌 : ${inAccountNum}<br>
이체 금액 : ${money}<br>

현재 잔액 : ${balance}

<button><a href="main">확인</a></button>
</body>
</html>