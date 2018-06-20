package org.ddd.section2.example2_40;

public class StringUtil {
	/*public static void main(String[] args) {
		System.out.println(StringUtil.firstCharToUp(str)); 
	}*/
	public static String firstCharToUp(String str){
		char ch[]=str.toCharArray();
		char ch1=Character.toUpperCase(ch[0]);
		ch[0]=ch1;
		String s=new String(ch);
		return s;
	}
	
	public static String firstCharToLower(String str){
		char ch[]=str.toCharArray();
		char ch1=Character.toLowerCase(ch[0]);
		ch[0]=ch1;
		String s=new String(ch);
		return s;
	}
}
