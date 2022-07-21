package com.varxyz.jv251.domain;

import com.varxyz.jv251.execption.InsufficienBalanceException;


public class SavingAccount extends Account {
	private double interestRate;
	
	public SavingAccount() {
		
	}
	
	public SavingAccount(String accountNum, double balance) {
		this(accountNum, balance, 0.0);
	}
	
	public SavingAccount(String accountNum, double balance, double interestRate) {
		super(accountNum, balance);
		this.interestRate = interestRate;
	}
	
	public double getInterestRate() {
		return interestRate;
	}
	
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	public String toString() {
		return accountNum + ", " + balance + ", " +interestRate;
	}

	@Override
	public void withdraw(double amount) {
		if (balance - amount < 0) {
			// 잔고 부족으로 예외 발생
			throw new InsufficienBalanceException("잔고가 부족합니다. 현재 출금 가능한 잔액은" + balance + "원 입니다.");
		} else {
			super.balance -= amount;
		}
	}
}
