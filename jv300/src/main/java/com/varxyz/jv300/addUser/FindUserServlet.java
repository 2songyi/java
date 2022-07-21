package com.varxyz.jv300.addUser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mod009/find_user.do")
public class FindUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 아이디 있으면 -> edit페이지로 넘어가게
	// 아이디 없으면 실패페이지로 넘어가게
	private UserDao userDao = new UserDao();
	
	public void init(ServletConfig config) throws ServletException {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		
		// 유효성 검증
		List<String> errorMsgs = new ArrayList<String>();
		if (userId == null || userId.length() == 0) {
			errorMsgs.add("아이디를 입력해주세요.");
		}
		
		RequestDispatcher dispatcher = null;
		if (errorMsgs.size() > 0) {
			request.setAttribute("errorMsgs", errorMsgs);
			dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		// 서비스 호출
		System.out.println(userId);
		User user = userDao.findUser(userId);
		request.setAttribute("user", user);
		System.out.println(user);
		
		dispatcher = request.getRequestDispatcher("edit_user.jsp");
		dispatcher.forward(request, response);
		
	}


}
