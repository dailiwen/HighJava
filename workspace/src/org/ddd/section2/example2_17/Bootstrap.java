package org.ddd.section2.example2_17;

import java.lang.reflect.Method;

public class Bootstrap {
	public static void main(String[] args) throws SecurityException, NoSuchMethodException {
		Class clazz = Person.class;
		Method method = clazz.getMethod("speak");
		System.out.println(method.toString());
		method = clazz.getMethod("eat", String.class);
		System.out.println(method.toString());
		method = clazz.getMethod("listen");
		System.out.println(method.toString());
		method = clazz.getMethod("fly");
		System.out.println(method.toString());
		method = clazz.getMethod("think");
		System.out.println(method.toString());
//		method = clazz.getMethod("userTool");	//不合法的调用
//		method = clazz.getMethod("userTool",String.class);	//不合法的调用
	}
}
