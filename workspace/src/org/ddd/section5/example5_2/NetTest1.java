package org.ddd.section5.example5_2;
import java.net.InetAddress;

public class NetTest1 {
	public static void main(String[] args) throws Exception{
		InetAddress address = InetAddress.getLocalHost();
		System.out.println(address.toString());
	}
}
