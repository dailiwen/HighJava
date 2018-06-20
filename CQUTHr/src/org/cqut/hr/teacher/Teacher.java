package org.cqut.hr.teacher;

public class Teacher {

	String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Teacher(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	Integer age;
	
}
