package com.varxyz.jv300.mod006;

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

@WebServlet("/mod006/adduser.do")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService = new UserService();
	
	public void init(ServletConfig config) throws ServletException {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		
		// 1. 폼 파라메터 열기
		String userId = request.getParameter("userId");
		String passwd = request.getParameter("passwd");
		String userName = request.getParameter("userName");
		String ssn = request.getParameter("ssn");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		
		
		// 2. 유효성 검증
		List<String> errorMsgs = new ArrayList<String>();
		if (userId == null || userId.length() == 0) {
			errorMsgs.add("아이디는 필수입력 정보입니다.");
		} else if (passwd == null || passwd.length() == 0) {
			errorMsgs.add("비밀번호는 필수입력 정보입니다.");
		}
		
		RequestDispatcher dispatcher = null;
		if (errorMsgs.size() > 0) {
			dispatcher = request.getRequestDispatcher("/error/error.jsp");
			dispatcher.forward(request, response);
			return;
		}
		User user = new User();
		user.setUserId(userId);
		user.setPasswd(passwd);
		user.setUserName(userName);
		user.setSsn(ssn);
		user.setEmail(email1 + "@" + email2);
		user.setAddr(addr1 + " " + addr2);
		
		// 3. 비지니스 서비스 호출
		userService.addUser(user);
		
		// 4. NextPage
		request.setAttribute("userName", userName);
		dispatcher = request.getRequestDispatcher("success.jsp"); //상대경로로 적은 이거는 add_user.do랑 동일선상에 있다
		dispatcher.forward(request, response);
	}
	// success.jsp -> 성공, error.jsp-> 실패 만 뜨게 구현

}
