package org.ddd.section5.example5_4_1.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ddd.section5.example5_4_1.client.entity.Message;

public class Server1 {
	public static void main(String[] args) throws Exception {
		Server1 server = new Server1();
		server.start();
	}
	public List<String> registUserNames = new ArrayList<String>();
	public Map<String,User> users = new HashMap<String,User>();
	private void start()
	{
		ServerSocket server;
		try {
			server = new ServerSocket(888);
			while (true) {
				Socket socket = server.accept();
				User user = new User(socket,this);
				Thread thread = new Thread(user);
				thread.start();
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public void sendMessage2User(String toUserName, Message message)
	{
		User toUser = this.users.get(toUserName);
		toUser.sendMessage(message);
	}
}
