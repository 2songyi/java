package com.varxyz.jvx330.jdbc;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Account {
	private int aid;
	private Customer customer;
//	private int customerId; oop적으로 받으려면 Customer로 받아야한다.
	private String accountNum;
	private char accType;
	private double balance;
//	private double interestRate;
//	private double overAmount;
	private Date regDate;
	
	public Account() {
		
	}



}
