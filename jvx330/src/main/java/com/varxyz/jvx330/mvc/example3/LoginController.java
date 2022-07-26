package com.varxyz.jvx330.mvc.example3;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller("example3.loginController")  // 같은 이름의 컨트롤러가 여러개 나올 경우 충돌을 피하기 위해 앞에 패키지를 적어준다.
public class LoginController {
	
	@GetMapping("example3/login")
	public String loginForm() {
		return "example3/login";
	}
	
//	@PostMapping("example3/login")
	public ModelAndView login(HttpServletRequest request) {
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("id", id);
		mav.addObject("passwd", passwd);
		mav.setViewName("example3/login_result");
		return mav;
	}
	
	// 위의 메소드에서 request를 어노테이션으로 사용해서
	@PostMapping("example3/login")
	public ModelAndView login(@RequestParam(value="id", required=true) String id, 
			@RequestParam String passwd) {
		//	public ModelAndView login(@RequestParam String id, -> 속성명을 맞추면 이렇게 사용 가능하다.
		// required명시하지 않으면 default = true
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("id", id);
		mav.addObject("passwd", passwd);
		mav.setViewName("example3/login_result");
		return mav;
	}
	
	
}
