package org.ddd.section2.example2_39;

import java.util.Date;

 

public class Person implements Speakable {
	
 
	@SuppressWarnings("unused")
	private String name; 
	
	@Override
	public String toString()
	{
		Date now = new Date();
		System.out.println(now.getYear());
		return null; 
	}
	 @Deprecated
	public void speak(String message) {
		System.out.println("Speak:	" + message);
	}
}

