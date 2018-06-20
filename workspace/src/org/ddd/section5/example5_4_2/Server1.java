package org.ddd.section5.example5_4_2;

import java.net.ServerSocket;
import java.net.Socket;

import org.ddd.section5.example5_4_1.util.MessageParser;

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
	private Map<String,SocketHandler> users = new HashMap<String,SocketHandler>();
	public handleMessage(String message)
	{
		if(message.startWith("<login"))
		{
			LoginMessage loginMessage = MessageParser.pareLoginMessage(message);
			users.put(loginMessage.getName(),SocketHandler);
			
		}
		
	}
}
