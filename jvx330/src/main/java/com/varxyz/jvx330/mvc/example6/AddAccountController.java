package com.varxyz.jvx330.mvc.example6;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("example6.addAccountController")
@RequestMapping("/example6/add_account")
public class AddAccountController {
	
	@GetMapping
	public String addAccountForm(Model model) {
		model.addAttribute("account", new AccountCommand());
		return "example6/add_account";
	}
	
	@ModelAttribute("accTypeProviderList")
	public List<accTypeProvider> getAccTypeProviderList() {
		List<accTypeProvider> list = new ArrayList<accTypeProvider>();
		list.add(new accTypeProvider("C", "Checking Account"));
		list.add(new accTypeProvider("S", "Saving Account"));
		
		return list;
	}
	
	@PostMapping
	public String addAccount(@ModelAttribute("account") AccountCommand account,
			Model model) {
		
		model.addAttribute("account", account);
		return "example6/success_add_account";
	}
}
