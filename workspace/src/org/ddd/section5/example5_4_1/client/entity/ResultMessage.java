package org.ddd.section5.example5_4_1.client.entity;

public class ResultMessage extends Message {

	//<result command=”register” state=”ok” />，
	private String command;
	private String state ;
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "ResultMessage [command=" + command + ", state=" + state + "]";
	}
}
