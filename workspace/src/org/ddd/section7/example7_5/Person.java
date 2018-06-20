package org.ddd.section7.example7_5;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
	private void writeObject(ObjectOutputStream out) throws IOException{
		out.defaultWriteObject();
		Date date = new Date();
		out.writeObject(date);
	}
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
		in.defaultReadObject();
		Date date = (Date)in.readObject();
		Date now = new Date();
		long offset = now.getTime() - date.getTime();
		if(offset < 100){
			System.out.println("在正常时间内接受到序列化对象！");
		}else{
			System.err.println("数据传输时间过长，请注意！");
		}
	}}
