package org.ddd.section7.example7_12;

import java.io.File;

public class application {
	public static void main(String[] args) throws Exception {
		Container c = new Container(System.getProperty("user.dir") + File.separator  +"beans.xml");
		Boy b = (Boy)c.getBean("boy");
		b.sendGit();
	}
}
