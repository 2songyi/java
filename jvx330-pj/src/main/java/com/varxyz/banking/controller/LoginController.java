package com.varxyz.banking.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.varxyz.banking.DataSourceConfig;
import com.varxyz.banking.Service.AccountService;
import com.varxyz.banking.Service.CustomerService;
import com.varxyz.banking.domain.AccountListCommand;
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
		public String login(@RequestParam String userId, @RequestParam String passwd, Model model, HttpSession session) {
			// 아이디, 비밀번호로 회원 확인하기
			
			AnnotationConfigApplicationContext context =
					new AnnotationConfigApplicationContext(DataSourceConfig.class);
			
			CustomerService service = context.getBean("customerService", CustomerService.class);
			
			Customer checkResult = service.checkUser(userId, passwd);
			System.out.println("checkResult : " + checkResult);
			
			//accountList 세션에 올리기
			AccountService aservice = context.getBean("accountService", AccountService.class);
			List<AccountListCommand> accountList = aservice.getAccount(userId);
			session.setAttribute("accountList", accountList);
			
			//로그인 아이디 세션에 올리기
			session.setAttribute("userId", userId);
			
			/*
			 * userContainer만들어서 세션 넣기
			UserContainer userContainer = new UserContainer();
			userContainer.setAuthUser(authUserService.getAuthUser(email));
			session.setAttribute();
			
			sessoion에 customer정보 다 올리면 비밀번호도 올라가서 문제가 됨. -> 시스템 운영에 필요한거만 따로 올리려고
			 만든게 authUser
			AuthUser클래스에는 비밀번호가 없음
			UserContainer에는 private AuthUser authUser, List<Account> accountList가 변수로 있음
			
			로그인 유효성 검증을 Authuser에 값이 들었는지 확인
			*/
			
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
//		@GetMapping("banking/main")
//		public String gotoMain(@RequestParam String userId, Model model) {
//			model.addAttribute("userId", userId);
//			return "log/success_login";
//		}
		@GetMapping("banking/main")
		public String gotoMain(HttpSession session, Model model) {
			String userId = (String)session.getAttribute("userId");
			model.addAttribute("userId", userId);
			return "log/success_login";
		}
		
		// 로그아웃
		@GetMapping("banking/logout")
		public String logout(HttpSession session) {
			// 로그아웃시 세션 제거
			session.invalidate();
			return "log/login";
		}
}
