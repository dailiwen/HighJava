package org.ddd.section2.example2_17;


public abstract class Person implements Speakable{
//	public void speak(){};
	protected void useTool(){};
	private void useTool(String toolName){};
	public void eat(String food){};
	public static void listen(){};
	protected abstract void listen(String destination);
	public final void fly(){};
	public native void think();
	public String ddd;
	private String ddd2;
}

