package com.varxyz.jvx330.jdbc.example5;

import com.varxyz.jvx330.jdbc.Account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SavingAccount extends Account {
	private double interestRate;
	
	public SavingAccount() {
		
	}
	public void withdraw(double amount) {
		
	}
}
