package com.varxyz.jvx330.jdbc.example1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.varxyz.jvx330.jdbc.Customer;
import com.varxyz.jvx330.jdbc.DataSourceConfig;

public class AddCustomerDaoTest {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DataSourceConfig.class);
		
		AddCustomerDao dao = context.getBean("addCustomerDao", AddCustomerDao.class);
//		addCustomer(dao);
//		addCustomer2(dao);
		addCustomer3(dao);
		
		context.close();
		
	}
	
	public static void addCustomer(AddCustomerDao dao) {
		Customer c = new Customer();
		c.setEmail("song2@naver.com");
		c.setPasswd("song2");
		c.setName("송2");
		c.setSsn("222222-2222222");
		c.setPhone("010-2222-2222");
		
		dao.addCustomer(c);
		System.out.println("INSERT!");
	}
	
	public static void addCustomer2(AddCustomerDao dao) {
		Customer c = new Customer();
		c.setEmail("song3@naver.com");
		c.setPasswd("song3");
		c.setName("송3");
		c.setSsn("333333-3333333");
		c.setPhone("010-3333-3333");
		
		dao.addCustomer2(c);
		System.out.println("INSERT!");
	}
	
	
	public static void addCustomer3(AddCustomerDao dao) {
		Customer c = new Customer();
		c.setEmail("song5@naver.com");
		c.setPasswd("song5");
		c.setName("송5");
		c.setSsn("555555-5555555");
		c.setPhone("010-5555-5555");
		
		long key = dao.addCustomer3(c); // 키값을 반환해줌(여기서는 cid가 프라이머리키)
		System.out.println("key" + key);
	}
	
}	
