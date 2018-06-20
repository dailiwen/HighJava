package org.simpletomcat;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileServlet extends HttpServlet {

	/**
	 * 响应请求时执行的方法。该方法以请求的URI指定的文件内容作为响应
	 */
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException  
	{
 
    	
    	String path = request.getRequestURI();
     
    	int pos =  path.lastIndexOf(".");
    	String extention = null;
    	if(pos>0)
    	{
    		extention =path.substring(pos);
    		extention = extention.toLowerCase();
    	}
    	path  = Constants.WEB_ROOT + File.separator + path;
    	
		if(path != null && path.length() > 0){
 
			File file = new File(path);
			
			if(!file.exists()){
				file = new File(Constants.WEB_ROOT + "/404.html");
			}
			try {
				this.report(file,response);
 					
			} catch (Exception e) {
				 throw new ServletException("error occured when read file "+path,e );
			}
		}	    
	}
	/**
	 * 读出指定的文件作为请求的响应
	 * @param file
	 * @throws Exception
	 */
	private void report(File file,HttpServletResponse response) throws Exception{
		byte[] buffer = new byte[1024];
		FileInputStream fis = new FileInputStream(file);
		int len = fis.read(buffer, 0, buffer.length);
		OutputStream out = response.getOutputStream();
		while(len != -1)
		{    
			out.write(buffer,0,len);
			len = fis.read(buffer, 0, buffer.length);
		}
		out.flush();
	}
 
	
 
} 
 
 