package org.ddd.section3.example3_5;

public class Teacher<T,S> extends Person<T> {
	protected T t;
	private S s;
	public Teacher(T t) {
		super(t);
	}
	
	public void set(T t, S s){
		this.t = t;
		this.s = s;
	}
}
