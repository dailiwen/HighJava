package org.ddd.section5.example5_4_1.util;

import org.ddd.section5.example5_4_1.client.entity.Message;
import org.ddd.section5.example5_4_1.client.entity.MessageMessage;
import org.ddd.section5.example5_4_1.client.entity.ResultMessage;

public class MessageParser {
	
	public static Message parseMessage(String message)
	{
		if(message.startsWith("<message"))
		{
			MessageMessage messageMessage = MessageParser.pareMessageMessage(message);
			
			return messageMessage;
			
		}else if(message.startsWith("<result"))
		{
			ResultMessage resultMessage =  MessageParser.pareResultMessage(message);
			
			return resultMessage;
		}
		return null;
	}
	public static MessageMessage pareMessageMessage(String message)
	{

		MessageMessage messageMessage = new MessageMessage();
		
		String attributeValue = null;

		attributeValue = MessageParser.parseMessageAttributeValue(message, "to");
		messageMessage.setFrom(attributeValue);
		
		attributeValue = MessageParser.parseMessageAttributeValue(message, "to");
		messageMessage.setFrom(attributeValue);
		
		attributeValue = MessageParser.parseMessageAttributeValue(message, "message");
		messageMessage.setMessage(attributeValue);		
		
		
		return messageMessage;
	}
	public static ResultMessage pareResultMessage(String message)
	{
		ResultMessage resultMessage = new ResultMessage();
		
		String attributeValue = null;
		
		attributeValue = MessageParser.parseMessageAttributeValue(message, "command");
		resultMessage.setCommand(attributeValue);
		
		attributeValue = MessageParser.parseMessageAttributeValue(message, "state");
		resultMessage.setCommand(attributeValue);		
		
		return resultMessage;	
	}
	private static String parseMessageAttributeValue(String message,String attributeName)
	{
		int beginIndex = message.indexOf(attributeName);
		int firstQuatoIndex = message.indexOf("\"", beginIndex);
		int lastQuatoIndex = message.indexOf("\"", firstQuatoIndex+1);
		String value = message.substring(firstQuatoIndex+1, lastQuatoIndex);
		return value;
	}
}
