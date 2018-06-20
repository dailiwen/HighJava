package org.ddd.section3.example3_1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GenericTest {
	public static void main(String[] args) {
		List list1 = new ArrayList();
		List list2 = new ArrayList();
		List list3 = new ArrayList();
		list1.add(new Integer(1));
		list2.add(new String("字符串"));
		list3.add(new Date());
		
		Integer i = (Integer)list1.get(0);
		String str = (String)list2.get(0);
		Date date = (Date)list3.get(0);
		
		System.out.println("第一个数组中存放的是数字：" + i);
		System.out.println("第二个数组中存放的是字符串：" + str);
		System.out.println("第三个数组中存放的是日期：" + date.toString());
	}
}
