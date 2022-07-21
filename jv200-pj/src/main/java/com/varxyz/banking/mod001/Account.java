package com.varxyz.banking.mod001;

/**
 * 계좌정보를 캡슐화
 * @author Administrator
 *
 */
public class Account {
	double balance;
	
	public Account(double initBalance) {
		balance = initBalance; //잔고
	}
	
	/**
	 * 현재의 잔고를 리턴한다
	 * @return 현재 잔고
	 */
	public double getBalance() {
		//void는 리턴값이 없어도 되는데 double은 리턴값 필요 소수점이라는 리턴타입을 반환
		return balance;
	}
	
	/**
	 * 전달된 amt를 현재잔고에 적립한다.
	 * @param amt 입금액
	 */
	public void deposite(double amt) {
		
	}
	
	public void withdraw(double amt) {
		//잔고가 부족할 때
	}

}
