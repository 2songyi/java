package com.varxyz.jv251.dao;

import java.util.*;

import com.varxyz.jv251.domain.Account;
import com.varxyz.jv251.domain.CheckingAccount;
import com.varxyz.jv251.domain.Customer;
import com.varxyz.jv251.domain.SavingAccount;

import java.sql.*;

public class AccountDao {

//	public List<Account> findAllAccount() {
//		String sql = "SELECT * FROM Account";
//		List<Account> accountList = new ArrayList<Account>();
//		try {
//			Connection con = null;
//			PreparedStatement pstmt = null;
//			ResultSet rs = null;
//			try {
//				con = DataSourceManager.getConnection();
//				pstmt = con.prepareStatement(sql);
//				rs = pstmt.executeQuery();
//				
//				while (rs.next()) {
//					SavingAccount a = new SavingAccount();
//					a.setAccountNum(rs.getString("accountNum"));
//					a.setBalance(rs.getDouble("balance"));
//					a.setInterestRate(rs.getDouble("interestRate"));
//				}
//			} finally {
//				DataSourceManager.close(rs, pstmt, con);
//			}
//			System.out.println();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return accountList;
//	}

	/**
	 * 전달된 주민번호를 가진 특정 고객의 계좌 목록 조회
	 * 
	 * @param ssn 주민번호
	 */
	
	public List<Account> findAccountsBySsn(String ssn) {
		String sql = "SELECT a.aid, a.accountNum, a.balance, a.interestRate, a.overdraft, a.accountType, c.name, c.ssn, c.phone, a.regDate"
				+ " FROM Account a INNER JOIN Customer c ON a.customerId = c.cid WHERE c.ssn = ?";

		List<Account> accountList = new ArrayList<Account>();

		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = DataSourceManager.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, ssn);
				rs = pstmt.executeQuery();

				// DB에서 값을 가져와서 객체에 넣기 (add와 반대)
				Account account = null;

				while (rs.next()) {
					if (rs.getString("accountType").charAt(0) == 'S') {
						account = new SavingAccount();
						((SavingAccount) account).setInterestRate(rs.getDouble("interestRate"));
					} else {
						account = new CheckingAccount();
						((CheckingAccount) account).setOverdraftAmount(rs.getDouble("overdraftAmount"));
					}
					account.setAid(rs.getLong("aid"));
					account.setAccountNum(rs.getString("accountNum"));
					account.setBalance(rs.getDouble("balance"));
					account.setCustomer(new Customer(rs.getString("name"), rs.getString("ssn"), rs.getString("phone")));
					account.setRegDate(rs.getTimestamp("regdate"));
					accountList.add(account);
				}
			} finally {
				DataSourceManager.close(rs, pstmt, con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return accountList;
	}

	public void addAccount(Account account) {
		String sql = "INSERT INTO Account(accountNum, balance, interestRate, overdraft, accountType, customerId) "
				+ "VALUES(?, ?, ?, ?, ?, ?)";
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = DataSourceManager.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, account.getAccountNum());
				pstmt.setDouble(2, account.getBalance());
				// 객체를 가져와서 DB에 넣기
				if (account instanceof SavingAccount) {
					SavingAccount sa = (SavingAccount) account;
					pstmt.setDouble(3, sa.getInterestRate());
					pstmt.setDouble(4, 0.0);
					pstmt.setString(5, String.valueOf('S')); // Account안에 type이 없어서(있으면 get쓰면됨)
				} else {
					CheckingAccount ca = (CheckingAccount) account;
					pstmt.setDouble(3, 0.0);
					pstmt.setDouble(4, ca.getOverdraftAmount());
					pstmt.setString(5, String.valueOf('C'));
				}
				pstmt.setLong(6, account.getCustomer().getCid());
				pstmt.executeUpdate();
			} finally {
				DataSourceManager.close(pstmt, con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 추가 
	public Account findAccountsByNum(String accountNum) {
		String sql = "SELECT a.aid, a.accountNum, a.balance, a.interestRate, a.overdraft, a.accountType, c.name, c.ssn, c.phone, a.regDate"
				+ " FROM Account a INNER JOIN Customer c ON a.customerId = c.cid WHERE a.accountNum = ?";

		Account account = null;

		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = DataSourceManager.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, accountNum);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					if (rs.getString("accountType").charAt(0) == 'S') {
						account = new SavingAccount();
						((SavingAccount) account).setInterestRate(rs.getDouble("interestRate"));
					} else {
						account = new CheckingAccount();
						((CheckingAccount) account).setOverdraftAmount(rs.getDouble("overdraftAmount"));
					}
					account.setAid(rs.getLong("aid"));
					account.setAccountNum(rs.getString("accountNum"));
					account.setBalance(rs.getDouble("balance"));
					account.setCustomer(new Customer(rs.getString("name"), rs.getString("ssn"), rs.getString("phone")));
					account.setRegDate(rs.getTimestamp("regdate"));
				}
			} finally {
				DataSourceManager.close(rs, pstmt, con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return account;
	}
	
	public Account updateAccount(String accountNum, Account account) {
		String sql = "UPDATE Account SET balance = ? WHERE accountNum = ?";
		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = DataSourceManager.getConnection();
				pstmt = con.prepareStatement(sql);
//				pstmt.setString(1,  );
				pstmt.setString(2, accountNum);
			} finally {
				DataSourceManager.close(pstmt, con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	


}
