package org.ddd.section2.example2_39;

import java.lang.reflect.Proxy;
public class Bootsrap {
	public static void main(String[] args){
		Person person = new Person();
		Speakable speakable = (Speakable)Proxy.newProxyInstance(
					Speakable.class.getClassLoader(),
					new Class[]{Speakable.class}, new MyProxy(person));
		speakable.speak("Lesson one!");
	}
}


