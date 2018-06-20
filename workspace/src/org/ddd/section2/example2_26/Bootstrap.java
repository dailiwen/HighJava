package org.ddd.section2.example2_26;

import java.util.List;

public class Bootstrap {
	public static void main(String[] args) {
		List<Employee> employees = Company.getEmployees();
		for(Employee employee : employees){
			if(employee instanceof Manager){
				employee.addSalary(5000);
			}else{
				employee.addSalary(1000);
			}
			System.out.println(employee.toString());
		}
	}
}




