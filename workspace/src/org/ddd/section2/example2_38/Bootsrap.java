package org.ddd.section2.example2_38;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
public class Bootsrap {
	public static void main(String[] args){
		Person person = new Person();
		PersonProxy proxy = new PersonProxy(person);
		proxy.speak("Lesson one!");
	}
}

