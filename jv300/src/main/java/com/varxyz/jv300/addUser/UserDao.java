package com.varxyz.jv300.addUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
	/* 유스케이스 목록
	 회원가입 (페이지jsp 
	 회원목록 보기 (회원가입처럼 폼 페이지 -> 컨트롤러 / 바로 결과페이지 : url쳐서 get하지않고 메뉴만들어서 메뉴만들어서 include/ 
	 회원정보수정 -> 본인정보가 폼에 채워져서 나옴(jsp바로 부를 수 없음) input에 value에 정보를 넣으면 됨 -> 동적으로 바뀌어야함 EL (request.setAttribute(user)를 저장해야함 -> user.id, user.name으로 불러옴)
	 table 이름 user말고 다른걸로 수정해서 사용
	*/
	// getInstance부르고
	NamingService namingService = NamingService.getInstance();
	DataSource ds = (DataSource) namingService.getAttribute("dataSource");
	
	// user 정보 저장
	public void addUser(User user) {
		// add_user.jsp 에서 가져온 값을 가져와서 db에 저장
		String sql = "INSERT INTO MyUser(userId, passwd, userName, ssn, email, addr) "
				+ "VALUES(?, ?, ?, ?, ?, ?)";
		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, user.getUserId());
				pstmt.setString(2, user.getPasswd());
				pstmt.setString(3, user.getUserName());
				pstmt.setString(4, user.getSsn());
				pstmt.setString(5, user.getEmail());
				pstmt.setString(6, user.getAddr());
				pstmt.executeUpdate();
				
				System.out.println(user.getAddr());
				System.out.println("INSERTED...");
			} finally {
				ds.close(pstmt, con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// user 목록 리스트
	public List<User> findAllUser() {
		String sql = "SELECT * FROM MyUser";
		List<User> userList = new ArrayList<User>();
		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					User u = new User();
					u.setUserId(rs.getString("userId"));
					u.setPasswd(rs.getString("passwd"));
					u.setUserName(rs.getString("userName"));
					u.setSsn(rs.getString("ssn"));
					u.setEmail(rs.getString("email"));
					u.setAddr(rs.getString("addr"));
					userList.add(u);
				}
			} finally {
				ds.close(rs, pstmt, con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return userList;
	}
	
	// 회원아이디로 회원 찾기
	public User findUser(String userId) {
		String sql = "SELECT * FROM MyUser WHERE userId=?";
		User user = null;
		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, userId);
				rs = pstmt.executeQuery();
				
				if (rs.next()) {
					user = new User();
					user.setUserId(rs.getString("userId"));
					user.setPasswd(rs.getString("passwd"));
					user.setUserName(rs.getString("userName"));
					user.setSsn(rs.getString("ssn"));
					user.setEmail(rs.getString("email"));
					user.setAddr(rs.getString("addr"));
				}
			} finally {
				ds.close(rs, pstmt, con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	// 회원정보 수정
	public void editUser(User user) {
		String sql = "UPDATE MyUser SET passwd=?, userName=?, ssn=?, email=?, addr=? "
				+ "WHERE userId=?";
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, user.getPasswd());
				pstmt.setString(2, user.getUserName());
				pstmt.setString(3, user.getSsn());
				pstmt.setString(4, user.getEmail());
				pstmt.setString(5, user.getAddr());
				pstmt.setString(6, user.getUserId());
				pstmt.executeUpdate();
				
				System.out.println(user.getAddr());
				System.out.println("COMPELTE EDIT...");
			} finally {
				ds.close(pstmt, con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
