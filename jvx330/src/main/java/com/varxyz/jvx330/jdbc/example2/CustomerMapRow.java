package com.varxyz.jvx330.jdbc.example2;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.varxyz.jvx330.jdbc.Customer;

public class CustomerMapRow implements RowMapper<Customer> {
	
	// 어나니머스 -> 이렇게 implements한 클래스를 하나 만들고 이거를 new CustomerMapRow() 해서 사용
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer c = new Customer(rs.getLong("cid"), 
				rs.getString("email"), rs.getString("passwd"), 
				rs.getString("name"), rs.getString("ssn"), 
				rs.getString("phone"), rs.getTimestamp("regDate"));
		
		return c;
	}

}
