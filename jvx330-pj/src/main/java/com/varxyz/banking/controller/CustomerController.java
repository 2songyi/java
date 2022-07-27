package com.varxyz.banking.controller;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.banking.DataSourceConfig;
import com.varxyz.banking.Service.CustomerService;
import com.varxyz.banking.domain.CustomerCommand;

@Controller("banking.customerController")
public class CustomerController {
	
	
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
		
		CustomerService service = context.getBean("customerService", CustomerService.class);
		
		service.addCustomer(customer);
		
		model.addAttribute("userId", customer.getUserId());
		return "customer/add_customer_result";
	}
	
	
	
	
	

}
