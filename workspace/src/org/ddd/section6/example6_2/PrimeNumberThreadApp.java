package org.ddd.section6.example6_2;

import java.util.Scanner;

//org/ddd/thread/primenumber/PrimeNumberThreadApp.java
public class PrimeNumberThreadApp {
	public static void main(String[] args) {
		PrimeNumberThreadApp primeNumberThreadApp = new PrimeNumberThreadApp();
		primeNumberThreadApp.execute();
	}

	public void execute() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入：");
		Long number = scanner.nextLong();
		System.out.println("输入了：" + number);
		int testerCount = 0;
		while (number != 0) {
			PrimeNumberTester primeNumberTester = new PrimeNumberThreadApp.PrimeNumberTester(
					number);
			testerCount++;
			primeNumberTester.setName("primeNumberTester " + testerCount);
			primeNumberTester.start();
			System.out.println("请输入：");
			number = scanner.nextLong();
			System.out.println("输入了：" + number);
		}
	}

	public class PrimeNumberTester extends Thread {

		private Long number;

		public PrimeNumberTester(Long number) {
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
		public void run() {
			Long count = 0l;
			for (Long i = 2l; i <= number; i++) {
				if (this.isPrimeNumber(i)) {
					count++;
				}
			}
			System.out.println(Thread.currentThread().getName() + " 计算结果：小于:"
					+ number + " 的质数个人数：" + count);
		}
	}
}
