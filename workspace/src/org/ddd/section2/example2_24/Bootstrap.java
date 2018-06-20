package org.ddd.section2.example2_24;

import java.lang.reflect.Field;

public class Bootstrap {
	public static void main(String[] args) throws NoSuchFieldException {
		Class clazz = Person.class;
		Field field = clazz.getDeclaredField("name");
		System.out.println(field.toString());
		field = clazz.getDeclaredField("sex");
		System.out.println(field.toString());
		field = clazz.getDeclaredField("age");
		System.out.println(field);
	}
}



