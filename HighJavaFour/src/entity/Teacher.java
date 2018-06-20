package entity;

import annotation.Column;

/**
 * 教师信息实体类
 * @author dailiwen
 * @date 2018/05/17
 */
public class Teacher {
    @Column(isId = true, name="id", caption="唯一标识id", nullable = false, length = 11)
    private String id;
    @Column(name="sname", caption="姓名", nullable = false)
    private String name;
    @Column(name="sex", caption="性别")
    private String sex;
    @Column(name="birthday", caption="生日")
    private String birthday;
    @Column(name="salary", caption="薪水")
    private Double salary;
    @Column(name="college", caption="大学名称")
    private String college;
    @Column(name="major", caption="专业名称")
    private String majoy;

    public Teacher(){
        super();
        this.id = "11603080209";
        this.name = "代利文";
        this.salary = 100.0;
        this.sex = "男";
        this.birthday = "1997-10-28";
        this.college = "重庆理工大学";
        this.majoy = "软件工程";
    }

    public Teacher(String id, String name, String sex, String birthday, Double salary, String college, String majoy) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.salary = salary;
        this.college = college;
        this.majoy = majoy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getMajoy() {
        return majoy;
    }

    public void setMajoy(String majoy) {
        this.majoy = majoy;
    }
}
