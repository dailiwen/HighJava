package org.ddd.section7.example7_5;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws Exception{
		ServerSocket server = new ServerSocket(8010);
		Socket socket = server.accept();
		System.out.println("请求已接受");
		InputStream in = socket.getInputStream();
		ObjectInputStream objIn = new ObjectInputStream(in);
		Person person = (Person)objIn.readObject();
		System.out.println("姓名：" + person.getName());
		objIn.close();
		in.close();
		socket.close();
		server.close();
	}}
