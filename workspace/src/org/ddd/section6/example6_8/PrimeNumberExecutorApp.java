package org.ddd.section6.example6_8;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


//org/ddd/thread/primenumber/PrimeNumberExecutorApp.java
public class PrimeNumberExecutorApp {
	public static void main(String[] args) 
	{
		PrimeNumberExecutorApp primeNumberThreadApp = new PrimeNumberExecutorApp();
		primeNumberThreadApp.execute();
	}
	public  void execute() {
		ExecutorService executorService = Executors.newCachedThreadPool();
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入：");
		Long number = scanner.nextLong();
		System.out.println("输入了："+number);
		int testerCount = 0 ;
		while (number != 0) {
			PrimeNumberTester primeNumberTester = new PrimeNumberExecutorApp.PrimeNumberTester(number);	 
			executorService.execute(primeNumberTester); 
			System.out.println("请输入：");
			number = scanner.nextLong();
			System.out.println("输入了："+number);
		}
	}	
	public  class PrimeNumberTester implements Runnable {
		
		private Long number; 
		public PrimeNumberTester(Long number)
		{
			this.number = number;
		}
		/**
		 * 测试输入的整数是否是质数
		 * 
		 * @param number
		 * @return
		 */
		public boolean isPrimeNumber(Long number) {

			Long sqrNumber = (new Double(Math.sqrt(number))).longValue();
			for (Long i = 2l; i <= sqrNumber; i++) {
				if (number % i == 0) {
					return false;
				}
			}
			return true;
		}
		/**
		 * 测试小于等于指定整数中质数的个数
		 * 
		 * @param number
		 * @return
		 */
		public void run(){
			Long count = 0l;
			for (Long i = 2l; i <= number; i++) {
				if (this.isPrimeNumber(i)) {
					count++;
				}
			}
			System.out.println("["+Thread.currentThread().getName()+ "]: ������С��:" + number + " ���������" + count);	 
		}
 
	}	
}
