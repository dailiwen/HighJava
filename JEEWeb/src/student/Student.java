
package student;

public class Student {
	private String stuNo;
	private String stuName;
	private String stuSex;
	private int stuAge;
	public Student(String stuNo,String stuName,String stuSex,int stuAge){
		this.stuNo = stuNo;
		this.stuName = stuName;
		this.stuSex = stuSex;
		this.stuAge = stuAge;
	}
	public String getStuNo() {
		return stuNo;
	}
	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuSex() {
		return stuSex;
	}
	public void setStuSex(String stuSex) {
		this.stuSex = stuSex;
	}
	public int getStuAge() {
		return stuAge;
	}
	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}
}
