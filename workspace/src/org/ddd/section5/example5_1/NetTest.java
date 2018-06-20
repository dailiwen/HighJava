package org.ddd.section5.example5_1;
import java.net.InetAddress;

public class NetTest {
	public static void main(String[] args) throws Exception {
		InetAddress address = InetAddress.getByName("localhost");
		System.out.println("========获取新浪的IP地址========");
		System.out.println(address.toString());
		InetAddress[] addresses = InetAddress.getAllByName("www.sina.com.cn");
		System.out.println("======获取新浪的IP地址列表=======");
		for(InetAddress add : addresses){
			System.out.println(add.toString());
		}
	}
}
