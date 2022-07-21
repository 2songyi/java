package com.varxyz.banking.domain;

import java.util.*;

// Map으로 구현
public class CustomerServiceImp1 implements CustomersService{
	private Map<String, Customer> map = new HashMap<String, Customer>();
	
	public void addCustomer(Customer customer) {
		// 입력하려는 주민번호가 map에 없다면
		if (!map.containsKey(customer.getSsn())) {
			// 주민번호를 key값으로 사용
			map.put(customer.getSsn(), customer);
		}
	}

	public Customer getCustomerBySsn(String ssn) {
		if (map.containsKey(ssn)) {
			return map.get(ssn);
		}
		return null;
	}

	public Collection<Customer> getAllCustomer() {
		return map.values();
	}

	public int getNumberOfCustomers() {
		return map.size();
	}

}
