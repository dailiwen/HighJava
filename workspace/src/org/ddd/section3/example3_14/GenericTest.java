package org.ddd.section3.example3_14;


public class GenericTest<T> {
	public static void  main(String[] args) throws Exception{
		Sortor sortor = new Sortor();
		System.out.println("泛型方法获取的最大数是： " + sortor.getMax(3, 5));
	}
}
