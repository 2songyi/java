package com.varxyz.jv300.mod009;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDao {
	/* 유스케이스 목록
	 회원가입 (페이지jsp 
	 회원목록 보기 (회원가입처럼 폼 페이지 -> 컨트롤러 / 바로 결과페이지 : url쳐서 get하지않고 메뉴만들어서 메뉴만들어서 include/ 
	 회원정보수정 -> 본인정보가 폼에 채워져서 나옴(jsp바로 부를 수 없음) input에 value에 정보를 넣으면 됨 -> 동적으로 바뀌어야함 EL (request.setAttribute(user)를 저장해야함 -> user.id, user.name으로 불러옴)
	 table 이름 user말고 다른걸로 수정해서 사용
	*/
	
	public void addUser(User user) {
		// add_user.jsp 에서 가져온 값을 가져와서 db에 저장
		String sql = null;
		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				//con = DataSource.getConnection();
				pstmt = con.prepareStatement(sql);
			} finally {
				//DataSource.close(pstmt, con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
