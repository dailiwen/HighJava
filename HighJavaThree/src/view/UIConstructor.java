package view;

import dao.TeacherDao;
import entity.Teacher;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * @author dailiwen
 * @date 2018/05/17
 */

public class UIConstructor {
    static Scanner scanner = new Scanner(System.in);
    Teacher teacher = new Teacher();

    public int menu() {
        System.out.println("教职工管理系统");
        System.out.print("1、查询全体教职工信息\t");
        System.out.println("2、新教职工信息增添");
        System.out.print("3、教职工信息修改\t");
        System.out.println("4、教职工信息删除");
        System.out.print("请选择你的操作选项号：");

        int command = scanner.nextInt();
        return command;
    }

    public void selectAllInfoView() {
        System.out.println("下面是全教职工信息");
        List<Teacher> teachers = TeacherDao.getTeacherDao().selectAllInfo();
        //输出15列，左对齐(-号表示左对齐)
        System.out.printf("%-15s","id");
        System.out.printf("%-10s","name");
        System.out.printf("%-10s","sex");
        System.out.printf("%-20s","birthday");
        System.out.printf("%-10s","salary");
        System.out.printf("%-10s","college");
        System.out.printf("%-10s","majoy");
        System.out.println();
        for (int i = 0; i < teachers.size(); i++) {
            System.out.printf("%-15s",teachers.get(i).getId());
            System.out.printf("%-10s",teachers.get(i).getName());
            System.out.printf("%-10s",teachers.get(i).getSex());
            System.out.printf("%-20s",teachers.get(i).getBirthday());
            System.out.printf("%-10s",teachers.get(i).getSalary());
            System.out.printf("%-10s",teachers.get(i).getCollege());
            System.out.printf("%-10s",teachers.get(i).getMajoy());
            System.out.println();
        }
        System.out.println();
    }

    public void insertInfoView() throws Exception {
        while (true) {
            System.out.print("请输入教职工ID：");
            teacher.setId(scanner.next());
            if (!(teacher.getId().length() > 11 || "".equals(teacher.getId()))) {
                break;
            } else {
                System.out.println("请输入小于11位的ID号");
            }
        }

        System.out.print("请输入教职工姓名：");
        teacher.setName(scanner.next());

        sexChoose();

        brithChoose();

        while (true) {
            System.out.print("请输入教职工薪水：");
            try {
                teacher.setSalary(scanner.nextDouble());
            } catch (Exception e) {
                System.out.println("请输入正确的薪水");
                continue;
            }
            break;
        }

        System.out.print("请输入教职工所属大学：");
        teacher.setCollege(scanner.next());

        System.out.print("请输入教职工所属专业：");
        teacher.setMajoy(scanner.next());

        TeacherDao.getTeacherDao().insertInfo(teacher);
        selectAllInfoView();
    }

    private void sexChoose() {
        while (true) {
            System.out.println("请选择教职工性别(1.男，2.女)：");
            String sex = scanner.next();
            boolean flag = true;
            switch (sex) {
                case "1": {
                    teacher.setSex("男");
                    flag = false;
                    break;
                }
                case "2": {
                    teacher.setSex("女");
                    flag = false;
                    break;
                }
                case "男": {
                    teacher.setSex("男");
                    flag = false;
                    break;
                }
                case "女": {
                    teacher.setSex("女");
                    flag = false;
                    break;
                }
                default: {
                    System.out.println("输入不符合规则请重新输入");
                    break;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    private void brithChoose() {
        while (true) {
            System.out.println("请输入教职工的生日：");
            System.out.print("年：");
            String year = scanner.next();
            System.out.print("月：");
            String month = scanner.next();
            System.out.print("日：");
            String day = scanner.next();
            String times = year + "-" + month + "-" + day;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = null;
            try {
                date = sdf.parse(times);
            } catch (ParseException e) {
                e.printStackTrace();
                System.out.println("输入时间有误");
                continue;
            }
            teacher.setBirthday(times);
            break;
        }
    }

    public void updataInfoView() throws Exception {
        selectAllInfoView();
        System.out.print("请输入想更改的教职工ID：");
        String id = scanner.next();

        while (true) {
            System.out.print("请输入教职工ID：");
            teacher.setId(scanner.next());
            if (!(teacher.getId().length() > 11 || "".equals(teacher.getId()))) {
                break;
            } else {
                System.out.print("请输入小于11位的ID号");
            }
        }

        System.out.print("请输入教职工姓名：");
        teacher.setName(scanner.next());

        sexChoose();

        brithChoose();

        while (true) {
            System.out.print("请输入教职工薪水：");
            try {
                teacher.setSalary(scanner.nextDouble());
            } catch (Exception e) {
                System.out.println("请输入正确的薪水");
                continue;
            }
            break;
        }

        System.out.print("请输入教职工所属大学：");
        teacher.setCollege(scanner.next());

        System.out.print("请输入教职工所属专业：");
        teacher.setMajoy(scanner.next());

        TeacherDao.getTeacherDao().updateInfo(id ,teacher);
        selectAllInfoView();
    }

    public void deleteInfoView() throws Exception {
        selectAllInfoView();
        System.out.print("请输入想要删除职工的ID：");
        String id = scanner.next();
        TeacherDao.getTeacherDao().deleteInfo(id);
        selectAllInfoView();
    }
}
