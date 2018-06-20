package org.ddd.section3.example3_20;

public class Zoo<T extends Speakable&Flyable> {
	private T t;
	public Zoo(T t){
		this.t = t;
	}
	public T pop(){
		return this.t;
	}
}
