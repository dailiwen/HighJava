package org.ddd.section2.example2_17;

import java.lang.reflect.Field;

public class ClassTester {

	/**
	 * @param args
	 * @throws NoSuchFieldException 
	 * @throws SecurityException 
	 */
	public static void main(String[] args) throws SecurityException, NoSuchFieldException {
	  Class personClass =	Person.class;
	  System.out.println(personClass.getCanonicalName());
	  System.out.println(personClass.getPackage().getName());
	  System.out.println(personClass.getField("ddd").getType().getName());
	  Field[] fields= personClass.getFields();
	  fields= personClass.getDeclaredFields();
	  for(Field field:fields)
	  {
		  System.out.println( field.getType().getName()+" " + field.getName());
	  }
	}

}
