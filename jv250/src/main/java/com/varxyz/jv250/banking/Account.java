package com.varxyz.jv250.banking;

import java.util.Date;

/**
 * 은행계좌정보를 8 구현한 class 0 
 * @author LeeSongYi
 *
 */
public abstract class Account {
	// 공통정보
	protected long aid;
	protected String accountNum;
	protected double balance; 
	protected Customer customer;
	protected Date regdate;
	protected char accountType;

	public Date getRegDate() {
		return regdate;
	}

	public void setRegDate(Date date) {
		this.regdate = date;
	}
	
	public Account() {
		
	}
	
	public char getAccountType() {
		return accountType;
	}

	public void setAccountType(char accountType) {
		this.accountType = accountType;
	}

	
	public Account(String accountNum, double balance) {
		this.setAccountNum(accountNum);
		this.balance = balance;
	}

	// 입금 method
	public void deposite(double amount) {
		balance += amount;
	}

//	 출금메서드를 추상메서드로 구현 후 자식클래스에서 오버라이딩한다.
	public abstract void withdraw(double amount);
	
	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setAid(long aid) {
		this.aid = aid;
	}
	
	public long getAid() {
		return aid;
	}
	


	
	public String toString() {
		return accountNum + ", " + balance + ", ";
	}
	
	
}
