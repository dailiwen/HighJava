package org.ddd.section5.example5_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class Server {
	public static void main(String[] args) throws Exception{
		ServerSocket server = new ServerSocket(888);
		Socket socket = server.accept();
		//Socket socketCurrent = server.accept();
 		
		InputStreamReader reader = new InputStreamReader(socket.getInputStream());
		BufferedReader buffer_reader=new BufferedReader(reader);
		PrintWriter writer=new PrintWriter(socket.getOutputStream());
		
		String request = buffer_reader.readLine();
		
		System.out.println("Client say:" + request);
		
		String line="Hello,too!";
		writer.println(line);
		writer.flush();

		writer.close();
		buffer_reader.close();
		socket.close();
		server.close();
	}
}
