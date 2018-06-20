package org.ddd.section2.example2_33;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Bootsrap {
	public static String className = "org.ddd.section2.example2_29.Teacher";
	public static void main(String[] args){
		try {
			Class clazz = Class.forName(className);
			Constructor constructor = clazz.getConstructor();
			Object teacher = constructor.newInstance();
			Method method = clazz.getMethod("speak", String.class);
			method.invoke(teacher, "Lesson one!");
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
