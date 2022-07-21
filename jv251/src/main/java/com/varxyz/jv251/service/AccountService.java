package com.varxyz.jv251.service;

import java.util.List;

import com.varxyz.jv251.dao.AccountDao;
import com.varxyz.jv251.domain.Account;

public class AccountService {
	
	private AccountDao accountDao;
	
	public AccountService(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	
	public void addAccount(Account account) {
		accountDao.addAccount(account);
	}
	
	public List<Account> getAccountsBySsn(String ssn) {
		return accountDao.findAccountsBySsn(ssn);
	}
	
	public Account getAccount(String accountNum) {
		return accountDao.findAccountsByNum(accountNum);
	}
	
	/**
	 * XXX-XX-XXXX 형식의 계좌번호 생성기
	 * @return
	 */
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
