package com.varxyz.banking.dao;

import java.util.List;
import static java.sql.Types.*;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.varxyz.banking.domain.Account;
import com.varxyz.banking.domain.CheckingAccount;
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
			args = new Object[] { sa.getAccountNum(), String.valueOf(sa.getAccType()), sa.getBalance(),
					sa.getInterestRate(), 0.0, sa.getCustomer().getCid() };
		} else {
			ca = (CheckingAccount) account;
			args = new Object[] { ca.getAccountNum(), String.valueOf(ca.getAccType()), ca.getBalance(), 0.0,
					ca.getOverdraftAmount(), ca.getCustomer().getCid() };

		}

		jdbcTemplate.update(sql, args, types);

	}

	// 회원id로 자신의 계좌 정보를 확인
	public List<Account> getAccount(String customerId) {
		String sql = "SELECT a.aid, a.customerId, a.accountNum, a.accType "
				+ " a.balance, a.interestRate, a.overAmount, a.regDate " + " FROM Account a INNER JOIN Customer c "
				+ " ON a.customerId = c.cid " + " WHERE c.ssn = ?";

		return jdbcTemplate.query(sql, new CustomerAccountRowMapper(), customerId);
	}
	
	// 자신의 계좌 잔고를 확인할 수 있다.
	public double getBalacne(String accountNum) {
		String sql = "SELECT balance FROM Account WHERE accountNum = ?";
		
		Account account = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Account>(Account.class), accountNum);
		return account.getBalance();
	}



}
