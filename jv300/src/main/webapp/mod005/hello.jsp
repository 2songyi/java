<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%! 
	private static final String DEFAULT_NAME = "World"; 
	public void jspInit() {
		
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello world</title>
</head>
<body>
<%-- jsp 주석 (%디렉티브 태그, !멤버변수선언, =출력, 바디안에 안넣고 바깥에 적어도 된다.)
	mod005/HelloServlet.java랑 비교
	-> doGet(service메소드) 서비스 메서드를 오버라이딩한게 jsp가 됨/ 이거 자체가 service()
	_jspService()메서드는 자신이 jsp라서 오버라이딩 안됨
	비지니스로직 -> 서블릿 , 프레젠테이션 로직 -> jsp 로 사용해야한다.
	
	request, response, out, exception ...은 내장객체 있어서 바로 사용 가능하다.
--%>
<%
	String name = request.getParameter("userName");
	if(name == null || name.length() == 0) {
		name = DEFAULT_NAME;
	}
%>
<h3>Hello, <%=name %></h3>
</body>
</html>