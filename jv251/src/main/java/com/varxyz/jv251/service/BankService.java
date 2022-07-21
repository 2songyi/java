package com.varxyz.jv251.service;

import java.util.List;

import com.varxyz.jv251.dao.AccountDao;
import com.varxyz.jv251.dao.CustomerDao;
import com.varxyz.jv251.domain.Account;
import com.varxyz.jv251.domain.CheckingAccount;
import com.varxyz.jv251.domain.Customer;
import com.varxyz.jv251.domain.SavingAccount;
import com.varxyz.jv251.execption.CustomerNotFoundException;
import com.varxyz.jv251.execption.DuplicatedEntityException;

public class BankService {
	private static final BankService service = new BankService(); // singleTon 
	
	public static final char SA = 'S';
	public static final char CA = 'C';
	
	public static final double DEFAULT_INTEREST_RATE = 0.03;
	public static final double DEFAULT_OVERDRAFT_AMOUNT= 1000.0;
	
	private CustomerService customerService;
	private	AccountService accountService;
	
	private BankService() {
		init();
	}
	
	public void init() {
		customerService = new CustomerService(new CustomerDao());
		accountService = new AccountService(new AccountDao());
	}
	
	public static BankService getInstance() {
		return service; // main에서 이 메서드를 통해 생성된 객체를 호출 -> static
	}
	
	public void addCustomer (String name, String ssn, String phone, String userId, String passwd) {
		// 초기에 정보만 넘기면 이 안에서 정보를 add하고 계좌생성하고 해줌
		if (!isCustomer(ssn)) {
			customerService.addCustomer(customerService.createCustomer(name, ssn, phone, userId, passwd));
		} else {
			throw new DuplicatedEntityException(ssn + "is duplicated.");			
		}
	}
	
	public Customer getCustomerBySsn(String ssn) {
		return customerService.getCustomerBySsn(ssn);
	}
	
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}
	
	public void addSavingAccount(double balance, double interestRate, String ssn) throws CustomerNotFoundException{
		SavingAccount account = new SavingAccount();
		account.setAccountNum(accountService.generateAccountNum());
		account.setBalance(balance);
		account.setAccountType(BankService.SA);
		account.setInterestRate(interestRate);
		
		Customer customer = customerService.getCustomerBySsn(ssn);
		if (customer != null) {
			account.setCustomer(customer);
			accountService.addAccount(account);
		} else {
			throw new CustomerNotFoundException(ssn + " not found.");
		}
	}
	
	
	public void addCheckingAccount(double balance, double overdraftAmount, String ssn) throws CustomerNotFoundException {
		CheckingAccount account = new CheckingAccount();
		account.setAccountNum(accountService.generateAccountNum());
		account.setBalance(balance);
		account.setAccountType(BankService.CA);
		account.setOverdraftAmount(overdraftAmount);
		
		// 고객정보 찾아보고 insert(고객부터 정보 넣고 account생성)
		Customer customer = customerService.getCustomerBySsn(ssn);
		if (customer != null) {
			account.setCustomer(customer);
			accountService.addAccount(account); //db에 넣기
		} else {
			throw new CustomerNotFoundException(ssn + " not found.");
		}
	}
	
	public boolean isCustomer(String ssn) {
		return customerService.getCustomerBySsn(ssn) == null ? false : true;
	}
	
	// client가 생성할 유일한 객체는 bank인데 singleTon이라 직접 안만들고 
	public List<Account> getAccountsBySsn(String ssn) {
		return accountService.getAccountsBySsn(ssn);
	}
	
	
	public Account getAccount(String accountNum) {
		return accountService.getAccount(accountNum);
	}
	
	// 입금
	public Double deposite(double amount, Account account) {
		account.deposit(amount);
		double percent = 0;
		double com = 0;
		
		if (account instanceof SavingAccount) {
			SavingAccount sa = (SavingAccount)account;
			percent = sa.getInterestRate() + 1;
			com = account.getBalance() * percent;
		} else {
			com = account.getBalance();
		}
		
		return com;
	}
	
	// 출금
	public void withDraw(double amount, String accountNum) {
		
	}
	
}
