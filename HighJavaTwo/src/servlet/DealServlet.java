package servlet;

import dao.TeacherDao;
import entity.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * @author dailiwen
 * @date 2018/06/03
 */
@WebServlet("/Information")
public class DealServlet extends HttpServlet {
	private TeacherDao teacherDao = TeacherDao.getAccountDao();
	Teacher teacher = new Teacher();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<String> nameList = new ArrayList<>();
		Iterator<String> it = req.getParameterNames().asIterator();
		while (it.hasNext()) {
			nameList.add(it.next());
		}
		switch (nameList.get(nameList.size() - 1)) {
			case "define": {
				dataSave(nameList, req);
				try {
					teacherDao.insertInfo(teacher);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			}
			case "updatedefine": {
				dataSave(nameList, req);
				try {
					teacherDao.updateInfo(teacher.getId(), teacher);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			}
			default: {
				String[] checked = req.getParameterValues("check");
				List<Teacher> teachers = null;
				try {
					teachers = teacherDao.findAll();
				} catch (Exception e) {
					e.printStackTrace();
				}
				for (int i = 0; i < checked.length; i++) {
					try {
						teacherDao.deleteFromId(teachers.get(Integer.parseInt(checked[i])).getId());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				break;
			}
		}
		resp.sendRedirect("../ListServlet");
	}

	private void dataSave(List<String> nameList, HttpServletRequest req) {
		for (int i = 0; i < nameList.size() - 1; i++) {
			String parameterValues = req.getParameterValues(nameList.get(i))[0];
			switch (i) {
				case 0:
					teacher.setId(parameterValues);
					break;
				case 1:
					teacher.setName(parameterValues);
					break;
				case 2:
					teacher.setSex(parameterValues);
					break;
				case 3:
					teacher.setBirthday(parameterValues);
					break;
				case 4:
					teacher.setSalary(Float.valueOf(parameterValues));
					break;
				case 5:
					teacher.setCollege(parameterValues);
					break;
				case 6:
					teacher.setMajor(parameterValues);
					break;
				default:
					break;
			}
		}
	}
}
