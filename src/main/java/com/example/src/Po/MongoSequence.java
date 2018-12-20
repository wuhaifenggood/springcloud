package com.example.src.Po;

import org.springframework.data.annotation.Id;

public class MongoSequence {
	@Id
	private String id;
	
	private String collName;// 集合名称
	
	private int seq;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getCollName() {
		return collName;
	}

	public void setCollName(String collName) {
		this.collName = collName;
	}
}
