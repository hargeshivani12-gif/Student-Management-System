package com.example.demo.dto;

public class updateStudentRequestdto 
{
	private String name;
	private Integer age;
	private Integer rollno;
	private String subject;
	
	public String getName() {
		return name;
	}
	public Integer getAge() {
		return age;
	}
	public Integer getRollno() {
		return rollno;
	}
	public String getSubject() {
		return subject;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public void setRollno(Integer rollno) {
		this.rollno = rollno;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
}
