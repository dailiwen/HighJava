package org.ddd.section2.example2_5;

public class Bootstrap {
	public static void main(String[] args){
		System.out.println("Use static field!");
		System.out.println(Person.ID);
		System.out.println("new a instance!");
		new Person();
	}
}

