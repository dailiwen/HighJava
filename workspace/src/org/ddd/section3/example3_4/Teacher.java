package org.ddd.section3.example3_4;

public class Teacher<V,S> extends Person<V> {
	protected V v;
	private S s;
	public Teacher(V t) {
		super(t);
	}
	
	public void set(V v, S s){
		this.v = v;
		this.s = s;
	}
}

