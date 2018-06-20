package org.ddd.section7.example7_8;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Person implements Externalizable {
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		this.name = in.readLine();
	}
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.write(this.name.getBytes());
	}
}
