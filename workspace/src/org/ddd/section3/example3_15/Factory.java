package org.ddd.section3.example3_15;

public class Factory<T extends  Flyable&Speakable> {
	public Flyable create(Class<T> t) throws Exception{
		return t.newInstance();
	}
}
