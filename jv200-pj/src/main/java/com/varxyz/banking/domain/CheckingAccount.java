package com.varxyz.banking.domain;

public class CheckingAccount extends Account {
	private static final double DEFAULT_OVERDRAFT = 1000;
	private double overdraftAmount;
	
	// super()를 이용해 부모클래스에서 선언한 생성자를 호출한다.
	public CheckingAccount(String accountNum, double balance) {
//		super(accountNum, balance);
//		this.overdraftAmount = overdraftAmount;
		this(accountNum, balance, DEFAULT_OVERDRAFT);
	}
	
	public CheckingAccount(String accountNum, double balance, double overdraftAmount) {
		super(accountNum, balance);
		this.overdraftAmount = overdraftAmount;
	}

	@Override
	public void withdraw(double amount) {
		if (balance + overdraftAmount < amount) {
			// 현재 출금 가능 금액
			double sumBalance = balance + overdraftAmount;

			// 한도초과로 예외 발생
			throw new OverdraftException("한도초과입니다. 현재 출금 가능한 잔액은" + sumBalance + "원 입니다.");
		} else {
			super.balance -= amount;
			System.out.println(amount + "원 출금하셨습니다. 현재 잔액은 " + super.balance + "입니다.");
		}
	}
}
