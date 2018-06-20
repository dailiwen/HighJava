package org.ddd.section5.example5_4_1.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import org.ddd.section5.example5_4_1.client.entity.LoginMessage;
import org.ddd.section5.example5_4_1.client.entity.Message;
import org.ddd.section5.example5_4_1.client.entity.MessageMessage;
import org.ddd.section5.example5_4_1.client.entity.RegisterMessage;
import org.ddd.section5.example5_4_1.client.entity.ResultMessage;
import org.ddd.section5.example5_4_1.util.MessageParser;

public class Client {
	private Socket socket =  null;
	private PrintWriter writer = null; 
	private Scanner scanner = null;
	private String clientName = null;
	public static void main(String[] args) throws Exception{
		Client client = new Client();
		client.start();
	}
	
	public void start() throws Exception{
		this.socket = new Socket("127.0.0.1",888);
		this.writer = new PrintWriter(socket.getOutputStream());
		this.scanner = new Scanner(System.in);
	}
	private void execute()
	{
		while(true)
		{
			System.out.println("1.注册");
			System.out.println("2.登陆");
			System.out.println("3.发消息");
			
			int command = this.scanner.nextInt();
			switch(command)
			{
				case 1:
					this.register();
					break; 
				case 2:
					this.login();
					break;
				case 3: 
					this.talk();
					break; 
				default:
					
			}
		}
	}
	private void register()
	{
		System.out.println("请输入注册名称：");
		String name = this.scanner.nextLine();
		RegisterMessage registerMessage = new RegisterMessage();
		registerMessage.setName(name);
		this.sendMessage(registerMessage);
	}
	private void login()
	{
		System.out.println("请输入登录名称：");
		this.clientName = this.scanner.nextLine();
		LoginMessage loginMessage = new LoginMessage();
		loginMessage.setName(clientName);
		this.sendMessage(loginMessage);			
	}
	private void talk()
	{
		if(this.clientName == null)
		{
			System.out.println("请先登录");
			return; 
		}
		System.out.println("请输入消息（格式如     xu:您好）：");
		String messageLine = this.scanner.nextLine();
		MessageMessage messageMessage = new MessageMessage();
		String toName = messageLine.split(":")[0];
		String message = messageLine.split(":")[1]; //TODO:不好！
		messageMessage.setFrom(this.clientName);
		messageMessage.setTo(toName);
		messageMessage.setMessage(message);
		
		this.sendMessage(messageMessage);		
	}
	private void end()
	{
		this.writer.close(); 
		try {
			this.socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 		
	}
	public Message parseMessage(String message)
	{
		return MessageParser.parseMessage(message);
			
	}

	public void handleMessage(String messageString)
	{
		Message message = this.parseMessage(messageString);
		if(message instanceof MessageMessage)
		{
			this.showMessage((MessageMessage)message);
		}else if(message instanceof ResultMessage)
		{
			//TODO:
		}
	}
	private void showMessage(MessageMessage message)
	{
		System.out.println(message.getFrom() + ":"+message.getMessage());
	}
	public void sendMessage(Message message)
	{
		this.writer.println(message.toString());
	}
}
