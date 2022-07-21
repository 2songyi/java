package com.varxyz.jv251.execption;

public class InsufficienBalanceException extends RuntimeException {
	private double balance;
	
	public InsufficienBalanceException(String msg) {
		super(msg);
	}
	
	public InsufficienBalanceException(String msg, double balance) {
		super(msg);
		this.balance = balance;
	}
	
	@Override
	public String getMessage() {
		return super.getMessage() + "현재 잔고는 " + balance + "입니다.";
	}
	

}
