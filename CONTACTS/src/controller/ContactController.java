package controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import dao.ContactDao;
import model.Contact;

@WebServlet("/contact")
public class ContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ContactDao contactDao;

	@Resource(name = "jdbc/demo")
	private DataSource dataSource;

	@Override
	public void init() throws ServletException {
		contactDao = new ContactDao(dataSource);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		// 파라메터가 cmd값을 읽어서 액션으로 저장하는데 만약 값이 null이면 "list"로 대체
		String action = req.getParameter("cmd") != null ? req.getParameter("cmd") : "list";

		switch (action) {
		case "post": // 새로 입력 저장
			save(req, resp);
			break;
		case "edit": // 수정하기 창을 표시
			edit(req, resp);
			break;
		case "update": // 실제 수정하기
			update(req, resp);
			break;
		case "del": // 삭제
			delete(req, resp);
			break;
		default: // 전체 연락처를 화면에 테이블로 표시
			list(req, resp);
			break;
		}
	}

	private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Contact> contacts = contactDao.findAll(); //DB모든 연락처 가져오기
		req.setAttribute("contacts", contacts);
		RequestDispatcher rd = req.getRequestDispatcher("contact/list.jsp");
		rd.forward(req, resp); //리퀘스트를 유지하면서 list.jsp페이지로 이동
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub

	}

	private void update(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub

	}

	private void edit(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub

	}

	private void save(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
