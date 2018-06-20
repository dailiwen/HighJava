package org.ddd.section5.example5_4_2.entity;

public class RegisterMessage extends Message {
	//：<login name=”xu”/>
	private String name ;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public String toString()
	{
		
		return "<login name=\""+this.name+"\"/>";
		
	}
}
