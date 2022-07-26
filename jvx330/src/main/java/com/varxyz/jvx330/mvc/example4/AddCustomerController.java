package com.varxyz.jvx330.mvc.example4;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller("example4.addCustomerController")
public class AddCustomerController {
	
	@GetMapping("example4/add_customer")
	public String addCustomerForm() {
		return "example4/add_customer";
	}
	
	@PostMapping("example4/add_customer")
	public String addCustomer(CustomerCommand customerCommand, Model model) {
		//request getparam쓰지 않고 클래스를 하나 만들어서 사용 (네이밍컨벤션에 따라 알아서 가져와짐)
		
		System.out.println(customerCommand.getEmail());
		model.addAttribute("customerCommand", customerCommand);
		return "example4/success_add_customer";
	}
	
}
