package com.varxyz.banking.Service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.varxyz.banking.dao.AccountDao;
import com.varxyz.banking.domain.Account;

@Component
public class AccountService {
	private AccountDao accountDao;
	
	@Autowired
	public AccountService(DataSource dataSource) {
		accountDao = new AccountDao(dataSource);
	}
	
	// 계좌 생성
	public void addAccount(Account account) {
		accountDao.addAccount(account);
	}
	
	// 계좌목록 조회
	public List<Account> getAccount(String userId) {
		return accountDao.getAccount(userId);
	}
	
	// 계좌 잔액 확인
	public double getBalance(String accountNum) {
		return accountDao.getBalance(accountNum);
	}
	
	
	// 계좌 이체
	public void transfer(String outAccountNum, String inAccountNum, double money) {
		double balance1 = getBalance(outAccountNum) - money; //출금계좌용
		double balance2 = getBalance(inAccountNum) + money; //입금계좌용
		
		withDraw(outAccountNum, balance1);
		deposit(inAccountNum, balance2);
		
		// outAccountNum계좌에서 money만큼 출금 withdraw
		// inAccountNum 계좌에 money만큼 입금 deposit
	}
	
	// 출금
	public void withDraw(String accountNum, double money) {
		accountDao.withDraw(accountNum, money);
	}
	
	// 입금
	public void deposit(String accountNum, double money) {
		accountDao.deposit(accountNum, money);
	}
	
	// 계좌이체 시 비밀번호 확인
	public Account checkPasswdForTransfer(String accountNum, String passwd) {
		// accountNum, passwd는 다른테이블에 있으니 조인이 필요할 듯
		return accountDao.checkPasswdForTransfer(accountNum, passwd);
	}
	
	// 이자 입금
	// saveInterest(이자율, 계좌번호) -> 지급여부 확인
	public void saveInterest(double interestRate, String accountNum) {
		// 매월 말일 계산 -> 현재날짜가 말일이 아니면 error
		LocalDate today = LocalDate.now();
		int year = Integer.parseInt(String.valueOf(today.getYear()));
		int month = Integer.parseInt(String.format("%02d", today.getMonthValue()));
		
		String lastDay = String.valueOf(getLastDay(year, month));
		
		
		
		// 말일이 맞다면 해당계좌에 이자 입금
		double saveInterest = getBalance(accountNum) * interestRate;
		deposit(accountNum, saveInterest);
		
	}
	
	// 말일 구하기
	public int getLastDay(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, 1);
		int lastDay = cal.getActualMaximum(Calendar.DATE);
		return lastDay;
	}
	
	
}
