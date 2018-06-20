package org.ddd.section6.example6_15;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.ddd.section6.example6_12.Account;

//org/ddd/thread/awaitstock/StockMarket.java
public class StockMarket {
	private final Account[] accounts ;
	private Long initialStocks;
	private int accountCount;
	private Lock stockMarketLock = new ReentrantLock();
	private Condition insufficientCondition = stockMarketLock.newCondition();
	public StockMarket(int accountCount,Long initialStocks)
	{
		this.accountCount = accountCount; 
		this.initialStocks = initialStocks;
		accounts = new Account[accountCount];
		for(int i = 0; i<accountCount; i++)
		{
			accounts[i] = new Account(initialStocks);
		}
	}
	/**
	 * 股票交易
	 * @param fromAccount 卖家帐户
	 * @param toAccount 买家帐户
	 * @param stocks 交易的股票数
	 */
	//public synchronized void  deal(int fromAccount,int toAccount,Long stocks)
	public  void  deal(int fromAccount,int toAccount,Long stocks)
	{
		this.stockMarketLock.lock();
		try
		{
			//如果交易的金额大于卖家的股票数,则放弃交易
			while(accounts[fromAccount].getStocks() < stocks) 
			{
				try {
					 System.err.printf("阻塞：%s ,卖家：%5d,买家：%5d,卖家股票数:%15d,交易金额：%15d %n",Thread.currentThread().getName(), fromAccount, toAccount, accounts[fromAccount].getStocks(),stocks);
					this.insufficientCondition.await();
				} catch (InterruptedException e) {
				}
			}
			accounts[fromAccount].setStocks(accounts[fromAccount].getStocks() - stocks);
			accounts[fromAccount].setStocksSold(accounts[fromAccount].getStocksSold() + stocks);
			accounts[toAccount].setStocks(accounts[toAccount].getStocks() + stocks);
			accounts[toAccount].setStocksBought(accounts[toAccount].getStocksBought() + stocks); 
			this.showTotalStocks();
			
			this.insufficientCondition. signalAll ();
		}
		finally
		{
			this.stockMarketLock.unlock();
		}				 
	}
	public volatile long  startN;
	public volatile long dealCount;
	/**
	 * 显示股票总额,并测试数量是否正确
	 */
	public void showTotalStocks() {
		long stocks = 0l;
		long stocksBought = 0l;
		long stocksSold = 0l;

		for (Account account : accounts) {
			stocks += account.getStocks();
			stocksBought += account.getStocksBought();
			stocksSold += account.getStocksSold();
		}
		String errorMessage = "";
		if (stocks != this.accountCount * this.initialStocks) {
			errorMessage += " 总数不正确 ";
		}
		if (stocksBought != stocksSold) {
			errorMessage += " 买卖之和与总数不相等 ";
		}
		System.out.printf("总股票数:%15d 卖出总数%15d 买入总数:%15d %s %n  ", stocks,
				stocksSold, stocksBought, errorMessage);
	}
	   
	   public int getAccountCount()
	   {
		   return this.accounts.length;
	   }
}
