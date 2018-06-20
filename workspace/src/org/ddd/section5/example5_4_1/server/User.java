package org.ddd.section5.example5_4_1.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import org.ddd.section5.example5_4_1.client.entity.LoginMessage;
import org.ddd.section5.example5_4_1.client.entity.LogoutMessage;
import org.ddd.section5.example5_4_1.client.entity.Message;
import org.ddd.section5.example5_4_1.client.entity.MessageMessage;
import org.ddd.section5.example5_4_1.client.entity.RegisterMessage;
import org.ddd.section5.example5_4_1.util.MessageParser;

public class User implements Runnable {
	private Socket socket;
	private Server1 server = null;
	private BufferedReader reader;
	private PrintWriter writer;
	public User(Socket socket,Server1 server ) {
		this.socket = socket;
		this.server = server;
		try {
			InputStreamReader inputStreamReader = new InputStreamReader(
					this.socket.getInputStream());
			this.reader = new BufferedReader(reader);
			this.writer = new PrintWriter(this.socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void end()
	{
		try {
			this.writer.close();
			this.reader.close();
			this.socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private String clientUserName = null; 
	public void run() {
		try {

			while (true) {
				String messageLine = this.reader.readLine();
				Message message = MessageParser.parseMessage(messageLine);
				if(message instanceof RegisterMessage)
				{
					RegisterMessage registerMessage = (RegisterMessage)message;
					this.server.registUserNames.add(registerMessage.getName());
				}else if(message instanceof LoginMessage)
				{
					LoginMessage loginMessage = (LoginMessage)message;
					this.clientUserName =loginMessage.getName();
					this.server.users.put(this.clientUserName, this);
					
				}else if(message instanceof MessageMessage)
				{
					MessageMessage messageMessage = (MessageMessage)message;
					this.server.sendMessage2User(messageMessage.getTo(), messageMessage);
				}else if(message instanceof LogoutMessage)
				{
					this.server.users.remove(this.clientUserName);
					this.end();
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void sendMessage(Message message)
	{
		this.writer.println(message.toString());
	}
}
