package org.ddd.section6.example6_13;

  
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


//org/ddd/thread/threadlocal/ThreadLocalApp.java
public class ThreadLocalApp {
	public static void main(String[] args) 
	{
		ThreadLocalApp threadLocalApp = new ThreadLocalApp();
		threadLocalApp.execute();
	}
	public  void execute() {
		RequestHandler requestHandler = new RequestHandler("ddd");	 
		requestHandler.start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {}		
		
		requestHandler = new RequestHandler("aaa");	 
		requestHandler.start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {}		
		
		requestHandler = new RequestHandler();	 

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {}		
		 
	}	
	public  class RequestHandler extends Thread {	
		private String user = null;
		public RequestHandler(){}
		public RequestHandler(String user)
		{
			this.user = user;
		}
		public void run(){
			UserManager.setUser(this.user);
			//登录检查
			Permission permission = new Permission();
			if( ! permission.isLogined())
			{
				System.err.printf("线程：[%s],没有登录,将退出%n",Thread.currentThread().getName());
				return;
			 
			}

			//显示登录用户
			DisplayUI displayUI = new DisplayUI();
			displayUI.display();
		}
	}
	public static class UserManager
	{
		private static final ThreadLocal<String> threadUser = new ThreadLocal<String>() ; 
		public static void setUser(String user)
		{
			threadUser.set(user);
		}
		public static String getUser()
		{
			return threadUser.get();
		}
		
	}
	//登录检查
	public class Permission
	{
		public boolean isLogined()
		{
			String user = UserManager.getUser();
			if (user != null)
			{
				System.out.printf("线程：[%s][Permission],登录的用户名:%s %n",Thread.currentThread().getName(),user);	
				return true;
			}
			else
			{
				System.err.printf("线程：[%s][Permission],没有登录,将退出%n",Thread.currentThread().getName());
				return false;
			}
		}
	}
	//显示登录的用户
	public class DisplayUI
	{
		public void display()
		{
			String user = UserManager.getUser();
			System.out.printf("线程：[%s][DisplayUI],登录的用户名:%s %n",Thread.currentThread().getName(),user);				
		}
	}
}
