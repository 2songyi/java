package com.varxyz.banking.domain2;

import java.util.*;
/* 고객의 정보를 보관할 수 있는 속성을 유지해야 한다.
 * 고객의 정보를 유지할 수 있는 속성을 정의하라*/

// customer에 대한 서비스를 처리하는 클래스
public class CustomerService {
	
	List<Customer> customerList = new ArrayList<Customer>();
	
	// 신규 고객 추가
	public String addCustomer(Customer customer){ 
		customerList.add(customer);
		return "신규고객 : " + customer.name;
	}
	
	// 주민번호로 고객 조회
	public String getCustomerBySsn(String checkssn){
		for (Customer c : customerList ) {
			if (c.ssn == checkssn) {
				System.out.println(c.name);
			}
		}
		return checkssn;
	}
	
	// 전체 고객 목록
	public void getAllCustomer() {
		for (Customer s : customerList) {
			System.out.println(s.name);
		}
//		return
	}
	
	// 전체 고객 수
	public int getNumOfCustomers() {
		return customerList.size();
	}
}
