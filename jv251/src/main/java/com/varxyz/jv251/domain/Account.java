package com.varxyz.jv251.domain;

import java.util.Date;

public abstract class Account {
	protected long aid;
	protected String accountNum;
	protected double balance; 
	protected Customer customer;
	protected Date regdate;
	protected char accountType;
	
	
	public Account() {
		
	}
	
	public Account(String accountNum, double balance) {
		this.setAccountNum(accountNum);
		this.balance = balance;
	}
	
	public void deposit(double amount) {
		this.balance += amount;
	}
	
	
	public Date getRegDate() {
		return regdate;
	}

	public void setRegDate(Date date) {
		this.regdate = date;
	}
	
	
	public char getAccountType() {
		return accountType;
	}

	public void setAccountType(char accountType) {
		this.accountType = accountType;
	}

	

	// 입금 method
	public void deposite(double amount) {
		balance += amount;
	}

	// 출금메서드를 추상메서드로 구현 후 자식클래스에서 오버라이딩한다.
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
	
	@Override
	public String toString() {
		return "Account [aid=" + aid + ", accountNum=" + accountNum + ", balance=" + balance + ", customer=" + customer
				+ ", regdate=" + regdate + ", accountType=" + accountType + "]";
	}
	
	
}
