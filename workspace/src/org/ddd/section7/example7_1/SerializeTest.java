package org.ddd.section7.example7_1;


public class SerializeTest {
	public static void main(String[] args) throws Exception{
//		Person p = new Person();
//		SerializeTool.serialize(p,"d:\\person.data");
//		SerializeTool.printFileInfo("person");
		Object obj = SerializeTool.deSerialize("person");
		Person dep = (Person)obj;
		System.out.println("Peron Name:	" + dep.getName());
	}
}
