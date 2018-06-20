/**
* @Title: SocketHandler.java
* @Package org.ddd.section6.example6_3
* @Description: TODO(用一句话描述该文件做什么)
* @author matao@cqrainbowsoft.com
* @date 2018年6月14日 上午8:58:50
* @version V1.0
*/
package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;
 
public class SocketHandler implements Runnable
{
	private Socket socket;
	private BufferedReader bufferedReader;
	private BufferedWriter bufferedWriter;
	public SocketHandler(Socket socket) throws IOException
	{
		this.socket = socket;
		
		this.bufferedReader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
		this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
	}
	@Override
	public void run()
	{
		try
		{
			while(true)
			{
				String command = this.bufferedReader.readLine();
				if(command.startsWith("msg:"))
				{
					System.out.println(command);
					Scanner scanner = new Scanner(System.in);
					System.out.println("pleas say to BF:");
					String msg = scanner.next();
					
					bufferedWriter.write(msg+"\n");
					bufferedWriter.flush();
					
				}
				else if(command.equals("quit"))
				{
					System.out.println(Thread.currentThread().getName() +" has quited");
					return ;
				}
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
}
