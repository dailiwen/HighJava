package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author dailiwen
 * @date 2018/06/17
 */
public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(8080);
		while (true) {
			Socket socket = serverSocket.accept();
			SocketHandler socketHandler = new SocketHandler(socket);
			Thread thread = new Thread(socketHandler);
			thread.start();
		}
	}
}
