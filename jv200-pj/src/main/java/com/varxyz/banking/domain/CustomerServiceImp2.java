package com.varxyz.banking.domain;

import java.util.*;

// List로 구현
public class CustomerServiceImp2 implements CustomersService{
	private static CustomersService service = new CustomerServiceImp2();
	
	private List<Customer> customerList = new ArrayList<Customer>();
	
	// singleton
	private CustomerServiceImp2() {
		super(); // 생략가능
	}
	
	public static CustomersService getInstance() {
		return service;
	}
	
	public void addCustomer(Customer customer) {
		if (getCustomerBySsn(customer.getSsn()) == null) {
			// 등록된 주민번호 있는지 확인 후 없으면 고객정보등록
			customerList.add(customer);
		}
	}
	
	// 주민번호로 고객 검색
	public Customer getCustomerBySsn(String ssn) {
		for (Customer c : customerList) {
			if (ssn.equals(c.getSsn())) {
				return c;
			}
		}
		return null;
	}
	
	// 전체 고객 리스트
	public Collection<Customer> getAllCustomer() {
		return customerList;
	}
	
	// 등록된 고객의 수 
	public int getNumberOfCustomers() {
		return customerList.size();
	}

}
