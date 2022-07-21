package com.varxyz.jv250.banking;

import java.util.Date;
import java.sql.Timestamp;

public class SavingAccount extends Account {
	private static final double DEFALT_INTEREST_RATE = 0.03;
	private double interestRate;
	private Timestamp regdate;
	
	
	// super()를 이용해 부모클래스에서 선언한 생성자를 호출한다.
	public SavingAccount() {
		
	}
	
	public SavingAccount(String accountNum, double balance) {
		this(accountNum, balance, DEFALT_INTEREST_RATE);
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
			System.out.println(amount + "원 출금하셨습니다. 현재 잔액은 " + super.balance + "입니다.");
			System.out.println("현재 계좌의 이자율은 " + interestRate + "% 입니다.");
		}
	}
	
//	public Timestamp getRegDate() {
//		return regdate;
//	}
//
//	public void setRegDate(Date date) {
//		regdate = (Timestamp) date;
//	}
}
