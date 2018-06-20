package org.ddd.section4.example4_11.processor;

import java.io.File;
import java.util.List;

import org.ddd.section4.example4_11.tool.ClassFileLoader;
import org.ddd.section4.example4_11.tool.Scanner;
import org.ddd.section4.example4_11.util.TableInfo;

public class TableProcessor implements IProcessor {

	public String process(String url) throws Exception {
		List<File> classFiles = Scanner.getClassFiles(url);
		StringBuilder sql = new StringBuilder();
		for(File file : classFiles){
			Class<?> clazz = ClassFileLoader.loadClass(file);
			TableInfo table = TableInfo.parse(clazz);
			if(table != null)
				sql.append(table.toString());
		}
		return sql.toString();
	}
}
