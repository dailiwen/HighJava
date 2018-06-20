package org.ddd.section3.example3_25;

import java.util.ArrayList;
import java.util.List;



public class GenericTest {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(3);
		Integer i = list.get(0);
	}
}

