package org.ddd.section6.example6_6;

public class ExceptionThread implements Runnable {

	// org/ddd/thread/exception/ExceptionThread.java
	public static void main(String[] args) {
		try
		{
			Thread exceptionThread = new Thread(new ExceptionThread());
			System.out.println("开始启动线程");
			exceptionThread.start();
			System.out.println("线程启动完成");
		}catch(Exception e)
		{
			
			System.out.println("eee");
		}
	}

	public void run() {
		System.out.println("线程已经开始执行任务");
		throw new RuntimeException();
	}
}