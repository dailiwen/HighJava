package org.simpletomcat;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
 	
	private boolean live = true;
	/**
	 * 服务启动方法
	 * @throws Exception
	 */
	public void start() throws Exception {
		
		ServerSocket server = new ServerSocket(8010); //启动Socket侦听8010端口
		System.out.println("服务器已经启动，等请求....");
		while(live){ //如果 live为true,一直等等待浏览器的请求			
			Socket socket = server.accept(); //等待浏览器的请求
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			Request request = new Request(in); //把请求封装成 Request对象
			System.out.println("收到请求:"+request.getUri());
			if(Constants.SHUTDOWN.equals(request.getUri())){ //如果请求为 shutdown ，则停止服务
				this.stop(); //停止服务
				continue;
			}
			Response response = new Response(request,out); //创建响应对象
			//根据请求的uri查找 ServletWrapper
			ServletWrapper servletWrapper = Mapper.getMapper().map(request.getUri());
			if(servletWrapper == null)
			{
				String errorMessage = "<h1>File Not Found</h1>";	
				PrintWriter printWriter =  response.getWriter();				
				printWriter.write(errorMessage); 
				printWriter.flush();
				System.err.println("没有查到对应的 servlet，Uri:" +request.getUri());
				
			}
			else
			{
				//调用serlvet，处理请求
				servletWrapper.invoke(request, response);
			}
			socket.close(); //关闭Socket连接 
		}
		server.close(); // 关闭服务Socket,停止 侦听8010端口
	}
	
	public void stop(){
		this.live = false;
	}
	/**
	 * 初始化服务：设置servlet的映射
	 */
	public void initialize()
	{
		 
		Mapper.getMapper().addPattern("/*.html", new ServletWrapper("org.simpletomcat.FileServlet"));
		Mapper.getMapper().addPattern("/*.htm", new ServletWrapper("org.simpletomcat.FileServlet"));
		Mapper.getMapper().addPattern("/*.jpg", new ServletWrapper("org.simpletomcat.FileServlet"));
		Mapper.getMapper().addPattern("/*.jpeg", new ServletWrapper("org.simpletomcat.FileServlet"));
		Mapper.getMapper().addPattern("/hello", new ServletWrapper("org.simpletomcat.HelloWorld"));
			
	}

}
