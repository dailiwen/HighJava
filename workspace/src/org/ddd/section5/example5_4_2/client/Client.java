package org.ddd.section5.example5_4_2.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import org.ddd.section5.example5_4_1.client.entity.RegisterMessage;
import org.ddd.section5.example5_4_1.client.entity.ResultMessage;

public class Client {
	public static void main(String[] args) throws Exception{
	 
		Client client = new Client();
		client.execute();
	}
	private PrintWriter writer;
	private Scanner scanner = new Scanner(System.in);
	private String userName = null;
	public void execute() throws Exception{
		Socket socket = new Socket("127.0.0.1",888);
		
		this.writer = new PrintWriter(socket.getOutputStream());
		
		while(true)
		{
			System.out.println("请输入命令：");
			System.out.println("1.请注册");
			System.out.println("2.请登录");
			System.out.println("3.发送消息");
			System.out.println("4.注销");
			
			int commandNo= this.scanner.nextInt();
			
			switch(commandNo)
			{
			case 1:
				System.out.println("请输入用户名：");
				this.userName = this.scanner.nextLine();
				RegisterMessage registerMessage = new RegisterMessage();
				registerMessage.setName(this.userName);
				this.writer.println(registerMessage.toString());
				break;
			case 2:
				this.writer.println("<login name=\""+this.userName+"\"/>");
				break;
			case 3:
				//：<message from=”xu” to=”zhang” message=”this is a test”>  
				System.out.println("请输入消息，格式如：zhang:this is a test :");
				String message = this.scanner.nextLine();
				String fromUserName = message.split(":")[0];
				String content = message.split(":")[1];
				this.writer.println("<message from=”xu” to=”zhang” message=”this is a test”>" );
				break;
			case 4:
				break;
			default:
				System.out.println("命令：" + commandNo+ " 不正确，输入的命令不正确");
			}
		}
		
		writer.close(); 
		socket.close(); 
	}
 
	public void handleMessage(String message)
	{
		if(message.startsWith("<result"))
		{
			ResultMessage resultMessage =this.parseResultMessage(message);
			if(resultMessage.getCommand().equals("register"))
			{
				if(resultMessage.getState().equals("ok"))
				{
					System.out.println("注册成功");
				}
				else
				{
					//TODO:
				}
			}
			else if(resultMessage.getCommand().equals("login"))
			{
				if(resultMessage.getState().equals("ok"))
				{
					System.out.println("登陆成功");
				}
				else
				{
					//TODO:
				}
			}
		} else if(message.startsWith("<message"))
		{
			//parse 
		}
		System.out.println(message);
	}
	public ResultMessage parseResultMessage(String message)
	{
		ResultMessage resultMessage = new ResultMessage();
		
		String value = this.parseMessageProperty(message, "command");
		resultMessage.setCommand(value);

		value = this.parseMessageProperty(message, "state");
		resultMessage.setState(value);
		
		return resultMessage;
		
	}
	public ResultMessage parseResultMessage(String message)
	{
		
	}
	private String parseMessageProperty(String message,String propertyName)
	{
		int propertyIndex = message.indexOf(propertyName);
		int valueBeginIndex = message.indexOf("\"", propertyIndex);
		int valueEndIndex = message.indexOf("\"", valueBeginIndex+1);
		
		String value = message.substring(valueBeginIndex, valueEndIndex) ;
		
		return value;
	}
}
