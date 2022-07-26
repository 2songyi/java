package com.varxyz.banking.controller;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.varxyz.banking.DataSourceConfig;
import com.varxyz.banking.dao.AccountDao;
import com.varxyz.banking.domain.CheckingAccount;
import com.varxyz.banking.domain.SavingAccount;

@Controller("banking.accountController")
public class AccountController {
	
//	@Autowired
//	private AccountDao accountDao;
	
	@GetMapping("banking/add_account")
	public String addAccount() {
		return "account/add_account";
	}
	
	@PostMapping("banking/add_account")
	public String addAccountForm(@RequestParam String cid, @RequestParam String accType, 
			@RequestParam double balance, Model model) {
		
		String accountNum;
		
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DataSourceConfig.class);
		
		AccountDao dao = context.getBean("accountDao", AccountDao.class);
		
		
		if (accType.equals("S")) {
			accType="Saving Account";
			accountNum = generateAccountNum();
			
			SavingAccount account = new SavingAccount();
			account.setAccountNum(accountNum);// 랜덤생성기 만들기
			account.setAccType('S');
			account.setBalance(balance);
			account.setInterestRate(0.2);
//			account.set
			//입력받는 값이 아이디가 아니고 cid여야함 ->customerId에 넣기 아닌가... 
			// 
			dao.addAccount(account);
		} else {
			accType="Checking Account";
			accountNum = generateAccountNum();
			
			
			CheckingAccount account = new CheckingAccount();
			account.setAccountNum(accountNum);// 랜덤생성기 만들기
			account.setAccType('C');
			account.setBalance(balance);
			account.setOverdraftAmount(0.3);
			
			dao.addAccount(account);
		}
		
		model.addAttribute("userId", cid);
		model.addAttribute("accType", accType);
		model.addAttribute("accountNum", accountNum);
		model.addAttribute("balance", balance);
		
		return "account/add_account_success";
		
		
	}
	// 계좌랜덤생성기
	public String generateAccountNum() {
		String accountNum = "";
		
		for (int i = 0; i < 3; i++) {
			accountNum += (int) (Math.random()*10);
		}
		accountNum += "-";
		for (int i = 0; i < 2; i++) {
			accountNum += (int) (Math.random()*10);
		}
		accountNum += "-";
		for (int i = 0; i < 4; i++) {
			accountNum += (int) (Math.random()*10);
		}
		
		return accountNum;
	}

}
