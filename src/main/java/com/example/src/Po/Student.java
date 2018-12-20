package com.example.src.Po;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

/*@Document(collection = "student")*/
public class Student {

	/*@AutoIncKey*/
	@Id
	private int id;

	@Field
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
