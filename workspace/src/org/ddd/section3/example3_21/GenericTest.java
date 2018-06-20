package org.ddd.section3.example3_21;

import java.lang.reflect.TypeVariable;
import java.util.Arrays;


public class GenericTest {
	public static void  main(String[] args) throws Exception{
		Zoo<Fish> fishZoo = new Zoo<Fish>();
		Zoo<Bird> birdZoo = new Zoo<Bird>();
		Person person = new Person();
		
		TypeVariable[] fishTypes = fishZoo.getClass().getTypeParameters();
		TypeVariable[] birdTypes = fishZoo.getClass().getTypeParameters();
		TypeVariable[] personTypes = person.getClass().getTypeParameters();
		
		System.out.println("fishZoo的参数类型是：" + Arrays.toString(fishTypes));
		System.out.println("birdZoo的参数类型是：" + Arrays.toString(birdTypes));
		System.out.println("person的参数类型是：" + Arrays.toString(personTypes));
	}
}
