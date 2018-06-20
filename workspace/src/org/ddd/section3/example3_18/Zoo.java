package org.ddd.section3.example3_18;

public class Zoo<T> {
	private T t;
	public Zoo(T t){
		this.t = t;
	}
	public T pop(){
		return this.t;
	}
	public void add(T t){}
}
