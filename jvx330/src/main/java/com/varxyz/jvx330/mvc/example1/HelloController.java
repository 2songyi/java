package com.varxyz.jvx330.mvc.example1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // 서블릿 역할
public class HelloController {
	
	@RequestMapping("/example1/sayHello")  //get
	public ModelAndView sayHello() {
		String greeting = "Hello 스프링 MVC";
		
		ModelAndView mav = new ModelAndView(); // model 사용자에게 보여줄 어떤 것 greeting, view->화면이 보여질 jsp
		mav.setViewName("example1/hello"); // dispatcher forward
		mav.addObject("greeting", greeting);
		
		return mav;
	}
	
}
