package com.varxyz.jvx330pj.adduser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	
	@RequestMapping("/user/start")
	public ModelAndView start() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("user/adduser");
		return mav;
	}
	
	@RequestMapping("/user/userform")
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response) {
		
		String userId = request.getParameter("userId");
		String passwd = request.getParameter("passwd");
		String userName = request.getParameter("userName");
		String ssn = request.getParameter("ssn");
		String email = request.getParameter("email");
		String addr = request.getParameter("addr");
	
		ModelAndView mav = new ModelAndView();
		mav.addObject("userId", userId);
		mav.addObject("passwd", passwd);
		mav.addObject("userName", userName);
		mav.addObject("ssn", ssn);
		mav.addObject("email", email);
		mav.addObject("addr", addr);
		mav.setViewName("user/adduser_success");
		
		return mav;
	}
}
