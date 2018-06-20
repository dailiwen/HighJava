package org.ddd.section6.example6_15;

public class Broker extends Thread {
	private long dealMaxStocks;
	private int accountCount;
	private StockMarket stockMarket; 
	private int brokerId ; 
	public Broker(StockMarket stockMarket,int brokerId, long dealMaxStocks)
	{
		this.stockMarket = stockMarket;
		this.brokerId = brokerId;
		this.dealMaxStocks = dealMaxStocks; 
	}
	
	public void run()
	{
		while(true)
		{
			int fromAccount = this.brokerId;
			int toAccount = 0;
			do{
				toAccount = (int)(this.stockMarket.getAccountCount() *Math.random());
			}
			while(toAccount == fromAccount);
			
			long stocks = (long)(this.dealMaxStocks * Math.random());
			this.stockMarket.deal(fromAccount, toAccount, stocks);
			try {
				Thread.sleep((long)(10 * Math.random()));
			} catch (InterruptedException e) {
		 
			}
		}
	}
}
