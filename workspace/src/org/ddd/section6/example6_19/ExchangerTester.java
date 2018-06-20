package org.ddd.section6.example6_19;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Exchanger;

//org/ddd/thread/synchronizer/ExchangerTester.java
/**
 * 两个线程间的数据交换
 */
@SuppressWarnings("all")
public class ExchangerTester {

	private static final Exchanger ex = new Exchanger();

	class DataProducer implements Runnable {
		private List list = new ArrayList();

		public void run() {
			System.out.println("生产者开始运行");
			System.out.println("开始生产数据");
			for (int i = 1; i <= 5; i++) {
				System.out.println("生产了第" + i + "个数据，耗时1秒");
				list.add("生产者" + i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("生产数据结束");
			System.out.println("开始与消费者交换数据");
			try {
				// 将数据准备用于交换，并返回消费者的数据
				list = (List) ex.exchange(list);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("结束与消费者交换数据");
			System.out.println("生产者与消费者交换数据后，再生产数据");
			for (int i = 6; i < 10; i++) {
				System.out.println("交换后生产了第" + i + "个数据，耗时1秒");
				list.add("交换后生产者" + i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("开始遍历生产者交换后的数据");
			// 开始遍历生产者的数据
			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				System.out.println(iterator.next());
			}
		}
	}

	class DataConsumer implements Runnable {
		private List list = new ArrayList();

		public void run() {
			System.out.println("消费者开始运行");
			System.out.println("开始消费数据");
			for (int i = 1; i <= 5; i++) {
				System.out.println("消费了第" + i + "个数据");
				// 消费者产生数据，后面交换的时候给生产者
				list.add("消费者" + i);
			}
			System.out.println("消费数据结束");
			System.out.println("开始与生产者交换数据");
			try {
				// 进行数据交换，返回生产者的数据
				list = (List) ex.exchange(list);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("消费者与生产者交换数据后，再消费数据");
			for (int i = 6; i < 10; i++) {
				System.out.println("交换后消费了第" + i + "个数据");
				list.add("交换后消费者" + i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("开始遍历消费者交换后的数据");
			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				System.out.println(iterator.next());
			}
		}
	}

	public static void main(String args[]) {
		ExchangerTester exchangerTester = new ExchangerTester();
		new Thread(exchangerTester.new DataProducer()).start();
		new Thread(exchangerTester.new DataConsumer()).start();
	}
}