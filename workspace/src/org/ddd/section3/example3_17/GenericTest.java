package org.ddd.section3.example3_17;


public class GenericTest {
	public static void  main(String[] args) throws Exception{
		
		Zoo<? super Bird> zoo = new Zoo<Bird>(new Bird());
		
		zoo = new Zoo<Animal>(new Animal());
		
//		zoo = new Zoo<Fish>(new Fish()); //不合法
	}
}
