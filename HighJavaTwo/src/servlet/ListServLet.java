package servlet;

import dao.TeacherDao;
import entity.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author dailiwen
 * @date 2018/06/03
 */
@WebServlet("/ListServlet")
public class ListServLet extends HttpServlet {
	private TeacherDao teacherDao = TeacherDao.getAccountDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Teacher> teachers = null;
		try {
			teachers = teacherDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("teachers", teachers);
		req.getRequestDispatcher("main.jsp").forward(req, resp);
	}
}
