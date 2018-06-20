package org.simpletomcat;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;


public class HelloWorld extends GenericServlet {

	public void service(ServletRequest request, ServletResponse response)
	throws ServletException, IOException {
 
		String name = request.getParameter("name"); 
		
		PrintWriter  printWriter = response.getWriter(); 
		printWriter.write( "<h1>"+name+": hello world</h1>");
		printWriter.write("<h1></h1>");
		printWriter.flush(); 
	}
} 
 
 
