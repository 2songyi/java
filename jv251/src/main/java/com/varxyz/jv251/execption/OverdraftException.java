package com.varxyz.jv251.execption;

public class OverdraftException extends RuntimeException {
	private double overdraftAvail;
	
	public OverdraftException(String msg) {
		super(msg);
	}
	
	public OverdraftException(String msg, double balance, double overdraftAvail) {
		super(msg);
		this.overdraftAvail = overdraftAvail;
	}
	
//	public String getMessage() {
//		return super.getMessage() + "현재잔고는 "입니다";
//	}
	
}
