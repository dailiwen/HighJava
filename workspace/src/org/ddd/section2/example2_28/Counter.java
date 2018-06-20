package org.ddd.section2.example2_28;

import java.util.HashMap;
import java.util.Map;

public class Counter {
	public static Map<Class,Integer> employeeTypes = new HashMap<Class,Integer>();
	public static void count(Employee employee){
		for(Class clazz : employeeTypes.keySet()){
			if(clazz.isInstance(employee)){
				int acount = employeeTypes.get(clazz)+1;
				employeeTypes.put(clazz, acount);
			}
		}
	}
	public static void addEmployeeType(Class clazz){
		employeeTypes.put(clazz, 0);
	}
	public static void removeEmployeeType(Class clazz){
		employeeTypes.remove(clazz);
	}
}

