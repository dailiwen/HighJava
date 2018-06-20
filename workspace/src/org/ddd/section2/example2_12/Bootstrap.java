package org.ddd.section2.example2_12;

import java.lang.reflect.Constructor;

public class Bootstrap {
	public static void main(String[] args) throws SecurityException, NoSuchMethodException {
		Class clazz = Person.class;
		Constructor constructor = clazz.getConstructor();
		System.out.println(constructor.toString());
		constructor = clazz.getConstructor(String.class);
		System.out.println(constructor.toString());
		constructor = clazz.getConstructor(String.class,int.class);
		System.out.println(constructor.toString());
//		constructor = clazz.getConstructor(boolean.class);  //不合法的调用
//		constructor = clazz.getConstructor(Date.class); //不合法的调用
	}
}

