package org.ddd.section7.example7_14;

import java.beans.XMLDecoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class XMLToObject {
	public static void main(String[] args) {
		InputStream is;
		try {
			is = new FileInputStream(System.getProperty("user.dir") + File.separator  + "student.xml");
			XMLDecoder xd = new XMLDecoder(is);
			Student student = (Student) xd.readObject();
			System.out.println("id:"+student.getId());
			System.out.println("name:"+student.getName());
			System.out.println("ps:"+student.getPs());
			System.out.println("age:"+student.getAge());
			System.out.println("birthday:"+student.getBirthDay());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
