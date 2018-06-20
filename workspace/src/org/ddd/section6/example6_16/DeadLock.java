package org.ddd.section6.example6_16;

//src/org/ddd/thread/deadlock/DeadLock.java
public class DeadLock implements Runnable {
	// 标示是先拿叉还是先拿刀
	private boolean flag;
	private static Object fork = new String("fork");
	private static Object knife = new String("knife");

	public void run() {
		if (flag) {
			// 给对象fork上锁
			System.out.printf("[%s] 试图获得叉%n", Thread.currentThread().getName());
			synchronized (fork) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.printf("[%s] 成功获得叉,试图获得刀%n", Thread.currentThread()
						.getName());
				synchronized (knife) {
					System.out.printf("[%s] 成功获得刀%n", Thread.currentThread()
							.getName());
				}
			}
		} else {
			// 给对象knife上锁
			System.out.printf("[%s] 试图获得刀%n", Thread.currentThread().getName());
			synchronized (knife) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// 给对象fork上锁
				System.out.printf("[%s] 成功获得刀,试图获得叉%n", Thread.currentThread()
						.getName());
				synchronized (fork) {
					System.out.printf("[%s] 成功获得叉%n", Thread.currentThread()
							.getName());
				}
			}
		}
		System.out
				.printf("[%s] 就餐完成,放回刀、叉%n", Thread.currentThread().getName());
	}

	public static void main(String[] args) {
		DeadLock person1 = new DeadLock();
		DeadLock person2 = new DeadLock();
		person1.flag = true;
		person2.flag = false;
		Thread thread1 = new Thread(person1);// 上锁的顺序
		thread1.setName("person1");
		Thread thread2 = new Thread(person2);// 上锁的顺序
		thread2.setName("person2");
		thread1.start();
		thread2.start();
	}
}