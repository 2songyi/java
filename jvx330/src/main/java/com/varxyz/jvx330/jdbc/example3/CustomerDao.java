package com.varxyz.jvx330.jdbc.example3;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.varxyz.jvx330.jdbc.Customer;
import com.varxyz.jvx330.jdbc.example2.CustomerMapRow;

public class CustomerDao {
	private JdbcTemplate jdbcTemplate;
	
	public CustomerDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Customer> findAllCustomers() {
		String sql = "SELECT cid, email, passwd, name, ssn, phone, regDate FROM Customer2";
		
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Customer>(Customer.class));
	}
	
	// 가입날짜로 고객 찾기
	public List<Customer> findCustomerByRegDate(Date regDate) {
		String sql = "SELECT cid, email, passwd, name, ssn, phone, regDate "
				+ " FROM Customer2 WHERE DATE(regDate)=?"; // date함수쓰면 날짜만 남음
		
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Customer>(Customer.class), regDate);
		
	}
	
	// 이메일로 고객 찾기
	public Customer findCustomerByEmail(String email) {
		String sql = "SELECT cid, email, passwd, name, ssn, phone, regDate "
				+ " FROM Customer2 WHERE email=?";
		
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Customer>(Customer.class), email);
	}
	
	// 고객 카운트 (숫자는 기본적으로 long)
	public long countCustomers() {
		String sql = "SELECT count(*) FROM Customer2";
		
		return jdbcTemplate.queryForObject(sql, Long.class);
	
	}
	
	// 주민번호로 고객 찾기
	public Customer findCustomerBySsn(String ssn) {
		String sql = "SELECT cid, email, passwd, name, ssn, phone, regDate "
				+ " FROM Customer2 WHERE ssn=?";
		
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Customer>(Customer.class), ssn);
	}

}
