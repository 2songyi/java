package com.varxyz.jv250.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample3 {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/jv250?serverTimezone=Asia/Seoul"; // DB에 접속하기 위해 위치 확인
		String id = "jv250";
		String passwd = "jv250";
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			Class.forName(driver);
			System.out.println("LOADED DRIVER --->" + driver);
			
			con = DriverManager.getConnection(url, id, passwd);
			System.out.println("CONNECTED TO --->" + url);
			
			String sql = "INSERT INTO Customer(name, ssn, phone, customerId, passwd) VALUES(?, ?, ?, ?, ?)";
			stmt = con.prepareStatement(sql); // createStatement보다 많이 사용함(더 빠름)
			stmt.setString(1, "유리");
			stmt.setString(2, "898989-1234567");
			stmt.setString(3, "555-5555-5555");
			stmt.setString(4, "sql");
			stmt.setString(5, "1111");
			stmt.executeUpdate();
			
			System.out.println("INSERTED...");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			// close해줘야 자원누수가 일어나지 않는다. 연 순서 반대로 while에서 에러가 생기면 close를 하지않고 catch문으로 넘어가게 됨 -> final에 넣어야한다.
		}
	}
}
