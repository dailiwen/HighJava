package org.ddd.section7.example7_6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerTest {
	public static void main(String[] args) throws Exception{
		Earth earth = Earth.getInstance();
		writeObject(earth,"earth.byte");
		Earth earth1 = (Earth)readObject("earth.byte");
		System.out.println(earth1);
		Earth earth2 = (Earth)readObject("earth.byte");
		System.out.println(earth2);
		if(earth1 == earth2){
			System.out.println("获取的是同一个对象！");
		}else{
			System.out.println("获取的不是同一对象！");
		}		}
	public static void writeObject(Object obj, String fileName) throws Exception{
		File file = new File(fileName);
		FileOutputStream fileOut = new FileOutputStream(file);
		ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
		objOut.writeObject(obj);
		objOut.flush();
		objOut.close();
		fileOut.close();
	}
	public static Object readObject(String fileName) throws Exception{
		File file = new File(fileName);
		FileInputStream fileIn = new FileInputStream(file);
		ObjectInputStream objIn = new ObjectInputStream(fileIn);
		Object obj = objIn.readObject();
		objIn.close();
		fileIn.close();
		return obj;
	}}
