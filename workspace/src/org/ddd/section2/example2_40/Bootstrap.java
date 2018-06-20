package org.ddd.section2.example2_40;

public class Bootstrap {
	public static void main(String[] args) {
		BeanFactory factory = new XMLContext("beans.xml");
		Speakable s = (Speakable)factory.getBean("Person");
		s.speak("Lesson one!");
	}
}
