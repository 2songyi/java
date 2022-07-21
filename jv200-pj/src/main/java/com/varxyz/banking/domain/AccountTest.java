package com.varxyz.banking.domain;

public class AccountTest {

	public static void main(String[] args) {
		
		CheckingAccount c = new CheckingAccount("123", 1000);
		c.withdraw(200);
		
		SavingAccount s = new SavingAccount("120", 1000);
		s.withdraw(200);
	}

}
