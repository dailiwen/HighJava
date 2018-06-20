package dao;

import entity.Teacher;
import util.DBUtil;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dailiwen
 * @date 2018/06/03
 */
public class TeacherDao extends BaseDao{
	private static TeacherDao teacherDao;

	public static TeacherDao getAccountDao() {
		if (teacherDao == null) {
			teacherDao = new TeacherDao();
		}
		return teacherDao;
	}

	public List<Teacher> findAll() throws Exception {
		String sql = "SELECT * FROM teacher";
		List<Teacher> teachers = new ArrayList<>();
		//executeQuery用于产生单个结果集的语句，例如 SELECT 语句
		ResultSet rs = select(sql);
		//getMetaData()得到结果集的结构
		ResultSetMetaData data = rs.getMetaData();
		while (rs.next()) {
			Teacher teacher = new Teacher();
			//i必须从1开始，为第一列的意思
			for (int i = 1; i <= data.getColumnCount(); i++) {
				// 获得指定列的列值
				String columnValue = rs.getString(i);
				switch (i) {
					case 1: {
						teacher.setId(columnValue);
						break;
					}
					case 2: {
						teacher.setName(columnValue);
						break;
					}
					case 3: {
						teacher.setSex(columnValue);
						break;
					}
					case 4: {
						teacher.setBirthday(columnValue);
						break;
					}
					case 5: {
						teacher.setSalary(Float.valueOf(columnValue));
						break;
					}
					case 6: {
						teacher.setCollege(columnValue);
						break;
					}
					case 7: {
						teacher.setMajor(columnValue);
						break;
					}
				}
			}
			teachers.add(teacher);
		}
		return teachers;
	}

	public void insertInfo(Teacher teacher) throws Exception {
		StringBuffer result = new StringBuffer();
		result.append("'" + teacher.getId() + "'").append(",");
		result.append("'" + teacher.getName() + "'").append(",");
		result.append("'" + teacher.getSex() + "'").append(",");
		result.append("'" + teacher.getBirthday() + "'").append(",");
		result.append(+ teacher.getSalary()).append(",");
		result.append("'" + teacher.getCollege() + "'").append(",");
		result.append("'" + teacher.getMajor() + "'");

		String sql = "INSERT INTO teacher (id,sname,sex,birthday,salary,college,major) VALUES ("+ result +");";
		System.out.println(sql);
		execute(sql);
	}

	public void deleteFromId(String id) throws Exception {
		String sql = "DELETE FROM teacher WHERE id = '" + id +  "'";
		execute(sql);
	}

	public void updateInfo(String id,Teacher teacher) throws Exception {
		StringBuffer result = new StringBuffer();
		result.append("sname = ").append("'" + teacher.getName() + "'").append(",");
		result.append("sex = ").append("'" + teacher.getSex() + "'").append(",");
		result.append("birthday = ").append("'" + teacher.getBirthday() + "'").append(",");
		result.append("salary = ").append(+ teacher.getSalary()).append(",");
		result.append("college = ").append("'" + teacher.getCollege() + "'").append(",");
		result.append("major = ").append("'" + teacher.getMajor() + "' ");
		result.append("WHERE id = " + id);

		String sql = "UPDATE teacher SET "+ result +";";
		execute(sql);
	}
}
