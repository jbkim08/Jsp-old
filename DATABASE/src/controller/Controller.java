package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name = "jdbc/webshop")
	private DataSource ds; // 데이터소스 ds 로 DB 연결
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");	
		
		if(action == null) {
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		else if(action.equals("login")) {
			request.setAttribute("email", "");
			request.setAttribute("password", "");
			request.setAttribute("message", "");
			request.getRequestDispatcher("/login.jsp").forward(request, response);			
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8"); //한글설정		
		PrintWriter out = response.getWriter();
		
		String action = request.getParameter("action");
		
		if(action == null) {
			out.println("알수 없는 요청입니다.");
			return;
		}
		
		Connection conn = null;
		
		try {			
			conn = ds.getConnection(); //DB 연결
		} catch (SQLException e) {
			out.println("DB에 연결 실패");
			return;
		} 
		
		//out.println("DB 연결 테스트 완료!");
		Account account = new Account(conn); // 어카운트 클래스 생성
		
		if(action.equals("dologin")) {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			request.setAttribute("email", email);
			request.setAttribute("password", "");
			
			try {
				if(account.login(email, password)) {
					request.getRequestDispatcher("/loginsuccess.jsp").forward(request, response);
				} else {
					request.setAttribute("message", "아이디 또는 패스워드가 틀립니다.");
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				request.setAttribute("message", "DB 에러 발생");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}
		
		
		try {
			conn.close(); //실제로는 conn을 닫는것 대신에 커넥션을 커넥션 풀로 보냄
		} catch (SQLException e) {
			out.println("DB 연결 닫는 에러");
		}		
	}

}
