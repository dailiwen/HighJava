package org.ddd.section3.example3_13;

public class CarFactory<T>{
	T t;
	public T get(T t)
	{
		return this.t = t; 
	}
	public T create(Class<T> clazz) throws Exception {
		System.out.println("装载发动机！");
		System.out.println("装载座椅！");
		System.out.println("装载轮子！");
		return clazz.newInstance();
	}
}

public class CarFactory{
	Car t;
	public Car get(Car t)
	{
		return this.t = t; 
	}
	public T create(Class<T> clazz) throws Exception {
		System.out.println("装载发动机！");
		System.out.println("装载座椅！");
		System.out.println("装载轮子！");
		return clazz.newInstance();
	}
}
