package com.varxyz.jv300.mod010;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/mod010/mypage")
public class MypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService;
	
	public void init() {
		userService = new UserService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false); // 있을때만 연결 없으면 null
		// HttpSession session = req.getSession(true); 이렇게 하면 모두가 세션을 만들게 되니 검증을 할 수 없다. 
		
		String userId = (String)session.getAttribute("userId");
		
		if (userId == null) { // null이라면 로그인안하고 접근한거니까 로그인페이지로
			req.getRequestDispatcher("login.jsp");
			return;
		}
		
		// 세션아이디 쿠키를 만든게 아이디 확인하는거
		
		Cookie[] cookies = req.getCookies(); 
		for (Cookie cookie : cookies) {
			System.out.println(cookie.getName() + " : " + cookie.getValue()); //쿠키는 map형태라 이렇게 뽑아야함 (이거는 기본적으로 있는 쿠키)
			// 최근방문한게 언제인지 쿠키로 확인해서 jsp에 보냄
			if (cookie.getName().equals("lastAccessTime")) {
				req.setAttribute("lastAccessTime", URLDecoder.decode(cookie.getValue(), "UTF-8"));
			}
		}
		resp.addCookie(lastAccessTime()); //브라우저 메모리에 저장됨(서버꺼버리면 날아가서 일정정도 저장해줘야한다)
		
		req.getRequestDispatcher("mypage.jsp").forward(req, resp);
	}
	
	private Cookie lastAccessTime() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = format.format(new Date()); //쿠키는 문자이기 때문에 string으로
		
		Cookie cookie = null;
		try {
			cookie = new Cookie("lastAccessTime", URLEncoder.encode(dateStr, "UTF-8")); 
			//date형태가 yyyy-mm...라서 인코딩해줘야한다.
		} catch (Exception e) {
			e.printStackTrace();
		}
		cookie.setMaxAge(60 * 60 * 24 * 30); // 한달동안 브라우저 메모리에 저장해두겠다
		cookie.setPath("/"); // 이 사이트 어떤 페이지에 들어와도 쿠키를 심겠다.
		
		return cookie;
	}

}
