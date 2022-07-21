package com.varxyz.jv300.mod002;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
// Servlet<<i>> ← GemericServlet ← HttpServlet ← HelloServlet
// new로 객체생성해서 사용하지 않고 상속받아서 사용해야함 (인터페이스라서)
// get방식을 지원하려고 하는 경우 doGet method를 오버라이딩해서 사용해야한다.
// 이 웹 컴포넌트를 웹 컨테이너가 관리(톰캣)
// web.xml 에 servlet추가
// 비지니스로직 servlet, 프레젠테이션로직 jsp
// http://localhost:8080/jv300/hello.view
// 지역변수는 동시성 문제를 야기시키지 않음 (멤버변수 조심해서 써야한다)
// 요청, 응답을 클래스화 -> 캡슐화
// 이 서블릿을 쪼개서 쓰는게 스프링
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String pageTitle = "Hello world";
		response.setContentType("text/html; charset=UTF-8"); // jdbc처럼 어떤 컨테이너가 와도 바뀌지 않는 메서드 -> 이런 인터페이스를 협약, 계약
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>" + pageTitle + "</title></head>");
		out.println("<body>");
		out.println("<h3>Welcome to 서블릿 프로그램</h3>");
		out.println("</body></html>");
		out.close();
	}
}
