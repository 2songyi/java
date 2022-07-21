package com.varxyz.jv250.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/jv250?serverTimezone=Asia/Seoul"; // DB에 접속하기 위해 위치 확인
		String id = "jv250";
		String passwd = "jv250";

		Connection con = null; // Connection 특정 DB서버연결
		Statement stmt = null; // 실행 요청
		ResultSet rs = null; // 조회된 결과(행열데이터) 저장 - DQL작업
		
		try {
			try {
				Class.forName(driver);
				System.out.println("LOADED DRIVER --->" + driver);

				con = DriverManager.getConnection(url, id, passwd);
				System.out.println("CONNECTED TO --->" + url);

				String sql = "SELECT * FROM Customer";
				stmt = con.createStatement();
				rs = stmt.executeQuery(sql); // 조회요청, 조회된 결과를 리턴

				while (rs.next()) { // next하는동안은 데이터가 있다
					long cid = rs.getLong("cid");
					String customerId = rs.getString("customerId");
					String name = rs.getString("name");
					String phone = rs.getString("phone");
					System.out.println(cid);
					System.out.println(customerId);
					System.out.println(name);
					System.out.println(phone);
					System.out.println("----------");
				}
			} finally {
				rs.close();
				stmt.close();
				con.close();
				// close해줘야 자원누수가 일어나지 않는다. 연 순서 반대로 while에서 에러가 생기면 close를 하지않고 catch문으로 넘어가게 됨
				// -> final에 넣어야한다.
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
