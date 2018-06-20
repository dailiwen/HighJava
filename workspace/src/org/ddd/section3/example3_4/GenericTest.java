package org.ddd.section3.example3_4;

import java.util.Date;


public class GenericTest<T> {
	public static void  main(String[] args){
		
		
//		Person<String> peson = new Person<String>("ddd");
//		System.out.println(peson.toString());
		
		Teacher<String,Date> teacher = new Teacher<String,Date>("ddd");
		System.out.println(teacher.toString());
		teacher.set("ste", new Date());
		System.out.println(teacher.toString());
	}
}
