package org.ddd.section2.example2_31;

import org.ddd.section2.example2_29.Person;

public class Bootsrap {
	public static String className = "org.ddd.section2.example2_29.Teacher";
	public static void main(String[] args){
		try {
			Class clazz = Class.forName(className);
			Person person = (Person) clazz.newInstance();
			System.out.println(person.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
