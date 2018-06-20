package org.ddd.section5.example5_4_2.entity;

public class ResultMessage extends Message {

	//：<result command=” login ” state=”ok” />，
	private String command;
	private String state;
	
	public void setCommand(String command) {
		this.command = command;
	}
	public String getCommand() {
		return command;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getState() {
		return state;
	}
	
}
