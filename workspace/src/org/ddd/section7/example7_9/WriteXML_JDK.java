package org.ddd.section7.example7_9;

import java.beans.Encoder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.UTFDataFormatException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class WriteXML_JDK {
	public static void main(String[] args) {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = null;
		Document document;
		try {
			db = dbFactory.newDocumentBuilder();
			document = db.newDocument();
			
			Element root = document.createElement("Course");//创建根节点元素
			document.appendChild(root);
			
			Element element1 = document.createElement("姓名");
			element1.appendChild(document.createTextNode("张三"));
			root.appendChild(element1);
			
			Element element2 = document.createElement("java基础");
			element2.appendChild(document.createTextNode("95"));
			root.appendChild(element2);
			
			Element element3 = document.createElement("高级java");
			element3.appendChild(document.createTextNode("95"));
			root.appendChild(element3);
			
			Element element4 = document.createElement("数据结构");
			element4.appendChild(document.createTextNode("89"));
			root.appendChild(element4);
			
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			DOMSource source = new DOMSource(document);//document object model 
			transformer.setOutputProperty(OutputKeys.ENCODING,"utf-8");//设置转换中实际输出的相关属性
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            PrintWriter pw = new PrintWriter(new FileOutputStream(new File(System.getProperty("user.dir") + File.separator  + "text1.xml")));
            StreamResult result = new StreamResult(pw);//streamResult 充当装换结果的持有者      构建一个转换的结果保存集
            transformer.transform(source, result);
                
            System.out.println("输出成功");
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
}
