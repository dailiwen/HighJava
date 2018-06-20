package org.ddd.section6.example6_14;

public class Account {
	private Long stocksBought = 0l;
	private Long stocksSold = 0l;
	private Long stocks = 0l;
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
