package org.ddd.section2.example2_25;

import java.lang.reflect.Field;

public class Bootstrap {
	public static void main(String[] args) throws NoSuchFieldException {
		Class clazz = Person.class;
		Field[] fields = clazz.getDeclaredFields();
		for(Field field : fields){
			System.out.println(field.toString());
		}
	}
}




