package org.ddd.section3.example3_2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GenericTest {
	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<Integer>();
		List<String> list2 = new ArrayList<String>();
		List<Date> list3 = new ArrayList<Date>();
		
		list1.add(new Integer(1));
//		list1.add(new String("测试")); //编译错误
		list2.add(new String("字符串"));
		list3.add(new Date());
		
		Integer i = list1.get(0);
		String str = list2.get(0);
		Date date = list3.get(0);
		
		System.out.println("��һ�������д�ŵ������֣�" + i);
		System.out.println("�ڶ��������д�ŵ����ַ�" + str);
		System.out.println("����������д�ŵ������ڣ�" + date.toString());
	}
}
