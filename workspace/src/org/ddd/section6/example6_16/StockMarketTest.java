package org.ddd.section6.example6_16;

import java.io.IOException;
 
//org/ddd/thread/awaitstock/StockMarketTest.java
public class StockMarketTest {

	public static void main(String[] args) throws IOException {
		StockMarket stockMarket = new StockMarket(STOCK_ACCOUNT_COUNT,
				INITIAL_STOCKS);
		stockMarket.dealCount = 0;
		stockMarket.startN = System.nanoTime();

		int i;
		for (i = 0; i < BROKER_THREAD_COUNT; i++) {
			Broker broker = new Broker(stockMarket, i,INITIAL_STOCKS*2);
			broker.setDaemon(true);
			broker.setName(String.format(" broker %5d ", i));

			broker.start();
		}
		System.in.read();

	}

	public static final int BROKER_THREAD_COUNT = 3;
	public static final int STOCK_ACCOUNT_COUNT = 3;
	public static final long INITIAL_STOCKS = 10;

}
