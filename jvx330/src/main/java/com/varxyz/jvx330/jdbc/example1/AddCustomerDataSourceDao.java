package com.varxyz.jvx330.jdbc.example1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.varxyz.jvx330.jdbc.Customer;
import com.varxyz.jvx330.jdbc.DataSourceConfig;

public class AddCustomerDataSourceDao {
	
	private DataSource dataSource; //platform independent, java.sql로 임포트해도되고 tomcat으로 해도된다.
	
	public AddCustomerDataSourceDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void addCoustomer(Customer customer) {
		String sql = "INSERT INTO Customer2 (email, passwd, name, ssn, phone) VALUES (?, ?, ?, ?, ?)";
		
		try (Connection con = dataSource.getConnection(); //스프링에서 제공되는거 사용
			 PreparedStatement pstmt = con.prepareStatement(sql);){
			
			 pstmt.setString(1, customer.getEmail());
			 pstmt.setString(2, customer.getPasswd());
			 pstmt.setString(3, customer.getName());
			 pstmt.setString(4, customer.getSsn());
			 pstmt.setString(5, customer.getPhone());
			 
			 pstmt.executeUpdate();
			 
			 con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DataSourceConfig.class);
		
		AddCustomerDataSourceDao dao = 
				context.getBean("addCustomerDataSourceDao", AddCustomerDataSourceDao.class);
		
		Customer c = new Customer();
		c.setEmail("song@naver.com");
		c.setPasswd("song");
		c.setName("송");
		c.setSsn("111111-1111111");
		c.setPhone("010-1111-1111");
		System.out.println("INSERT--");
		
		dao.addCoustomer(c);
		context.close();
		
	}

}
