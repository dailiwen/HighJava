package org.ddd.section7.example7_9;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadXML_JDK {
	public static void main(String[] args) {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();//文档解析工厂
		DocumentBuilder db = null;//文件构造器
		
		try {
			db = dbFactory.newDocumentBuilder();
			Document document  = db.parse(new File(System.getProperty("user.dir") + File.separator  + "text.xml"));
			Element eroot = document.getDocumentElement();//得到根节点   book
			
			System.out.println("根节点名字：" + eroot.getTagName());
			System.out.println("****下面遍历XML元素****");
			NodeList nodeList = eroot.getElementsByTagName("page");
			/*循环取XML文件的内容*/
			for(int i =0;i<nodeList.getLength();i++){
				Element element1 = (Element) nodeList.item(i);
				String s_id = element1.getAttribute("id");
				
				NodeList titleList = element1.getElementsByTagName("title");
				Element element2 = (Element) titleList.item(0);
				String s_title = element2.getTextContent();
				
				NodeList nameList  = element1.getElementsByTagName("name");
				Element element3 = (Element) nameList.item(0);
				String s_name = element3.getTextContent();
				
				System.out.println("ID:"+s_id+"标题："+s_title+"姓名："+s_name);
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
