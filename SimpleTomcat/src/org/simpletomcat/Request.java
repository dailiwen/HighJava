package org.simpletomcat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 请求消息对象
 */
public class Request implements HttpServletRequest{
	//请求标题
	private String title;
	//请求头
	private String header;
	//请求体
	private String body;	
	//请求方法
	private String method;
	//请求目的地址
	private String uri;
	//请求使用的协议名称和版本
	private String protocol;
	//请求消息的参数集合
	private Map<String,String> params = new HashMap<String,String>();
	//请求消息的输入流
	private InputStream in;
	//请求消息字符串
	private String requestStr;
	public Request(){}	
	/**
	 *	以输入流作为参数的构造函数 
	 */
	public Request(InputStream in){
		this.in = in;
		//读取输入流，并将其转换成字符串
		this.requestStr = this.readRequest(in);
		//解析请求消息
		this.parse();
	}
	/**
	 * 从输入流中读取请求消息
	 */
	public String readRequest(InputStream in){
		//记录实际读取的数据长度
		int len = 0;
		//读取输入流用的缓冲数据
		byte[] buffer = new byte[2048];
		//存储读入数据的缓冲字符串对象
		StringBuffer sb = new StringBuffer();
		try {
			//将输入流中的数据读入buffer数组中,返回实际读取的数据长度
			len = in.read(buffer);
			while(len > 0){
				//将读取的数据放入字符串缓冲对象中
				for(int i =0; i<len; i++){
					sb.append((char)buffer[i]);
				}
				//如果输入流中仍有数据未读完，则继续读取
				if(in.available() > 0){
					len = in.read(buffer);
				}else{
					//否则跳出循环
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}	
	/**
	 * 解析请求消息
	 */
	protected void parse(){
		if(this.requestStr.length() > 0){
			//找到第一个换行符索引
			int index = this.requestStr.indexOf("\r\n");
			this.title = this.requestStr.substring(0,index);
			String context = this.requestStr.substring(index + 1);
			
			//将请求消息分成三个部分，即请求行、请求头和请求体
			String[] elements = context.split("\r\n\r\n");
			
			if(elements.length==1){
				this.header = elements[0];
			}else if(elements.length == 2){
				this.header = elements[0];
				this.body = elements[1];
			}
			
			//解析请求行
			this.parseTitle();
			//解析请求头
			this.parseHeader();
			//解析请求体
			this.parseBody();
		}
	}	
	/**
	 * 解析请求行
	 */
	protected void parseTitle(){
		//将请求行分成三个部分，即请求方法、请求地址和请求协议
		String[] elements = this.title.split(" ");
		this.method = elements[0];
		this.uri = elements[1];
		this.protocol = elements[2];
		//解析请求地址
		this.parseUri();
	}
	//解析请求头
	protected void parseHeader(){
	}
	//解析请求体
	protected void parseBody(){
	}
	
	/**
	 * 解析请求地址，如果采用GET方式传输数据，则数据保护在请求地址中
	 * 需要通过解析请求地址，从而获取请求数据.这种请求地址的常见方式
	 * 如下：/login.jsp?name=admin&pwd=admin
	 */
	protected void parseUri(){
		//请求数据都放在"?"后面，因此需要判断是否有"?"以及"?"的位置
		int index = this.uri.indexOf("?");
		//如果请求地址中保护"?"
		if(index > -1){
			//"?"号后面的是请求数据
			String condition = this.uri.substring(index+1);
			//"?"号前面的才是真正的请求地址
			this.uri = this.uri.substring(0, index);
			//请求数据之间使用"&"分开
			String[] elements = condition.split("&");
			//循环遍历每一条数据
			for(String element : elements){
				//数据采用键值对的方式存储，键与值之间使用"="
				String[] param = element.split("=");
				if(param.length > 1){
					//将请求数据放入请求参数集合中
					this.addParam(param[0], param[1]);
				}
			}
		}
	}
	@Override
	public String getParameter(String name) {
		return this.params.get(name);
	}
	
	private void addParam(String name, String value){
		this.params.put(name, value);
	}
	private void removeParam(String name, String value){
		this.params.remove(name);
	}
 
	public String getUri() {
		return uri;
	}
	
	public String toString(){
		return this.requestStr;
	}

	@Override
	public Object getAttribute(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enumeration getAttributeNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCharacterEncoding() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCharacterEncoding(String env)
			throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getContentLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServletInputStream getInputStream() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Enumeration getParameterNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getParameterValues(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map getParameterMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getProtocol() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getScheme() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServerName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getServerPort() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BufferedReader getReader() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRemoteAddr() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRemoteHost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAttribute(String name, Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAttribute(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Locale getLocale() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enumeration getLocales() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isSecure() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public RequestDispatcher getRequestDispatcher(String path) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRealPath(String path) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getRemotePort() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getLocalName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLocalAddr() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLocalPort() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getAuthType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cookie[] getCookies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getDateHeader(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getHeader(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enumeration getHeaders(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enumeration getHeaderNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getIntHeader(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getMethod() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPathInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPathTranslated() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getContextPath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getQueryString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRemoteUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUserInRole(String role) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Principal getUserPrincipal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRequestedSessionId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRequestURI() {
		return this.uri; 
	}

	@Override
	public StringBuffer getRequestURL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletPath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HttpSession getSession(boolean create) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HttpSession getSession() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isRequestedSessionIdValid() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRequestedSessionIdFromCookie() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRequestedSessionIdFromURL() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRequestedSessionIdFromUrl() {
		// TODO Auto-generated method stub
		return false;
	}
}
