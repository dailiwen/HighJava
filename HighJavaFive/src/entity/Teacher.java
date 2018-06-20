package entity;

/**
 * 教师信息实体类
 * @author dailiwen
 * @date 2018/05/17
 */
public class Teacher {
    private String id;
    private String name;
    private String sex;
    private String birthday;
    private Double salary;
    private String college;
    private String majoy;

    public Teacher() {
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
