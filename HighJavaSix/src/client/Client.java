/**
* @Title: Client.java
* @Package org.ddd.section6.example6_3
* @Description: TODO(用一句话描述该文件做什么)
* @author matao@cqrainbowsoft.com
* @date 2018年6月14日 上午9:10:49
* @version V1.0
*/
package client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;


public class Client
{
	private static BufferedReader bufferedReader;
	private static BufferedWriter bufferedWriter;	
	public static void main(String[] args) throws IOException
	{
		Socket socket = new Socket("127.0.0.1",8888);
		bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

		Scanner scanner = new Scanner(System.in);
		
		while(true)
		{
			String command = scanner.next();
			if(command.equals("quit"))
			{
				bufferedWriter.write("quit\n");
				bufferedWriter.flush();
				System.out.println("I don't want to chat again");
				return ;
			}
			else
			{
				bufferedWriter.write("msg:"+command+"\n");
				bufferedWriter.flush();
				
				String msg = bufferedReader.readLine();
				System.out.println("GF said:"+msg);
			}
		}
	}
	
}
