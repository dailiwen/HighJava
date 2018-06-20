package org.ddd.section5.example5_4_2.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientReciever extends Thread {

	private Socket socket; 
	private BufferedReader reader = null ;
	private Client client = null; 
	public ClientReciever(Socket socket,Client client)
	{
		this.socket = socket;
		this.client = client;
		try {
			InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
			this.reader = new BufferedReader(inputStreamReader);
		} catch (IOException e) {
			System.out.println("网络联接失败，原因："+e.getMessage() + ",请检查网络");
		}

	}
	public void run()
	{
		if(this.reader == null ) return ;
		while(true)
		{
			try {
				String message = this.reader.readLine();
				this.client.handleMessage(message);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
