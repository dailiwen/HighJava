package org.ddd.section7.example7_6;

import java.io.Serializable;

public class Earth implements Serializable{
	private static Earth instance;
	private Earth(){
	}
	public static Earth getInstance(){
		if(instance == null)
			instance = new Earth();
		return instance;
	}  }
