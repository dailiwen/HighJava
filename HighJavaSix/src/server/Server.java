/**
* @Title: Server.java
* @Package org.ddd.section6.example6_3
* @Description: TODO(用一句话描述该文件做什么)
* @author matao@cqrainbowsoft.com
* @date 2018年6月14日 上午8:56:29
* @version V1.0
*/
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
	
 
	public static void main(String[] args) throws IOException
	{
		ServerSocket serverSocket = new ServerSocket(8888);
		while(true)
		{
			System.out.println("waiting for a BF...");
			Socket socket = serverSocket.accept();
			SocketHandler socketHandler = new SocketHandler(socket);
			Thread thread =new Thread(socketHandler);
			thread.start();
		}
		
	}
	
}
