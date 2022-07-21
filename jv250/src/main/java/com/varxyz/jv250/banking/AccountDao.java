package com.varxyz.jv250.banking;

import java.util.*;
import java.sql.*;

public class AccountDao {
	protected static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	protected static final String JDBC_URL = "jdbc:mysql://localhost:3306/jv250?serverTimezone=Asia/Seoul"; // DB에 접속하기 위해
	protected static final String JDBC_ID = "jv250";
	protected static final String JDBC_PASSWD = "jv250";
	
	public AccountDao() {
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("LOADED DRIVER --->" + JDBC_DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Account> findAllAccount() {
		String sql = "SELECT * FROM Account";
		List<Account> accountList = new ArrayList<Account>();
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = DriverManager.getConnection(JDBC_URL, JDBC_ID, JDBC_PASSWD);
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					SavingAccount a = new SavingAccount();
					a.setAccountNum(rs.getString("accountNum"));
					a.setBalance(rs.getDouble("balance"));
					a.setInterestRate(rs.getDouble("interestRate"));
				}
				
			} finally {
				rs.close();
				pstmt.close();
				con.close();
			}
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return accountList;
	}
	
	/**
	 * 전달된 주민번호를 가진 특정 고객의 계좌 목록 조회
	 * @param ssn	주민번호
	 */
	public List<Account> findAccountsBySsn(String ssn) {
//		String sql = "SELECT * FROM Account, Customer WHERE Account.customerId = Customer.cid AND Customer.ssn = ?";
//		inner join
		String sql = "SELECT a.aid, a.accountNum, a.balance, a.interestRate, "
					+ "a.overdraft, a.accountType, c.name, c.ssn, c.phone, a.regDate"
					+ " FROM Account a INNER JOIN Customer c ON a.customerId = c.cid WHERE c.ssn = ?";
		List<Account> list = new ArrayList<Account>();
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = DriverManager.getConnection(JDBC_URL, JDBC_ID, JDBC_PASSWD);
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, ssn);
				rs = pstmt.executeQuery();
				
				// DB에서 값을 가져와서 객체에 넣기 (add와 반대)
				Account account = null;
				while (rs.next()) {
					if (rs.getString("accountType").charAt(0) == 'S') {
						account = new SavingAccount();
						((SavingAccount)account).setInterestRate(rs.getDouble("interestRate"));
					} else {
						account = new CheckingAccount();
						((CheckingAccount)account).setOverdraftAmount(rs.getDouble("overdraftAmount"));
					}
					account.setAid(rs.getLong("aid"));
					account.setAccountNum(rs.getString("accountNum"));
					account.setBalance(rs.getDouble("balance"));
					account.setCustomer(new Customer(rs.getString("name"),
							rs.getString("ssn"), rs.getString("phone")));
					account.setRegDate(rs.getTimestamp("regdate"));
					list.add(account);
				}	
			} finally {
//				rs.close();
				pstmt.close();
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
}
	
	public void addAccount(Account account) {
		String sql = "INSERT INTO Account(accountNum, balance, interestRate, overdraft, accountType, customerId) "
						+ "VALUES(?, ?, ?, ?, ?, ?)";
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = DriverManager.getConnection(JDBC_URL, JDBC_ID, JDBC_PASSWD);
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, account.getAccountNum());
				pstmt.setDouble(2, account.getBalance());
				// 객체를 가져와서 DB에 넣기
				if (account instanceof SavingAccount) {
					SavingAccount sa = (SavingAccount)account;
					pstmt.setDouble(3, sa.getInterestRate());
					pstmt.setDouble(4, 0.0);
					pstmt.setString(5, String.valueOf('S')); // Account안에 type이 없어서(있으면 get쓰면됨)
				} else {
					CheckingAccount ca = (CheckingAccount)account;
					pstmt.setDouble(3, 0.0);
					pstmt.setDouble(4, ca.getOverdraftAmount());
					pstmt.setString(5, String.valueOf('C'));
				}
				pstmt.setLong(6, account.getCustomer().getCid());
				pstmt.executeUpdate();
			} finally {
				pstmt.close();
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
