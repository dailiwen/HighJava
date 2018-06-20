package org.ddd.section3.example3_8;

import java.awt.Button;
import java.util.Date;



public class GenericTest<T> {
	public static void  main(String[] args) throws Exception{
		Factory factory = new Factory();
		
		Date date = factory.generator(Date.class);
		System.out.println(date.toString());
		
		Button button = factory.generator(Button.class);
		System.out.println(button.toString());
	}
}
