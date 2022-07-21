package com.varxyz.banking.domain;

public class OverdraftException extends RuntimeException {
	/* 이 예외가 발생해도 프로그램을 구동하는데 문제가 없다.
	 * 즉 컴파일 시 생기는 문제가 아닌, 실행할 때 발생하는 문제이기 때문에 RuntimeException을 상속받아
	 * uncheckedExcpetion으로 처리한다.*/
	
	public OverdraftException(String msg) {
		super(msg);
	}
	
}
