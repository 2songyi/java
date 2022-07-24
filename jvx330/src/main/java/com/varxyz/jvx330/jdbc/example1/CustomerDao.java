package com.varxyz.jvx330.jdbc.example1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.varxyz.jvx330.jdbc.Customer;

public class CustomerDao {
	private JdbcTemplate jdbcTemplate;
	
	public CustomerDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Customer> findAllCustomers() {
		String sql = "SELECT cid, email, passwd, name, ssn, phone, regDate FROM Customer2";
		
		return jdbcTemplate.query(sql, new RowMapper<Customer>() {//<>안에 매핑해야할거 넣음
			/* 쿼리의 반환형은 데이터형만 가능하다
			 * 하지만 sql문의 결과를 객체로 받을때는 RowMapper인터페이스를 사용한다.
			 * RowMapper는 원하는 형태의 결과값을 반환할 수 있다.
			 * 원래는 resultSet으로 값을 받고 객체에 담아서 반환했어서 이런일이 없었음.
			 * 
			 * 이 안에 mapRow라는 메서드를 사용 ResultSet에 값을 담아서 rowNuM만큼 반복한다.(알아서함)
			 * 
			 * */
			 */
			
			@Override
			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Customer c = new Customer(rs.getLong("cid"), 
						rs.getString("email"), rs.getString("passwd"), 
						rs.getString("name"), rs.getString("ssn"), 
						rs.getString("phone"), rs.getTimestamp("regDate"));
				
				return c;
			}
		});
	}
	
	// 가입날짜로 고객 찾기
	public List<Customer> findCustomerByRegDate(Date regDate) {
		String sql = "SELECT cid, email, passwd, name, ssn, phone, regDate "
				+ " FROM Customer2 WHERE DATE(regDate)=?"; // date함수쓰면 날짜만 남음
		
		return jdbcTemplate.query(sql, new RowMapper<Customer>() {
			
			@Override
			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Customer c = new Customer(rs.getLong("cid"), 
						rs.getString("email"), rs.getString("passwd"), 
						rs.getString("name"), rs.getString("ssn"), 
						rs.getString("phone"), rs.getTimestamp("regDate"));
				
				return c;
			}
			
		}, regDate); // 마지막에 조건 -> regDate
		
	}
	
	// 이메일로 고객 찾기
	public Customer findCustomerByEmail(String email) {
		String sql = "SELECT cid, email, passwd, name, ssn, phone, regDate "
				+ " FROM Customer2 WHERE email=?";
		
		return jdbcTemplate.queryForObject(sql, new RowMapper<Customer>() {
			// query는 list가 반환. quertForObject는 하나만 반환
			
			@Override
			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Customer c = new Customer(rs.getLong("cid"), 
						rs.getString("email"), rs.getString("passwd"), 
						rs.getString("name"), rs.getString("ssn"), 
						rs.getString("phone"), rs.getTimestamp("regDate"));
				
				return c;
			}
			
		}, email);
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
		
		return jdbcTemplate.queryForObject(sql, new RowMapper<Customer>() {
			
			@Override
			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Customer c = new Customer(rs.getLong("cid"), 
						rs.getString("email"), rs.getString("passwd"), 
						rs.getString("name"), rs.getString("ssn"), 
						rs.getString("phone"), rs.getTimestamp("regDate"));
				
				return c;
			}
			
		}, ssn);
	}

}
