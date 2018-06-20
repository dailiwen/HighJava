package org.ddd.section6.example6_5;

import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

//org/ddd/thread/primenumber/PrimeNumberThreadInterruptApp.java
public class PrimeNumberThreadInterruptApp {
	public static void main(String[] args) {
		PrimeNumberThreadInterruptApp primeNumberThreadInterruptApp = new PrimeNumberThreadInterruptApp();
		primeNumberThreadInterruptApp.execute();
	}

	public void execute() {
		// 创建并启动计算超时监视进程
		PrimeNumberCalcMonitor primeNumberCalcMonitor = new PrimeNumberCalcMonitor(
				this.primeNumberTesters);
		primeNumberCalcMonitor.start();

		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入：");
		Long number = scanner.nextLong();
		System.out.println("输入了：" + number);

		int testerCount = 0;
		while (number != 0) {
			PrimeNumberTester primeNumberTester = new PrimeNumberThreadInterruptApp.PrimeNumberTester(
					number);
			primeNumberTesters.put(primeNumberTester, 2000l);

			primeNumberTester.setName("primeNumberTester " + testerCount++);
			primeNumberTester.start();

			System.out.println("请输入：");
			number = scanner.nextLong();
			System.out.println("输入了：" + number);
		}
	}

	// 用来存储所有计算线程，及其生命周期
	private ConcurrentHashMap<PrimeNumberTester, Long> primeNumberTesters = new ConcurrentHashMap<PrimeNumberTester, Long>();

	public class PrimeNumberTester extends Thread {

		private long number;

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
				// 如果有中断请求，就退出线程
				if (Thread.interrupted()) {
					System.err
							.printf("[%s]:响应中断请求，线程准备终止，当前时间（纳秒）：%10d%n",
									Thread.currentThread().getName(),
									System.nanoTime());
					return;
				}
				if (this.isPrimeNumber(i)) {
					count++;
				}
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					System.err
							.printf("[%s]:线程正休眠，被中断，线程准备终止，当前时间（纳秒）：%10d%n",
									Thread.currentThread().getName(),
									System.nanoTime());
					return;
				}
			}
			System.out.println("[" + Thread.currentThread().getName()
					+ "]: 计算结果：小于:" + number + " 的质数个数：" + count);
		}
	}

	// 线程用来监视所有计算线程是否超时，如果超时，则中断线程的运行
	public class PrimeNumberCalcMonitor extends Thread {
		private ConcurrentHashMap<PrimeNumberTester, Long> primeNumberTesters;

		public PrimeNumberCalcMonitor(
				ConcurrentHashMap<PrimeNumberTester, Long> primeNumberTesters) {
			this.primeNumberTesters = primeNumberTesters;
		}

		public void run() {
			while (true) {
				Iterator<PrimeNumberTester> iterator = primeNumberTesters
						.keySet().iterator();
				while (iterator.hasNext()) {

					PrimeNumberTester primeNumberTester = iterator.next();
					// 如果线程没有处于活动状态，表示已经计算完成，直接移出线程
					if (!primeNumberTester.isAlive()) {
						primeNumberTesters.remove(primeNumberTester);
						continue;
					}
					long lifetime = primeNumberTesters.get(primeNumberTester);
					if (lifetime == 0) {
						// 如果超时，则中断计算线程的运行
						System.err
								.printf("[%s]:计算超时，请求终止线程，当前在运行的线程总数：%3d，当前时间（纳秒）：%10d%n",
										primeNumberTester.getName(),
										this.primeNumberTesters.size() - 1,
										System.nanoTime());
						primeNumberTester.interrupt();
						 
						primeNumberTesters.remove(primeNumberTester);

					}
					lifetime--;
					primeNumberTesters.put(primeNumberTester, lifetime);
				}
				try {
					this.sleep(10);
				} catch (InterruptedException e) {
				}
			}
		}
	}
}
