package org.ddd.section5.example5_4;

import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(888);
		while (true) {
			Socket socket = server.accept();
			SocketHandler handler = new SocketHandler(socket);
			Thread thread = new Thread(handler);
			thread.start();
		}
	}
}
