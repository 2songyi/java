package com.varxyz.banking.controller;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.varxyz.banking.DataSourceConfig;
import com.varxyz.banking.Service.AccountService;
import com.varxyz.banking.dao.AccountDao;
import com.varxyz.banking.domain.Account;
import com.varxyz.banking.domain.CheckingAccount;
import com.varxyz.banking.domain.Customer;
import com.varxyz.banking.domain.SavingAccount;

@Controller("banking.accountController")
public class AccountController {

	@GetMapping("banking/add_account")
	public String addAccount() {
		return "account/add_account";
	}

	// 계좌 생성
	@PostMapping("banking/add_account")
	public String addAccountForm(@RequestParam int cid, @RequestParam String accType, @RequestParam double balance,
			Model model) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);

		AccountDao dao = context.getBean("accountDao", AccountDao.class);

		String accountNum;

		if (accType.equals("S")) {
			accType = "Saving Account";
			accountNum = generateAccountNum(); // 계좌번호생성기로 랜덤계좌번호 생성

			SavingAccount account = new SavingAccount();
			account.setCustomer(new Customer(cid));
			account.setAccountNum(accountNum);
			account.setAccType('S');
			account.setBalance(balance);
			account.setInterestRate(0.2);

			dao.addAccount(account);
		} else {
			accType = "Checking Account";
			accountNum = generateAccountNum();

			CheckingAccount account = new CheckingAccount();
			account.setCustomer(new Customer(cid));
			account.setAccountNum(accountNum);
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

	// 계좌 목록 확인
	@GetMapping("banking/find_account")
	public String findAccount(@RequestParam String userId, Model model) {
		
		//유저 아이디로 account정보 받기
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
		AccountDao dao = context.getBean("accountDao", AccountDao.class);
		
		List<Account> accountList = dao.getAccount(userId);
		
		System.out.println("accountList" + accountList);
		model.addAttribute(accountList);
		return "account/find_account";
	}

//	@PostMapping("banking/find_account")
//	public String findAccountList(@RequestParam long customerId, Model model) {
//		// 고객아이디 입력받아서 계좌 목록 찾기
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
//
//		System.out.println("customerId" + customerId);
//		AccountDao dao = context.getBean("accountDao", AccountDao.class);
//
//		List<Account> accountList = dao.getAccount(customerId);
//		model.addAttribute("accountList", accountList);
//		System.out.println("accountList" + accountList);
//		return "account/find_account";
//	}

	// 계좌번호로 잔액조회
	@GetMapping("banking/get_balance")
	public String getBalance() {
		return "account/get_balance";
	}
	
	@PostMapping("banking/get_balance")
	public String getBalanceResult(@RequestParam String accountNum, Model model) {
		System.out.println(accountNum);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
		AccountService service = context.getBean("accountService", AccountService.class);
		
		double balance = service.getBalance(accountNum);
		model.addAttribute("accountNum", accountNum);
		model.addAttribute("balance", balance);
		System.out.println(balance);
		return "account/get_balance";
	}
	

	
//	 계좌이체
	@GetMapping("banking/transfer")
	public String transfer() {
		return "account/transfer";
	}
	
	@PostMapping("banking/transfer")
	public String transferDo(@RequestParam String outAccountNum, @RequestParam String inAccountNum, 
			@RequestParam double money, @RequestParam String passwd, Model model) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
		AccountService service = context.getBean("accountService", AccountService.class);
		
		// outAccountNum, passwd로 계좌 소유주 조회 -> 맞으면 진행
		Account checkPasswd = service.checkPasswdForTransfer(outAccountNum, passwd);
		
		if (checkPasswd == null) {
			model.addAttribute("error_msg", "비밀번호가 일치하지 않습니다.");
			return "account/transfer";
		}
		
		service.transfer(outAccountNum, inAccountNum, money);
		double balance = service.getBalance(outAccountNum); 
		
		model.addAttribute("outAccountNum", outAccountNum);
		model.addAttribute("inAccountNum", inAccountNum);
		model.addAttribute("money", money);
		model.addAttribute("balance", balance); // 이체 결과 잔액
		return "account/transfer_success";
	}

	// 계좌랜덤생성기
	public String generateAccountNum() {
		String accountNum = "";

		for (int i = 0; i < 3; i++) {
			accountNum += (int) (Math.random() * 10);
		}
		accountNum += "-";
		for (int i = 0; i < 2; i++) {
			accountNum += (int) (Math.random() * 10);
		}
		accountNum += "-";
		for (int i = 0; i < 4; i++) {
			accountNum += (int) (Math.random() * 10);
		}

		return accountNum;
	}
	


}
