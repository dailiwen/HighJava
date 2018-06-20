package org.ddd.section2.example2_38;

public class Person implements Speakable {
	@Override
	public void speak(String message) {
		System.out.println("Speak:	" + message);
	}
}

