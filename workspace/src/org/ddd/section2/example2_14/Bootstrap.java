package org.ddd.section2.example2_14;

import java.lang.reflect.Constructor;
import java.util.Date;

public class Bootstrap {
	public static void main(String[] args) throws SecurityException, NoSuchMethodException {
		Class clazz = Person.class;
		Constructor constructor = clazz.getDeclaredConstructor();
		System.out.println(constructor.toString());
		constructor = clazz.getDeclaredConstructor(String.class);
		System.out.println(constructor.toString());
		constructor = clazz.getDeclaredConstructor(String.class,int.class);
		System.out.println(constructor.toString());
		constructor = clazz.getDeclaredConstructor(boolean.class);  
		System.out.println(constructor.toString());
		constructor = clazz.getDeclaredConstructor(Date.class); 
		System.out.println(constructor.toString());
	}
}



