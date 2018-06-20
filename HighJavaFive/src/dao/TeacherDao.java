package dao;

import entity.Teacher;
import util.DBUtil;

import java.util.List;

/**
 * @author dailiwen
 * @date 2018/05/17
 */
public class TeacherDao {
    private static TeacherDao teacherDao;

    public static TeacherDao getTeacherDao() {
        if (teacherDao == null) {
            teacherDao = new TeacherDao();
        }

        return teacherDao;
    }

    /**
     * 查询全体教职工信息
     */
    public List<Teacher> selectAllInfo() {
        String sql = "SELECT * FROM teacher;";
        List<Teacher> teachers = null;
        try {
            System.out.println(sql);
            teachers = DBUtil.select(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return teachers;
    }

    /**
     * 新教职工信息增添
     * @param teacher
     */
    public void insertInfo(Teacher teacher) {
        StringBuffer result = new StringBuffer();
        result.append("'" + teacher.getId() + "'").append(",");
        result.append("'" + teacher.getName() + "'").append(",");
        result.append("'" + teacher.getSex() + "'").append(",");
        result.append("'" + teacher.getBirthday() + "'").append(",");
        result.append(+ teacher.getSalary()).append(",");
        result.append("'" + teacher.getCollege() + "'").append(",");
        result.append("'" + teacher.getMajoy() + "'");

        String sql = "INSERT INTO teacher (id,sname,sex,birthday,salary,college,major) VALUES ("+ result +");";
        try {
            System.out.println(sql);
            DBUtil.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateInfo(String id,Teacher teacher) {
        StringBuffer result = new StringBuffer();
        result.append("id = ").append("'" + teacher.getId() + "'").append(",");
        result.append("sname = ").append("'" + teacher.getName() + "'").append(",");
        result.append("sex = ").append("'" + teacher.getSex() + "'").append(",");
        result.append("birthday = ").append("'" + teacher.getBirthday() + "'").append(",");
        result.append("salary = ").append(+ teacher.getSalary()).append(",");
        result.append("college = ").append("'" + teacher.getCollege() + "'").append(",");
        result.append("major = ").append("'" + teacher.getMajoy() + "' ");
        result.append("WHERE id = " + id);

        String sql = "UPDATE teacher SET "+ result +";";
        try {
            System.out.println(sql);
            DBUtil.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteInfo(String id) {
        String sql = "DELETE FROM teacher WHERE id = '" + id +  "'";

        try {
            System.out.println(sql);
            DBUtil.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
