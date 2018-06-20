package org.ddd.section4.example4_11.test;

import org.ddd.section4.example4_11.annotation.Column;
import org.ddd.section4.example4_11.annotation.ID;


public class Teacher {
	
	@ID
	@Column(nullable = false)
	private Integer id;
	
	@Column(length = 16)
	private String name;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
