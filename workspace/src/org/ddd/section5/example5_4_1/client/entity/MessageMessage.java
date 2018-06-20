package org.ddd.section5.example5_4_1.client.entity;

public class MessageMessage extends Message {
	//<message from=”xu” to=”zhang” message=”this is a test”>
	private String from ;
	private String to;
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	private String message;
}
