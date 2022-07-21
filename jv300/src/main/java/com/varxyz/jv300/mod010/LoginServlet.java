package com.varxyz.jv300.mod010;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/mod010/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// get-> page를 보여주는거/ post는 로그인으로 넘어가는거
	
	private UserService userService;
	
	public void init() {
		userService = new UserService();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String userId = request.getParameter("userId");
		String passwd = request.getParameter("passwd");
		
		//유효성검증하기
		List<String> errorMsgs = new ArrayList<String>();
		if (userId == null || userId.length() == 0) {
			errorMsgs.add("아이디를 입력해주세요.");
		}
		if (passwd == null || passwd.length() == 0) {
			errorMsgs.add("비밀번호를 입력해주세요.");
		}
		
		RequestDispatcher dispatcher = null;
		if (errorMsgs.size() > 0) {
			request.setAttribute("errorMsgs", errorMsgs);
			dispatcher = request.getRequestDispatcher("/error/error.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		// 서비스 호출
		if (!userService.isValidUser(userId, passwd)) {
			// 유저가 아니면 다시 로그인페이지로 돌아감.
			System.out.println("유저가 아닙니다.");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		
		System.out.println("유저가 확인되었습니다.");
		
		HttpSession session = request.getSession(true); 
		session.setAttribute("userId", userId);
		response.sendRedirect("mypage"); //getRequestDispatcher차이
		
		
	}
}
