package org.ddd.section7.example7_13;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class WriteXML {
	public static void main(String[] args) {
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("地址");//创建根节点
		Element user = root.addElement("用户").addAttribute("name", "张三")
		.addAttribute("age","12").addAttribute("ps", "备注");
		user.addText("这个是个人基本信息");
		OutputFormat of = OutputFormat.createPrettyPrint();//控制格式，让格式显得更加pretty  默认调用方法createCompactprint
		try {
			XMLWriter xw = new XMLWriter(new FileOutputStream(System.getProperty("user.dir") + File.separator  + "text.xml"),of);
			xw.write(document);
			xw.close();
	        System.out.println("创建成功");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
