package org.ddd.section7.example7_12;

public class Boy {
	
	private Gift gift;

	public Gift getGift() {
		return gift;
	}

	public void setGift(Gift gift) {
		this.gift = gift;
	}
	public void sendGit(){
		gift.makeSbHappy();
	}
}
