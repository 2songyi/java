package com.varxyz.banking.domain;

public class CustomerTest {

	public static void main(String[] args) {
		Customer c1 = new Customer("철수", "123-123", "010-1234-4567", "abcd12", "abcd1234");
		Customer c2 = new Customer("짱구", "123-456", "010-4568-4567", "abcd1234", "abc4567");
		
		// list
		CustomerServiceImp2.getInstance();
		
//		c.addCustomer(c1);
//		c.addCustomer(c2);
//		System.out.println(c.getCustomerBySsn("123-123"));
//		System.out.println(c.getAllCustomer());
//		System.out.println(c.getNumberOfCustomers());
		
		// map
		CustomerServiceImp1 cm = new CustomerServiceImp1();
		cm.addCustomer(c1);
		cm.addCustomer(c2);
		System.out.println(cm.getCustomerBySsn("123-123"));
		System.out.println(cm.getNumberOfCustomers());
		System.out.println(cm.getAllCustomer());
		
		
	}

}
