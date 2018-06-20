package org.ddd.section3.example3_18;


public class GenericTest {
	public static void  main(String[] args) throws Exception{
		
		Zoo<Fish> fishZoo = new Zoo<Fish>(new Fish());
		
		Zoo<Bird> birdZoo = new Zoo<Bird>(new Bird());
		
		boolean isSampleClass = fishZoo.getClass().equals(birdZoo.getClass());
		
		System.out.println("两者的类型相同：" + isSampleClass);
	}
}
