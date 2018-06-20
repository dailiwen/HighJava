package org.ddd.section7.example7_2;

import java.io.Serializable;

public class Person implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name = "simple";
	 //新增加的静态属性
	public static String type = "human"; 
}
