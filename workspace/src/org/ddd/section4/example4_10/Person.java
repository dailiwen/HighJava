package org.ddd.section4.example4_10;

@ExtractInterface(value="IPerson",isPublicModifier=false)
public class Person {

	public void speak(String message){
		System.out.println(message);
	}
	public void useTool(String toolName){
		System.out.println(toolName);
	}
}
