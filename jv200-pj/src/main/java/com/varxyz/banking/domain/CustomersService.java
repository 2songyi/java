package com.varxyz.banking.domain;

import java.util.*;

public interface CustomersService {
	void addCustomer(Customer customer);
	Customer getCustomerBySsn(String checkssn);
	Collection<Customer> getAllCustomer();
	int getNumberOfCustomers();
	
}
