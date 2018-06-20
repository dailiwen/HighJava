package org.ddd.section6.example6_3;

//org/ddd/thread/primenumber/PrimeNumberThreadPriorityApp.java
public class PrimeNumberThreadPriorityApp {
	public static void main(String[] args) 
	{
		System.out.println(Thread.currentThread().getName());
		PrimeNumberThreadPriorityApp primeNumberThreadApp = new PrimeNumberThreadPriorityApp();
		primeNumberThreadApp.execute();
		int i =100;
		while(i-- > 0){};
	}
	public  void execute() {
		for(int i= Thread.MIN_PRIORITY;i <= Thread.MAX_PRIORITY; i++) {
			long number = 1234567l;
			PrimeNumberTester primeNumberTester = new PrimeNumberThreadPriorityApp.PrimeNumberTester(number);
			primeNumberTester.setName("primeNumberTester " + i);
			primeNumberTester.setPriority(i);
			primeNumberTester.start(); 
		}
	}	
	public  class PrimeNumberTester extends Thread {
		
		private Long number; 
		public PrimeNumberTester(Long number)
		{
			this.number = number;
		}
		/**
		 * 测试输入的整数是否是质数
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
		 */
		public void run(){
			long nano = System.nanoTime(); 
			Long count = 0l;
			for (Long i = 2l; i <= number; i++) {
				if (this.isPrimeNumber(i)) {
					count++;
				}
			}
		    nano = System.nanoTime()-nano; 
			System.out.printf("[%s] ,线程优先级：%2d, 耗时(纳秒)：%10d %n", Thread.currentThread().getName(),Thread.currentThread().getPriority(),nano); 
		} 
	}	
}
