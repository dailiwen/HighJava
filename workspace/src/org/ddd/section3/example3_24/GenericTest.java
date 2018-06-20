package org.ddd.section3.example3_24;

import java.util.ArrayList;
import java.util.List;



public class GenericTest {
	public static void main(String[] args) {
		List  list = new ArrayList ();
		list.add("ddd");
		Integer i = (Integer)list.get(0);
	}
}

public static void main(String[] args) {
	List list = new ArrayList();
	list.add((Integer)3);
	Integer i = (Integer)list.get(0);
}

