package dao;

import entity.Teacher;
import util.DBUtil;
import util.ReflectionUtil;

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
    public void insertInfo(Teacher teacher) throws Exception {
        String sql = ReflectionUtil.generateInsertSQL(teacher);
        try {
            System.out.println(sql);
            DBUtil.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateInfo(String id, Teacher teacher) throws Exception {
        String sql = ReflectionUtil.generateUpdateSQL(teacher);
        try {
            System.out.println(sql);
            DBUtil.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteInfo(String id) throws Exception {
        Teacher teacher = new Teacher();
        teacher.setId(id);
        String sql = ReflectionUtil.generateDeleteSQL(teacher);

        try {
            System.out.println(sql);
            DBUtil.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
