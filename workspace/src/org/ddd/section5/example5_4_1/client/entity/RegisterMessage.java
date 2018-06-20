package org.ddd.section5.example5_4_1.client.entity;

public class RegisterMessage extends Message {
	private String name ;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "<register name=\""+this.name+"\"/>";
	}
	
	
}
