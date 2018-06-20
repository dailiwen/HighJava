package org.ddd.section5.example5_6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws Exception {

		ServerSocket server = new ServerSocket(8010);
		Socket socket = server.accept();

		BufferedReader br = new BufferedReader(new InputStreamReader(
				socket.getInputStream()));
		PrintWriter pw = new PrintWriter(socket.getOutputStream());

		char[] buffer = new char[1024];
		int len = br.read(buffer);
		StringBuffer reqStr = new StringBuffer();
		for (int i = 0; i < len; i++) {
			reqStr.append(buffer[i]);
		}
		System.out.print(reqStr.toString());
		pw.println("<h1>Hello World!</h1>");
		pw.flush();
		socket.close();
	}
}
