package org.ddd.section7.example7_11;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class WriteXML_jdom {
	public static void main(String[] args) {
		Document doc;
		try {
			doc = new Document();
			Element root = new Element("teacher");
			doc.setRootElement(root);
			
			Element name = new Element("name");
			root.addContent(name);
			
			Element age = new Element ("age");
			root.addContent(age);
			
			Element birthplace = new Element("birthplace");
			root.addContent(birthplace);
			
			Attribute attri  = new Attribute("id","0001");
			name.setAttribute(attri);
			
			name.setText("张三");
			age.setText("22");
			birthplace.setText("重庆");
			
			XMLOutputter out = new XMLOutputter();//用于输出jdom 文档
			Format format = Format.getPrettyFormat();
			format.setEncoding("GBK");
			out.setFormat(format);
			OutputStream os = new FileOutputStream(System.getProperty("user.dir") + File.separator  + "jdom.xml");
			out.output(doc, os);
			System.out.println("创建文件成功");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
