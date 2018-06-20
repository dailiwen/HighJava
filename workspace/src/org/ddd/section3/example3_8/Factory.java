package org.ddd.section3.example3_8;

public class Factory {
	public <T> T generator(Class<T> t) throws Exception{
		return t.newInstance();
	}
}
