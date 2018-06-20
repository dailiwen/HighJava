package org.ddd.section6.example6_9;

import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//org/ddd/thread/primenumber/PrimeNumberCallableApp.java
public class PrimeNumberCallableApp {
	public static void main(String[] args) 
	{
		PrimeNumberCallableApp primeNumberThreadApp = new PrimeNumberCallableApp();
		primeNumberThreadApp.execute();
	}
	public  void execute() {
		ExecutorService executorService = Executors.newCachedThreadPool();
		//创建并启动计算完成监视线程。
		PrimeNumberCalcMonitor primeNumberCalcMonitor = new PrimeNumberCalcMonitor(this.primeNumberFutures);
		primeNumberCalcMonitor.start(); 		
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入：");
		Long number = scanner.nextLong();
		System.out.println("输入了："+number);
		int testerCount = 0 ;
		while (number != 0) {
			PrimeNumberTester primeNumberTester = new PrimeNumberCallableApp.PrimeNumberTester(number);	 
			Future<Long> future = executorService.submit(primeNumberTester); 
			primeNumberFutures.put(future,number);			
			System.out.println("请输入：");
			number = scanner.nextLong();
			System.out.println("输入了："+number);
 
		}
		}
	}	
	// 用来存储异步计算的结果返回对象
	private ConcurrentHashMap<Future<Long>,Long> primeNumberFutures = new ConcurrentHashMap<Future<Long>,Long>();
	public  class PrimeNumberTester implements Callable<Long> {		
		private Long number; 
		public PrimeNumberTester(int[][] grays,int startX,int startY,int endX,int endY )
		{
			this.number = number;
		} 
		public PrimeNumberTester(Long number)
		{
			this.number = number;
		} 
		//测试输入的整数是否是质数
		public boolean isPrimeNumber(Long number) {
			Long sqrNumber = (new Double(Math.sqrt(number))).longValue();
			for (Long i = 2l; i <= sqrNumber; i++) {
				if (number % i == 0) {
					return false;
				}
			}
			return true;
		}
		//测试小于等于指定整数中质数的个数
		public Map<integer,integer> call() throws Exception {
		public Long call() throws Exception {
			Long count = 0l;
			for (Long i = 2l; i <= number; i++) {
				if (this.isPrimeNumber(i)) {
					count++;
				}
			}
			//System.out.println("["+Thread.currentThread().getName()+ "]: 计算结果：小于:" + number + " 的质数个数：" + count);	 
			return count;
		}
	}
	// 线程用来监视所有计算是否完成，如果计算完成，则显示计算的结果
	public class PrimeNumberCalcMonitor extends Thread {
		private ConcurrentHashMap<Future<Long>,Long> primeNumberFutures;
		public PrimeNumberCalcMonitor(
				ConcurrentHashMap<Future<Long>,Long>  primeNumberFutures) {
			this.primeNumberFutures = primeNumberFutures;
		}
		public void run() {
			while (true) {
				Iterator<Future<Long>> iterator = primeNumberFutures
						.keySet().iterator();
				while (iterator.hasNext()) {
					Future<Long> future = iterator.next();
					// 如果计算完成，则显示结果
					if ( future.isDone() ) {
						//显示结果
						try {
							System.out.println(" 计算结果：小于:" + this.primeNumberFutures.get(future) + " 的质数个数：" + future.get());
						} catch (InterruptedException e) {
						} catch (ExecutionException e) {
						}	
						this.primeNumberFutures.remove(future);
						continue;
					} 
					else if (future.isCancelled()) //检测计算任务是否已经取消
					{
						System.out.println(" 任务取消：计算 " + this.primeNumberFutures.get(future) + " 的任务已经取消");
						this.primeNumberFutures.remove(future);
						continue;
					}					 
				}
				try {
					this.sleep(1);
				} catch (InterruptedException e) {
				}
			}
		}
	}	
}
