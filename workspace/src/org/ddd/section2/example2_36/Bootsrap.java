package org.ddd.section2.example2_36;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class Bootsrap {
	public static String className = "org.ddd.section2.example2_29.Teacher";
	public static void main(String[] args){
		try {
			Class clazz = Class.forName(className);
			Constructor constructor = clazz.getConstructor();
			Object teacher = constructor.newInstance();
			System.out.println(teacher.toString());
			Field field = clazz.getDeclaredField("salary");
			field.setAccessible(true);
			field.set(teacher, 5000);
			System.out.println(teacher.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
