package demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/Connect")
public class Connect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8"); //한글설정		
		PrintWriter out = response.getWriter();
		
		Connection conn = null;
		
		try {
			//0. 드라이버 로딩 (생략가능)
			Class.forName("com.mysql.jdbc.Driver");
			//1. DB연결
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webshop?useSSL=false", "root", "1234");
		} catch (SQLException e) {
			out.println("DB에 연결 실패");
			return;
		} catch (ClassNotFoundException e) {
			out.println("드라이버 클래스를 찾을수 없음");
			return;
		}
		
		out.println("DB 연결 테스트 완료!");
		
		try {
			conn.close();
		} catch (SQLException e) {
			out.println("DB 연결 닫는 에러");
		}		

	}

}








