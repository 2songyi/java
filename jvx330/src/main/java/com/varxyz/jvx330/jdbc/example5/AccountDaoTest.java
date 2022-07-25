package com.varxyz.jvx330.jdbc.example5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.varxyz.jvx330.jdbc.Account;
import com.varxyz.jvx330.jdbc.Customer;
import com.varxyz.jvx330.jdbc.DataSourceConfig;

public class AccountDaoTest {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DataSourceConfig.class);
	
		AccountDao dao = context.getBean("accountDao", AccountDao.class);
//		addAccount(dao);
		findAllAccount(dao);
//		findAccountBySsn(dao);
	
	}
	
	public static void addAccount(AccountDao dao) {
		SavingAccount sa = new SavingAccount();
		sa.setAccountNum("123-11-1111");
		sa.setBalance(60000);
		sa.setAccType('S');
		sa.setCustomer(new Customer(1002));
		sa.setInterestRate(0.2);
		dao.addAccount(sa);
	
		System.out.println("INSERT COMPLETE!");
	}
	
	public static void findAllAccount(AccountDao dao) {
		System.out.println("[findAllAccount()]");
		dao.findAllAccount().forEach(a -> System.out.println(a));
	}
	
	public static void findAccountBySsn(AccountDao dao) {
		System.out.println("[findAccountBySsn()]");
		System.out.println(dao.findAccountBySsn("111111-1111111"));
	}
	
	
}
