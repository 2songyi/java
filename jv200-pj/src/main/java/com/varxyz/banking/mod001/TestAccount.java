package com.varxyz.banking.mod001;

public class TestAccount {
	public static void main(String[] args) {
		Account a = new Account(3000.0); //default생성자가 아니라서 아무것도 안넣으면 에러남.
		System.out.println(a.getBalance());
		
	}
}
