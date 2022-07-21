package com.varxyz.banking.domain;

import java.util.ArrayList;
import java.util.List;

public class AccountServiceImp1 implements AccountService {
	private static AccountService service = new AccountServiceImp1();
	
	private List<Account> accountList = new ArrayList<Account>();
	private CustomersService customerService;
	
	// 싱글톤패턴
	private AccountServiceImp1() {
		customerService = CustomerServiceImp2.getInstance();
	}
	
	public static AccountService getInstance() {
		return service;
	}
	
	// saving 계좌 생성
	public Account createSavingAccount(String accountNum, double balance, double interestRate) {
		return new SavingAccount(accountNum, balance, interestRate);
	}
	
	// checking 계좌 생성
	public Account createCheckingAccount(String accountNum, double balance, double overdraftAmount) {
		return new CheckingAccount(accountNum, balance, overdraftAmount);
	}
	
	/**
	 * 신규 계좌 등록
	 * @param account 	계좌정보와 고객정보 전체를 캡슐화
	 */
	public void addAccount(Account account) {
		accountList.add(account);			
	}
	
	/**
	 * 전달된 ssn을 통해 고객을 조회한 후 신규 계좌 등록
	 * @param account	
	 * @param ssn
	 */
	public void addAccount(Account account, String ssn) {
		Customer customer = customerService.getCustomerBySsn(ssn);
		account.setCustomer(customer);
	}
	
	// 계좌 리스트
	public List<Account> getAccountBySsn(String ssn) {
		

		// customer -> account
		// ssn에 해당하는 게좌 출력, customer에 acccount목록에 주민번호가 같은지 찾고 같으면 account객체 찾기
		// account를 뒤지고 그 안에 customer 그안에 ssn 찾기
		return null;
	}
	
	public Account getAccountByAccountNum(String accountNum) {
		for (Account a : accountList) {
			// 입력된 계좌번호와 리스트에 있는 계좌번호 비교
			if (accountNum.equals(a.getAccountNum())) {
				return a;
			}
		}
		// 없는 계좌번호라면 null 반환
		return null;
	}

}


