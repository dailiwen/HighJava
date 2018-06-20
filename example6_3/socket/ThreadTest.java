/**
* @Title: ThreadTest.java
* @Package org.ddd.section6.example6_3
* @Description: TODO(用一句话描述该文件做什么)
* @author matao@cqrainbowsoft.com
* @date 2018年6月14日 上午8:43:08
* @version V1.0
*/
package socket;

class TestRun implements Runnable
{

	private int i =0;
	@Override
	public void run()
	{
		System.out.println(Thread.currentThread().getName()+" "+i);
	}
	
}
class TestThread extends Thread
{

	private int i =0;
	@Override
	public void run()
	{
		System.out.println(Thread.currentThread().getName()+" "+i);
	}
	
}

public class ThreadTest
{
	
	/** 
	 * @Title: main 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param args 
	 * @return void 
	 */
	public static void main(String[] args)
	{
		Thread thread = new Thread(new TestRun());
		thread.start();

		thread = new Thread(new TestRun());
		thread.start();
				
		thread = new TestThread();
		thread.start();
		
		System.out.println(Thread.currentThread().getName());
	}
	
	
}
