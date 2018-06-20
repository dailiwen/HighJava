package org.ddd.section3.example3_10;

public class GenericTest {
	public static void  main(String[] args) throws Exception{
		Factory<Car> carFactory = new CarFacotry();
		Factory<Computer> computerFactory = new ComputerFactory();
		System.out.println("======开始生产车子！=======");
		carFactory.create();
		System.out.println("=====开始生产电脑！========");
		computerFactory.create();
	}
}
