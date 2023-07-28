package com.tyss.Car_Engine;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Test {
	@Id
	private int idName;
	private String name;
	public int getIdName() {
		return idName;
	}
	public void setIdName(int idName) {
		this.idName = idName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
