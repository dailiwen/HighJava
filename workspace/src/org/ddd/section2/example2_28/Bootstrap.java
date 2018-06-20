package org.ddd.section2.example2_28;

import java.util.List;

public class Bootstrap {
	public static void main(String[] args){
		List<Employee> employees = Company.getEmployees();
		Counter.addEmployeeType(Manager.class);
		Counter.addEmployeeType(Worker.class);
		for(Employee employee : employees){
			Counter.count(employee);
		}
		for(Class clazz : Counter.employeeTypes.keySet()){
			System.out.println(clazz.getCanonicalName() + " : " + Counter.employeeTypes.get(clazz));
		}
	}
}






