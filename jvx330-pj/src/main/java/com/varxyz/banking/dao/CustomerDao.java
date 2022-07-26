package com.varxyz.banking.dao;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.varxyz.banking.domain.CustomerCommand;

@Repository
public class CustomerDao {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public CustomerDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	// 온라인 뱅킹을 위한 가입을 수행
	public void addCustomer(CustomerCommand customer) {
		// 회원id, 비밀번호, 이름, 주민번호, 전화번호 -> 출력정보 가입여부 확인
		String sql = "INSERT INTO Customer(userId, passwd, name, ssn, phone) VALUES(?, ?, ?, ?, ?)";
		
		jdbcTemplate.update(sql, customer.getUserId(), customer.getPasswd(), customer.getName(),
				customer.getSsn(), customer.getPhone());
	}
}
