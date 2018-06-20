package org.ddd.section3.example3_6;



public class GenericTest<T> {
	public static void  main(String[] args){
		Person<Integer> p = new Person<Integer>(5);
		System.out.println(p.toString());
	}
}
