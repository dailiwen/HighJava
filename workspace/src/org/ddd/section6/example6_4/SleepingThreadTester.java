package org.ddd.section6.example6_4;

import java.util.Scanner;

//org/ddd/thread/sleep/SleepingThread.java
//�������̸߳�������û��������֣����̸߳�����������Ƿ����˱仯
public class SleepingThreadTester {
	public static void main(String[] args) {
		SleepingThreadTester sleepingThreadTester = new SleepingThreadTester();
		sleepingThreadTester.execute();
	}
	public void execute() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入：");
		this.number = scanner.nextLong();
		System.out.println("输入了：" + number);
		//启动监视线程
		Thread numberChangedMonitorThread = new Thread(
				new NumberChangedMonitor(this));
		numberChangedMonitorThread.start();
		while (number != 0) {
			System.out.println("请输入：");
			number = scanner.nextLong();
			System.out.println("输入了：" + number);
		}
	}
	private volatile long number;
	public long getNumber() {
		return number;
	}
}
// 该类负责监视 SleepingThreadTester的getNumber()方法返回的值是否变化
class NumberChangedMonitor implements Runnable {
	private SleepingThreadTester sleepingThreadTester;
	public NumberChangedMonitor(SleepingThreadTester sleepingThreadTester) {
		this.sleepingThreadTester = sleepingThreadTester;
	}
	private long preNumber;
	public void run() {
		while (true) {
			long newNumber = this.sleepingThreadTester.getNumber();
			// 如数字发生了变化,则在控制台上显示变化
			if (newNumber != preNumber) {
				System.out.printf("数字从%5d变成了%5d", preNumber, newNumber);
				this.preNumber = newNumber;
			}
			try {
				// 暂停3秒,即3000毫秒
				Thread.sleep(7000);
			} catch (InterruptedException e) {
				System.err.println("线程已经被中断");
			}
		}
	}
}
