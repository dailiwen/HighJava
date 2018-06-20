package org.ddd.section3.example3_14;

public class Sortor {
	public <V extends Integer> V getMax(V x, V y){ 
		if(x > y){
			return x;
		}else{
			return y;
		}
	}
}
