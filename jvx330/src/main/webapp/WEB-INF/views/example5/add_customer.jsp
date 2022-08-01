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
<h3>회원가입</h3>
<form:form method="post" modelAttribute="customer"> <!-- command를 써주면 됨 안써줘도 -->
	<label>이메일</label>
	<form:input path="email1"/>@
	<form:select path="email2">
		<option value="unkonwn">--선택--</option>
		<form:options itemValue="emailHost" 
		              itemLabel="emailCode"
		              items="${emailProviderList}"/>
	</form:select>
	<br> <!-- name, id = path -->
	<label>비밀번호</label>
	<form:input path="passwd"/><br>
	<label>이름</label>
	<form:input path="name"/><br>
	<label>주민번호</label>
	<form:input path="ssn"/><br>
	<label>연락처</label>
	<form:select path="phone1">
		<form:options items="${phoneProviderList}"/>
	</form:select>-
	<form:input path="phone2"/>-
	<form:input path="phone3"/><br>
	
	<%-- <form:radiobuttons ></form> --%>
	<input type="submit" value="가입하기" />

</form:form>

</body>
</html>