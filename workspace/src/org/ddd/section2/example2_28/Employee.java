package org.ddd.section2.example2_28;

public abstract class Employee {
	protected int salary = 0;
	public void addSalary(int amount){
		this.salary += amount;
	}
	public abstract String toString();
}
