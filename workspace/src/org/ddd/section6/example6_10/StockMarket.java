package org.ddd.section6.example6_10;

//src/org/ddd/thread/unsynchstock/StockMarket.java
public class StockMarket {
	private final Account[] accounts;
	private Long initialStocks;
	private int accountCount;

	public StockMarket(int accountCount, Long initialStocks) {
		this.accountCount = accountCount;
		this.initialStocks = initialStocks;
		accounts = new Account[accountCount];
		for (int i = 0; i < accountCount; i++) {
			accounts[i] = new Account(initialStocks);
		}
	}

	/**
	 * 股票交易
	 * 
	 * @param fromAccount
	 *            卖家帐户
	 * @param toAccount
	 *            买家帐户
	 * @param stocks
	 *            交易的股票数
	 */
	public void deal(int fromAccount, int toAccount, Long stocks) {
		// 如果交易的金额大于卖家的股票数,则放弃交易
		if (accounts[fromAccount].getStocks() < stocks)
			return;
		accounts[fromAccount].setStocks(accounts[fromAccount].getStocks()
				- stocks);
		accounts[fromAccount].setStocksSold(accounts[fromAccount]
				.getStocksSold() + stocks);
		accounts[toAccount].setStocks(accounts[toAccount].getStocks() + stocks);
		accounts[toAccount].setStocksBought(accounts[toAccount]
				.getStocksBought() + stocks);
		this.showTotalStocks();
	}
	public volatile long  startN;
	public volatile long dealCount;
	/**
	 * 显示股票总额,并测试数量是否正确。理论上说：市场的股票总量不会发生变化,并且所有卖出的总量应该等所有买入的总量
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

	public int getAccountCount() {
		return this.accounts.length;
	}
}
