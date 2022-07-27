package com.varxyz.banking.dao;

import java.util.List;
import static java.sql.Types.*;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.varxyz.banking.domain.Account;
import com.varxyz.banking.domain.CheckingAccount;
import com.varxyz.banking.domain.Customer;
import com.varxyz.banking.domain.SavingAccount;

@Repository
public class AccountDao {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public AccountDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// 신규 계좌 신청
	public void addAccount(Account account) {
		String sql = "INSERT INTO Account(accountNum, accType, balance, interestRate, overAmount, customerId) "
				+ "VALUES(?, ?, ?, ?, ?, ?)";
		SavingAccount sa = null;
		CheckingAccount ca = null;
		Object[] args = null;
		int[] types = new int[] { CHAR, CHAR, DOUBLE, DOUBLE, DOUBLE, BIGINT };

		if (account instanceof SavingAccount) {
			sa = (SavingAccount) account;
			
			args = new Object[] { 
					sa.getAccountNum(), String.valueOf(sa.getAccType()), 
					sa.getBalance(), sa.getInterestRate(), 0.0, 
					sa.getCustomer().getCid() 
					};
		} else {
			ca = (CheckingAccount) account;
			args = new Object[] { 
					ca.getAccountNum(), String.valueOf(ca.getAccType()), 
					ca.getBalance(), 0.0, ca.getOverdraftAmount(), 
					ca.getCustomer().getCid() };

		}

		jdbcTemplate.update(sql, args, types);
		
	}

	// 회원id로 자신의 계좌 정보를 확인
	public List<Account> getAccount(String userId) {
		String sql = "SELECT * FROM Account a INNER JOIN Customer c "
				+ " ON a.customerId = c.cid " + " WHERE c.userId = ?";

		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Account>(Account.class), userId);
	}
	
	// 자신의 계좌 잔고를 확인할 수 있다.
	public double getBalance(String accountNum) {
		String sql = "SELECT balance FROM Account WHERE accountNum = ?";
		
		Account account = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Account>(Account.class), accountNum);
		return account.getBalance();
	}
	
	// 출금
	public void withDraw(String accountNum, double money) {
		String sql = "UPDATE Account SET balance = ? WHERE accountNum = ?";
		jdbcTemplate.update(sql, money, accountNum);
	}
	
	//입금
	public void deposit(String accountNum, double money) {
		String sql = "UPDATE Account SET balance = ? WHERE accountNum = ?";
		jdbcTemplate.update(sql, money, accountNum);
	}
	
	// 계좌번호, 비밀번호 일치 확인
	public Account checkPasswdForTransfer(String accountNum, String passwd) {
		
		try {
			String sql = "SELECT * FROM Account a INNER JOIN Customer c " 
					+ " ON (a.customerId = c.cid) WHERE a.accountNum = ? AND c.passwd= ?";
			return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Account>(Account.class), accountNum, passwd);	
			
		} catch (IncorrectResultSizeDataAccessException error) {
			return null;
		}
		
	}
	



}
