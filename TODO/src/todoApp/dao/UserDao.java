package todoApp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import todoApp.model.User;
import todoApp.utils.JDBCUtils;

// DAO 는 DB에 연결해 데이터를 조작하는 클래스
public class UserDao {
	//유저 입력 => DB에 유저데이터를 입력
	public int registerUser(User user) { //결과가 성공이면 1리턴 아니면 0이하
		
		String INSERT_USER_SQL = "INSERT INTO users(firstName,lastName,userName,password) "
				+ "VALUES (?,?,?,?)";
		
		int result = 0;
				
		try {
			Connection conn = JDBCUtils.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(INSERT_USER_SQL);
			pstmt.setString(1, user.getFirstName());
			pstmt.setString(2, user.getLastName());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getPassword()); // pstmt 준비 완료
			
			result = pstmt.executeUpdate(); //결과가 없는 업데이트,삭제,입력 등은 쿼리 업데이트 한 줄의 갯수가 리턴됨
			
		} catch (SQLException e) {
			System.out.println("SQL 입력 에러");
		}
		
		return result;
	}
}
