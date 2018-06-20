package org.ddd.section2.example2_30;

public class Bootsrap {
	public static String className = "org.ddd.section2.example2_29.Teacher";
	public static void main(String[] args){
		try {
			System.out.println("开始加载类！");
			Class clazz = Class.forName(className);
			System.out.println("类加载完成！");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
