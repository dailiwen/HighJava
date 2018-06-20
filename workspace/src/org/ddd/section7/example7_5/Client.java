package org.ddd.section7.example7_5;

import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
	public static void main(String[] args) throws Exception{
		Socket socket = new Socket("127.0.0.1",8010); 
		OutputStream out = socket.getOutputStream();
		Person person = new Person();
		person.setName("Simple");
		ObjectOutputStream objOut = new ObjectOutputStream(out);
		objOut.writeObject(person);
		objOut.flush();
		objOut.close();
		out.close();
		socket.close();
	}}
