package org.ddd.section3.example3_16;


public class GenericTest {
	public static void  main(String[] args) throws Exception{
		
		Zoo<? extends Animal> zoo = new Zoo<Bird>(new Bird());
		
		zoo = new Zoo<Fish>(new Fish());
		
//		zoo = new Zoo<Integer>(5); //不合法
	}
}
