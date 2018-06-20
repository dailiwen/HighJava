package org.ddd.section5.example5_5;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketAddress;

public class Server {
	public static void main(String[] args) {
		try {
			InetAddress ip = InetAddress.getLocalHost();
			int port = 8888;
			// 创建接收方的套接字，并制定端口号和IP地址
			DatagramSocket getSocket = new DatagramSocket(port, ip); // 确定数据报接受的数据的数组大小
			byte[] buf = new byte[1024]; // 创建接受类型的数据报，数据将存储在buf中
			DatagramPacket getPacket = new DatagramPacket(buf, buf.length); // 通过套接字接收数据
			getSocket.receive(getPacket);
			String getMes = new String(buf, 0, getPacket.getLength());
			System.out.println("对方发送的消息：" + getMes);
			InetAddress sendIP = getPacket.getAddress();
			int sendPort = getPacket.getPort();
			System.out.println("对方的地址是：" + sendIP.getHostAddress() + ":"
					+ sendPort);
			// 通过数据报得到发送方的套接字地址
			SocketAddress sendAddress = getPacket.getSocketAddress();
			String feedback = "接收方说：我收到了！";
			byte[] backBuf = feedback.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(backBuf,
					backBuf.length, sendAddress);
			getSocket.send(sendPacket);
			getSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
