package org.simpletomcat;

import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;
import java.io.File;
import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * ServletWrapper Servlet包装器，代表一个Servlet;
 * 
 * @author ddd
 */
public class ServletWrapper {

	public ServletWrapper(String servletClass) {
		this.servletClass = servletClass;
	}

	public void invoke(Request request, Response response) {
	 
		URLClassLoader loader = null;
		try {
			// 创建类加载器:URLClassLoader，因为Servlet对应的.class文件存放在指定目录中，因此要使用专用的类加载器
			// 加载servlet类。在Tomcat中的，Servlet对应的.class文件默认存放在应用程序根目录下的WEB-INF的下classes目录中
			URL[] urls = new URL[1];
			File classPath = new File(Constants.WEB_ROOT); //Constants.WEB_ROOT 指定Servlet的.class文件所在目录名称
			// 为Servlet加载器指定.class文件所在目录
			String repository = (new URL("file", null,classPath.getCanonicalPath() + File.separator)).toString();
			urls[0] = new URL(null, repository);
			loader = new URLClassLoader(urls);
		} catch (IOException e) {
			System.err.println(e.toString());
		}
		Class servletClazz = null;
		try {
			//从.class文件中加载类
			servletClazz = loader.loadClass(this.servletClass);
		} catch (ClassNotFoundException e) {
			System.err.println(e.toString());
		}

		Servlet servlet = null;
		try {
			//创建Servlet实例
			servlet = (Servlet) servletClazz.newInstance();
		} catch (Exception e) {
			System.err.println(e.toString());
		} 
		try {
			//执行Servlet的服务方法
			servlet.service((ServletRequest) request,
					(ServletResponse) response);
		} catch (Exception e) {
			System.err.println(e.toString());
		}  
	}

	public void setServletClass(String servletClass) {
		this.servletClass = servletClass;
	}

	public String getServletClass() {
		return servletClass;
	}

	/**
	 * servlet的类名，包括包名
	 */
	private String servletClass = null;
}