package org.simpletomcat;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
/**
 * 请求响应对象
 * @author ddd
 *
 */
public class Response implements HttpServletResponse {
	private OutputStream out;
	private Request request;
	
	public Response(Request request, OutputStream out){
		this.request = request;
		this.out = out;
	}
 	/* 返回与Socket相关联的ServletOutputStream对象
 	 * @see javax.servlet.ServletResponse#getOutputStream()
 	 */
 	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		return new ServletOutputStream() {
			@Override
			public void write(int b) throws IOException {
				out.write(b);
			}
		};
	}
	/* 返回输出流相关关联的PrintWriter对象
	 * @see javax.servlet.ServletResponse#getWriter()
	 */
	@Override
	public PrintWriter getWriter() throws IOException {
		 return new PrintWriter(this.out);
	}
	
	@Override
	public String getCharacterEncoding() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCharacterEncoding(String charset) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setContentLength(int len) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setContentType(String type) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setBufferSize(int size) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int getBufferSize() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void flushBuffer() throws IOException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void resetBuffer() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean isCommitted() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setLocale(Locale loc) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Locale getLocale() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCookie(Cookie cookie) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean containsHeader(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String encodeURL(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String encodeRedirectURL(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String encodeUrl(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String encodeRedirectUrl(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sendError(int sc, String msg) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendError(int sc) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendRedirect(String location) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDateHeader(String name, long date) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addDateHeader(String name, long date) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setHeader(String name, String value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addHeader(String name, String value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setIntHeader(String name, int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addIntHeader(String name, int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setStatus(int sc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setStatus(int sc, String sm) {
		// TODO Auto-generated method stub
		
	}
}
