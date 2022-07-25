package com.varxyz.jvx330.jdbc.example1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.varxyz.jvx330.jdbc.Customer;

public class AddCustomerDao {

	private JdbcTemplate jdbcTemplate; // 한번 더 캡슐화

	public AddCustomerDao(DataSource dataSource) { // 템플릿 직접 만드는방법
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// creator 사용하기
	public void addCustomer(Customer customer) {
		String sql = "INSERT INTO Customer (email, passwd, name, ssn, phone) " 
					+ " VALUES (?, ?, ?, ?, ?)";

		jdbcTemplate.update(new PreparedStatementCreator() {
			// connection을 spring에서 대신하니까 pstmt에 사용할 con을 이렇게 불러옴

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(sql);

				pstmt.setString(1, customer.getEmail());
				pstmt.setString(2, customer.getPasswd());
				pstmt.setString(3, customer.getName());
				pstmt.setString(4, customer.getSsn());
				pstmt.setString(5, customer.getPhone());

				return pstmt;
			}
		});
	}
	
	// update
	public void addCustomer2(Customer customer) {
		String sql = "INSERT INTO Customer (email, passwd, name, ssn, phone) " 
					+ " VALUES (?, ?, ?, ?, ?)";

		jdbcTemplate.update(sql, customer.getEmail(), customer.getPasswd(), customer.getName(),
				customer.getSsn(), customer.getPhone());
	}

	// keyHolder
	public long addCustomer3(Customer customer) {
		String sql = "INSERT INTO Customer (email, passwd, name, ssn, phone) " 
				+ " VALUES (?, ?, ?, ?, ?)";
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		PreparedStatementCreator creator = (connection) -> { //람다식
			PreparedStatement pstmt = connection.prepareStatement(sql, new String[] {"cid"});
			
			pstmt.setString(1, customer.getEmail());
			pstmt.setString(2, customer.getPasswd());
			pstmt.setString(3, customer.getName());
			pstmt.setString(4, customer.getSsn());
			pstmt.setString(5, customer.getPhone());
			return pstmt;
		};
		jdbcTemplate.update(creator, keyHolder); //keyHolder에 현재 레코드의 키값을 담아줌
		return keyHolder.getKey().longValue();
		
	}

}
