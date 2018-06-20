package org.ddd.section2.example2_40;

public class Person implements Speakable {
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public void speak(String message) {
		System.out.println( this.name + " say:	" + message);
	}
}
