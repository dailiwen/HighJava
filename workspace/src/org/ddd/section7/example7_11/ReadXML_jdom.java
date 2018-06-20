package org.ddd.section7.example7_11;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class ReadXML_jdom {
	public ReadXML_jdom() {
		String xmlpath = System.getProperty("user.dir") + File.separator  + "text.xml";
		SAXBuilder builder = new SAXBuilder(false);
		try {
			Document doc = builder.build(xmlpath);
			Element root = doc.getRootElement();
			List<Element> booklist = (List<Element>)root.getChildren("page");
			for(Iterator<Element> iter = booklist.iterator();iter.hasNext();) {
				Element book = iter.next();
				String id = book.getAttributeValue("id");
				String title = book.getChildText("title");
				String name = book.getChildTextTrim("name");
				System.out.println("id:"+id+"\t"+"title:"+title+"\t"+"name:"+name);
			}
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new ReadXML_jdom();
	}
}
