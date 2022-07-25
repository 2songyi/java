package com.varxyz.jvx330.jdbc.example5;

import static java.sql.Types.*;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.varxyz.jvx330.jdbc.Account;

// @Component("accountDao")
@Repository // mvc에 dao의 경우 repository로 component를 세분화 함.
public class AccountDao {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public AccountDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	// 계좌 생성
	public void addAccount(Account account) {
		String sql = "INSERT INTO Account(accountNum, accType, balance, interestRate, overAmount, customerId) "
				+ "VALUES(?, ?, ?, ?, ?, ?)";
		
		SavingAccount sa = null;
		CheckingAccount ca = null;
		Object[] args = null;
		int[] types = new int[] {CHAR, CHAR, DOUBLE, DOUBLE, DOUBLE, BIGINT};
		
		if (account instanceof SavingAccount) {
			sa = (SavingAccount)account;
			args = new Object[] {
					sa.getAccountNum(), String.valueOf(sa.getAccType()),
					sa.getBalance(), sa.getInterestRate(), 0.0, 
					sa.getCustomer().getCid()
			};
		} else  {
			ca = (CheckingAccount)account;
			args = new Object[] {
					ca.getAccountNum(), String.valueOf(ca.getAccType()),
					ca.getBalance(), 0.0, ca.getOverdraftAmount(),
					ca.getCustomer().getCid()
			};
			
		}
		
		jdbcTemplate.update(sql, args, types);
	
//		jdbcTemplate.update(sql, account.getAccountNum(), account.getBalance(),
//				account.getInterestRate(), account.getOverAmount(), account.getAccType(), account.getCustomerId());
		
	}
	
	// 전체계좌조회
	public List<Account> findAllAccount() {
		String sql = "SELECT aid, customerId, accountNum, accType, balance, interestRate,"
				+ " overAmount, regDate FROM Account";
		
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Account>(Account.class));
	}
	
	// 주민번호로 계좌 찾기
	public List<Account> findAccountBySsn(String ssn) {
		
		String sql = "SELECT a.aid, a.customerId, a.accountNum, a.accType "
				+ " a.balance, a.interestRate, a.overAmount, a.regDate "
				+ " FROM Account a INNER JOIN Customer c "
				+ " ON a.customerId = c.cid "
				+ " WHERE c.ssn = ?";
		
		return jdbcTemplate.query(sql, new CustomerAccountRowMapper(), ssn);
//		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Account>(Account.class), ssn);
	}
	
	// cid로 계좌 찾기
	public List<Account> findAccountByCustomerId(String customerId) {
		
		String sql = "SELECT a.aid, a.customerId, a.accountNum, a.accType "
				+ " a.balance, a.interestRate, a.overAmount, a.regDate "
				+ " FROM Account a INNER JOIN Customer c "
				+ " ON a.customerId = c.cid "
				+ " WHERE c.ssn = ?";
		
		return jdbcTemplate.query(sql, new CustomerAccountRowMapper(), customerId);
	}
	
	


}
 