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

@WebServlet("/mod009/user_list.do")
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static List<User> userList;

	private UserDao userDao = new UserDao();
	
	public void init(ServletConfig config) throws ServletException {
		userList = userDao.findAllUser();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("userList", userList);
		request.getRequestDispatcher("user_list.jsp").forward(request, response);
	}


}
