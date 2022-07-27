package com.varxyz.banking.Service;


import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.varxyz.banking.dao.CustomerDao;
import com.varxyz.banking.domain.Customer;
import com.varxyz.banking.domain.CustomerCommand;

@Component
public class CustomerService {
	 private CustomerDao customerDao;
	 
	 @Autowired 
	 public CustomerService(DataSource dataSource) { 
		 customerDao = new CustomerDao(dataSource); 
	 }
	
	 // 고객 회원가입
	public void addCustomer(CustomerCommand customer) {
		customerDao.addCustomer(customer);
	}
	
	// 로그인시 유저 체크
	public Customer checkUser(String userId, String passwd) {
		return customerDao.checkUser(userId, passwd);
	}
	
}
