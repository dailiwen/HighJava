package org.ddd.section2.example2_29;
public final class Teacher extends Person {
	public String position;
	private int salary;
	public void speak(String message) {
		System.out.println("Speak: " + message);
	}
	@Override
	public String toString() {
		return "[Position: " + position + " Salary: " + salary + "]";
	}
	private int getSalary(){
		return this.salary;
	}
}

