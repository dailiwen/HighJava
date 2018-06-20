package org.ddd.section2.example2_22;

import java.lang.reflect.Field;

public class Bootstrap {
	public static void main(String[] args) throws NoSuchFieldException {
		Class clazz = Person.class;
		Field field = clazz.getField("name");
		System.out.println(field.toString());
//		field = clazz.getField("sex"); //不合法的调用
//		field = clazz.getField("age"); //不合法的调用
	}
}

