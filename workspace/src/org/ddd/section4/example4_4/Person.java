package org.ddd.section4.example4_4;

import java.util.ArrayList;
import java.util.List;

public class Person {

	@SuppressWarnings(value = "unused")
	private String name;
	
	
	public void speak(String message){
		@SuppressWarnings({"unchecked","unused"})
		List list = new ArrayList();
		System.out.println("Speak:	" + message);
	}
}
