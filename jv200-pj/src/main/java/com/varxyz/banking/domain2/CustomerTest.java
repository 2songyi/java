package com.varxyz.banking.domain2;

public class CustomerTest {

	public static void main(String[] args) {
		// name, ssn, phone, customerId, passwd
		Customer c1 = new Customer("철수", "123-123", "010-1234-4567", "abcd12", "abcd1234");
		Customer c2 = new Customer("짱구", "123-124", "010-1234-6511", "abcd34", "abcd1235");
		Customer c3 = new Customer("맹구", "123-125", "010-1234-9874", "abcd56", "abcd1236");
		
		CustomerService c = new CustomerService();
		
		c.addCustomer(c1);
		c.addCustomer(c2);
		c.addCustomer(c3);
		
		c.getCustomerBySsn("123-123");
		
		System.out.println(c.getNumOfCustomers());
		
		
	}

}
