package org.ddd.section3.example3_15;


public class GenericTest<T> {
	public static void  main(String[] args) throws Exception{
		Factory<Parrot> factory = new Factory<Parrot>();
		Parrot p = factory.create(Parrot.class);
		System.out.println(p.speak());
	}
}
