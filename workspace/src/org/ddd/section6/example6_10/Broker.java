package org.ddd.section6.example6_10;

//org/ddd/thread/unsynchstock/Broker.java
public class Broker extends Thread {
	private long dealMaxStocks; //允许的最大交易数量
	private int accountCount;
	private StockMarket stockMarket; 
	private int brokerId ; 
	public Broker(StockMarket stockMarket,int brokerId, long dealMaxStocks)
	{
		this.stockMarket = stockMarket;
		this.brokerId = brokerId;
		this.dealMaxStocks = dealMaxStocks; 
	}	
	public void run(){
		while(true)
		{
			//Broker只代理一个股票帐户,即卖家帐户
			int fromAccount = this.brokerId;
			int toAccount = 0;
			do{
				toAccount = (int)(this.stockMarket.getAccountCount() *Math.random());
			}
			while(toAccount == fromAccount);			
			//交易的数量不能大于允许的最大交易数量
			long stocks = (long)(this.dealMaxStocks * Math.random());
			//向市场提交交易请求
			this.stockMarket.deal(fromAccount, toAccount, stocks);
			try {
				Thread.sleep((long)(10 * Math.random()));
			} catch (InterruptedException e){
			}
		}
	}
}