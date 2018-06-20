package org.ddd.section6.example6_7;

//org/ddd/thread/exception/ExceptionHandlerThreadTest.java
public class ExceptionHandlerThreadTest {
	public static void main(String[] args) {
		Thread exceptionThread = new Thread(new ExceptionHandlerThread());
		System.out.println("开始启动线程0");
		exceptionThread
				.setUncaughtExceptionHandler(new UncaughtExceptionTestHandler());
		exceptionThread.start();
		System.out.println("线程0启动完成");
		Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionDefaultTestHandler());
		Thread exceptionThread1 = new Thread(new ExceptionHandlerThread());
		System.out.println("开始启动线程1");
		exceptionThread1.start();
		System.out.println("线程1启动完成");
	}
}

class ExceptionHandlerThread implements Runnable {
	public void run() {
		System.out.println("线程已经开始执行任务");
		throw new RuntimeException();
	}
}

class UncaughtExceptionTestHandler implements Thread.UncaughtExceptionHandler {
	public void uncaughtException(Thread t, Throwable e) {
		System.err.printf("线程 [%s]抛出异常,由UncaughtExceptionTestHandler进行处理%n",
				t.getName());
	}
}

class UncaughtExceptionDefaultTestHandler implements
		Thread.UncaughtExceptionHandler {
	public void uncaughtException(Thread t, Throwable e) {
		System.err.printf(
				"线程 [%s]抛出异常,由UncaughtExceptionDefaultTestHandler进行处理%n",
				t.getName());
	}
}