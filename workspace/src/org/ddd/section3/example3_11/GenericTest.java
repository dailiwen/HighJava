package org.ddd.section3.example3_11;

import java.util.Date;

public class GenericTest<T> {
	public static void  main(String[] args) throws Exception{
		Class<?> clazz = Integer.class;
		System.out.println(clazz.getCanonicalName());
		clazz = String.class;
		System.out.println(clazz.getCanonicalName());
		clazz = Date.class;
		System.out.println(clazz.getCanonicalName());
	}
}
