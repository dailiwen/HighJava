package org.ddd.section7.example7_14;

import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;

public class ObjectToXML {
	public static void main(String[] args) {
		Student student = new Student();
		student.setAge(11);
		student.setBirthDay(new Date());
		student.setId(1);
		student.setName("Alice");
		student.setPs("from cqut");
		try {
			OutputStream os = new FileOutputStream(System.getProperty("user.dir") + File.separator  + "student.xml");
			XMLEncoder  encoder = new XMLEncoder(os);
			encoder.writeObject(student);
			encoder.close();
			System.out.println("对象写入完毕");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
