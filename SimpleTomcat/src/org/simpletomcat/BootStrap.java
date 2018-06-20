package org.simpletomcat;

public class BootStrap {
	public static void main(String[] args) throws Exception{
		Server server = new Server();
		//实始化服务器
		System.out.println("开始初始化服务器.....");
		server.initialize();
		System.out.println("服务器实始化完成.....");
		System.out.println("开始启动服务器.....");
		server.start();
		System.out.println("服务器停止.....");
	}
}
