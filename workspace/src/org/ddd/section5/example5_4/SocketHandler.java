package org.ddd.section5.example5_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketHandler implements Runnable {
	private Socket socket;

	public SocketHandler(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		try {
			InputStreamReader reader = new InputStreamReader(
					socket.getInputStream());
			BufferedReader buffer_reader = new BufferedReader(reader);
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			while (true) {
					
				String client = "<" + socket.getInetAddress().toString() + " : "
						+ socket.getPort() + ">";
				String request = buffer_reader.readLine();
				if( request == null )
				{
					continue;
				}
				if(request.startsWith("<loginout"))
				{
					break;
				}
				
	
				System.out.println(client + " say:" + request);
				String line = client + " Hello,too!";
				writer.println(line);
	
				writer.flush();
			}
			writer.close();
			buffer_reader.close();
			socket.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
