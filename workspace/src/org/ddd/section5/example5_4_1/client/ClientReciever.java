package org.ddd.section5.example5_4_1.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientReciever extends Thread {

	private Socket socket;
	private BufferedReader reader;
	private Client client = null; 
	public ClientReciever(Socket socket,Client client)
	{
		this.socket = socket;
		this.client = client;
		try {
			InputStreamReader inputStreamReader = new InputStreamReader(this.socket.getInputStream());
			this.reader = new BufferedReader(inputStreamReader);
		} catch (IOException e) {
			System.out.println("网络联接出错，请检查网络，或者确认服务器是否启动。原因是："+e.getMessage());
		}
		
	}
	public void run()
	{
		while(true)
		{
			try {
				String message = this.reader.readLine();
				this.client.handleMessage(message);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
		
	}
}
