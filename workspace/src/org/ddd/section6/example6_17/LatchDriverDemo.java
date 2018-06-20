package org.ddd.section6.example6_17;

import java.util.concurrent.CountDownLatch;

//org/ddd/thread/synchronizer/LatchDriverDemo.java
/**
 * 该demo主要想要做的事就是：在主线程中创建N个支线程，让支线程等待主线程将开关计数器startSignal打开。
 * 而当主线程打开startSignal开关后，主线程要等待计数器doneSignal归零，
 * 而doneSignal计数器归零依赖于每个支线程为主线程的计数器减一。
 * 所以当主线程打开开关后，支线程才能运行完毕，而只有支线程全部运行完毕，才能打开主线程的计数器。 这样整个程序才能走完
 */
public class LatchDriverDemo {
	public static final int N = 5;

	public static void main(String[] args) throws InterruptedException {
		// 用于向工作线程发送启动信号
		CountDownLatch startSignal = new CountDownLatch(1);
		// 用于等待工作线程的结束信号
		CountDownLatch doneSignal = new CountDownLatch(N);
		// 创建启动线程
		System.out
				.println("开始创建并运行分支线程，且分支线程启动startSignal计数器，等待主线程将startSignal计数器打开");
		for (int i = 0; i < N; i++) {
			new Thread(new LatchWorker(startSignal, doneSignal), "t" + i)
					.start();
		}
		// 得到线程开始工作的时间
		long start = System.nanoTime();
		// 主线程，递减开始计数器，让所有线程开始工作
		System.out.println("主线程" + Thread.currentThread().getName()
				+ "将startSignal计数器打开");
		startSignal.countDown();
		// 主线程阻塞，等待所有线程完成
		System.out.println("主线程" + Thread.currentThread().getName()
				+ "开始倒计时5个数");
		doneSignal.await();
		/*
		 * 为什么说运行到下一句，所有线程就全部运行完毕了呢。 因为主线程要倒计时5个数,而产生的5个支线程在运行完毕前会将主线程的计数器减一，
		 * 所以如果所有支线程运行完毕了 ，主线程才能继续运行主线程的最后一个打印程序
		 */
		System.out.println("所有线程运行完毕");
	}
}

class LatchWorker implements Runnable {
	// 用于等待启动信号
	private final CountDownLatch startSignal;
	// 用于发送结束信号
	private final CountDownLatch doneSignal;

	LatchWorker(CountDownLatch startSignal, CountDownLatch doneSignal) {
		this.startSignal = startSignal;
		this.doneSignal = doneSignal;
	}

	public void run() {
		try {
			// 一旦调用await()方法，该线程就会开始阻塞。知道计数器startSignal为0
			System.out.println(Thread.currentThread().getName()
					+ " 开始调用await()方法，等待计数器startSignal被主线程打开");
			startSignal.await();
			doWork();
			System.out
					.println(Thread.currentThread().getName() + " 将主线程的计数器减一");
			doneSignal.countDown();// 发送完成信号
		} catch (InterruptedException ex) {
		}
	}

	void doWork() {
		System.out.println(Thread.currentThread().getName()
				+ " 的计数器被打开，分支线程开始运行");
		int sum = 0;
		for (int i = 0; i < 10000; i++) {
			sum += i;
		}
	}
}