package org.ddd.section7.example7_1;

import java.io.Serializable;

public class Person implements Serializable {

	private static final long serialVersionUID = 2L;
	
	private transient String name = "simple";
	private Integer age = 15;
	
	public String getName(){
		return this.name;
	}
}
