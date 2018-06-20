package org.ddd.section2.example2_19;

import java.lang.reflect.Method;

public class Bootstrap {
	public static void main(String[] args) throws SecurityException, NoSuchMethodException {
		Class clazz = Person.class;
		Method method = clazz.getDeclaredMethod("useTool");
		System.out.println(method.toString());
		method = clazz.getDeclaredMethod("useTool", String.class);
		System.out.println(method.toString());
	}
}


