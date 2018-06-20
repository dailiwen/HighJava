package org.ddd.section2.example2_32;

import java.lang.reflect.Constructor;

import org.ddd.section2.example2_29.Person;

public class Bootsrap {
	public static String className = "org.ddd.section2.example2_29.Teacher";
	public static void main(String[] args){
		try {
			Class clazz = Class.forName(className);
			Constructor constructor = clazz.getConstructor();
			Person person = (Person) constructor.newInstance();
			System.out.println(person.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
