package view;

import dao.TeacherDao;
import entity.Teacher;
import util.JacksonUtil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.*;

/**
 * @author dailiwen
 * @date 2018/05/17
 */

public class UIConstructor {
    private Teacher teacher = new Teacher();

    public String menu() {
        return "教职工管理系统" + "\n"
                + "1、查询全体教职工信息\t" + "2、新教职工信息增添" + "\n"
                + "3、教职工信息修改\t" + "4、教职工信息删除" + "\n"
                + "请选择你的操作选项号：" + "\n";
    }

    public String selectAllInfoView() {
        List<Teacher> teachers = TeacherDao.getTeacherDao().selectAllInfo();
        Map<String, Object> msg = new HashMap<>();
        msg.put("type", 1);
        msg.put("result", teachers);

        return JacksonUtil.objectToJson(msg);

    }

    public void insertInfoView(BufferedReader bufferedReader, BufferedWriter bufferedWriter) throws IOException {
        Map<String, Object> msg = new HashMap<>();
        msg.put("type", 2);

        bufferedWriter.write(JacksonUtil.objectToJson(msg) + "\n");
        bufferedWriter.flush();

        bufferedWriter.write("请输入新增教职工ID：" + "\n");
        bufferedWriter.flush();
        teacher.setId(bufferedReader.readLine());

        bufferedWriter.write("请输入教职工姓名：" + "\n");
        bufferedWriter.flush();
        teacher.setName(bufferedReader.readLine());

        bufferedWriter.write("请输入教职工性别：" + "\n");
        bufferedWriter.flush();
        teacher.setSex(bufferedReader.readLine());

        bufferedWriter.write("请输入教职工的生日(yyyy-mm-dd)：" + "\n");
        bufferedWriter.flush();
        teacher.setBirthday(bufferedReader.readLine());

        bufferedWriter.write("请输入职工薪水：" + "\n");
        bufferedWriter.flush();
        teacher.setSalary(Double.parseDouble(bufferedReader.readLine()));

        bufferedWriter.write("请输入教职工所属大学：" + "\n");
        bufferedWriter.flush();
        teacher.setCollege(bufferedReader.readLine());

        bufferedWriter.write("请输入教职工所属专业：" + "\n");
        bufferedWriter.flush();
        teacher.setMajoy(bufferedReader.readLine());

        TeacherDao.getTeacherDao().insertInfo(teacher);
        bufferedWriter.write("新增成功" + "\n");
        bufferedWriter.flush();
    }

    public void updataInfoView(BufferedReader bufferedReader, BufferedWriter bufferedWriter) throws IOException {
        Map<String, Object> msg = new HashMap<>();
        msg.put("type", 3);

        bufferedWriter.write(JacksonUtil.objectToJson(msg) + "\n");
        bufferedWriter.flush();

        bufferedWriter.write("请输入想更改的教职工ID：" + "\n");
        bufferedWriter.flush();
        teacher.setId(bufferedReader.readLine());

        bufferedWriter.write("请输入教职工姓名：" + "\n");
        bufferedWriter.flush();
        teacher.setName(bufferedReader.readLine());

        bufferedWriter.write("请输入教职工性别：" + "\n");
        bufferedWriter.flush();
        teacher.setSex(bufferedReader.readLine());

        bufferedWriter.write("请输入教职工的生日(yyyy-mm-dd)：" + "\n");
        bufferedWriter.flush();
        teacher.setBirthday(bufferedReader.readLine());

        bufferedWriter.write("请输入职工薪水：" + "\n");
        bufferedWriter.flush();
        teacher.setSalary(Double.parseDouble(bufferedReader.readLine()));

        bufferedWriter.write("请输入教职工所属大学：" + "\n");
        bufferedWriter.flush();
        teacher.setCollege(bufferedReader.readLine());

        bufferedWriter.write("请输入教职工所属专业：" + "\n");
        bufferedWriter.flush();
        teacher.setMajoy(bufferedReader.readLine());

        TeacherDao.getTeacherDao().updateInfo(teacher.getId() ,teacher);
        bufferedWriter.write("修改成功" + "\n");
        bufferedWriter.flush();
    }

    public void deleteInfoView(BufferedReader bufferedReader, BufferedWriter bufferedWriter) throws IOException {
        Map<String, Object> msg = new HashMap<>();
        msg.put("type", 4);
        msg.put("result", "请输入想要删除职工的ID：");

        bufferedWriter.write(JacksonUtil.objectToJson(msg) + "\n");
        bufferedWriter.flush();

        String id = bufferedReader.readLine();
        TeacherDao.getTeacherDao().deleteInfo(id);
        bufferedWriter.write("删除成功" + "\n");
        bufferedWriter.flush();
    }
}
