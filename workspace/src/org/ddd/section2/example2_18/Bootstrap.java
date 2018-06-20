package org.ddd.section2.example2_18;

import java.lang.reflect.Method;

public class Bootstrap {
	public static void main(String[] args) throws SecurityException, NoSuchMethodException {
		Class clazz = Person.class;
		Method[] methods = clazz.getMethods();
		for(Method method : methods){
			System.out.println(method.toString());
		}
	}
}

