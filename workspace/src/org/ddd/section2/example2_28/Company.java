package org.ddd.section2.example2_28;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Company {
	/**随机生成一个Employee列表，其中包括Manager和Worker
	 * @return employee列表*/
	public static List<Employee> getEmployees(){
		List<Employee> employees = new ArrayList<Employee>();
		Random random = new Random(); 
		for(int i = 0; i<5; i++){
			if(random.nextInt(5)>3){
				employees.add(new Manager());
			}else{
				employees.add(new Worker());
			}
		}
		return employees;
	}
}

