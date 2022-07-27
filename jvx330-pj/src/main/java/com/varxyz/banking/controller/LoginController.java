package com.varxyz.banking.controller;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.varxyz.banking.DataSourceConfig;
import com.varxyz.banking.Service.CustomerService;
import com.varxyz.banking.domain.Customer;

@Controller("banking.loginController")
public class LoginController {
	
	// 로그인 페이지가 첫 페이지
		@GetMapping("banking/login")
		public String startLogin() {
			return "log/login";
		}
		
		// 로그인 페이지
		@PostMapping("banking/login")
		public String login(@RequestParam String userId, @RequestParam String passwd, Model model) {
			// 아이디, 비밀번호로 회원 확인하기
			
			AnnotationConfigApplicationContext context =
					new AnnotationConfigApplicationContext(DataSourceConfig.class);
			
			CustomerService service = context.getBean("customerService", CustomerService.class);
			
			Customer checkResult = service.checkUser(userId, passwd);
			System.out.println("checkResult : " + checkResult);
			
			
			if (checkResult == null) {
				System.out.println("아이디, 비밀번호가 틀림");
				model.addAttribute("error_msg", "아이디나 비밀번호가 틀렸습니다.");
				return "log/login";
			} else {
				// 계좌번호 session으로 redirect 추가
				
				System.out.println("로그인확인");
				model.addAttribute("userId", userId);
				
				return "redirect:/banking/main";
			}
		}
		
		// 확인버튼 클릭 시 메인페이지로 이동
		@GetMapping("banking/main")
		public String gotoMain(@RequestParam String userId, Model model) {
			model.addAttribute("userId", userId);
			return "log/success_login";
		}
		
		// 로그아웃
		@GetMapping("banking/logout")
		public String logout() {
			return "log/login";
		}
}
