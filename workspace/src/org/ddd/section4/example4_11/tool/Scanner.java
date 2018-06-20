package org.ddd.section4.example4_11.tool;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Scanner {
	
	private static List<File> allClassFile;
	
	public static List<File> getClassFiles(String url){
		allClassFile = new ArrayList<File>();
		File file = new File(url);
		if(file.isDirectory()){
			fillClassFiles(file);
		}else{
			if(isClassFile(file)){
				allClassFile.add(file);
			}
		}
		return allClassFile;
	}
	
	private static void fillClassFiles(File directory){
		File[] list = directory.listFiles();
		for(File file : list){
			if(file.isDirectory()){
				fillClassFiles(file);
			}else
			{
				if(isClassFile(file)){
					allClassFile.add(file);
				}
			}
		}
	}
	
	private static String getFileType(File file){
		String fileName = file.getName();
		String type = fileName.substring(fileName.lastIndexOf(".") + 1);
		return type;
	}
	
	private static boolean isClassFile(File file){
		return getFileType(file).equals("class");
	}
}
