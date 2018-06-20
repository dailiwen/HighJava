package org.ddd.section6.example6_10;

//org/ddd/thread/unsynchstock/Account.java
public class Account {
	private Long stocksBought = 0l;//帐户已经卖出的股票数量
	private Long stocksSold = 0l;//帐户已经买入的股票数量
	private Long stocks = 0l; //帐户当前股票数量
	public Long getStocksBought() {
		return stocksBought;
	}
	public void setStocksBought(Long stocksBought) {
		this.stocksBought = stocksBought;
	}
	public Long getStocksSold() {
		return stocksSold;
	}
	public void setStocksSold(Long stocksSold) {
		this.stocksSold = stocksSold;
	}
	public Long getStocks() {
		return stocks;
	}
	public void setStocks(Long stocks) {
		this.stocks = stocks;
	}
	public Account(Long stocks) {
		super();
		this.stocks = stocks;
	}
}
