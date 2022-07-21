package com.varxyz.jv300.mod004;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mod004/adduser.do")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String userId= request.getParameter("userId");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		String ssn = request.getParameter("ssn");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String[] concerns = request.getParameterValues("concerns");
		
		String pageTitle = "회원가입 폼";
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>" + pageTitle + "</head></title>");
		out.println("<body>");
		out.println("<h3>아이디 : " + userId + "</h3>");
		out.println("<h3>비밀번호 : " + passwd + "</h3>");
		out.println("<h3>이름 : " + name + "</h3>");
		out.println("<h3>주민번호 : " + ssn + "</h3>");
		out.println("<h3>이메일 : " + email1 + "@" + email2 + "</h3>");
		out.println("<h3>관심분야 : " + concerns + "</h3>");
		out.println("</html></body>");
		out.close();
		// get으로 받으면 사용자 정보 주소창에 다 찍힘
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
