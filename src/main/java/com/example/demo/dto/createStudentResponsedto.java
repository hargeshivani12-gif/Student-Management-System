package com.example.demo.dto;

import java.time.LocalDateTime;

public class createStudentResponsedto
{
	private String name;
	private Integer age;
	private String email;
	private Integer rollno;
	private String subject;
	private String message;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getName() {
		return name;
	}
	public Integer getAge() {
		return age;
	}
	public String getEmail() {
		return email;
	}
	public Integer getRollno() {
		return rollno;
	}
	public String getSubject() {
		return subject;
	}
	public String getMessage() {
		return message;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setRollno(Integer rollno) {
		this.rollno = rollno;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
