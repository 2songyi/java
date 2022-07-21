package com.varxyz.jv250.banking;

import java.util.*;

public class CustomerDaoTest {

	public static void main(String[] args) {
		CustomerDao dao = new CustomerDao();
		
		// findAllCustomers() Test
		List<Customer> customerList = dao.findAllCustomers();
		for ( Customer customer : customerList) {
			System.out.println(customer.toString());
		}
		System.out.println("---------------");
		
		// findCustomerBySsn Test
		Customer customerBySsn = dao.findCustomerBySsn("960810-1234567"); 
		System.out.println(customerBySsn);
		System.out.println("================");
		
		// addCustomer Test
		Customer c = new Customer();
		c.setName("훈이");
		c.setSsn("999998-9999998");
		c.setPhone("010-9999-9999");
		c.setCustomerId("jdbchh");
		c.setPasswd("pwjdbchh");
		dao.addCustomer(c);
		
//		System.out.println(customerList);
		
		
	}

}
