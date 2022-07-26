package com.varxyz.banking.controller;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.varxyz.banking.DataSourceConfig;
import com.varxyz.banking.dao.CustomerDao;
import com.varxyz.banking.domain.CustomerCommand;

@Controller("banking.customerController")
public class CustomerController {
	
//	@Autowired
//	private CustomerDao customerDao;
	
	// 로그인 페이지가 첫 페이지
	@GetMapping("banking/login")
	public String startLogin() {
		return "log/login";
	}
	
	// 로그인 페이지
	@PostMapping("banking/login")
	public String login(@RequestParam String userId, @RequestParam String passwd, Model model) {
		// 로그인한 아이디 + 계좌정보 + 이체하기 버튼
		// 아이디, 비밀번호로 회원확인하기

		model.addAttribute("userId", userId);
		model.addAttribute("passwd", passwd);
		
		return "log/success_login";
	}
	
	// 확인버튼 클릭 시 메인페이지로 이동
	@GetMapping("banking/main")
	public String gotoMain() {
		return "log/success_login";
	}
	
	// 로그아웃
	@GetMapping("banking/logout")
	public String logout() {
		return "log/login";
	}
	
	// 회원 가입 페이지로 이동
	@GetMapping("/banking/add_customer")
	public String addCustomer1() {
		return "customer/add_customer";
	}
	
	@PostMapping("/banking/add_customer")
	public String addCustomerForm(CustomerCommand customer, Model model) {
		// 받은정보 customer테이블에 insert한 후 가입 정보 띄우기
		
		System.out.println(customer);
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DataSourceConfig.class);
		
		CustomerDao dao = context.getBean("customerDao", CustomerDao.class);
		
		dao.addCustomer(customer);
		
		model.addAttribute("userId", customer.getUserId());
		return "customer/add_customer_result";
	}
	
	
	
	
	

}
