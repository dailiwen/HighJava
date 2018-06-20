package org.ddd.section3.example3_4;

public class Person<T> {
	protected T t;
	public Person(T t){
		this.t = t;
	}
	public String toString(){
		return "参数的类型是：" + t.getClass().getCanonicalName();
	}
}
