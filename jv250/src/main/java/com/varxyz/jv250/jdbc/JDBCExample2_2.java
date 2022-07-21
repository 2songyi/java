package com.varxyz.jv250.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample2_2 {
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
			
			String sql = "INSERT INTO Account(accountNum, balance, interestRate, overdraft, accountType, customerId) VALUES(?, ?, ?, ?, ?, ?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, "888-88-8888");
			stmt.setDouble(2, 50000);
			stmt.setDouble(3, 0);
			stmt.setDouble(4, 2.0);
			stmt.setString(5, "C");
			stmt.setLong(6, 1001);
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
