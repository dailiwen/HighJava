package entity;

/**
 * 教师信息实体类
 * @author dailiwen
 * @date 2018/05/29
 */
public class Teacher {
    String id;
    String name;
    String sex;
    String birthday;
    Float salary;
    String college;
    String major;

    public Teacher() {
    }

    public Teacher(String id, String name, String sex, String birthday, Float salary, String college, String major) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.salary = salary;
        this.college = college;
        this.major = major;
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

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
