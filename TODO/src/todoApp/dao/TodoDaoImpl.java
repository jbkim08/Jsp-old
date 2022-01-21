package todoApp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import todoApp.model.Todo;
import todoApp.utils.JDBCUtils;

public class TodoDaoImpl implements TodoDao{
//DB연결하고 각 기능에 맞게 작업한다. 데이터베이스 todos테이블에 CRUD 작업

	@Override
	public void insertTodo(Todo todo) {
		
		String INSERT_USER_SQL = "INSERT INTO todos(title,username,description,target_date,is_done) "
				+ "VALUE (?,?,?,?,?)";
				
		try {
			Connection conn = JDBCUtils.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(INSERT_USER_SQL);
			pstmt.setString(1, todo.getTitle());
			pstmt.setString(2, todo.getUsername());
			pstmt.setString(3, todo.getDescription());
			pstmt.setDate(4, JDBCUtils.getSQLDate(todo.getTargetDate())); 
			pstmt.setBoolean(5, todo.isStatus());
			
			pstmt.executeUpdate(); //결과가 없는 업데이트,삭제,입력 등은 쿼리 업데이트 한 줄의 갯수가 리턴됨
			
		} catch (SQLException e) {
			System.out.println("SQL 입력 에러");
		}

	}

	@Override
	public Todo selectTodo(long todoId) {
		
		Todo todo = null;
		
		Connection conn = JDBCUtils.getConnection();
		
		String SELECT_TODO_BY_ID = "SELECT id,title,username,description,target_date,is_done FROM todos WHERE id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SELECT_TODO_BY_ID);
			pstmt.setLong(1, todoId);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) { //결과가 있을 경우에 값을 저장한다. (없는데 저장하면 에러발생)
				long id = rs.getLong("id");
				String title = rs.getString("title");
				String username = rs.getString("username");
				String description = rs.getString("description");
				LocalDate targetDate = rs.getDate("target_date").toLocalDate();
				Boolean status = rs.getBoolean("is_done");
				todo = new Todo(id, title, username, description, targetDate, status);
			}
			
		} catch (SQLException e) {
			System.out.println("SQL todo 검색 에러");
		}
		
		return todo;
	}

	@Override
	public List<Todo> selectAllTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteTodo(long todoId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateTodo(Todo todo) {
		// TODO Auto-generated method stub
		return false;
	}

}
