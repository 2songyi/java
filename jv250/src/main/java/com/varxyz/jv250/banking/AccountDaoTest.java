package com.varxyz.jv250.banking;

import java.util.List;
import java.util.Date;

public class AccountDaoTest {

	public static void main(String[] args) {
		AccountDao dao = new AccountDao();
		
		// findAllAccount Test
//		List<Account> accountList = dao.findAllAccount();
//		for (Account account : accountList) {
//			System.out.println(account.toString());
//		}
		
		// addCustomer Test
		SavingAccount sa = new SavingAccount();
		sa.setAccountNum("123-00-0000");
		sa.setBalance(45000);
		sa.setCustomer(new Customer(1004));
		sa.setInterestRate(0.04);
		sa.setRegDate(new Date());
		sa.setAccountType('S');
		dao.addAccount(sa);
		
		
		for(Account account : dao.findAccountsBySsn("898989-1234567")) {
			System.out.println(account.getCustomer());
		}
		
		
		
	}

}
