package org.ddd.section2.example2_34;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class Bootsrap {
	public static String className = "org.ddd.section2.example2_29.Teacher";
	public static void main(String[] args){
		try {
			Class clazz = Class.forName(className);
			Constructor constructor = clazz.getConstructor();
			Object teacher = constructor.newInstance();
			Field field = clazz.getField("position");
			System.out.println(teacher.toString());
			field.set(teacher, "Master");
			System.out.println(teacher.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
