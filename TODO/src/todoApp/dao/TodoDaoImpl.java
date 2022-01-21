package todoApp.dao;

import java.util.List;

import todoApp.model.Todo;

public class TodoDaoImpl implements TodoDao{
//DB연결하고 각 기능에 맞게 작업한다. 데이터베이스 todos테이블에 CRUD 작업

	@Override
	public void insertTodo(Todo todo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Todo selectTodo(long todoId) {
		// TODO Auto-generated method stub
		return null;
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
