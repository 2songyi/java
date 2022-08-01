package com.varxyz.jvx330.banking;

public interface BankService {
	
	/*
	 * 회원가입
	 * 가입폼에서 회원 정보를 입력받아 customer테이블에 정보를 insert한다.
	 */
	default boolean addCustomer(String userId, String passwd, String userName, String ssn, String phone) {
		return false;
	}
	
	/*
	 * 신규 계좌 개설
	 * checking, saving 계좌로 타입을 나누어 계좌를 개설할 수 있다.
	 */
	default Account addAccount(String accType, String userId) {
		return null;
	}
	
	/*
	 * 회원 아이디로 계좌목록 확인
	 * 회원 아이디를 입력받고 해당하는 계좌를 리턴받는다. 한 회원당 여러개의 계좌를 가질 수 있기때문에 List형태로 리턴받는다.
	 */
	default List<Account> getAccount(String userId) {
		return null;
	}
	
	/*
	 * 계좌 이체
	 * 이체할 금액, 출금 계좌번호(out), 입금 계좌번호(in)를 입력받는다.
	 * getBalance로 얻은 (계좌의 잔액 - 이체 금액) 을 출금계좌의 잔액으로 업데이트한다.
	 * (계좌의 잔액 + 이체 금액) 을 입금 계좌의 잔액으로 업데이트 한다.  
	 */
	default boolean transfer(double money, String outAccountNum, String inAccountNum) {
		return false;
	}
	
	/*
	 * 매월 말일 이자 지급
	 * 이 메서드를 사용할 때 현재 날짜가 해당 월의 말일인지 확인한 후 말일이 맞다면 이자를 지급한다. 
	 */
	default String saveInterest(double interestRate, String accountNum){
		return null;
	}
	
	/*
	 * 계좌 잔액 조회
	 * 계좌번호로 현재 계좌의 잔액을 확인할 수 있다.
	 */
	default double getBalance(String accountNum) {
		return false;
	}
}
