package org.ddd.section7.example7_3;


public class SerializeTest {
	public static void main(String[] args) throws Exception{
		Teacher t = new Teacher();
		SerializeTool.serialize(t,"teacher");
		SerializeTool.printFileInfo("teacher");
	}
}
