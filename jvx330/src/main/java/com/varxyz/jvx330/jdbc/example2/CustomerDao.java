package com.varxyz.jvx330.jdbc.example2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.varxyz.jvx330.jdbc.Customer;
import com.varxyz.jvx330.jdbc.example2.CustomerMapRow;

public class CustomerDao {
	private JdbcTemplate jdbcTemplate;
	
	public CustomerDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	// CustomerMapRow 클래스 하나 만들어서 어나니머스 
	
	public List<Customer> findAllCustomers() {
		String sql = "SELECT cid, email, passwd, name, ssn, phone, regDate FROM Customer";
		
		return jdbcTemplate.query(sql, new CustomerMapRow());
	}
	
	// 가입날짜로 고객 찾기
	public List<Customer> findCustomerByRegDate(Date regDate) {
		String sql = "SELECT cid, email, passwd, name, ssn, phone, regDate "
				+ " FROM Customer WHERE DATE(regDate)=?"; // date함수쓰면 날짜만 남음
		
		return jdbcTemplate.query(sql, new CustomerMapRow(), regDate); // 마지막에 조건 -> regDate
		
	}
	
	// 이메일로 고객 찾기
	public Customer findCustomerByEmail(String email) {
		String sql = "SELECT cid, email, passwd, name, ssn, phone, regDate "
				+ " FROM Customer WHERE email=?";
		
		return jdbcTemplate.queryForObject(sql, new CustomerMapRow(), email);
	}
	
	// 고객 카운트 (숫자는 기본적으로 long)
	public long countCustomers() {
		String sql = "SELECT count(*) FROM Customer";
		
		return jdbcTemplate.queryForObject(sql, Long.class);
	
	}
	
	// 주민번호로 고객 찾기
	public Customer findCustomerBySsn(String ssn) {
		String sql = "SELECT cid, email, passwd, name, ssn, phone, regDate "
				+ " FROM Customer WHERE ssn=?";
		
		return jdbcTemplate.queryForObject(sql, new CustomerMapRow(), ssn);
	}

}
