package org.ddd.section2.example2_9;

import java.util.Arrays;
import java.util.List;

public class Bootstrap {
	public static void main(String[] args) {
		List<Person> peoples = Arrays.asList(new Teacher(),new Student());
		for(Person people : peoples){
	if(people.getClass().equals(Teacher.class)){
				people.speak("I am a teacher!");
			}
		}
	}
}




