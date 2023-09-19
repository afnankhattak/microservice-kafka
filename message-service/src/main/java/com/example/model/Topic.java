package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Topic {
	

	@Id
	@GeneratedValue
	private long id;
	private String message;
	
	
	public Topic() {
		
	}
	
	public Topic(String message) {
		this.message=message;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
