package org.ddd.section3.example3_12;

import java.util.ArrayList;
import java.util.List;


public class GenericTest<T> {
	public static void  main(String[] args){
		Tool tool = new Tool();
		List<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(5);
		tool.exchange(list, 0, 1);
	}
}
