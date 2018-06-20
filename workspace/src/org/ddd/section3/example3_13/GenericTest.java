package org.ddd.section3.example3_13;

public class GenericTest {
	public static void  main(String[] args) throws Exception{
		CarFactory<BenzCar> benzFactory = new CarFactory<BenzCar>();
		CarFactory<BMWCar> BMWFactory = new CarFactory<BMWCar>();
		
		System.out.println("====开始生产奔驰汽车====");
		benzFactory.create(BenzCar.class);
		System.out.println("====开始生产宝马汽车====");
		BMWFactory.create(BMWCar.class);
	}
}
