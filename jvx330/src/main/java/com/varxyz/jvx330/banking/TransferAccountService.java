package com.varxyz.jvx330.banking;

import org.springframework.transaction.annotation.Transactional;

public class TransferAccountService implements BankService{
	/*
	 * 예외처리 해야하는 경우
	 * - 송금하려는 금액이 잔액보다 큰 경우
	 * - 보내는 사람의 계좌와 계좌비밀번호가 일치하지 않는 경우
	 * - 받는사람의 계좌가 존재하지 않는 계좌일 경우
	 * - 송금하는 도중 에러가 나서 중단되는 경우 출금과 입금이 취소되어야 한다.
	 * 	송금, 입금을 하는 중 하나만 실패하더라도 rollback하고 모두 성공한 후 commit되어야 한다.
	 * 	그래서 @Transactional 어노테이션을 사용한다.
	 * 
	 *
	 * */
	@Override
	public boolean transfer(double money, String outAccountNum, String inAccountNum) {
		return false;
	}
}
