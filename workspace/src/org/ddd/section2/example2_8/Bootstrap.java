package org.ddd.section2.example2_8;

public class Bootstrap {
	public static void main(String[] args) {
		Class<Person> clazz = Person.class;
		System.out.println(clazz.getCanonicalName());
	}
}



