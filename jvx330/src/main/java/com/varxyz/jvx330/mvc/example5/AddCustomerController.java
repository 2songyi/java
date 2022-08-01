package com.varxyz.jvx330.mvc.example5;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("example5.addCustomerController")
@RequestMapping("/example5/add_customer")
public class AddCustomerController {
	
	@GetMapping
	public String addCustomerForm(Model model) {
		
		model.addAttribute("customer", new CustomerCommand());
		return "example5/add_customer";
	}
	
	// 이메일 select박스
	@ModelAttribute("emailProviderList")
	public List<EmailProvider> getEmailProviderList() {
		List<EmailProvider> list = new ArrayList<EmailProvider>();
		list.add(new EmailProvider("Google", "gmail.com"));
		list.add(new EmailProvider("Naver", "naver.com"));
		list.add(new EmailProvider("Daum", "daum.net"));
		return list;
	}
	
	// 전화번호 select박스
	@ModelAttribute("phoneProviderList")
	public List<String> getPhoneProviderList() {
		List<String> list = new ArrayList<String>();
		list.add("010");
		list.add("011");
		list.add("016");
		list.add("053");
		list.add("02");

		return list;
	}
	
	@PostMapping
	public String addCustomer(@ModelAttribute("customer") CustomerCommand customer, Model model) {
		
		//db처리
		// ...
		//customer = customerService.addCustomer(customer);
		
		String email = customer.getEmail1() + "@" + customer.getEmail2();
		String phone = customer.getPhone1() + "-" + customer.getPhone2() + "-" + customer.getPhone3();
		
		customer.setEmail(email);
		customer.setPhone(phone);
		
		model.addAttribute("customer", customer);
		return "example5/success_add_customer";
		
	}
	

}
