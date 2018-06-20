package org.ddd.section3.example3_12;

import java.util.List;

public class Tool {
	public void exchange(List<?> list, int i, int j){
//		? t = list.get(i); //不合法
		this.exchangeT(list, i, j);
	}
	public <T> void exchangeT(List<T> list, int i, int j){
		T t = list.get(i);
		list.set(i, list.get(j));
		list.set(j, t);
	}
}
