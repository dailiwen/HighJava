package org.ddd.section2.example2_38;

public class PersonProxy implements Speakable {
	private Person person;
	public PersonProxy(Person person){
		this.person = person;
	}
	@Override
	public void speak(String message) {
		this.person.speak(message);
		System.out.println("运行时间： " + System.currentTimeMillis());
	}
}

