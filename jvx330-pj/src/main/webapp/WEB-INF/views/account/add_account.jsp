<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
계좌 생성하기
<form action="add_account" method="post">
	아이디 : <input type="text" name="cid">
	<select name="accType">계좌 타입 : 
		<option value="S">Saving Account</option>
		<option value="C">Checking Account</option>
	</select>
	최초 입금액 : <input type="number" name="balance">
	<button type="submit">계좌 생성하기</button>
</form>
</body>
</html>