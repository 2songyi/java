package com.varxyz.jvx330.banking;

import org.springframework.transaction.annotation.Transactional;

public class TransferAccount implements BankService {
	private AccountDao accountDao;
	
	@Transactional
	@Override
	public boolean transfer(double money, String outAccountNum, String inAccountNum) {
		
		withDraw(outAccountNum, money); // outAccountNum계좌에서 money만큼 출금
		deposit(inAccountNum, money); // inAccountNum 계좌에 money만큼 입금
		
		return true;
	}
	
	/* 출금
	 * 계좌번호와 출금할 금액을 입력받는다.
	 * 원래 잔액에서 출금액을 뺀 금액을 잔액으로 잔액정보를 업데이트 한다.
	 * */
	public void withDraw(String accountNum, double money) {
		double balacne = getBalance(accountNum) - money;
		accountDao.withDraw(accountNum, balacne);
	}
	
	/* 입금 
	 * 계좌번호와 입금할 금액을 입력받는다.
	 * 원래 잔액에서 입금액을 더한 금액이 잔액이 된다.
	 * */
	public void deposit(String accountNum, double money) {
		double balance = getBalance(accountNum) + money;
		accountDao.deposit(accountNum, balance);
	}
	
	// 잔액 조회
	@Override
	public double getBalance(String accountNum) {
		return accountDao.getBalance(accountNum);
	}
}
