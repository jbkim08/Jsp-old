package test;

import java.time.LocalDate;

import todoApp.dao.TodoDaoImpl;
import todoApp.model.Todo;

public class Test {

	public static void main(String[] args) {
		
		TodoDaoImpl dao = new TodoDaoImpl();
		Todo todo = new Todo(1L, "할일1", "drv98", "첫번째 할일", LocalDate.parse("2022-01-30"), false);
		
		//dao.insertTodo(todo);
		Todo t1 = dao.selectTodo(1);
		System.out.println(t1.toString());

	}

}
