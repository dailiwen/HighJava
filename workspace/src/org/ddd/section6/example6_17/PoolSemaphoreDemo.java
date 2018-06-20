package org.ddd.section6.example6_17;

import java.util.concurrent.Semaphore;

//org/ddd/thread/synchronizer/PoolSemaphoreDemo.java
public class PoolSemaphoreDemo {
	private static final int MAX_AVAILABLE = 5;
	private final Semaphore available = new Semaphore(MAX_AVAILABLE, true);

	public static void main(String[] args) {
		final PoolSemaphoreDemo pool = new PoolSemaphoreDemo();
		Runnable runner = new Runnable() {
			public void run() {
				try {
					Object o;
					o = pool.getItem();

					Thread.sleep(1000);// 表示该线程睡眠1秒钟，即改线程不去竞争cpu处理时间1秒钟

					pool.putItem(o);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		// 将上述线程重复执行10次
		for (int i = 0; i < 10; i++) {
			Thread t = new Thread(runner, "thread" + i);
			t.start();
		}
	}

	/**
	 * 从字符串池中取得最近一个可用的字符串资源，同时将标志位池中的状态设为true，表示有线程正在使用。
	 */
	public Object getItem() throws InterruptedException {
		System.out.println("线程：" + Thread.currentThread().getName()
				+ "开始从字符串资源池中取数据");
		available.acquire();
		return getNextAvailableItem();
	}

	/**
	 * 将x对应的标志位池的状态修改为false，然后释放该字符串资源供其他线程读取
	 */
	public void putItem(Object x) {
		if (markAsUnused(x)) {
			available.release();
			System.out.println("线程：" + Thread.currentThread().getName()
					+ "已经释放资源");
		}
	}

	// 需要循环取的字符串池
	protected Object[] items = { "1111", "2222", "3333", "4444", "5555" };
	// 字符串池对应的标志位池，如果为true表示正在使用，其他线程不可用。如果为false，则表示其他线程可以用
	protected boolean[] used = new boolean[MAX_AVAILABLE];
	/**
	 * 根据标志位数组得到items中有效的字符串
	 */
	protected synchronized Object getNextAvailableItem() {
		for (int i = 0; i < MAX_AVAILABLE; ++i) {
			if (!used[i]) {
				used[i] = true;
				System.out.println("线程：" + Thread.currentThread().getName()
						+ "从字符串池中取得资源：" + items[i]);
				return items[i];
			}
		}
		return null;
	}

	/**
	 * 根据item将对应位置的标志位的值改为false
	 */
	protected synchronized boolean markAsUnused(Object item) {
		for (int i = 0; i < MAX_AVAILABLE; ++i) {
			if (item == items[i]) {
				if (used[i]) {
					used[i] = false;
					System.out.println("线程：" + Thread.currentThread().getName()
							+ "开始向字符串池中放入资源：" + items[i]);
					return true;
				} else
					return false;
			}
		}
		return false;
	}
}