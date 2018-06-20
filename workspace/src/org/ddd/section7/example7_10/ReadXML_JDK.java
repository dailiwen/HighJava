package org.ddd.section7.example7_10;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class ReadXML_JDK {
	public ReadXML_JDK() throws ParserConfigurationException, SAXException, IOException{
		SAXParserFactory saxfac = SAXParserFactory.newInstance();
		SAXParser saxparser = saxfac.newSAXParser();
		InputStream is = new FileInputStream(System.getProperty("user.dir") + File.separator  + "library.xml");
		saxparser.parse(is,new MySAXHandler());
	}
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		new ReadXML_JDK();
	}
}
